package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.util.SimpleBuilder;

public class TransformedMetadataBuilder extends SimpleBuilder {
    public static final String ID = Constants.PLUGIN_ID + ".builder";
    
    @Override
    protected BuildInput[] getInputs() {
        return new BuildInput[] {
                new BuildInput(Constants.RAW_PATH, true),
                new BuildInput(Constants.TRANSFORMATIONS_PATH, false) };
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
        metadata.transform();
        outputFolder.delete(false, monitor);
        metadata.getFolderSubset().save();
    }
}
