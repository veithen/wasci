package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.util.SimpleBuilder;

public class ModelBuilder extends SimpleBuilder {
    public static final String ID = Constants.PLUGIN_ID + ".builder";
    
    @Override
    protected IPath[] getInputPaths() {
        return new IPath[] { Constants.MODELS_PATH, Constants.TRANSFORMATIONS_PATH };
    }

    @Override
    protected IPath getOutputPath() {
        return Constants.TRANSFORMED_PATH;
    }

    @Override
    protected void doBuild(IFolder[] inputFolders, IFolder outputFolder, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        MetadataProject metadataProject = (MetadataProject)project.getAdapter(MetadataProject.class);
        ResourceSet resourceSet = new ResourceSetImpl();
        Metadata metadata = metadataProject.loadMetadata(resourceSet);
        metadata.getTransformer().transform(metadata.getRealm());
        metadata.getFolderSubset().save();
    }
    
    /*
    @Override
    protected void doBuild(IFolder inputFolder, IFolder outputFolder, IProgressMonitor monitor) throws CoreException {
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
    */
}
