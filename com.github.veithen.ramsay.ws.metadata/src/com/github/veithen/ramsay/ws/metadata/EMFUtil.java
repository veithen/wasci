package com.github.veithen.ramsay.ws.metadata;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
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
        for (EPackage subpkg : (List<EPackage>)pkg.getESubpackages()) {
            registerPackage(registry, subpkg);
        }
    }
    
    public static Resource createResource(ResourceSet resourceSet, IFile file) {
        // See http://wiki.eclipse.org/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
        return resourceSet.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
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
    
    public static void save(Resource resource) throws CoreException {
        try {
            resource.save(null);
        } catch (IOException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to save resource " + resource.getURI().toString(), ex));
        }
    }
}
