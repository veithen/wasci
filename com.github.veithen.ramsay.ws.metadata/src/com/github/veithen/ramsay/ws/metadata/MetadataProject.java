package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.xmi.XmiPackage;
import com.github.veithen.ramsay.util.EMFUtil;
import com.github.veithen.ramsay.util.FolderSubset;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

public class MetadataProject {
    private final IProject project;

    public MetadataProject(IProject project) {
        this.project = project;
    }
    
    public ContextType getCellContextType() throws CoreException {
        IFolder modelsFolder = project.getFolder(Constants.RAW_PATH);
        IFile repositoryMetadata = modelsFolder.getFile("repository-metadata.xmi");
        ResourceSet resourceSet = new ResourceSetImpl();
        for (EObject object : EMFUtil.load(resourceSet, repositoryMetadata).getContents()) {
            if (object instanceof ContextType && ((ContextType)object).getName().equals("cells")) {
                return (ContextType)object;
            }
        }
        return null;
    }
    
    public Metadata loadMetadata(final ResourceSet resourceSet) throws CoreException {
        IFolder modelsFolder = project.getFolder(Constants.RAW_PATH);
        final EPackage.Registry registry = new EPackageRegistryImpl();
        FolderSubset folderSubset = new FolderSubset(resourceSet, modelsFolder);
        folderSubset.load();
        for (Resource resource : resourceSet.getResources()) {
            if (resource.getURI().lastSegment().endsWith(".ecore")) {
                for (EObject content : resource.getContents()) {
                    EMFUtil.registerPackage(registry, (EPackage)content);
                }
            }
        }
        registry.put("http://www.ibm.com/websphere/appserver/schemas/6.0/pmiservice.xmi", registry.get("http://www.ibm.com/websphere/appserver/schemas/5.0/pmiservice.xmi"));
        Realm realm = new Realm();
        for (Object object : registry.values()) {
            realm.addPackage((EPackage)object);
        }
        EMFUtil.registerPackage(registry, XmiPackage.eINSTANCE);
        EMFUtil.registerPackage(registry, RepositoryPackage.eINSTANCE);
        return new Metadata(folderSubset, project.getFolder(Constants.TRANSFORMATIONS_PATH), project.getFolder(Constants.TRANSFORMED_PATH), realm, registry, folderSubset.getResource(modelsFolder.getFile("repository-metadata.xmi")));
    }

    public void extractRaw(IProgressMonitor monitor) throws CoreException {
        project.getWorkspace().run(new ExtractRawRunnable(project.getFolder(Constants.RAW_PATH)),
                null, IWorkspace.AVOID_UPDATE, monitor);
    }
}
