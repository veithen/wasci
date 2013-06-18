package com.github.veithen.ramsay.emf.local;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.github.veithen.ramsay.emf.cm.impl.AdapterBase;

final class ResourceSetAdapter extends AdapterBase<ResourceSet> {
    private final LocalPackageSupport localPackageSupport;
    private final Set<EPackage> localPackages = new HashSet<EPackage>();
    
    ResourceSetAdapter(LocalPackageSupport localPackageSupport, ResourceSet target) {
        super(target);
        this.localPackageSupport = localPackageSupport;
    }

    LocalPackageSupport getLocalPackageSupport() {
        return localPackageSupport;
    }

    void addLocalPackage(EPackage ePackage) {
        localPackages.add(ePackage);
    }
    
    void removeLocalPackage(EPackage ePackage) {
        localPackages.remove(ePackage);
    }
    
    Map<String,EPackage> getLocalPackageMap() {
        Map<String,EPackage> map = new HashMap<String,EPackage>();
        for (EPackage localPackage : localPackages) {
            map.put(localPackage.getEAnnotation(LocalPackageSupport.ANNOTATION_URI).getDetails().get(LocalPackageSupport.ORIGINAL_NS_URI), localPackage);
        }
        return map;
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
