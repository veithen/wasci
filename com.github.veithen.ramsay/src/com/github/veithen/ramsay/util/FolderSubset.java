package com.github.veithen.ramsay.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class FolderSubset {
    private final ResourceSet resourceSet;
    private IFolder folder;
    private Map<IFile,Resource> resourceMap = new HashMap<IFile,Resource>();
    
    public FolderSubset(ResourceSet resourceSet, IFolder folder) {
        this.resourceSet = resourceSet;
        this.folder = folder;
    }

    public void load() throws CoreException {
        final Map<IFile,Resource> resourceMap = this.resourceMap = new HashMap<IFile,Resource>();
        final IFolder folder = this.folder;
        folder.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE) {
                    IFile file = (IFile)resource;
                    resourceMap.put(file, EMFUtil.load(resourceSet, file));
                }
                return true;
            }
        });
    }
    
    public Resource getResource(IFile file) {
        return resourceMap.get(file);
    }
    
    public void mapTo(IFolder newFolder) {
        // Before changing the URIs we need to make sure that all proxies are resolved.
        // If we don't do this, the output files may contain references to the input files
        EcoreUtil.resolveAll(resourceSet);
        Map<IFile,Resource> newResourceMap = new HashMap<IFile,Resource>(resourceMap.size());
        // Now change the URIs.
        for (Map.Entry<IFile,Resource> entry : resourceMap.entrySet()) {
            IFile file = entry.getKey();
            Resource resource = entry.getValue();
            IPath relPath = file.getFullPath().makeRelativeTo(folder.getFullPath());
            IFile newFile = newFolder.getFile(relPath);
            resource.setURI(EMFUtil.createURI(newFile));
            newResourceMap.put(newFile, resource);
        }
        resourceMap = newResourceMap;
        folder = newFolder;
    }
    
    public Resource createResource(IPath path) {
        // TODO: we should check that the path actually refers to a location in the folder
        IFile file = folder.getFile(path);
        Resource resource = EMFUtil.createResource(resourceSet, file);
        resourceMap.put(file, resource);
        return resource;
    }
    
    public void save() throws CoreException {
        for (Resource resource : resourceMap.values()) {
            EMFUtil.save(resource);
        }
    }
}
