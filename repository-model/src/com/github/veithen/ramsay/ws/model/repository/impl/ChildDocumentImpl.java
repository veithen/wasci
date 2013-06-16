/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.ChildDocument;
import com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.model.repository.Document;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Child Document</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ChildDocumentImpl#getLink <em>Link</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ChildDocumentImpl#getDocument <em>Document</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChildDocumentImpl extends EObjectImpl implements ChildDocument {
    /**
     * The cached value of the '{@link #getLink() <em>Link</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLink()
     * @generated
     * @ordered
     */
    protected ChildDocumentTypeLink link;

    /**
     * The cached value of the '{@link #getDocument() <em>Document</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDocument()
     * @generated
     * @ordered
     */
    protected Document document;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildDocumentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.CHILD_DOCUMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChildDocumentTypeLink getLink() {
        if (link != null && link.eIsProxy()) {
            InternalEObject oldLink = (InternalEObject)link;
            link = (ChildDocumentTypeLink)eResolveProxy(oldLink);
            if (link != oldLink) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CHILD_DOCUMENT__LINK, oldLink, link));
            }
        }
        return link;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChildDocumentTypeLink basicGetLink() {
        return link;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLink(ChildDocumentTypeLink newLink) {
        ChildDocumentTypeLink oldLink = link;
        link = newLink;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_DOCUMENT__LINK, oldLink, link));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Document getDocument() {
        return document;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDocument(Document newDocument, NotificationChain msgs) {
        Document oldDocument = document;
        document = newDocument;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_DOCUMENT__DOCUMENT, oldDocument, newDocument);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDocument(Document newDocument) {
        if (newDocument != document) {
            NotificationChain msgs = null;
            if (document != null)
                msgs = ((InternalEObject)document).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.CHILD_DOCUMENT__DOCUMENT, null, msgs);
            if (newDocument != null)
                msgs = ((InternalEObject)newDocument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.CHILD_DOCUMENT__DOCUMENT, null, msgs);
            msgs = basicSetDocument(newDocument, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CHILD_DOCUMENT__DOCUMENT, newDocument, newDocument));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.CHILD_DOCUMENT__DOCUMENT:
                return basicSetDocument(null, msgs);
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
            case RepositoryPackage.CHILD_DOCUMENT__LINK:
                if (resolve) return getLink();
                return basicGetLink();
            case RepositoryPackage.CHILD_DOCUMENT__DOCUMENT:
                return getDocument();
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
            case RepositoryPackage.CHILD_DOCUMENT__LINK:
                setLink((ChildDocumentTypeLink)newValue);
                return;
            case RepositoryPackage.CHILD_DOCUMENT__DOCUMENT:
                setDocument((Document)newValue);
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
            case RepositoryPackage.CHILD_DOCUMENT__LINK:
                setLink((ChildDocumentTypeLink)null);
                return;
            case RepositoryPackage.CHILD_DOCUMENT__DOCUMENT:
                setDocument((Document)null);
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
            case RepositoryPackage.CHILD_DOCUMENT__LINK:
                return link != null;
            case RepositoryPackage.CHILD_DOCUMENT__DOCUMENT:
                return document != null;
        }
        return super.eIsSet(featureID);
    }

} //ChildDocumentImpl
