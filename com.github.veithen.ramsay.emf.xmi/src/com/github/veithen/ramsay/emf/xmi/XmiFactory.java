/**
 */
package com.github.veithen.ramsay.emf.xmi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.emf.xmi.XmiPackage
 * @generated
 */
public interface XmiFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    XmiFactory eINSTANCE = com.github.veithen.ramsay.emf.xmi.impl.XmiFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Documentation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Documentation</em>'.
     * @generated
     */
    Documentation createDocumentation();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    XmiPackage getXmiPackage();

} //XmiFactory
