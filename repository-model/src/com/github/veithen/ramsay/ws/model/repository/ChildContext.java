/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildContext#getLink <em>Link</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.ChildContext#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildContext()
 * @model
 * @generated
 */
public interface ChildContext extends EObject {
    /**
     * Returns the value of the '<em><b>Link</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Link</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Link</em>' reference.
     * @see #setLink(ChildContextTypeLink)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildContext_Link()
     * @model required="true"
     * @generated
     */
    ChildContextTypeLink getLink();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildContext#getLink <em>Link</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Link</em>' reference.
     * @see #getLink()
     * @generated
     */
    void setLink(ChildContextTypeLink value);

    /**
     * Returns the value of the '<em><b>Context</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context</em>' containment reference.
     * @see #setContext(Context)
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getChildContext_Context()
     * @model containment="true" required="true"
     * @generated
     */
    Context getContext();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.ws.model.repository.ChildContext#getContext <em>Context</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context</em>' containment reference.
     * @see #getContext()
     * @generated
     */
    void setContext(Context value);

} // ChildContext
