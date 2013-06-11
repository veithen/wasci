package com.github.veithen.ramsay.ws.extract;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.github.veithen.ramsay.util.FolderSubset;
import com.github.veithen.ramsay.util.SimpleBuilder;
import com.github.veithen.ramsay.ws.metadata.Metadata;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;

public class Builder extends SimpleBuilder {
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
    protected void doBuild(IFolder[] inputFolders, final IFolder outputFolder, IProgressMonitor monitor) throws CoreException {
        IFolder inputFolder = inputFolders[0];
        ExtractionProject project = (ExtractionProject)getProject().getAdapter(ExtractionProject.class);
        ResourceSet resourceSet = new ResourceSetImpl();
        MetadataProject metadataProject = project.getMetadataProject();
        Metadata metadata = metadataProject.loadMetadata(new ResourceSetImpl() /* resourceSet */); // TODO
        Registry registry = metadata.getRegistry();
        resourceSet.setPackageRegistry(registry);
        FolderSubset folderSubset = new FolderSubset(resourceSet, inputFolder);
        folderSubset.load();
        
        // TODO: need to pass this to the metadata project so that it can transform contexts
        folderSubset.getResource(inputFolder.getFile("index.xmi"));
        
        metadata.getTransformer().transform(metadata.getRealm());

        folderSubset.mapTo(outputFolder);
        folderSubset.save();
    }
}
