package com.github.veithen.ramsay.emf.cm.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Instances {
    private final EClass eClass;
    private final Map<EStructuralFeature,Object[]> valueMap = new HashMap<EStructuralFeature,Object[]>();
    private int capacity = 10;
    private int instanceCount;

    public Instances(EClass eClass) {
        this.eClass = eClass;
        for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            featureAdded(feature);
        }
    }
    
    public void featureAdded(EStructuralFeature feature) {
        valueMap.put(feature, new Object[capacity]);
    }

    public void featureRemoved(EStructuralFeature feature) {
        valueMap.remove(feature);
    }
    
    public EClass getEClass() {
        return eClass;
    }

    public EObject newInstance() {
        if (instanceCount == capacity) {
            int newCapacity = capacity*2;
            for (Map.Entry<EStructuralFeature,Object[]> entry : valueMap.entrySet()) {
                Object[] oldValues = entry.getValue();
                Object[] newValues = new Object[newCapacity];
                System.arraycopy(oldValues, 0, newValues, 0, capacity);
                entry.setValue(newValues);
            }
            capacity = newCapacity;
        }
        return new CovariantObject(this, instanceCount++);
    }
    
    private Object[] getValues(int featureID) {
        EStructuralFeature feature = eClass.getEStructuralFeature(featureID);
        Object[] values = valueMap.get(feature);
        if (values == null) {
            throw new IllegalArgumentException(feature.getName() + " is not a feature of " + eClass.getName());
        }
        return values;
    }
    
    public Object get(int instanceID, int featureID) {
        return getValues(featureID)[instanceID];
    }
    
    public void set(int instanceId, int featureID, Object newValue) {
        getValues(featureID)[instanceId] = newValue;
    }
}
