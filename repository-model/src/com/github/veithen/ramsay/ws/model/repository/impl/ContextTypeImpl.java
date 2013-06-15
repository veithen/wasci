/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getChildContextTypes <em>Child Context Types</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getChildDocumentTypes <em>Child Document Types</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl#getRootDocumentType <em>Root Document Type</em>}</li>
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
     * The cached value of the '{@link #getChildContextTypes() <em>Child Context Types</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildContextTypes()
     * @generated
     * @ordered
     */
    protected EList<ContextType> childContextTypes;

    /**
     * The cached value of the '{@link #getChildDocumentTypes() <em>Child Document Types</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildDocumentTypes()
     * @generated
     * @ordered
     */
    protected EList<DocumentType> childDocumentTypes;

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
    public EList<ContextType> getChildContextTypes() {
        if (childContextTypes == null) {
            childContextTypes = new EObjectResolvingEList<ContextType>(ContextType.class, this, RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPES);
        }
        return childContextTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DocumentType> getChildDocumentTypes() {
        if (childDocumentTypes == null) {
            childDocumentTypes = new EObjectResolvingEList<DocumentType>(DocumentType.class, this, RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPES);
        }
        return childDocumentTypes;
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
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.CONTEXT_TYPE__NAME:
                return getName();
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPES:
                return getChildContextTypes();
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPES:
                return getChildDocumentTypes();
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                if (resolve) return getRootDocumentType();
                return basicGetRootDocumentType();
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
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPES:
                getChildContextTypes().clear();
                getChildContextTypes().addAll((Collection<? extends ContextType>)newValue);
                return;
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPES:
                getChildDocumentTypes().clear();
                getChildDocumentTypes().addAll((Collection<? extends DocumentType>)newValue);
                return;
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                setRootDocumentType((DocumentType)newValue);
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
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPES:
                getChildContextTypes().clear();
                return;
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPES:
                getChildDocumentTypes().clear();
                return;
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                setRootDocumentType((DocumentType)null);
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
            case RepositoryPackage.CONTEXT_TYPE__CHILD_CONTEXT_TYPES:
                return childContextTypes != null && !childContextTypes.isEmpty();
            case RepositoryPackage.CONTEXT_TYPE__CHILD_DOCUMENT_TYPES:
                return childDocumentTypes != null && !childDocumentTypes.isEmpty();
            case RepositoryPackage.CONTEXT_TYPE__ROOT_DOCUMENT_TYPE:
                return rootDocumentType != null;
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
