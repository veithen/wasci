package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import com.github.veithen.ramsay.emf.cm.Realm;

public class CovariantPackageAdapter extends AdapterBase<EPackage> {
    private final Realm realm;
    
    public CovariantPackageAdapter(Realm realm, EPackage target) {
        super(target);
        this.realm = realm;
    }

    public Realm getRealm() {
        return realm;
    }

    @Override
    protected void added() {
        for (EClassifier classifier : target.getEClassifiers()) {
            if (classifier instanceof EClass) {
                classifier.eAdapters().add(new CovariantClassAdapter((EClass)classifier));
            }
        }
    }

    @Override
    protected void removed() {
        // TODO
    }

    @Override
    protected void set(int featureId, Object value) {
        switch (featureId) {
            case EcorePackage.EPACKAGE__ECLASSIFIERS:
                if (value instanceof EClass) {
                    EClass eClass = (EClass)value;
                    eClass.eAdapters().add(new CovariantClassAdapter(eClass));
                }
                break;
        }
    }

    @Override
    protected void unset(int featureId, Object value) {
    }
}
