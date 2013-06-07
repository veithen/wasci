package com.github.veithen.ramsay.ws.extract;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.emf.xmi.XmiPackage;
import com.github.veithen.ramsay.ws.metadata.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.model.repository.Context;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.Document;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryFactory;
import com.ibm.websphere.management.exception.RepositoryException;
import com.ibm.websphere.management.repository.ConfigRepository;

public class ExtractRawRunnable implements IWorkspaceRunnable {
    private final MetadataProject metadataProject;
    private final IFolder folder;
    private final ConfigRepository repository;
    private IProgressMonitor monitor;
    private Set<String> resourceNames;
    private ResourceSet resourceSet;
    
    public ExtractRawRunnable(MetadataProject metadataProject, IFolder folder, ConfigRepository repository) {
        this.metadataProject = metadataProject;
        this.folder = folder;
        this.repository = repository;
    }

    @Override
    public void run(IProgressMonitor monitor) throws CoreException {
        resourceNames = new HashSet<String>(Arrays.asList(repository.listResourceNames("", 3, Integer.MAX_VALUE)));
        Context cellContext = buildContext("cells/test", metadataProject.getCellContextType(), "test");
        resourceSet = new ResourceSetImpl();
        Registry registry = metadataProject.loadMetadata().getRegistry();
        EMFUtil.registerPackage(registry, XmiPackage.eINSTANCE);
        resourceSet.setPackageRegistry(registry);
        Resource index = EMFUtil.createResource(resourceSet, folder.getFile("index.xmi"));
        index.getContents().add(cellContext);
        extractDocuments("cells/test", cellContext, folder);
        EMFUtil.save(index);
    }
    
    private Context buildContext(String uri, ContextType type, String name) {
        Context context = RepositoryFactory.eINSTANCE.createContext();
        context.setType(type);
        context.setName(name);
        DocumentType rootDocumentType = type.getRootDocumentType();
        if (rootDocumentType != null) {
            context.setRootDocument(searchDocument(uri, rootDocumentType));
        }
        for (DocumentType childDocumentType : (EList<DocumentType>)type.getChildDocumentTypes()) {
            if (childDocumentType != rootDocumentType) {
                Document document = searchDocument(uri, childDocumentType);
                if (document != null) {
                    context.getChildDocuments().add(document);
                }
            }
        }
        for (ContextType childContextType : (EList<ContextType>)type.getChildContextTypes()) {
            if (childContextType.getName().equals("repository") || childContextType.getName().equals("bver") || childContextType.getName().equals("cver")) {
                continue; // TODO: hack!
            }
            String prefix = uri + "/" + childContextType.getName() + "/";
            for (String resourceName : resourceNames) {
                if (resourceName.startsWith(prefix) && resourceName.indexOf('/', prefix.length()) == -1) {
                    context.getChildContexts().add(buildContext(resourceName, childContextType, resourceName.substring(prefix.length())));
                }
            }
        }
        return context;
    }
    
    private Document searchDocument(String contextURI, DocumentType type) {
        if (resourceNames.contains(contextURI + "/" + type.getFilePattern())) {
            Document document = RepositoryFactory.eINSTANCE.createDocument();
            document.setType(type);
            return document;
        } else {
            return null;
        }
    }
    
    private void extractDocuments(String uri, Context context, IFolder folder) throws CoreException {
        folder.create(true, true, monitor);
        Document rootDocument = context.getRootDocument();
        if (rootDocument != null) {
            extractDocument(repository, uri, rootDocument, folder, resourceSet);
        }
        for (Document childDocument : (EList<Document>)context.getChildDocuments()) {
            extractDocument(repository, uri, childDocument, folder, resourceSet);
        }
        for (Context childContext : (EList<Context>)context.getChildContexts()) {
            IFolder childFolder = folder.getFolder(childContext.getType().getName() + "_" + childContext.getName());
            extractDocuments(uri + "/" + childContext.getType().getName() + "/" + childContext.getName(), childContext, childFolder);
        }
    }
    
    private void extractDocument(ConfigRepository repository, String contextURI, Document document, IFolder folder, ResourceSet resourceSet) throws CoreException {
        String fileName = document.getType().getFilePattern();
        if (fileName.equals("ws-security.xml")) {
            return; // TODO: hack!
        }
        String uri = contextURI + "/" + fileName;
        IFile file = folder.getFile(fileName);
        try {
            file.create(repository.extract(uri).getSource(), true, monitor);
        } catch (RepositoryException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Error extracting document " + uri, ex));
        }
        for (EObject object : EMFUtil.load(resourceSet, file).getContents()) {
            if (!object.eClass().getEPackage().getNsPrefix().equals("xmi")) {
                document.getContents().add(object);
            }
        }
    }
}
