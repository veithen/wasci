/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.Document;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentImpl#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentImpl extends EObjectImpl implements Document {
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected DocumentType type;

    /**
     * The cached value of the '{@link #getContents() <em>Contents</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContents()
     * @generated
     * @ordered
     */
    protected EList contents;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.DOCUMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (DocumentType)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.DOCUMENT__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(DocumentType newType) {
        DocumentType oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.DOCUMENT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getContents() {
        if (contents == null) {
            contents = new EObjectResolvingEList(EObject.class, this, RepositoryPackage.DOCUMENT__CONTENTS);
        }
        return contents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.DOCUMENT__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case RepositoryPackage.DOCUMENT__CONTENTS:
                return getContents();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case RepositoryPackage.DOCUMENT__TYPE:
                setType((DocumentType)newValue);
                return;
            case RepositoryPackage.DOCUMENT__CONTENTS:
                getContents().clear();
                getContents().addAll((Collection)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset(int featureID) {
        switch (featureID) {
            case RepositoryPackage.DOCUMENT__TYPE:
                setType((DocumentType)null);
                return;
            case RepositoryPackage.DOCUMENT__CONTENTS:
                getContents().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case RepositoryPackage.DOCUMENT__TYPE:
                return type != null;
            case RepositoryPackage.DOCUMENT__CONTENTS:
                return contents != null && !contents.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //DocumentImpl
