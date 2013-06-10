package com.github.veithen.ramsay.emf.cm.transform.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class SimpleKeyFactory implements KeyFactory {
    private final EStructuralFeature[] featurePath;

    public SimpleKeyFactory(EStructuralFeature[] featurePath) {
        this.featurePath = featurePath;
    }

    public EStructuralFeature[] getFeaturePath() {
        return featurePath;
    }

    @Override
    public boolean isNotNull() {
        for (EStructuralFeature feature : featurePath) {
            if (feature.getLowerBound() == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getKey(EObject object) {
        Object current = object;
        for (EStructuralFeature feature : featurePath) {
            current = ((EObject)current).eGet(feature);
            if (current == null) {
                return null;
            }
        }
        return current;
    }
}
