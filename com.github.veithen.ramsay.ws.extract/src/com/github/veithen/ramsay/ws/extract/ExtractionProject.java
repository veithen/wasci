package com.github.veithen.ramsay.ws.extract;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.ws.metadata.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.Metadata;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.metadata.ModelMapper;
import com.github.veithen.ramsay.ws.model.repository.Context;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.Document;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryFactory;
import com.ibm.websphere.management.AdminClient;
import com.ibm.websphere.management.exception.RepositoryException;
import com.ibm.websphere.management.repository.ConfigRepository;
import com.ibm.ws.management.repository.client.JMXRemoteConfigRepositoryClient;

public class ExtractionProject {
    private final IProject project;

    public ExtractionProject(IProject project) {
        this.project = project;
    }
    
    private static EPackage createXMIPackage() {
        EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("xmi");
        pkg.setNsPrefix("xmi");
        pkg.setNsURI("http://www.omg.org/XMI");
        EClass clazz = EcoreFactory.eINSTANCE.createEClass();
        clazz.setName("Documentation");
        EAttribute att = EcoreFactory.eINSTANCE.createEAttribute();
        att.setName("contact");
        att.setEType(EcorePackage.eINSTANCE.getEString());
        clazz.getEStructuralFeatures().add(att);
        pkg.getEClassifiers().add(clazz);
        return pkg;
    }
    
    private ConfigRepository connect() throws CoreException {
        JMXRemoteConfigRepositoryClient repository = new JMXRemoteConfigRepositoryClient();
        Properties props = new Properties();
        props.setProperty(AdminClient.CONNECTOR_HOST, "localhost");
        props.setProperty(AdminClient.CONNECTOR_PORT, "8879");
        props.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_SOAP);
        try {
            repository.connect(props);
        } catch (Exception ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to connect to WebSphere", ex));
        }
        return repository;
    }
    
    public void extract(IFile outFile) throws CoreException {
        Metadata metadata = getMetadataProject().loadMetadata();
        EPackage.Registry registry = metadata.getRegistry();
        EMFUtil.registerPackage(registry, createXMIPackage());
        ModelMapper modelMapper = metadata.getModelMapper();
        EClass cellClass = modelMapper.map(metadata.getCellContextType());
        EObject cell = EcoreUtil.create(cellClass);
        ResourceSet outResourceSet = new ResourceSetImpl();
        Resource outResource = EMFUtil.createResource(outResourceSet, outFile);
        try {
            outResource.getContents().addAll(new Loader(connect(), registry, modelMapper).load("cells/test", "cell.xml"));
        } catch (Exception ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to extract configuration", ex));
        }
        EMFUtil.save(outResource);
    }
    
    /**
     * Get the metadata project corresponding to this extraction project.
     * 
     * @return the metadata project; never <code>null</code>
     * @throws CoreException
     *             if the metadata project was not found or if there was some
     *             other problem
     */
    public MetadataProject getMetadataProject() throws CoreException {
        MetadataProject metadataProject = null;
        for (IProject refProject : project.getReferencedProjects()) {
            MetadataProject mp = (MetadataProject)refProject.getAdapter(MetadataProject.class);
            if (mp != null) {
                if (metadataProject == null) {
                    metadataProject = mp;
                } else {
                    throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "The project has references to more than one metadata project"));
                }
            }
        }
        if (metadataProject == null) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "The project has no reference to a metadata project"));
        }
        return metadataProject;
    }
    
    public void extractRaw() throws CoreException {
        MetadataProject metadataProject = getMetadataProject();
        IFolder folder = project.getFolder("raw");
        ConfigRepository repository = connect();
        Set<String> resourceNames = new HashSet<String>(Arrays.asList(repository.listResourceNames("", 3, Integer.MAX_VALUE)));
        Context cellContext = buildContext("cells/test", metadataProject.getCellContextType(), "test", resourceNames);
        ResourceSet resourceSet = new ResourceSetImpl();
        Registry registry = metadataProject.loadMetadata().getRegistry();
        EMFUtil.registerPackage(registry, createXMIPackage());
        resourceSet.setPackageRegistry(registry);
        Resource index = EMFUtil.createResource(resourceSet, folder.getFile("index.xmi"));
        index.getContents().add(cellContext);
        extractDocuments(repository, "cells/test", cellContext, folder, resourceSet);
        EMFUtil.save(index);
    }
    
    private Context buildContext(String uri, ContextType type, String name, Set<String> resourceNames) {
        Context context = RepositoryFactory.eINSTANCE.createContext();
        context.setType(type);
        context.setName(name);
        DocumentType rootDocumentType = type.getRootDocumentType();
        if (rootDocumentType != null) {
            context.setRootDocument(searchDocument(uri, rootDocumentType, resourceNames));
        }
        for (DocumentType childDocumentType : (EList<DocumentType>)type.getChildDocumentTypes()) {
            if (childDocumentType != rootDocumentType) {
                Document document = searchDocument(uri, childDocumentType, resourceNames);
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
                    context.getChildContexts().add(buildContext(resourceName, childContextType, resourceName.substring(prefix.length()), resourceNames));
                }
            }
        }
        return context;
    }
    
    private Document searchDocument(String contextURI, DocumentType type, Set<String> resourceNames) {
        if (resourceNames.contains(contextURI + "/" + type.getFilePattern())) {
            Document document = RepositoryFactory.eINSTANCE.createDocument();
            document.setType(type);
            return document;
        } else {
            return null;
        }
    }
    
    private void extractDocuments(ConfigRepository repository, String uri, Context context, IFolder folder, ResourceSet resourceSet) throws CoreException {
        folder.create(true, true, null);
        Document rootDocument = context.getRootDocument();
        if (rootDocument != null) {
            extractDocument(repository, uri, rootDocument, folder, resourceSet);
        }
        for (Document childDocument : (EList<Document>)context.getChildDocuments()) {
            extractDocument(repository, uri, childDocument, folder, resourceSet);
        }
        for (Context childContext : (EList<Context>)context.getChildContexts()) {
            IFolder childFolder = folder.getFolder(childContext.getType().getName() + "_" + childContext.getName());
            extractDocuments(repository, uri + "/" + childContext.getType().getName() + "/" + childContext.getName(), childContext, childFolder, resourceSet);
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
            file.create(repository.extract(uri).getSource(), true, null);
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
