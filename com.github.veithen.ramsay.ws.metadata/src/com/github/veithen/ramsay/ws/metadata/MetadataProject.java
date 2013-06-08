package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.xmi.XmiPackage;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

public class MetadataProject {
    private final IProject project;

    public MetadataProject(IProject project) {
        this.project = project;
    }
    
    public ContextType getCellContextType() throws CoreException {
        IFolder modelsFolder = project.getFolder(Constants.MODELS_PATH);
        IFile repositoryMetadata = modelsFolder.getFile("repository-metadata.xmi");
        ResourceSet resourceSet = new ResourceSetImpl();
        for (EObject object : EMFUtil.load(resourceSet, repositoryMetadata).getContents()) {
            if (object instanceof ContextType && ((ContextType)object).getName().equals("cells")) {
                return (ContextType)object;
            }
        }
        return null;
    }
    
    public Metadata loadMetadata() throws CoreException {
        IFolder modelsFolder = project.getFolder(Constants.MODELS_PATH);
        IFile repositoryMetadata = modelsFolder.getFile("repository-metadata.xmi");
        final EPackage.Registry registry = new EPackageRegistryImpl();
        final ResourceSet resourceSet = new ResourceSetImpl();
        modelsFolder.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE && resource.getName().endsWith(".ecore")) {
                    for (EObject content : EMFUtil.load(resourceSet, (IFile)resource).getContents()) {
                        EMFUtil.registerPackage(registry, (EPackage)content);
                    }
                }
                return true;
            }
        }, IResource.DEPTH_ONE, 0);
        registry.put("http://www.ibm.com/websphere/appserver/schemas/6.0/pmiservice.xmi", registry.get("http://www.ibm.com/websphere/appserver/schemas/5.0/pmiservice.xmi"));
        Realm realm = new Realm();
        for (Object object : registry.values()) {
            realm.addPackage((EPackage)object);
        }
        EMFUtil.registerPackage(registry, XmiPackage.eINSTANCE);
        EMFUtil.registerPackage(registry, RepositoryPackage.eINSTANCE);
        return new Metadata(realm, registry, EMFUtil.load(resourceSet, repositoryMetadata), new ModelMapper(realm));
    }
}
