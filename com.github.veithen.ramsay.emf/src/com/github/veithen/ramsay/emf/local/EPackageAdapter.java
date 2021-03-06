package com.github.veithen.ramsay.emf.local;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.notify.AdapterBase;
import com.github.veithen.ramsay.emf.util.EMFUtil;

final class EPackageAdapter extends AdapterBase<EPackage> {
    private final ResourceSetAdapter resourceSetAdapter;
    
    EPackageAdapter(ResourceSetAdapter resourceSetAdapter, EPackage target) {
        super(target);
        this.resourceSetAdapter = resourceSetAdapter;
    }

    boolean isLocal() {
        return target.getEAnnotation(LocalPackageSupport.ANNOTATION_URI) != null;
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
        EAnnotation ann = target.getEAnnotation(LocalPackageSupport.ANNOTATION_URI);
        EMap<String,String> details = ann.getDetails();
        if (!details.containsKey(LocalPackageSupport.ORIGINAL_NS_URI)) {
            details.put(LocalPackageSupport.ORIGINAL_NS_URI, target.getNsURI());
        }
        setLocalNsURI();
        resourceSetAdapter.addLocalPackage(target);
    }
    
    private void setLocalNsURI() {
        target.setNsURI(EcoreUtil.getURI(target).toString());
    }
    
    @Override
    protected void removed() {
        if (isLocal()) {
            resourceSetAdapter.removeLocalPackage(target);
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
