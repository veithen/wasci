/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Type#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Type#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject {
    /**
     * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ns URI</em>' attribute.
     * @see #setNsURI(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getType_NsURI()
     * @model required="true"
     * @generated
     */
    String getNsURI();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.Type#getNsURI <em>Ns URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ns URI</em>' attribute.
     * @see #getNsURI()
     * @generated
     */
    void setNsURI(String value);

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
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getType_Name()
     * @model required="true"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.Type#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Type
