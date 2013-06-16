/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Context Type Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink#getContextType <em>Context Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildContextTypeLink()
 * @model
 * @generated
 */
public interface ChildContextTypeLink extends EObject {
    /**
     * Returns the value of the '<em><b>Context Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Type</em>' reference.
     * @see #setContextType(ContextType)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildContextTypeLink_ContextType()
     * @model required="true"
     * @generated
     */
    ContextType getContextType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink#getContextType <em>Context Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Type</em>' reference.
     * @see #getContextType()
     * @generated
     */
    void setContextType(ContextType value);

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
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildContextTypeLink_Reference()
     * @model
     * @generated
     */
    EReference getReference();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink#getReference <em>Reference</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference</em>' reference.
     * @see #getReference()
     * @generated
     */
    void setReference(EReference value);

} // ChildContextTypeLink
