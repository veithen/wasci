package com.github.veithen.ramsay.emf.cm;

import org.eclipse.emf.ecore.EPackage;

public class CovariantEPackageFactory implements EPackageFactory {
    private final Realm realm = new Realm();

    @Override
    public EPackage createEPackage() {
        return realm.createEPackage();
    }
}
