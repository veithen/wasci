package com.github.veithen.ramsay.emf.local;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.github.veithen.ramsay.emf.cm.impl.EMFUtil;

public final class LocalPackageUtil {
    private LocalPackageUtil() {}
    
    public static void makePackageLocal(ResourceSet resourceSet, EPackage ePackage) {
        ResourceSetAdapter resourceSetAdapter = null;
        for (Adapter adapter : resourceSet.eAdapters()) {
            if (adapter instanceof ResourceSetAdapter) {
                resourceSetAdapter = (ResourceSetAdapter)adapter;
                break;
            }
        }
        if (resourceSetAdapter == null) {
            resourceSetAdapter = new ResourceSetAdapter(resourceSet);
            resourceSet.eAdapters().add(resourceSetAdapter);
        }
        resourceSetAdapter.addLocalPackage(ePackage);
        Resource resource = ePackage.eResource();
        if (resource != null && resource.getResourceSet() == resourceSet) {
            EMFUtil.getAdapter(EPackageAdapter.class, ePackage).makeLocal();
        }
    }
    
    public static String getOriginalNsURI(EPackage ePackage) {
        EPackageAdapter adapter = EMFUtil.getAdapter(EPackageAdapter.class, ePackage);
        if (adapter == null || !adapter.isLocal()) {
            return ePackage.getNsURI();
        } else {
            return adapter.getOriginalNsURI();
        }
    }
}
