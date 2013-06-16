/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Document Type Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink#getDocumentType <em>Document Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildDocumentTypeLink()
 * @model
 * @generated
 */
public interface ChildDocumentTypeLink extends EObject {
    /**
     * Returns the value of the '<em><b>Document Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Document Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Document Type</em>' reference.
     * @see #setDocumentType(DocumentType)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildDocumentTypeLink_DocumentType()
     * @model required="true"
     * @generated
     */
    DocumentType getDocumentType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink#getDocumentType <em>Document Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Document Type</em>' reference.
     * @see #getDocumentType()
     * @generated
     */
    void setDocumentType(DocumentType value);

    /**
     * Returns the value of the '<em><b>Reference</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference</em>' reference.
     * @see #setReference(EReference)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildDocumentTypeLink_Reference()
     * @model
     * @generated
     */
    EReference getReference();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
    void setReference(EReference value);

} // ChildDocumentTypeLink
