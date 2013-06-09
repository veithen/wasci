/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.impl;

import com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage;
import com.github.veithen.ramsay.emf.cm.cmml.Transformation;
import com.github.veithen.ramsay.emf.cm.cmml.Transformations;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationsImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationsImpl extends EObjectImpl implements Transformations {
    /**
     * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTransformation()
     * @generated
     * @ordered
     */
    protected EList<Transformation> transformation;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TransformationsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CMMLPackage.Literals.TRANSFORMATIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transformation> getTransformation() {
        if (transformation == null) {
            transformation = new EObjectContainmentEList<Transformation>(Transformation.class, this, CMMLPackage.TRANSFORMATIONS__TRANSFORMATION);
        }
        return transformation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CMMLPackage.TRANSFORMATIONS__TRANSFORMATION:
                return ((InternalEList<?>)getTransformation()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CMMLPackage.TRANSFORMATIONS__TRANSFORMATION:
                return getTransformation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CMMLPackage.TRANSFORMATIONS__TRANSFORMATION:
                getTransformation().clear();
                getTransformation().addAll((Collection<? extends Transformation>)newValue);
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
            case CMMLPackage.TRANSFORMATIONS__TRANSFORMATION:
                getTransformation().clear();
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
            case CMMLPackage.TRANSFORMATIONS__TRANSFORMATION:
                return transformation != null && !transformation.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TransformationsImpl
