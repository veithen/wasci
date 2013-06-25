package com.github.veithen.ramsay.emf.local;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

public final class LocalPackageSupport {
    public static final String ANNOTATION_URI = "http://github.com/veithen/ramsay/emf/local";
    public static final String ORIGINAL_NS_URI = "originalNsURI";
    
    private final ResourceSetAdapter resourceSetAdapter;
    
    LocalPackageSupport(ResourceSet resourceSet) {
        resourceSetAdapter = new ResourceSetAdapter(this, resourceSet);
        resourceSet.eAdapters().add(resourceSetAdapter);
    }
    
    public Map<String,EPackage> getLocalPackageMap() {
        return resourceSetAdapter.getLocalPackageMap();
    }
}
