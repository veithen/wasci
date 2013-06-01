/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentTypeImpl#getFilePattern <em>File Pattern</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentTypeImpl#getRootRefObjectTypes <em>Root Ref Object Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentTypeImpl extends EObjectImpl implements DocumentType {
    /**
     * The default value of the '{@link #getFilePattern() <em>File Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilePattern()
     * @generated
     * @ordered
     */
    protected static final String FILE_PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFilePattern() <em>File Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilePattern()
     * @generated
     * @ordered
     */
    protected String filePattern = FILE_PATTERN_EDEFAULT;

    /**
     * The cached value of the '{@link #getRootRefObjectTypes() <em>Root Ref Object Types</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRootRefObjectTypes()
     * @generated
     * @ordered
     */
    protected EList rootRefObjectTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.DOCUMENT_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFilePattern() {
        return filePattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilePattern(String newFilePattern) {
        String oldFilePattern = filePattern;
        filePattern = newFilePattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.DOCUMENT_TYPE__FILE_PATTERN, oldFilePattern, filePattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList getRootRefObjectTypes() {
        if (rootRefObjectTypes == null) {
            rootRefObjectTypes = new EObjectResolvingEList(EClass.class, this, RepositoryPackage.DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES);
        }
        return rootRefObjectTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.DOCUMENT_TYPE__FILE_PATTERN:
                return getFilePattern();
            case RepositoryPackage.DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES:
                return getRootRefObjectTypes();
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
            case RepositoryPackage.DOCUMENT_TYPE__FILE_PATTERN:
                setFilePattern((String)newValue);
                return;
            case RepositoryPackage.DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES:
                getRootRefObjectTypes().clear();
                getRootRefObjectTypes().addAll((Collection)newValue);
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
            case RepositoryPackage.DOCUMENT_TYPE__FILE_PATTERN:
                setFilePattern(FILE_PATTERN_EDEFAULT);
                return;
            case RepositoryPackage.DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES:
                getRootRefObjectTypes().clear();
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
            case RepositoryPackage.DOCUMENT_TYPE__FILE_PATTERN:
                return FILE_PATTERN_EDEFAULT == null ? filePattern != null : !FILE_PATTERN_EDEFAULT.equals(filePattern);
            case RepositoryPackage.DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES:
                return rootRefObjectTypes != null && !rootRefObjectTypes.isEmpty();
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
        result.append(" (filePattern: ");
        result.append(filePattern);
        result.append(')');
        return result.toString();
    }

} //DocumentTypeImpl
