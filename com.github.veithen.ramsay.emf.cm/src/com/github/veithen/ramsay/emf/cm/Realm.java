package com.github.veithen.ramsay.emf.cm;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import com.github.veithen.ramsay.emf.cm.impl.CovariantPackageAdapter;
import com.github.veithen.ramsay.emf.cm.impl.EMFUtil;
import com.github.veithen.ramsay.emf.cm.impl.FactoryWrapper;

public class Realm {
    public void addPackage(EPackage ePackage) {
        CovariantPackageAdapter adapter = EMFUtil.getAdapter(CovariantPackageAdapter.class, ePackage);
        if (adapter == null) {
            ePackage.eAdapters().add(new CovariantPackageAdapter(this, ePackage));
            ePackage.setEFactoryInstance(new FactoryWrapper(ePackage.getEFactoryInstance()));
        } else if (adapter.getRealm() != this) {
            throw new IllegalStateException();
        }
    }
    
    public EPackage createEPackage() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.eAdapters().add(new CovariantPackageAdapter(this, ePackage));
        ePackage.setEFactoryInstance(new FactoryWrapper(ePackage.getEFactoryInstance()));
        return ePackage;
    }
}
