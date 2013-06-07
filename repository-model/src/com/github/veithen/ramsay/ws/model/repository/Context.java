/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Context#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Context#getName <em>Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Context#getRootDocument <em>Root Document</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Context#getChildDocuments <em>Child Documents</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.Context#getChildContexts <em>Child Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EObject {
    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(ContextType)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContext_Type()
     * @model required="true"
     * @generated
     */
    ContextType getType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.Context#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType(ContextType value);

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
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContext_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.Context#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Root Document</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Document</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root Document</em>' containment reference.
     * @see #setRootDocument(Document)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContext_RootDocument()
     * @model containment="true"
     * @generated
     */
    Document getRootDocument();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.Context#getRootDocument <em>Root Document</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root Document</em>' containment reference.
     * @see #getRootDocument()
     * @generated
     */
    void setRootDocument(Document value);

    /**
     * Returns the value of the '<em><b>Child Documents</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.Document}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Documents</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Documents</em>' containment reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContext_ChildDocuments()
     * @model type="com.github.veithen.ramsay.ws.model.repository.Document" containment="true"
     * @generated
     */
    EList getChildDocuments();

    /**
     * Returns the value of the '<em><b>Child Contexts</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.Context}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Contexts</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Contexts</em>' containment reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContext_ChildContexts()
     * @model type="com.github.veithen.ramsay.ws.model.repository.Context" containment="true"
     * @generated
     */
    EList getChildContexts();

} // Context
