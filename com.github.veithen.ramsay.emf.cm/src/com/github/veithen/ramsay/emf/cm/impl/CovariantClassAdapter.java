package com.github.veithen.ramsay.emf.cm.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.github.veithen.ramsay.emf.cm.Realm;

public class CovariantClassAdapter extends AdapterBase<EClass> {
    private final Instances instances;
    private List<CovariantClassAdapter> subclassAdapters;
    
    public CovariantClassAdapter(EClass target) {
        super(target);
        instances = new Instances(target);
    }

    public Realm getRealm() {
        // Note that the CovariantClassAdapter can only exist on a EClass if it is part of a covariant
        // EPackage. Therefore we should never get a NullPointerException here.
        return EMFUtil.getAdapter(CovariantPackageAdapter.class, target.getEPackage()).getRealm();
    }
    
    @Override
    protected void added() {
        subclassAdapters = getRealm().getSubclassAdapters(target);
    }

    @Override
    protected void removed() {
    }

    @Override
    protected void set(int featureId, Object value) {
        switch (featureId) {
            case EcorePackage.ECLASS__ESTRUCTURAL_FEATURES:
                featureAdded((EStructuralFeature)value);
                break;
            case EcorePackage.ECLASS__ESUPER_TYPES:
                EClass superclass = (EClass)value;
                CovariantClassAdapter superClassAdapter = EMFUtil.getAdapter(CovariantClassAdapter.class, superclass);
                if (superClassAdapter != null) {
                    superClassAdapter.subclassAdapters.add(this);
                }
                // TODO: possibly wrong for multiple inheritance
                for (EStructuralFeature feature : superclass.getEAllStructuralFeatures()) {
                    featureAdded(feature);
                }
                break;
        }
    }
    
    @Override
    protected void unset(int featureId, Object value) {
        switch (featureId) {
            case EcorePackage.ECLASS__ESTRUCTURAL_FEATURES:
                featureRemoved((EStructuralFeature)value);
                break;
            case EcorePackage.ECLASS__ESUPER_TYPES:
                CovariantClassAdapter superClassAdapter = EMFUtil.getAdapter(CovariantClassAdapter.class, (EClass)value);
                if (superClassAdapter != null) {
                    superClassAdapter.subclassAdapters.remove(this);
                }
                break;
        }
    }
    
    private void featureAdded(EStructuralFeature feature) {
        instances.featureAdded(feature);
        for (CovariantClassAdapter subclassAdapter : subclassAdapters) {
            subclassAdapter.featureAdded(feature);
        }
    }
    
    private void featureRemoved(EStructuralFeature feature) {
        instances.featureRemoved(feature);
        for (CovariantClassAdapter subclassAdapter : subclassAdapters) {
            subclassAdapter.featureAdded(feature);
        }
    }

    public Instances getInstances() {
        return instances;
    }
}
