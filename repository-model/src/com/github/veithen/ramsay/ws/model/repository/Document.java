/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Document#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Document#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject {
    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(DocumentType)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getDocument_Type()
     * @model required="true"
     * @generated
     */
    DocumentType getType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.Document#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(DocumentType value);

    /**
     * Returns the value of the '<em><b>Contents</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Contents</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Contents</em>' reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getDocument_Contents()
     * @model type="org.eclipse.emf.ecore.EObject"
     * @generated
     */
    EList getContents();

} // Document
