/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.impl;

import com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage;
import com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Remove Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.RemoveFeatureImpl#getConsistencyCheck <em>Consistency Check</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RemoveFeatureImpl extends FeatureTransformationImpl implements RemoveFeature {
    /**
     * The default value of the '{@link #getConsistencyCheck() <em>Consistency Check</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConsistencyCheck()
     * @generated
     * @ordered
     */
    protected static final String CONSISTENCY_CHECK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConsistencyCheck() <em>Consistency Check</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConsistencyCheck()
     * @generated
     * @ordered
     */
    protected String consistencyCheck = CONSISTENCY_CHECK_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RemoveFeatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CMMLPackage.Literals.REMOVE_FEATURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConsistencyCheck() {
        return consistencyCheck;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConsistencyCheck(String newConsistencyCheck) {
        String oldConsistencyCheck = consistencyCheck;
        consistencyCheck = newConsistencyCheck;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.REMOVE_FEATURE__CONSISTENCY_CHECK, oldConsistencyCheck, consistencyCheck));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CMMLPackage.REMOVE_FEATURE__CONSISTENCY_CHECK:
                return getConsistencyCheck();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CMMLPackage.REMOVE_FEATURE__CONSISTENCY_CHECK:
                setConsistencyCheck((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case CMMLPackage.REMOVE_FEATURE__CONSISTENCY_CHECK:
                setConsistencyCheck(CONSISTENCY_CHECK_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case CMMLPackage.REMOVE_FEATURE__CONSISTENCY_CHECK:
                return CONSISTENCY_CHECK_EDEFAULT == null ? consistencyCheck != null : !CONSISTENCY_CHECK_EDEFAULT.equals(consistencyCheck);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (consistencyCheck: ");
        result.append(consistencyCheck);
        result.append(')');
        return result.toString();
    }

} //RemoveFeatureImpl
