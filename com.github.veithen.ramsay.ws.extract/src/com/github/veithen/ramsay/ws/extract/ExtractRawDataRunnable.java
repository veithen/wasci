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

import com.github.veithen.ramsay.emf.util.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.Metadata;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.metadata.repository.ChildContext;
import com.github.veithen.ramsay.ws.metadata.repository.ChildContextTypeLink;
import com.github.veithen.ramsay.ws.metadata.repository.ChildDocument;
import com.github.veithen.ramsay.ws.metadata.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.metadata.repository.Context;
import com.github.veithen.ramsay.ws.metadata.repository.ContextType;
import com.github.veithen.ramsay.ws.metadata.repository.Document;
import com.github.veithen.ramsay.ws.metadata.repository.DocumentType;
import com.github.veithen.ramsay.ws.metadata.repository.RepositoryMetadataFactory;
import com.github.veithen.ramsay.ws.metadata.repository.handler.ContextTypeHandler;
import com.github.veithen.ramsay.ws.metadata.repository.handler.DiscoveredContext;
import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandler;
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
    
    private Context buildContext(String contextURI, ContextType type, String name) {
        // TODO: there is probably a better way to do this with TreeSets
        Set<String> relativeURIs = new HashSet<String>();
        {
            String prefix = contextURI + "/";
            for (String uri : resourceNames) {
                if (uri.startsWith(prefix)) {
                    relativeURIs.add(uri.substring(prefix.length()));
                }
            }
        }
        Context context = RepositoryMetadataFactory.eINSTANCE.createContext();
        context.setType(type);
        context.setName(name);
        DocumentType rootDocumentType = type.getRootDocumentType();
        if (rootDocumentType != null) {
            context.setRootDocument(searchDocument(relativeURIs, rootDocumentType));
        }
        for (ChildDocumentTypeLink link : type.getChildDocumentTypeLinks()) {
            Document document = searchDocument(relativeURIs, link.getDocumentType());
            if (document != null) {
                ChildDocument childDocument = RepositoryMetadataFactory.eINSTANCE.createChildDocument();
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
            ContextTypeHandler handler = (ContextTypeHandler)EcoreUtil.getRegisteredAdapter(childContextType, ContextTypeHandler.class);
            for (DiscoveredContext discoveredContext : handler.scan(relativeURIs)) {
                ChildContext childContext = RepositoryMetadataFactory.eINSTANCE.createChildContext();
                childContext.setLink(link);
                childContext.setContext(buildContext(contextURI + "/" + discoveredContext.getRelativeURI(), childContextType, discoveredContext.getName()));
                context.getChildContexts().add(childContext);
            }
        }
        return context;
    }
    
    private Document searchDocument(Set<String> relativeURIs, DocumentType type) {
        String path = ((DocumentTypeHandler)EcoreUtil.getRegisteredAdapter(type, DocumentTypeHandler.class)).scan(relativeURIs);
        if (path != null) {
            Document document = RepositoryMetadataFactory.eINSTANCE.createDocument();
            document.setType(type);
            document.setPath(path);
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
        String inputFileName = document.getPath();
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
                ((DocumentTypeHandler)EcoreUtil.getRegisteredAdapter(document.getType(), DocumentTypeHandler.class)).processDocument(resource, in);
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
