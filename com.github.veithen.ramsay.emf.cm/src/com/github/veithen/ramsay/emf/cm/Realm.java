package com.github.veithen.ramsay.emf.cm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import com.github.veithen.ramsay.emf.cm.impl.CovariantClassAdapter;
import com.github.veithen.ramsay.emf.cm.impl.CovariantPackageAdapter;
import com.github.veithen.ramsay.emf.cm.impl.EMFUtil;
import com.github.veithen.ramsay.emf.cm.impl.FactoryWrapper;

public class Realm {
    private final List<CovariantPackageAdapter> packageAdapters = new ArrayList<CovariantPackageAdapter>();
    
    public void addPackage(EPackage ePackage) {
        CovariantPackageAdapter adapter = EMFUtil.getAdapter(CovariantPackageAdapter.class, ePackage);
        if (adapter == null) {
            setup(ePackage);
        } else if (adapter.getRealm() != this) {
            throw new IllegalStateException();
        }
    }
    
    public EPackage createEPackage() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        setup(ePackage);
        return ePackage;
    }
    
    private void setup(EPackage ePackage) {
        CovariantPackageAdapter adapter = new CovariantPackageAdapter(this, ePackage);
        ePackage.eAdapters().add(adapter);
        ePackage.setEFactoryInstance(new FactoryWrapper(ePackage.getEFactoryInstance()));
        packageAdapters.add(adapter);
    }

    public EPackage getPackage(String uri) {
        for (CovariantPackageAdapter adapter : packageAdapters) {
            EPackage ePackage = adapter.getTarget();
            if (uri.equals(ePackage.getNsURI())) {
                return ePackage;
            }
        }
        return null;
    }
    
    public EObject[] getInstances(EClass eClass) {
        return EMFUtil.getAdapter(CovariantClassAdapter.class, eClass).getInstances().getInstances();
    }
    
    public boolean isCovariant(EClass eClass) {
        return EMFUtil.getAdapter(CovariantClassAdapter.class, eClass) != null;
    }
    
    // TODO: internal method
    /**
     * Get a list of all subclasses of the given type that are part of this realm.
     * 
     * @param eClass
     * @return
     */
    public List<CovariantClassAdapter> getSubclassAdapters(EClass eSuperClass) {
        List<CovariantClassAdapter> result = new ArrayList<CovariantClassAdapter>();
        for (CovariantPackageAdapter packageAdapter : packageAdapters) {
            for (EClassifier eClassifier : packageAdapter.getTarget().getEClassifiers()) {
                if (eClassifier instanceof EClass) {
                    EClass eClass = (EClass)eClassifier;
                    if (eClass.getESuperTypes().contains(eSuperClass)) {
                        result.add(EMFUtil.getAdapter(CovariantClassAdapter.class, eClass));
                    }
                }
            }
        }
        return result;
    }
}
