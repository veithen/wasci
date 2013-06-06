package com.github.veithen.ramsay.emf.cm;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

public class DefaultEPackageFactory implements EPackageFactory {
    public static final DefaultEPackageFactory INSTANCE = new DefaultEPackageFactory();
    
    private DefaultEPackageFactory() {}
    
    @Override
    public EPackage createEPackage() {
        return EcoreFactory.eINSTANCE.createEPackage();
    }
}
