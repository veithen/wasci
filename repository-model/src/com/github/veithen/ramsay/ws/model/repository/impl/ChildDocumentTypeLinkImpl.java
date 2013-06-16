/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Document Type Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ChildDocumentTypeLinkImpl#getDocumentType <em>Document Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ChildDocumentTypeLinkImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildDocumentTypeLinkImpl extends EObjectImpl implements ChildDocumentTypeLink {
    /**
     * The cached value of the '{@link #getDocumentType() <em>Document Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDocumentType()
     * @generated
     * @ordered
     */
    protected DocumentType documentType;

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
    protected ChildDocumentTypeLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.CHILD_DOCUMENT_TYPE_LINK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType getDocumentType() {
        if (documentType != null && documentType.eIsProxy()) {
            InternalEObject oldDocumentType = (InternalEObject)documentType;
            documentType = (DocumentType)eResolveProxy(oldDocumentType);
            if (documentType != oldDocumentType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__DOCUMENT_TYPE, oldDocumentType, documentType));
            }
        }
        return documentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType basicGetDocumentType() {
        return documentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDocumentType(DocumentType newDocumentType) {
        DocumentType oldDocumentType = documentType;
        documentType = newDocumentType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__DOCUMENT_TYPE, oldDocumentType, documentType));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__REFERENCE, oldReference, reference));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__REFERENCE, oldReference, reference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__DOCUMENT_TYPE:
                if (resolve) return getDocumentType();
                return basicGetDocumentType();
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__REFERENCE:
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
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__DOCUMENT_TYPE:
                setDocumentType((DocumentType)newValue);
                return;
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__REFERENCE:
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
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__DOCUMENT_TYPE:
                setDocumentType((DocumentType)null);
                return;
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__REFERENCE:
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
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__DOCUMENT_TYPE:
                return documentType != null;
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK__REFERENCE:
                return reference != null;
        }
        return super.eIsSet(featureID);
    }

} //ChildDocumentTypeLinkImpl
