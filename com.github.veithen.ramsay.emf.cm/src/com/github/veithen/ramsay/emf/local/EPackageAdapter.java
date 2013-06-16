package com.github.veithen.ramsay.emf.local;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.cm.impl.AdapterBase;
import com.github.veithen.ramsay.emf.cm.impl.EMFUtil;

final class EPackageAdapter extends AdapterBase<EPackage> {
    private final ResourceSetAdapter resourceSetAdapter;
    private String originalNsURI;
    
    EPackageAdapter(ResourceSetAdapter resourceSetAdapter, EPackage target) {
        super(target);
        this.resourceSetAdapter = resourceSetAdapter;
    }

    boolean isLocal() {
        return resourceSetAdapter.isLocal(target);
    }
    
    String getOriginalNsURI() {
        return originalNsURI;
    }

    @Override
    protected void added() {
        for (EPackage ePackage : target.getESubpackages()) {
            resourceSetAdapter.addAdapter(ePackage);
        }
        if (isLocal()) {
            makeLocal();
        }
    }
    
    void makeLocal() {
        originalNsURI = target.getNsURI();
        setLocalNsURI();
    }
    
    private void setLocalNsURI() {
        target.setNsURI(EcoreUtil.getURI(target).toString());
    }
    
    @Override
    protected void removed() {
        if (isLocal()) {
            target.setNsURI(originalNsURI);
        }
        for (EPackage ePackage : target.getESubpackages()) {
            resourceSetAdapter.removeAdapter(ePackage);
        }
    }

    @Override
    protected void set(int featureId, Object value) {
        if (featureId == EcorePackage.EPACKAGE__ESUBPACKAGES) {
            resourceSetAdapter.addAdapter((EPackage)value);
        }
    }

    @Override
    protected void unset(int featureId, Object value) {
        if (featureId == EcorePackage.EPACKAGE__ESUBPACKAGES) {
            resourceSetAdapter.removeAdapter((EPackage)value);
        }
    }

    void resourceURIChanged() {
        if (isLocal()) {
            setLocalNsURI();
        }
        for (EPackage ePackage : target.getESubpackages()) {
            EMFUtil.getAdapter(EPackageAdapter.class, ePackage).resourceURIChanged();
        }
    }
}
