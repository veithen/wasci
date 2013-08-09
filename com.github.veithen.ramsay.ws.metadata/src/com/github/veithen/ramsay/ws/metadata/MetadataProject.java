package com.github.veithen.ramsay.ws.metadata;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.local.LocalPackageUtil;
import com.github.veithen.ramsay.emf.notify.DelegatingAdapterFactory;
import com.github.veithen.ramsay.emf.util.FolderSubset;
import com.github.veithen.ramsay.ws.metadata.extension.MetadataExtension;
import com.github.veithen.ramsay.ws.metadata.repository.RepositoryMetadata;
import com.github.veithen.ramsay.ws.metadata.repository.handler.ContextTypeHandler;
import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandler;

public class MetadataProject {
    private final IProject project;

    public MetadataProject(IProject project) {
        this.project = project;
    }
    
    public Metadata loadMetadata(final ResourceSet resourceSet) throws CoreException {
        IFolder modelsFolder = project.getFolder(Constants.RAW_PATH);
        final EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
        FolderSubset folderSubset = new FolderSubset(resourceSet, modelsFolder);
        folderSubset.load();
        registry.putAll(LocalPackageUtil.configureLocalPackageSupport(resourceSet).getLocalPackageMap());
        registry.put("http://www.ibm.com/websphere/appserver/schemas/6.0/pmiservice.xmi", registry.get("http://www.ibm.com/websphere/appserver/schemas/5.0/pmiservice.xmi"));
        Realm realm = new Realm();
        for (Object object : registry.values()) {
            realm.addPackage((EPackage)object);
        }
        RepositoryMetadata repositoryMetadata = (RepositoryMetadata)folderSubset.getResource(modelsFolder.getFile("repository-metadata.xmi")).getContents().get(0);
        
        resourceSet.getAdapterFactories().add(DelegatingAdapterFactory.getInstance(DocumentTypeHandler.class));
        resourceSet.getAdapterFactories().add(DelegatingAdapterFactory.getInstance(ContextTypeHandler.class));
        
        IConfigurationElement[] extensionConfig = Platform.getExtensionRegistry().getConfigurationElementsFor(Constants.METADATA_EXTENSIONS_ID);
        MetadataExtension[] metadataExtensions = new MetadataExtension[extensionConfig.length];
        for (int i=0; i<extensionConfig.length; i++) {
            metadataExtensions[i] = (MetadataExtension)extensionConfig[i].createExecutableExtension("class");
        }
        for (MetadataExtension metadataExtension : metadataExtensions) {
            metadataExtension.enhanceMetadata(repositoryMetadata);
        }
        
        return new Metadata(folderSubset, project.getFolder(Constants.TRANSFORMATIONS_PATH), project.getFolder(Constants.TRANSFORMED_PATH), realm, registry, repositoryMetadata);
    }

    public void extractRaw(IProgressMonitor monitor) throws CoreException {
        IEclipsePreferences prefs = new ProjectScope(project).getNode(Constants.PREFERENCES_NODE);
        project.getWorkspace().run(new ExtractRawMetadataRunnable(
                new File(prefs.get(Constants.PREF_INSTALL_DIR, null)), new File(prefs.get(Constants.PREF_PROFILE_DIR, null)),
                project.getFolder(Constants.RAW_PATH)),
                null, IWorkspace.AVOID_UPDATE, monitor);
    }
}
