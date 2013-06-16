/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
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
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getChildContextTypeLinks <em>Child Context Type Links</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getChildDocumentTypeLinks <em>Child Document Type Links</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getRootDocumentType <em>Root Document Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getGeneratedClass <em>Generated Class</em>}</li>
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
     * Returns the value of the '<em><b>Child Context Type Links</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Context Type Links</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Context Type Links</em>' containment reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_ChildContextTypeLinks()
     * @model containment="true"
     * @generated
     */
    EList<ChildContextTypeLink> getChildContextTypeLinks();

    /**
     * Returns the value of the '<em><b>Child Document Type Links</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Child Document Type Links</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Child Document Type Links</em>' containment reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_ChildDocumentTypeLinks()
     * @model containment="true"
     * @generated
     */
    EList<ChildDocumentTypeLink> getChildDocumentTypeLinks();

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

    /**
     * Returns the value of the '<em><b>Generated Class</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The generated class is only relevant if the context type has no root document type. It this case, it specifies the class that will be used to represent contexts of this type.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Generated Class</em>' reference.
     * @see #setGeneratedClass(EClass)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getContextType_GeneratedClass()
     * @model
     * @generated
     */
    EClass getGeneratedClass();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getGeneratedClass <em>Generated Class</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Generated Class</em>' reference.
     * @see #getGeneratedClass()
     * @generated
     */
    void setGeneratedClass(EClass value);

} // ContextType
