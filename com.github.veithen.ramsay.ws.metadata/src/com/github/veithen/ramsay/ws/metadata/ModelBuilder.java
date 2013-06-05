package com.github.veithen.ramsay.ws.metadata;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ModelBuilder extends IncrementalProjectBuilder {
    public static final String ID = Constants.PLUGIN_ID + ".builder";
    
    @Override
    protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        IResourceDelta delta = getDelta(project);
        // Note: delta == null means unspecified changes
        if (kind == FULL_BUILD || delta == null || delta.findMember(Constants.MODELS_PATH) != null) {
            System.out.println("Build required");
            doBuild(monitor);
        }
        return null;
    }
    
    private void doBuild(IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        MetadataProject metadataProject = (MetadataProject)project.getAdapter(MetadataProject.class);
        Metadata metadata = metadataProject.loadMetadata();
        ModelMapper modelMapper = metadata.getModelMapper();
        modelMapper.map(metadata.getCellContextType());
        ResourceSet outResourceSet = new ResourceSetImpl();
        IFile outFile = project.getFile(Constants.METADATA_FILE);
        Resource outResource = EMFUtil.createResource(outResourceSet, outFile);
        outResource.getContents().add(modelMapper.getEPackage());
        EMFUtil.save(outResource);
        outFile.refreshLocal(IResource.DEPTH_ONE, monitor);
    }
}
