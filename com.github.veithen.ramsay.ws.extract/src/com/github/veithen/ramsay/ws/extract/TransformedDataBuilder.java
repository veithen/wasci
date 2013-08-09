package com.github.veithen.ramsay.ws.extract;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.emf.util.FolderSubset;
import com.github.veithen.ramsay.util.SimpleBuilder;
import com.github.veithen.ramsay.ws.metadata.Metadata;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.metadata.repository.Context;

public class TransformedDataBuilder extends SimpleBuilder {
    public static final String ID = Constants.PLUGIN_ID + ".builder";
    
    @Override
    protected IPath[] getInputPaths() {
        return new IPath[] { Constants.RAW_PATH };
    }

    @Override
    protected IPath getOutputPath() {
        return Constants.TRANSFORMED_PATH;
    }

    @Override
    protected void doBuild(IFolder[] inputFolders, IFolder outputFolder, IProgressMonitor monitor) throws CoreException {
        IFolder inputFolder = inputFolders[0];
        DataProject project = (DataProject)getProject().getAdapter(DataProject.class);
        ResourceSet resourceSet = new ResourceSetImpl();
        MetadataProject metadataProject = project.getMetadataProject();
        Metadata metadata = metadataProject.loadMetadata(resourceSet);
        FolderSubset folderSubset = new FolderSubset(resourceSet, inputFolder);
        folderSubset.load();
        metadata.setRootContext((Context)folderSubset.getResource(inputFolder.getFile("index.xmi")).getContents().get(0));
        metadata.transform();
        outputFolder.delete(false, monitor);
        folderSubset.mapTo(outputFolder);
        folderSubset.save();
    }
}
