/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink;
import com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getChildContextTypeLinks <em>Child Context Type Links</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getChildDocumentTypeLinks <em>Child Document Type Links</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getRootDocumentType <em>Root Document Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getGeneratedClass <em>Generated Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextTypeImpl extends EObjectImpl implements ContextType {
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
     * The cached value of the '{@link #getChildContextTypeLinks() <em>Child Context Type Links</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildContextTypeLinks()
     * @generated
     * @ordered
     */
    protected EList<ChildContextTypeLink> childContextTypeLinks;

    /**
     * The cached value of the '{@link #getChildDocumentTypeLinks() <em>Child Document Type Links</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildDocumentTypeLinks()
     * @generated
     * @ordered
     */
    protected EList<ChildDocumentTypeLink> childDocumentTypeLinks;

    /**
     * The cached value of the '{@link #getRootDocumentType() <em>Root Document Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRootDocumentType()
     * @generated
     * @ordered
     */
    protected DocumentType rootDocumentType;

    /**
     * The cached value of the '{@link #getGeneratedClass() <em>Generated Class</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGeneratedClass()
     * @generated
     * @ordered
     */
    protected EClass generatedClass;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContextTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.CONTEXT_TYPE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT_TYPE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ChildContextTypeLink> getChildContextTypeLinks() {
        if (childContextTypeLinks == null) {
            childContextTypeLinks = new EObjectContainmentEList<ChildContextTypeLink>(ChildContextTypeLink.class, this, RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPE_LINKS);
        }
        return childContextTypeLinks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ChildDocumentTypeLink> getChildDocumentTypeLinks() {
        if (childDocumentTypeLinks == null) {
            childDocumentTypeLinks = new EObjectContainmentEList<ChildDocumentTypeLink>(ChildDocumentTypeLink.class, this, RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPE_LINKS);
        }
        return childDocumentTypeLinks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType getRootDocumentType() {
        if (rootDocumentType != null && rootDocumentType.eIsProxy()) {
            InternalEObject oldRootDocumentType = (InternalEObject)rootDocumentType;
            rootDocumentType = (DocumentType)eResolveProxy(oldRootDocumentType);
            if (rootDocumentType != oldRootDocumentType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE, oldRootDocumentType, rootDocumentType));
            }
        }
        return rootDocumentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType basicGetRootDocumentType() {
        return rootDocumentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRootDocumentType(DocumentType newRootDocumentType) {
        DocumentType oldRootDocumentType = rootDocumentType;
        rootDocumentType = newRootDocumentType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE, oldRootDocumentType, rootDocumentType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGeneratedClass() {
        if (generatedClass != null && generatedClass.eIsProxy()) {
            InternalEObject oldGeneratedClass = (InternalEObject)generatedClass;
            generatedClass = (EClass)eResolveProxy(oldGeneratedClass);
            if (generatedClass != oldGeneratedClass) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.CONTEXT_TYPE__GENERATED_CLASS, oldGeneratedClass, generatedClass));
            }
        }
        return generatedClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass basicGetGeneratedClass() {
        return generatedClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGeneratedClass(EClass newGeneratedClass) {
        EClass oldGeneratedClass = generatedClass;
        generatedClass = newGeneratedClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.CONTEXT_TYPE__GENERATED_CLASS, oldGeneratedClass, generatedClass));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPE_LINKS:
                return ((InternalEList<?>)getChildContextTypeLinks()).basicRemove(otherEnd, msgs);
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPE_LINKS:
                return ((InternalEList<?>)getChildDocumentTypeLinks()).basicRemove(otherEnd, msgs);
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
            case RepositoryPackage.CONTEXT_TYPE__NAME:
                return getName();
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPE_LINKS:
                return getChildContextTypeLinks();
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPE_LINKS:
                return getChildDocumentTypeLinks();
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                if (resolve) return getRootDocumentType();
                return basicGetRootDocumentType();
            case RepositoryPackage.CONTEXT_TYPE__GENERATED_CLASS:
                if (resolve) return getGeneratedClass();
                return basicGetGeneratedClass();
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
            case RepositoryPackage.CONTEXT_TYPE__NAME:
                setName((String)newValue);
                return;
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPE_LINKS:
                getChildContextTypeLinks().clear();
                getChildContextTypeLinks().addAll((Collection<? extends ChildContextTypeLink>)newValue);
                return;
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPE_LINKS:
                getChildDocumentTypeLinks().clear();
                getChildDocumentTypeLinks().addAll((Collection<? extends ChildDocumentTypeLink>)newValue);
                return;
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                setRootDocumentType((DocumentType)newValue);
                return;
            case RepositoryPackage.CONTEXT_TYPE__GENERATED_CLASS:
                setGeneratedClass((EClass)newValue);
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
            case RepositoryPackage.CONTEXT_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPE_LINKS:
                getChildContextTypeLinks().clear();
                return;
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPE_LINKS:
                getChildDocumentTypeLinks().clear();
                return;
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                setRootDocumentType((DocumentType)null);
                return;
            case RepositoryPackage.CONTEXT_TYPE__GENERATED_CLASS:
                setGeneratedClass((EClass)null);
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
            case RepositoryPackage.CONTEXT_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPE_LINKS:
                return childContextTypeLinks != null && !childContextTypeLinks.isEmpty();
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPE_LINKS:
                return childDocumentTypeLinks != null && !childDocumentTypeLinks.isEmpty();
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                return rootDocumentType != null;
            case RepositoryPackage.CONTEXT_TYPE__GENERATED_CLASS:
                return generatedClass != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //ContextTypeImpl
