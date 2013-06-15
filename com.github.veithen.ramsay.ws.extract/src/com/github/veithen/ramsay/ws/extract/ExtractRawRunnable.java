package com.github.veithen.ramsay.ws.extract;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.util.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.Metadata;
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
    private Set<IResource> resourcesToDelete = new HashSet<IResource>();
    
    public ExtractRawRunnable(MetadataProject metadataProject, IFolder folder, ConfigRepository repository) {
        this.metadataProject = metadataProject;
        this.folder = folder;
        this.repository = repository;
    }

    @Override
    public void run(IProgressMonitor monitor) throws CoreException {
        if (folder.exists()) {
            folder.accept(new IResourceVisitor() {
                @Override
                public boolean visit(IResource resource) throws CoreException {
                    resourcesToDelete.add(resource);
                    return true;
                }
            });
            resourcesToDelete.remove(folder);
        } else {
            folder.create(false, true, monitor);
        }
        resourceNames = new HashSet<String>(Arrays.asList(repository.listResourceNames("", 3, Integer.MAX_VALUE)));
        resourceSet = new ResourceSetImpl();
        Metadata metadata = metadataProject.loadMetadata(resourceSet);
        Registry registry = metadata.getRegistry();
        Context cellContext = buildContext("cells/test", metadata.getCellContextType(), "test");
        resourceSet.setPackageRegistry(registry);
        IFile indexFile = folder.getFile("index.xmi");
        resourcesToDelete.remove(indexFile);
        Resource index = EMFUtil.createResource(resourceSet, indexFile);
        index.getContents().add(cellContext);
        extractDocuments("cells/test", cellContext, folder);
        EMFUtil.save(index);
        for (IResource resource : resourcesToDelete) {
            resource.delete(false, monitor);
        }
    }
    
    private void create(IFolder folder) throws CoreException {
        if (folder.exists()) {
            resourcesToDelete.remove(folder);
        } else {
            folder.create(false, true, monitor);
        }
    }
    
    private void create(IFile file, InputStream source) throws CoreException {
        if (file.exists()) {
            resourcesToDelete.remove(file);
            file.setContents(source, false, true, monitor);
        } else {
            file.create(source, false, monitor);
        }
    }
    
    private Context buildContext(String uri, ContextType type, String name) {
        Context context = RepositoryFactory.eINSTANCE.createContext();
        context.setType(type);
        context.setName(name);
        DocumentType rootDocumentType = type.getRootDocumentType();
        if (rootDocumentType != null) {
            context.setRootDocument(searchDocument(uri, rootDocumentType));
        }
        for (DocumentType childDocumentType : type.getChildDocumentTypes()) {
            if (childDocumentType != rootDocumentType) {
                Document document = searchDocument(uri, childDocumentType);
                if (document != null) {
                    context.getChildDocuments().add(document);
                }
            }
        }
        for (ContextType childContextType : type.getChildContextTypes()) {
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
        Document rootDocument = context.getRootDocument();
        if (rootDocument != null) {
            extractDocument(uri, rootDocument, folder);
        }
        for (Document childDocument : context.getChildDocuments()) {
            extractDocument(uri, childDocument, folder);
        }
        for (Context childContext : context.getChildContexts()) {
            IFolder childFolder = folder.getFolder(childContext.getType().getName());
            create(childFolder);
            childFolder = childFolder.getFolder(childContext.getName());
            create(childFolder);
            extractDocuments(uri + "/" + childContext.getType().getName() + "/" + childContext.getName(), childContext, childFolder);
        }
    }
    
    private void extractDocument(String contextURI, Document document, IFolder folder) throws CoreException {
        String fileName = document.getType().getFilePattern();
        if (fileName.equals("ws-security.xml")) {
            return; // TODO: hack!
        }
        String uri = contextURI + "/" + fileName;
        IFile file = folder.getFile(fileName);
        try {
            create(file, repository.extract(uri).getSource());
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
