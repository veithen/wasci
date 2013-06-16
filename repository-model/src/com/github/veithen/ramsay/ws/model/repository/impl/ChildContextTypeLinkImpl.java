/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Context Type Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ChildContextTypeLinkImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ChildContextTypeLinkImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildContextTypeLinkImpl extends EObjectImpl implements ChildContextTypeLink {
    /**
     * The cached value of the '{@link #getContextType() <em>Context Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextType()
     * @generated
     * @ordered
     */
    protected ContextType contextType;

    /**
     * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReference()
     * @generated
     * @ordered
     */
    protected EReference reference;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildContextTypeLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.CHILD_CONTEXT_TYPE_LINK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextType getContextType() {
        if (contextType != null && contextType.eIsProxy()) {
            InternalEObject oldContextType = (InternalEObject)contextType;
            contextType = (ContextType)eResolveProxy(oldContextType);
            if (contextType != oldContextType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__CONTEXT_TYPE, oldContextType, contextType));
            }
        }
        return contextType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextType basicGetContextType() {
        return contextType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextType(ContextType newContextType) {
        ContextType oldContextType = contextType;
        contextType = newContextType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__CONTEXT_TYPE, oldContextType, contextType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReference() {
        if (reference != null && reference.eIsProxy()) {
            InternalEObject oldReference = (InternalEObject)reference;
            reference = (EReference)eResolveProxy(oldReference);
            if (reference != oldReference) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__REFERENCE, oldReference, reference));
            }
        }
        return reference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference basicGetReference() {
        return reference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReference(EReference newReference) {
        EReference oldReference = reference;
        reference = newReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__REFERENCE, oldReference, reference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__CONTEXT_TYPE:
                if (resolve) return getContextType();
                return basicGetContextType();
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__REFERENCE:
                if (resolve) return getReference();
                return basicGetReference();
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
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__CONTEXT_TYPE:
                setContextType((ContextType)newValue);
                return;
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__REFERENCE:
                setReference((EReference)newValue);
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
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__CONTEXT_TYPE:
                setContextType((ContextType)null);
                return;
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__REFERENCE:
                setReference((EReference)null);
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
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__CONTEXT_TYPE:
                return contextType != null;
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK__REFERENCE:
                return reference != null;
        }
        return super.eIsSet(featureID);
    }

} //ChildContextTypeLinkImpl
