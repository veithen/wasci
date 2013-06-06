package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class CovariantClassAdapter extends AdapterBase<EClass> {
    private final Instances instances;
    
    public CovariantClassAdapter(EClass target) {
        super(target);
        instances = new Instances(target);
    }

    @Override
    protected void added() {
    }

    @Override
    protected void removed() {
    }

    @Override
    protected void set(int featureId, Object value) {
        switch (featureId) {
            case EcorePackage.ECLASS__ESTRUCTURAL_FEATURES:
                instances.featureAdded((EStructuralFeature)value);
                break;
        }
    }

    @Override
    protected void unset(int featureId, Object value) {
    }
    
    public Instances getInstances() {
        return instances;
    }
}
