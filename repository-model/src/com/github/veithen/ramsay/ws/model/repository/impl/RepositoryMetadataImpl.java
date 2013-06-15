/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryMetadata;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metadata</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.RepositoryMetadataImpl#getContextTypes <em>Context Types</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.RepositoryMetadataImpl#getDocumentTypes <em>Document Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryMetadataImpl extends EObjectImpl implements RepositoryMetadata {
    /**
     * The cached value of the '{@link #getContextTypes() <em>Context Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextTypes()
     * @generated
     * @ordered
     */
    protected EList<ContextType> contextTypes;

    /**
     * The cached value of the '{@link #getDocumentTypes() <em>Document Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDocumentTypes()
     * @generated
     * @ordered
     */
    protected EList<DocumentType> documentTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RepositoryMetadataImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REPOSITORY_METADATA;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ContextType> getContextTypes() {
        if (contextTypes == null) {
            contextTypes = new EObjectContainmentEList<ContextType>(ContextType.class, this, RepositoryPackage.REPOSITORY_METADATA__CONTEXT_TYPES);
        }
        return contextTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DocumentType> getDocumentTypes() {
        if (documentTypes == null) {
            documentTypes = new EObjectContainmentEList<DocumentType>(DocumentType.class, this, RepositoryPackage.REPOSITORY_METADATA__DOCUMENT_TYPES);
        }
        return documentTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.REPOSITORY_METADATA__CONTEXT_TYPES:
                return ((InternalEList<?>)getContextTypes()).basicRemove(otherEnd, msgs);
            case RepositoryPackage.REPOSITORY_METADATA__DOCUMENT_TYPES:
                return ((InternalEList<?>)getDocumentTypes()).basicRemove(otherEnd, msgs);
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
            case RepositoryPackage.REPOSITORY_METADATA__CONTEXT_TYPES:
                return getContextTypes();
            case RepositoryPackage.REPOSITORY_METADATA__DOCUMENT_TYPES:
                return getDocumentTypes();
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
            case RepositoryPackage.REPOSITORY_METADATA__CONTEXT_TYPES:
                getContextTypes().clear();
                getContextTypes().addAll((Collection<? extends ContextType>)newValue);
                return;
            case RepositoryPackage.REPOSITORY_METADATA__DOCUMENT_TYPES:
                getDocumentTypes().clear();
                getDocumentTypes().addAll((Collection<? extends DocumentType>)newValue);
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
            case RepositoryPackage.REPOSITORY_METADATA__CONTEXT_TYPES:
                getContextTypes().clear();
                return;
            case RepositoryPackage.REPOSITORY_METADATA__DOCUMENT_TYPES:
                getDocumentTypes().clear();
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
            case RepositoryPackage.REPOSITORY_METADATA__CONTEXT_TYPES:
                return contextTypes != null && !contextTypes.isEmpty();
            case RepositoryPackage.REPOSITORY_METADATA__DOCUMENT_TYPES:
                return documentTypes != null && !documentTypes.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //RepositoryMetadataImpl
