package com.github.veithen.ramsay.emf.cm.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.NotifyingInternalEListImpl;

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
    
    private Object[] getValues(EStructuralFeature feature) {
        Object[] values = valueMap.get(feature);
        if (values == null) {
            throw new IllegalArgumentException(feature.getName() + " is not a feature of " + eClass.getName());
        }
        return values;
    }
    
    public boolean eIsSet(int instanceId, EStructuralFeature feature) {
        Object value = getValues(feature)[instanceId];
        // TODO: need to take default values into account
        if (value == null) {
            return false;
        } else if (feature.isMany()) {
            return !((EList<?>)value).isEmpty();
        } else {
            return true;
        }
    }
    
    public Object eGet(int instanceID, int featureID) {
        EStructuralFeature feature = eClass.getEStructuralFeature(featureID);
        Object[] values = getValues(feature);
        Object value = values[instanceID];
        if (value == null && feature instanceof EReference && ((EReference)feature).isMany()) {
            value = new NotifyingInternalEListImpl();
            values[instanceID] = value;
        }
        return value;
    }
    
    public void eSet(int instanceId, EStructuralFeature feature, Object newValue) {
        getValues(feature)[instanceId] = newValue;
    }
}
