package com.github.veithen.ramsay.ws.metadata;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.util.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.extractor.ConfigMetadataCallback;
import com.github.veithen.ramsay.ws.metadata.extractor.IsolatedClassLoader;
import com.github.veithen.ramsay.ws.metadata.extractor.MetadataExtractor;
import com.github.veithen.ramsay.ws.metadata.extractor.MetadataExtractorImpl;
import com.github.veithen.ramsay.ws.metadata.extractor.RepositoryMetadataCallback;
import com.github.veithen.ramsay.ws.metadata.repository.ChildContextTypeLink;
import com.github.veithen.ramsay.ws.metadata.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.metadata.repository.ContextType;
import com.github.veithen.ramsay.ws.metadata.repository.DefaultDocumentType;
import com.github.veithen.ramsay.ws.metadata.repository.RepositoryFactory;
import com.github.veithen.ramsay.ws.metadata.repository.RepositoryMetadata;

public class ExtractRawMetadataRunnable implements IWorkspaceRunnable, ConfigMetadataCallback, RepositoryMetadataCallback {
    private final File installDir;
    private final File profileDir;
    private final IFolder folder;
    private final URIConverter uriConverter = new ExtensibleURIConverterImpl();
    private final ResourceSet resourceSet = new ResourceSetImpl();
    private final Map<String,EPackage> packageMap = new HashMap<String,EPackage>();
    private final Map<String,DefaultDocumentType> documentTypeMap = new TreeMap<String,DefaultDocumentType>();
    private final Map<String,ContextType> contextTypeMap = new TreeMap<String,ContextType>();
    
    public ExtractRawMetadataRunnable(File installDir, File profileDir, IFolder folder) {
        this.installDir = installDir;
        this.profileDir = profileDir;
        this.folder = folder;
    }

    @Override
    public void run(IProgressMonitor monitor) throws CoreException {
        folder.delete(false, monitor);
        List<File> jars = new ArrayList<File>();
        for (File file : new File(installDir, "plugins").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".jar")) {
                jars.add(file);
            }
        }
        jars.add(new File(installDir, "lib/bootstrap.jar"));
        List<URL> urls = new ArrayList<URL>(jars.size());
        for (File jar : jars) {
            try {
                urls.add(jar.toURI().toURL());
            } catch (MalformedURLException ex) {
                throw new Error("Unexpected exception", ex);
            }
        }
        ClassLoader cl = new IsolatedClassLoader(urls.toArray(new URL[urls.size()]), ExtractRawMetadataRunnable.class.getClassLoader());
        Thread thread = Thread.currentThread();
        ClassLoader savedContextClassLoader = thread.getContextClassLoader();
        thread.setContextClassLoader(cl);
        try {
            MetadataExtractor extractor;
            try {
                extractor = (MetadataExtractor)cl.loadClass(MetadataExtractorImpl.class.getName()).newInstance();
            } catch (Exception ex) {
                throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to create metadata extractor", ex));
            }
            try {
                extractor.extractConfigMetadata(this);
            } catch (Exception ex) {
                throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Configuration metadata extraction failed", ex));
            }
            for (Resource resource : resourceSet.getResources()) {
                EMFUtil.load(resource);
                collectPackages((EPackage)resource.getContents().get(0));
            }
            try {
                extractor.extractRepositoryMetadata(new File(profileDir, "config/.repository").getAbsolutePath(), this);
            } catch (Exception ex) {
                throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Repository metadata extraction failed", ex));
            }
            Resource resource = resourceSet.createResource(EMFUtil.createURI(folder.getFile("repository-metadata.xmi")));
            RepositoryMetadata repositoryMetadata = RepositoryFactory.eINSTANCE.createRepositoryMetadata();
            repositoryMetadata.getDocumentTypes().addAll(documentTypeMap.values());
            repositoryMetadata.getContextTypes().addAll(contextTypeMap.values());
            resource.getContents().add(repositoryMetadata);
            EMFUtil.save(resource);
       } finally {
            thread.setContextClassLoader(savedContextClassLoader);
        }
    }
    
    private void collectPackages(EPackage ePackage) {
        packageMap.put(ePackage.getNsURI(), ePackage);
        for (EPackage eSubpackage : ePackage.getESubpackages()) {
            collectPackages(eSubpackage);
        }
    }
    
    @Override
    public String getEcoreFileURI(String ePackageName, String ePackageNsURI, String ePackageNsPrefix, String javaPackageName) {
        return EMFUtil.createURI(folder.getFile(javaPackageName + ".ecore")).toString();
    }

    @Override
    public OutputStream createOutputStream(String uriString) throws IOException {
        URI uri = URI.createURI(uriString);
        resourceSet.createResource(uri);
        return uriConverter.createOutputStream(uri);
    }

    @Override
    public void createDocumentType(String name, String filePattern) {
        DefaultDocumentType documentType = RepositoryFactory.eINSTANCE.createDefaultDocumentType();
        documentType.setName(name);
        documentType.setFilePattern(filePattern);
        documentTypeMap.put(name, documentType);
    }

    @Override
    public void addRootRefObjectType(String documentTypeName, String nsURI, String name) {
        documentTypeMap.get(documentTypeName).getRootRefObjectTypes().add((EClass)packageMap.get(nsURI).getEClassifier(name));
    }

    @Override
    public void createContextType(String name, String rootDocumentTypeName) {
        ContextType contextType = RepositoryFactory.eINSTANCE.createContextType();
        contextType.setName(name);
        contextType.setRootDocumentType(rootDocumentTypeName == null ? null : documentTypeMap.get(rootDocumentTypeName));
        contextTypeMap.put(name, contextType);
    }

    @Override
    public void linkDocumentTypeToContextType(String parent, String child) {
        ChildDocumentTypeLink link = RepositoryFactory.eINSTANCE.createChildDocumentTypeLink();
        link.setDocumentType(documentTypeMap.get(child));
        contextTypeMap.get(parent).getChildDocumentTypeLinks().add(link);
    }

    @Override
    public void linkContextTypes(String parent, String child) {
        ChildContextTypeLink link = RepositoryFactory.eINSTANCE.createChildContextTypeLink();
        link.setContextType(contextTypeMap.get(child));
        contextTypeMap.get(parent).getChildContextTypeLinks().add(link);
    }
}
