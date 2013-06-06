package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;
import org.eclipse.emf.ecore.impl.EObjectImpl;

public class CovariantObject extends EObjectImpl implements EStructuralFeature.Internal.DynamicValueHolder {
    private final Instances instances;
    private final int instanceID;
    
    public CovariantObject(Instances instances, int instanceID) {
        this.instances = instances;
        this.instanceID = instanceID;
        eSetClass(instances.getEClass());
    }

    @Override
    protected DynamicValueHolder eSettings() {
        return this;
    }

    @Override
    public Object dynamicGet(int dynamicFeatureID) {
        return instances.get(instanceID, eStaticFeatureCount() + dynamicFeatureID);
    }

    @Override
    public void dynamicSet(int dynamicFeatureID, Object newValue) {
        instances.set(instanceID, eStaticFeatureCount() + dynamicFeatureID, newValue);
    }

    @Override
    public void dynamicUnset(int dynamicFeatureID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
