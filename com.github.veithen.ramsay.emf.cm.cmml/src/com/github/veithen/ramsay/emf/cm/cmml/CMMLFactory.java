/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage
 * @generated
 */
public interface CMMLFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CMMLFactory eINSTANCE = com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Transformation Chain</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Transformation Chain</em>'.
     * @generated
     */
    TransformationChain createTransformationChain();

    /**
     * Returns a new object of class '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type</em>'.
     * @generated
     */
    Type createType();

    /**
     * Returns a new object of class '<em>Key Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Key Mapping</em>'.
     * @generated
     */
    KeyMapping createKeyMapping();

    /**
     * Returns a new object of class '<em>Join</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Join</em>'.
     * @generated
     */
    Join createJoin();

    /**
     * Returns a new object of class '<em>Change Multiplicity</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Change Multiplicity</em>'.
     * @generated
     */
    ChangeMultiplicity createChangeMultiplicity();

    /**
     * Returns a new object of class '<em>Remove Feature</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Remove Feature</em>'.
     * @generated
     */
    RemoveFeature createRemoveFeature();

    /**
     * Returns a new object of class '<em>Create Opposite Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Create Opposite Reference</em>'.
     * @generated
     */
    CreateOppositeReference createCreateOppositeReference();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    CMMLPackage getCMMLPackage();

} //CMMLFactory
