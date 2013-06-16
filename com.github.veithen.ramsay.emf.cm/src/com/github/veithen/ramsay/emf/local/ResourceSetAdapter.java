package com.github.veithen.ramsay.emf.local;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.github.veithen.ramsay.emf.cm.impl.AdapterBase;

final class ResourceSetAdapter extends AdapterBase<ResourceSet> {
    private final Set<EPackage> localPackages = new HashSet<EPackage>();
    
    ResourceSetAdapter(ResourceSet target) {
        super(target);
    }

    void addLocalPackage(EPackage ePackage) {
        localPackages.add(ePackage);
    }
    
    boolean isLocal(EPackage ePackage) {
        return localPackages.contains(ePackage);
    }
    
    @Override
    protected void added() {
        for (Resource resource : target.getResources()) {
            addAdapter(resource);
        }
    }

    @Override
    protected void removed() {
        for (Resource resource : target.getResources()) {
            removeAdapter(resource);
        }
    }

    @Override
    protected void set(int featureId, Object value) {
        if (featureId == ResourceSet.RESOURCE_SET__RESOURCES) {
            addAdapter((Resource)value);
        }
    }

    @Override
    protected void unset(int featureId, Object value) {
        if (featureId == ResourceSet.RESOURCE_SET__RESOURCES) {
            removeAdapter((Resource)value);
        }
    }
    
    private void addAdapter(Resource resource) {
        resource.eAdapters().add(new ResourceAdapter(this, resource));
    }
    
    void addAdapter(EPackage ePackage) {
        ePackage.eAdapters().add(new EPackageAdapter(this, ePackage));
    }
    
    private void removeAdapter(Resource resource) {
        for (Iterator<Adapter> it = resource.eAdapters().iterator(); it.hasNext(); ) {
            Adapter adapter = it.next();
            if (adapter instanceof ResourceAdapter) {
                it.remove();
                break;
            }
        }
    }
    
    void removeAdapter(EPackage ePackage) {
        for (Iterator<Adapter> it = ePackage.eAdapters().iterator(); it.hasNext(); ) {
            Adapter adapter = it.next();
            if (adapter instanceof EPackageAdapter) {
                it.remove();
                break;
            }
        }
    }
}
