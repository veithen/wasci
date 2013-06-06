package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public class CovariantObject extends EObjectImpl {
    private final Instances instances;
    private final int instanceID;
    
    public CovariantObject(Instances instances, int instanceID) {
        this.instances = instances;
        this.instanceID = instanceID;
    }

    @Override
    protected EClass eStaticClass() {
        return instances.getEClass();
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        return instances.eGet(instanceID, featureID);
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        instances.eSet(instanceID, feature, newValue);
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return instances.eIsSet(instanceID, feature);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
