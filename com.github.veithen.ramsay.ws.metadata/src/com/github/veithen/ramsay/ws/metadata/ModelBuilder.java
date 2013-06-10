package com.github.veithen.ramsay.ws.metadata;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.util.EMFUtil;
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
        Metadata metadata = metadataProject.loadMetadata();
        metadataProject.getTransformer().transform(metadata.getRealm());
        
        // TODO: unify this with the code in the other builder
        URI inputFolderURI = EMFUtil.createURI(inputFolders[0]);
        URI outputFolderURI = EMFUtil.createURI(outputFolder);
        List<Resource> resources = new ArrayList<Resource>();
        for (Resource resource : metadata.getResourceSet().getResources()) {
            if (EMFUtil.isPrefix(inputFolderURI, resource.getURI())) {
                resources.add(resource);
            }
        }
        // Note: resolving proxies may modify the list of resources. To avoid ConcurrentModificationException,
        //       we need to do this in a second step
        for (Resource resource : resources) {
            EcoreUtil.resolveAll(resource);
        }
        for (Resource resource : resources) {
            resource.setURI(resource.getURI().replacePrefix(inputFolderURI, outputFolderURI));
        }
        for (Resource resource : resources) {
            EMFUtil.save(resource);
        }
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
