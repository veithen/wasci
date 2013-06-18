package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.local.LocalPackageUtil;
import com.github.veithen.ramsay.emf.xmi.XmiPackage;
import com.github.veithen.ramsay.util.EMFUtil;
import com.github.veithen.ramsay.util.FolderSubset;
import com.github.veithen.ramsay.ws.model.repository.RepositoryMetadata;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

public class MetadataProject {
    private final IProject project;

    public MetadataProject(IProject project) {
        this.project = project;
    }
    
    public Metadata loadMetadata(final ResourceSet resourceSet) throws CoreException {
        IFolder modelsFolder = project.getFolder(Constants.RAW_PATH);
        final EPackage.Registry registry = new EPackageRegistryImpl();
        FolderSubset folderSubset = new FolderSubset(resourceSet, modelsFolder);
        folderSubset.load();
        registry.putAll(LocalPackageUtil.configureLocalPackageSupport(resourceSet).getLocalPackageMap());
        registry.put("http://www.ibm.com/websphere/appserver/schemas/6.0/pmiservice.xmi", registry.get("http://www.ibm.com/websphere/appserver/schemas/5.0/pmiservice.xmi"));
        Realm realm = new Realm();
        for (Object object : registry.values()) {
            realm.addPackage((EPackage)object);
        }
        EMFUtil.registerPackage(registry, XmiPackage.eINSTANCE);
        EMFUtil.registerPackage(registry, RepositoryPackage.eINSTANCE);
        return new Metadata(folderSubset, project.getFolder(Constants.TRANSFORMATIONS_PATH), project.getFolder(Constants.TRANSFORMED_PATH), realm, registry, (RepositoryMetadata)folderSubset.getResource(modelsFolder.getFile("repository-metadata.xmi")).getContents().get(0));
    }

    public void extractRaw(IProgressMonitor monitor) throws CoreException {
        project.getWorkspace().run(new ExtractRawRunnable(project.getFolder(Constants.RAW_PATH)),
                null, IWorkspace.AVOID_UPDATE, monitor);
    }
}
