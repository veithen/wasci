/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getFrom <em>From</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getKeyMapping()
 * @model
 * @generated
 */
public interface KeyMapping extends EObject {
    /**
     * Returns the value of the '<em><b>From</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' attribute.
     * @see #setFrom(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getKeyMapping_From()
     * @model required="true"
     * @generated
     */
    String getFrom();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getFrom <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' attribute.
     * @see #getFrom()
     * @generated
     */
    void setFrom(String value);

    /**
     * Returns the value of the '<em><b>To</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' attribute.
     * @see #setTo(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getKeyMapping_To()
     * @model required="true"
     * @generated
     */
    String getTo();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getTo <em>To</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' attribute.
     * @see #getTo()
     * @generated
     */
    void setTo(String value);

} // KeyMapping
