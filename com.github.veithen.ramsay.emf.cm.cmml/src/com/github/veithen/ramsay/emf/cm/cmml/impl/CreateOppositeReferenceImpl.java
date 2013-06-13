/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.impl;

import com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage;
import com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference;
import com.github.veithen.ramsay.emf.cm.cmml.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Opposite Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.CreateOppositeReferenceImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.CreateOppositeReferenceImpl#getReferenceName <em>Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.CreateOppositeReferenceImpl#getOppositeReferenceName <em>Opposite Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.CreateOppositeReferenceImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.CreateOppositeReferenceImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateOppositeReferenceImpl extends TransformationImpl implements CreateOppositeReference {
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Type type;

    /**
     * The default value of the '{@link #getReferenceName() <em>Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferenceName()
     * @generated
     * @ordered
     */
    protected static final String REFERENCE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReferenceName() <em>Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferenceName()
     * @generated
     * @ordered
     */
    protected String referenceName = REFERENCE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getOppositeReferenceName() <em>Opposite Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOppositeReferenceName()
     * @generated
     * @ordered
     */
    protected static final String OPPOSITE_REFERENCE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOppositeReferenceName() <em>Opposite Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOppositeReferenceName()
     * @generated
     * @ordered
     */
    protected String oppositeReferenceName = OPPOSITE_REFERENCE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
    protected static final int LOWER_BOUND_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLowerBound()
     * @generated
     * @ordered
     */
    protected int lowerBound = LOWER_BOUND_EDEFAULT;

    /**
     * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
    protected static final int UPPER_BOUND_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpperBound()
     * @generated
     * @ordered
     */
    protected int upperBound = UPPER_BOUND_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CreateOppositeReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CMMLPackage.Literals.CREATE_OPPOSITE_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(Type newType, NotificationChain msgs) {
        Type oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE, oldType, newType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(Type newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE, null, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE, null, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE, newType, newType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReferenceName() {
        return referenceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferenceName(String newReferenceName) {
        String oldReferenceName = referenceName;
        referenceName = newReferenceName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.CREATE_OPPOSITE_REFERENCE__REFERENCE_NAME, oldReferenceName, referenceName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOppositeReferenceName() {
        return oppositeReferenceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOppositeReferenceName(String newOppositeReferenceName) {
        String oldOppositeReferenceName = oppositeReferenceName;
        oppositeReferenceName = newOppositeReferenceName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.CREATE_OPPOSITE_REFERENCE__OPPOSITE_REFERENCE_NAME, oldOppositeReferenceName, oppositeReferenceName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLowerBound(int newLowerBound) {
        int oldLowerBound = lowerBound;
        lowerBound = newLowerBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.CREATE_OPPOSITE_REFERENCE__LOWER_BOUND, oldLowerBound, lowerBound));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUpperBound(int newUpperBound) {
        int oldUpperBound = upperBound;
        upperBound = newUpperBound;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.CREATE_OPPOSITE_REFERENCE__UPPER_BOUND, oldUpperBound, upperBound));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE:
                return basicSetType(null, msgs);
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
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE:
                return getType();
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__REFERENCE_NAME:
                return getReferenceName();
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__OPPOSITE_REFERENCE_NAME:
                return getOppositeReferenceName();
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__LOWER_BOUND:
                return getLowerBound();
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__UPPER_BOUND:
                return getUpperBound();
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
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE:
                setType((Type)newValue);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__REFERENCE_NAME:
                setReferenceName((String)newValue);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__OPPOSITE_REFERENCE_NAME:
                setOppositeReferenceName((String)newValue);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__LOWER_BOUND:
                setLowerBound((Integer)newValue);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__UPPER_BOUND:
                setUpperBound((Integer)newValue);
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
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE:
                setType((Type)null);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__REFERENCE_NAME:
                setReferenceName(REFERENCE_NAME_EDEFAULT);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__OPPOSITE_REFERENCE_NAME:
                setOppositeReferenceName(OPPOSITE_REFERENCE_NAME_EDEFAULT);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__LOWER_BOUND:
                setLowerBound(LOWER_BOUND_EDEFAULT);
                return;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__UPPER_BOUND:
                setUpperBound(UPPER_BOUND_EDEFAULT);
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
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__TYPE:
                return type != null;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__REFERENCE_NAME:
                return REFERENCE_NAME_EDEFAULT == null ? referenceName != null : !REFERENCE_NAME_EDEFAULT.equals(referenceName);
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__OPPOSITE_REFERENCE_NAME:
                return OPPOSITE_REFERENCE_NAME_EDEFAULT == null ? oppositeReferenceName != null : !OPPOSITE_REFERENCE_NAME_EDEFAULT.equals(oppositeReferenceName);
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__LOWER_BOUND:
                return lowerBound != LOWER_BOUND_EDEFAULT;
            case CMMLPackage.CREATE_OPPOSITE_REFERENCE__UPPER_BOUND:
                return upperBound != UPPER_BOUND_EDEFAULT;
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
        result.append(" (referenceName: ");
        result.append(referenceName);
        result.append(", oppositeReferenceName: ");
        result.append(oppositeReferenceName);
        result.append(", lowerBound: ");
        result.append(lowerBound);
        result.append(", upperBound: ");
        result.append(upperBound);
        result.append(')');
        return result.toString();
    }

} //CreateOppositeReferenceImpl
