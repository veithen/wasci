/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getName <em>Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getChildContextTypes <em>Child Context Types</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getChildDocumentTypes <em>Child Document Types</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getRootDocumentType <em>Root Document Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType()
 * @model
 * @generated
 */
public interface ContextType extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Child Context Types</b></em>' reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.ContextType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Context Types</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Context Types</em>' reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_ChildContextTypes()
     * @model type="com.github.veithen.ramsay.ws.model.repository.ContextType"
     * @generated
     */
    EList getChildContextTypes();

    /**
     * Returns the value of the '<em><b>Child Document Types</b></em>' reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.DocumentType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Document Types</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Document Types</em>' reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_ChildDocumentTypes()
     * @model type="com.github.veithen.ramsay.ws.model.repository.DocumentType"
     * @generated
     */
    EList getChildDocumentTypes();

    /**
     * Returns the value of the '<em><b>Root Document Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Document Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root Document Type</em>' reference.
     * @see #setRootDocumentType(DocumentType)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_RootDocumentType()
     * @model
     * @generated
     */
    DocumentType getRootDocumentType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getRootDocumentType <em>Root Document Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root Document Type</em>' reference.
     * @see #getRootDocumentType()
     * @generated
     */
    void setRootDocumentType(DocumentType value);

} // ContextType
