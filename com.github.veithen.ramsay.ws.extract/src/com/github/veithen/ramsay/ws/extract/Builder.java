package com.github.veithen.ramsay.ws.extract;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.util.SimpleBuilder;
import com.github.veithen.ramsay.ws.metadata.EMFUtil;

public class Builder extends SimpleBuilder {
    public static final String ID = Constants.PLUGIN_ID + ".builder";
    
    @Override
    protected IPath getInputPath() {
        return Constants.RAW_PATH;
    }

    @Override
    protected IPath getOutputPath() {
        return Constants.TRANSFORMED_PATH;
    }

    @Override
    protected void doBuild(final IFolder inputFolder, final IFolder outputFolder, IProgressMonitor monitor) throws CoreException {
        ExtractionProject project = (ExtractionProject)getProject().getAdapter(ExtractionProject.class);
        final ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.setPackageRegistry(project.getMetadataProject().loadMetadata().getRegistry());
        final Map<Resource,IFile> resourceMap = new HashMap<Resource,IFile>();
        inputFolder.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE) {
                    IFile file = (IFile)resource;
                    IPath relPath = file.getFullPath().makeRelativeTo(inputFolder.getFullPath());
                    resourceMap.put(EMFUtil.load(resourceSet, file), outputFolder.getFile(relPath));
                }
                return true;
            }
        });
        
        // Before changing the URIs we need to make sure that all proxies are resolved.
        // If we don't do this, the output files may contain references to the input files
        for (Resource resource : resourceMap.keySet()) {
            EcoreUtil.resolveAll(resource);
        }
        // Now change the URIs.
        for (Map.Entry<Resource,IFile> entry : resourceMap.entrySet()) {
            entry.getKey().setURI(EMFUtil.createURI(entry.getValue()));
        }
        // Only save after all URIs have been changed
        for (Resource resource : resourceMap.keySet()) {
            EMFUtil.save(resource);
        }
    }
}
