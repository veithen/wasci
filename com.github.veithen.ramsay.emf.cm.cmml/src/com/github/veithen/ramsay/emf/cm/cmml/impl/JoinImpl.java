/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.impl;

import com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage;
import com.github.veithen.ramsay.emf.cm.cmml.Join;
import com.github.veithen.ramsay.emf.cm.cmml.KeyMapping;
import com.github.veithen.ramsay.emf.cm.cmml.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl#getFrom <em>From</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl#getTo <em>To</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl#getReferenceName <em>Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl#getOppositeReferenceName <em>Opposite Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl#getKeyMappings <em>Key Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoinImpl extends TransformationImpl implements Join {
    /**
     * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFrom()
     * @generated
     * @ordered
     */
    protected Type from;

    /**
     * The cached value of the '{@link #getTo() <em>To</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
    protected Type to;

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
     * The cached value of the '{@link #getKeyMappings() <em>Key Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKeyMappings()
     * @generated
     * @ordered
     */
    protected EList<KeyMapping> keyMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JoinImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CMMLPackage.Literals.JOIN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getFrom() {
        return from;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFrom(Type newFrom, NotificationChain msgs) {
        Type oldFrom = from;
        from = newFrom;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CMMLPackage.JOIN__FROM, oldFrom, newFrom);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFrom(Type newFrom) {
        if (newFrom != from) {
            NotificationChain msgs = null;
            if (from != null)
                msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CMMLPackage.JOIN__FROM, null, msgs);
            if (newFrom != null)
                msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CMMLPackage.JOIN__FROM, null, msgs);
            msgs = basicSetFrom(newFrom, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.JOIN__FROM, newFrom, newFrom));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getTo() {
        return to;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTo(Type newTo, NotificationChain msgs) {
        Type oldTo = to;
        to = newTo;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CMMLPackage.JOIN__TO, oldTo, newTo);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTo(Type newTo) {
        if (newTo != to) {
            NotificationChain msgs = null;
            if (to != null)
                msgs = ((InternalEObject)to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CMMLPackage.JOIN__TO, null, msgs);
            if (newTo != null)
                msgs = ((InternalEObject)newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CMMLPackage.JOIN__TO, null, msgs);
            msgs = basicSetTo(newTo, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.JOIN__TO, newTo, newTo));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.JOIN__REFERENCE_NAME, oldReferenceName, referenceName));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CMMLPackage.JOIN__OPPOSITE_REFERENCE_NAME, oldOppositeReferenceName, oppositeReferenceName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<KeyMapping> getKeyMappings() {
        if (keyMappings == null) {
            keyMappings = new EObjectContainmentEList<KeyMapping>(KeyMapping.class, this, CMMLPackage.JOIN__KEY_MAPPINGS);
        }
        return keyMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CMMLPackage.JOIN__FROM:
                return basicSetFrom(null, msgs);
            case CMMLPackage.JOIN__TO:
                return basicSetTo(null, msgs);
            case CMMLPackage.JOIN__KEY_MAPPINGS:
                return ((InternalEList<?>)getKeyMappings()).basicRemove(otherEnd, msgs);
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
            case CMMLPackage.JOIN__FROM:
                return getFrom();
            case CMMLPackage.JOIN__TO:
                return getTo();
            case CMMLPackage.JOIN__REFERENCE_NAME:
                return getReferenceName();
            case CMMLPackage.JOIN__OPPOSITE_REFERENCE_NAME:
                return getOppositeReferenceName();
            case CMMLPackage.JOIN__KEY_MAPPINGS:
                return getKeyMappings();
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
            case CMMLPackage.JOIN__FROM:
                setFrom((Type)newValue);
                return;
            case CMMLPackage.JOIN__TO:
                setTo((Type)newValue);
                return;
            case CMMLPackage.JOIN__REFERENCE_NAME:
                setReferenceName((String)newValue);
                return;
            case CMMLPackage.JOIN__OPPOSITE_REFERENCE_NAME:
                setOppositeReferenceName((String)newValue);
                return;
            case CMMLPackage.JOIN__KEY_MAPPINGS:
                getKeyMappings().clear();
                getKeyMappings().addAll((Collection<? extends KeyMapping>)newValue);
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
            case CMMLPackage.JOIN__FROM:
                setFrom((Type)null);
                return;
            case CMMLPackage.JOIN__TO:
                setTo((Type)null);
                return;
            case CMMLPackage.JOIN__REFERENCE_NAME:
                setReferenceName(REFERENCE_NAME_EDEFAULT);
                return;
            case CMMLPackage.JOIN__OPPOSITE_REFERENCE_NAME:
                setOppositeReferenceName(OPPOSITE_REFERENCE_NAME_EDEFAULT);
                return;
            case CMMLPackage.JOIN__KEY_MAPPINGS:
                getKeyMappings().clear();
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
            case CMMLPackage.JOIN__FROM:
                return from != null;
            case CMMLPackage.JOIN__TO:
                return to != null;
            case CMMLPackage.JOIN__REFERENCE_NAME:
                return REFERENCE_NAME_EDEFAULT == null ? referenceName != null : !REFERENCE_NAME_EDEFAULT.equals(referenceName);
            case CMMLPackage.JOIN__OPPOSITE_REFERENCE_NAME:
                return OPPOSITE_REFERENCE_NAME_EDEFAULT == null ? oppositeReferenceName != null : !OPPOSITE_REFERENCE_NAME_EDEFAULT.equals(oppositeReferenceName);
            case CMMLPackage.JOIN__KEY_MAPPINGS:
                return keyMappings != null && !keyMappings.isEmpty();
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
        result.append(')');
        return result.toString();
    }

} //JoinImpl
