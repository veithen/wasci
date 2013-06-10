/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.impl;

import com.github.veithen.ramsay.emf.cm.cmml.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CMMLFactoryImpl extends EFactoryImpl implements CMMLFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CMMLFactory init() {
        try {
            CMMLFactory theCMMLFactory = (CMMLFactory)EPackage.Registry.INSTANCE.getEFactory("http://github.com/veithen/ramsay/cm/cmml"); 
            if (theCMMLFactory != null) {
                return theCMMLFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new CMMLFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMLFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case CMMLPackage.TRANSFORMATION_CHAIN: return createTransformationChain();
            case CMMLPackage.TYPE: return createType();
            case CMMLPackage.KEY_MAPPING: return createKeyMapping();
            case CMMLPackage.JOIN: return createJoin();
            case CMMLPackage.CHANGE_MULTIPLICITY: return createChangeMultiplicity();
            case CMMLPackage.REMOVE_FEATURE: return createRemoveFeature();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TransformationChain createTransformationChain() {
        TransformationChainImpl transformationChain = new TransformationChainImpl();
        return transformationChain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type createType() {
        TypeImpl type = new TypeImpl();
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KeyMapping createKeyMapping() {
        KeyMappingImpl keyMapping = new KeyMappingImpl();
        return keyMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Join createJoin() {
        JoinImpl join = new JoinImpl();
        return join;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChangeMultiplicity createChangeMultiplicity() {
        ChangeMultiplicityImpl changeMultiplicity = new ChangeMultiplicityImpl();
        return changeMultiplicity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RemoveFeature createRemoveFeature() {
        RemoveFeatureImpl removeFeature = new RemoveFeatureImpl();
        return removeFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMLPackage getCMMLPackage() {
        return (CMMLPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CMMLPackage getPackage() {
        return CMMLPackage.eINSTANCE;
    }

} //CMMLFactoryImpl
