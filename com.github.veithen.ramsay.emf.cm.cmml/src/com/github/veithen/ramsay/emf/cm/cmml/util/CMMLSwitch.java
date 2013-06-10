/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.util;

import com.github.veithen.ramsay.emf.cm.cmml.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage
 * @generated
 */
public class CMMLSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static CMMLPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMLSwitch() {
        if (modelPackage == null) {
            modelPackage = CMMLPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case CMMLPackage.TRANSFORMATION: {
                Transformation transformation = (Transformation)theEObject;
                T result = caseTransformation(transformation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.TRANSFORMATION_CHAIN: {
                TransformationChain transformationChain = (TransformationChain)theEObject;
                T result = caseTransformationChain(transformationChain);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.TYPE: {
                Type type = (Type)theEObject;
                T result = caseType(type);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.KEY_MAPPING: {
                KeyMapping keyMapping = (KeyMapping)theEObject;
                T result = caseKeyMapping(keyMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.JOIN: {
                Join join = (Join)theEObject;
                T result = caseJoin(join);
                if (result == null) result = caseTransformation(join);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.FEATURE_TRANSFORMATION: {
                FeatureTransformation featureTransformation = (FeatureTransformation)theEObject;
                T result = caseFeatureTransformation(featureTransformation);
                if (result == null) result = caseTransformation(featureTransformation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.CHANGE_MULTIPLICITY: {
                ChangeMultiplicity changeMultiplicity = (ChangeMultiplicity)theEObject;
                T result = caseChangeMultiplicity(changeMultiplicity);
                if (result == null) result = caseFeatureTransformation(changeMultiplicity);
                if (result == null) result = caseTransformation(changeMultiplicity);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CMMLPackage.REMOVE_FEATURE: {
                RemoveFeature removeFeature = (RemoveFeature)theEObject;
                T result = caseRemoveFeature(removeFeature);
                if (result == null) result = caseFeatureTransformation(removeFeature);
                if (result == null) result = caseTransformation(removeFeature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transformation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transformation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransformation(Transformation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transformation Chain</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transformation Chain</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransformationChain(TransformationChain object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType(Type object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Key Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyMapping(KeyMapping object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Join</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Join</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJoin(Join object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Feature Transformation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Feature Transformation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFeatureTransformation(FeatureTransformation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Change Multiplicity</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Change Multiplicity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChangeMultiplicity(ChangeMultiplicity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Remove Feature</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Remove Feature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRemoveFeature(RemoveFeature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //CMMLSwitch
