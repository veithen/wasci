/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.Context;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.Document;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

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
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl#getRootDocument <em>Root Document</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl#getChildDocuments <em>Child Documents</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl#getChildContexts <em>Child Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextImpl extends EObjectImpl implements Context {
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ContextType type;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getRootDocument() <em>Root Document</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRootDocument()
     * @generated
     * @ordered
     */
    protected Document rootDocument;

    /**
     * The cached value of the '{@link #getChildDocuments() <em>Child Documents</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildDocuments()
     * @generated
     * @ordered
     */
    protected EList childDocuments;

    /**
     * The cached value of the '{@link #getChildContexts() <em>Child Contexts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildContexts()
     * @generated
     * @ordered
     */
    protected EList childContexts;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.CONTEXT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextType getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (ContextType)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CONTEXT__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextType basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(ContextType newType) {
        ContextType oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Document getRootDocument() {
        return rootDocument;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRootDocument(Document newRootDocument, NotificationChain msgs) {
        Document oldRootDocument = rootDocument;
        rootDocument = newRootDocument;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT__ROOT_DOCUMENT, oldRootDocument, newRootDocument);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRootDocument(Document newRootDocument) {
        if (newRootDocument != rootDocument) {
            NotificationChain msgs = null;
            if (rootDocument != null)
                msgs = ((InternalEObject)rootDocument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.CONTEXT__ROOT_DOCUMENT, null, msgs);
            if (newRootDocument != null)
                msgs = ((InternalEObject)newRootDocument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.CONTEXT__ROOT_DOCUMENT, null, msgs);
            msgs = basicSetRootDocument(newRootDocument, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT__ROOT_DOCUMENT, newRootDocument, newRootDocument));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getChildDocuments() {
        if (childDocuments == null) {
            childDocuments = new EObjectContainmentEList(Document.class, this, RepositoryPackage.CONTEXT__CHILD_DOCUMENTS);
        }
        return childDocuments;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getChildContexts() {
        if (childContexts == null) {
            childContexts = new EObjectContainmentEList(Context.class, this, RepositoryPackage.CONTEXT__CHILD_CONTEXTS);
        }
        return childContexts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.CONTEXT__ROOT_DOCUMENT:
                return basicSetRootDocument(null, msgs);
            case RepositoryPackage.CONTEXT__CHILD_DOCUMENTS:
                return ((InternalEList)getChildDocuments()).basicRemove(otherEnd, msgs);
            case RepositoryPackage.CONTEXT__CHILD_CONTEXTS:
                return ((InternalEList)getChildContexts()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.CONTEXT__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case RepositoryPackage.CONTEXT__NAME:
                return getName();
            case RepositoryPackage.CONTEXT__ROOT_DOCUMENT:
                return getRootDocument();
            case RepositoryPackage.CONTEXT__CHILD_DOCUMENTS:
                return getChildDocuments();
            case RepositoryPackage.CONTEXT__CHILD_CONTEXTS:
                return getChildContexts();
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
            case RepositoryPackage.CONTEXT__TYPE:
                setType((ContextType)newValue);
                return;
            case RepositoryPackage.CONTEXT__NAME:
                setName((String)newValue);
                return;
            case RepositoryPackage.CONTEXT__ROOT_DOCUMENT:
                setRootDocument((Document)newValue);
                return;
            case RepositoryPackage.CONTEXT__CHILD_DOCUMENTS:
                getChildDocuments().clear();
                getChildDocuments().addAll((Collection)newValue);
                return;
            case RepositoryPackage.CONTEXT__CHILD_CONTEXTS:
                getChildContexts().clear();
                getChildContexts().addAll((Collection)newValue);
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
            case RepositoryPackage.CONTEXT__TYPE:
                setType((ContextType)null);
                return;
            case RepositoryPackage.CONTEXT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RepositoryPackage.CONTEXT__ROOT_DOCUMENT:
                setRootDocument((Document)null);
                return;
            case RepositoryPackage.CONTEXT__CHILD_DOCUMENTS:
                getChildDocuments().clear();
                return;
            case RepositoryPackage.CONTEXT__CHILD_CONTEXTS:
                getChildContexts().clear();
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
            case RepositoryPackage.CONTEXT__TYPE:
                return type != null;
            case RepositoryPackage.CONTEXT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case RepositoryPackage.CONTEXT__ROOT_DOCUMENT:
                return rootDocument != null;
            case RepositoryPackage.CONTEXT__CHILD_DOCUMENTS:
                return childDocuments != null && !childDocuments.isEmpty();
            case RepositoryPackage.CONTEXT__CHILD_CONTEXTS:
                return childContexts != null && !childContexts.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //ContextImpl
