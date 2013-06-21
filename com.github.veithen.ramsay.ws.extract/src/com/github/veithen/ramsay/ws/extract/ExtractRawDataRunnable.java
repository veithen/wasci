package com.github.veithen.ramsay.ws.extract;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.github.veithen.ramsay.util.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.Metadata;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.model.repository.ChildContext;
import com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink;
import com.github.veithen.ramsay.ws.model.repository.ChildDocument;
import com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.model.repository.Context;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.Document;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryFactory;
import com.ibm.websphere.management.exception.RepositoryException;
import com.ibm.websphere.management.repository.ConfigRepository;

public class ExtractRawDataRunnable implements IWorkspaceRunnable {
    private final MetadataProject metadataProject;
    private final IFolder folder;
    private final ConfigRepository repository;
    private Set<String> resourceNames;
    private ResourceSet resourceSet;
    private Map<IFile,XMIResource> resourceMap = new HashMap<IFile,XMIResource>();
    
    public ExtractRawDataRunnable(MetadataProject metadataProject, IFolder folder, ConfigRepository repository) {
        this.metadataProject = metadataProject;
        this.folder = folder;
        this.repository = repository;
    }

    @Override
    public void run(IProgressMonitor monitor) throws CoreException {
        resourceNames = new HashSet<String>(Arrays.asList(repository.listResourceNames("", 3, Integer.MAX_VALUE)));
        resourceSet = new ResourceSetImpl();
        Metadata metadata = metadataProject.loadMetadata(resourceSet);
        Registry registry = metadata.getRegistry();
        String cellName = null;
        for (String resourceName : resourceNames) {
            if (resourceName.startsWith("cells/") && resourceName.indexOf('/', 6) == -1) {
                cellName = resourceName.substring(6);
            }
        }
        Context cellContext = buildContext("cells/" + cellName, metadata.getCellContextType(), cellName);
        resourceSet.setPackageRegistry(registry);
        IFile indexFile = folder.getFile("index.xmi");
        Resource index = EMFUtil.createResource(resourceSet, indexFile);
        index.getContents().add(cellContext);
        extractDocuments("cells/" + cellName, cellContext, folder);
        EcoreUtil.resolveAll(resourceSet);
        folder.delete(false, monitor);
        for (Map.Entry<IFile,XMIResource> entry : resourceMap.entrySet()) {
            Resource resource = entry.getValue();
            resource.setURI(EMFUtil.createURI(entry.getKey()));
            EMFUtil.save(resource);
        }
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
        for (ChildDocumentTypeLink link : type.getChildDocumentTypeLinks()) {
            Document document = searchDocument(uri, link.getDocumentType());
            if (document != null) {
                ChildDocument childDocument = RepositoryFactory.eINSTANCE.createChildDocument();
                childDocument.setLink(link);
                childDocument.setDocument(document);
                context.getChildDocuments().add(childDocument);
            }
        }
        for (ChildContextTypeLink link : type.getChildContextTypeLinks()) {
            ContextType childContextType = link.getContextType();
            if (childContextType.getName().equals("repository") || childContextType.getName().equals("aver") || childContextType.getName().equals("bver") || childContextType.getName().equals("cver")) {
                continue; // TODO: hack!
            }
            String prefix = uri + "/" + childContextType.getName() + "/";
            for (String resourceName : resourceNames) {
                if (resourceName.startsWith(prefix) && resourceName.indexOf('/', prefix.length()) == -1) {
                    ChildContext childContext = RepositoryFactory.eINSTANCE.createChildContext();
                    childContext.setLink(link);
                    childContext.setContext(buildContext(resourceName, childContextType, resourceName.substring(prefix.length())));
                    context.getChildContexts().add(childContext);
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
        for (ChildDocument childDocument : context.getChildDocuments()) {
            extractDocument(uri, childDocument.getDocument(), folder);
        }
        for (ChildContext childContext : context.getChildContexts()) {
            String type = childContext.getContext().getType().getName();
            String name = childContext.getContext().getName();
            extractDocuments(uri + "/" + type + "/" + name, childContext.getContext(), folder.getFolder(type).getFolder(name));
        }
    }
    
    private void extractDocument(String contextURI, Document document, IFolder folder) throws CoreException {
        String inputFileName = document.getType().getFilePattern();
        if (inputFileName.equals("ws-security.xml")) {
            return; // TODO: hack!
        }
        String uri = contextURI + "/" + inputFileName;
        XMIResource resource;
        InputStream in;
        try {
            in = repository.extract(uri).getSource();
        } catch (RepositoryException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Error extracting document " + uri, ex));
        }
        try {
            try {
                // All documents are saved as XMI irrespective of the original format
                resource = new XMIResourceImpl(URI.createURI("wsrepo:///" + uri));
                resourceSet.getResources().add(resource);
                document.getType().getDocumentProcessor().processDocument(resource, in);
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Error loading document " + uri, ex));
        }
        for (EObject object : resource.getContents()) {
            if (!object.eClass().getEPackage().getNsPrefix().equals("xmi")) {
                document.getContents().add(object);
            }
        }
        int idx = inputFileName.lastIndexOf('.');
        String outputFileName = (idx == -1 ? inputFileName : inputFileName.substring(0, idx)) + ".xmi";
        if (resourceMap.put(folder.getFile(outputFileName), resource) != null) {
            throw new IllegalStateException("Document " + uri + " encountered twice!");
        }
    }
}
