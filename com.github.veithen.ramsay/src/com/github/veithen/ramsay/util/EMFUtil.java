package com.github.veithen.ramsay.util;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public final class EMFUtil {
    private EMFUtil() {}

    public static void registerPackage(EPackage.Registry registry, EPackage pkg) {
        System.out.println(pkg.getNsURI());
        registry.put(pkg.getNsURI(), pkg);
        for (EPackage subpkg : pkg.getESubpackages()) {
            registerPackage(registry, subpkg);
        }
    }
    
    public static URI createURI(IResource resource) {
        // See http://wiki.eclipse.org/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
        String path = resource.getFullPath().toString();
        if (resource.getType() == IResource.FOLDER) {
            path += "/";
        }
        return URI.createPlatformResourceURI(path, true);
    }
    
    public static boolean isPrefix(URI prefix, URI uri) {
        URI relativeURI = uri.deresolve(prefix);
        return relativeURI.isRelative() && !relativeURI.segment(0).equals("..");
    }
    
    public static Resource createResource(ResourceSet resourceSet, IFile file) {
        return resourceSet.createResource(createURI(file));
    }
    
    public static Resource getResource(ResourceSet resourceSet, IFile file) {
        return resourceSet.getResource(createURI(file), true);
    }
    
    public static Resource load(ResourceSet resourceSet, IFile file) throws CoreException {
        Resource resource = createResource(resourceSet, file);
        try {
            resource.load(null);
        } catch (IOException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to load file " + file.getName(), ex));
        }
        return resource;
    }
    
    public static void load(Resource resource) throws CoreException {
        try {
            resource.load(null);
        } catch (IOException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to load resource " + resource.getURI(), ex));
        }
    }
    
    public static void save(Resource resource) throws CoreException {
        try {
            resource.save(null);
        } catch (IOException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to save resource " + resource.getURI().toString(), ex));
        }
    }
}
