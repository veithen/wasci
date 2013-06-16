/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildDocument#getLink <em>Link</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildDocument#getDocument <em>Document</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildDocument()
 * @model
 * @generated
 */
public interface ChildDocument extends EObject {
    /**
     * Returns the value of the '<em><b>Link</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Link</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Link</em>' reference.
     * @see #setLink(ChildDocumentTypeLink)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildDocument_Link()
     * @model required="true"
     * @generated
     */
    ChildDocumentTypeLink getLink();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildDocument#getLink <em>Link</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Link</em>' reference.
     * @see #getLink()
     * @generated
     */
    void setLink(ChildDocumentTypeLink value);

    /**
     * Returns the value of the '<em><b>Document</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Document</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Document</em>' containment reference.
     * @see #setDocument(Document)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildDocument_Document()
     * @model containment="true" required="true"
     * @generated
     */
    Document getDocument();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildDocument#getDocument <em>Document</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Document</em>' containment reference.
     * @see #getDocument()
     * @generated
     */
    void setDocument(Document value);

} // ChildDocument
