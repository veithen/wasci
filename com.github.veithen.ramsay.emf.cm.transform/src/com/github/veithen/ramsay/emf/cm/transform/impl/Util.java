package com.github.veithen.ramsay.emf.cm.transform.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.cmml.Type;
import com.github.veithen.ramsay.emf.local.LocalPackageUtil;

public final class Util {
    private Util() {}
    
    /**
     * Look up the given type from the realm.
     * 
     * @param realm
     * @param type
     * @return
     */
    public static EClass resolve(Realm realm, Type type) throws CoreException {
        EPackage ePackage = null;
        for (EPackage candidate : realm.getPackages()) {
            if (LocalPackageUtil.getOriginalNsURI(candidate).equals(type.getNsURI())) {
                ePackage = candidate;
                break;
            }
        }
        if (ePackage == null) {
            throw new CoreException(new TransformationStatus(IStatus.ERROR, "No EPackage with URI " + type.getNsURI() + " found", type));
        }
        EClass eClass = (EClass)ePackage.getEClassifier(type.getName());
        if (eClass == null) {
            throw new CoreException(new TransformationStatus(IStatus.ERROR, "Class " + type.getName() + " not found", type));
        }
        return eClass;
    }
    
    public static String formatKey(Object key) {
        return key instanceof EObject ? EcoreUtil.getURI((EObject)key).toString() : String.valueOf(key);
    }
}
