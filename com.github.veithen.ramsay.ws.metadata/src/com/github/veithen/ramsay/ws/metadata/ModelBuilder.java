package com.github.veithen.ramsay.ws.metadata;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.ws.model.repository.ContextType;

public class ModelBuilder extends IncrementalProjectBuilder {
    public static final String ID = "com.github.veithen.ramsay.ws.metadata.builder";
    
    public static final IPath MODELS_PATH = new Path("models");
    
    @Override
    protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        IResourceDelta delta = getDelta(project);
        // Note: delta == null means unspecified changes
        if (kind == FULL_BUILD || delta == null || delta.findMember(MODELS_PATH) != null) {
            System.out.println("Build required");
            doBuild(monitor);
        }
        return null;
    }
    
    private void doBuild(IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        IFolder modelsFolder = project.getFolder(MODELS_PATH);
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
        ContextType cellContextType = null;
        for (EObject object : EMFUtil.load(resourceSet, repositoryMetadata).getContents()) {
            if (object instanceof ContextType) {
                ContextType contextType = (ContextType)object;
                if (contextType.getName().equals("cells")) {
                    cellContextType = contextType;
                    break;
                }
            }
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(cellContextType);
        ResourceSet outResourceSet = new ResourceSetImpl();
        IFile outFile = project.getFile("wsconfig.ecore");
        Resource outResource = EMFUtil.createResource(outResourceSet, outFile);
        outResource.getContents().add(modelMapper.getEPackage());
        EMFUtil.save(outResource);
        outFile.refreshLocal(IResource.DEPTH_ONE, monitor);
    }
}
