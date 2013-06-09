/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getFrom <em>From</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getTo <em>To</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getReferenceName <em>Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getOppositeReferenceName <em>Opposite Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getKeyMappings <em>Key Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getJoin()
 * @model
 * @generated
 */
public interface Join extends Transformation {
    /**
     * Returns the value of the '<em><b>From</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' containment reference.
     * @see #setFrom(Type)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getJoin_From()
     * @model containment="true" required="true"
     * @generated
     */
    Type getFrom();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getFrom <em>From</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' containment reference.
     * @see #getFrom()
     * @generated
     */
    void setFrom(Type value);

    /**
     * Returns the value of the '<em><b>To</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' containment reference.
     * @see #setTo(Type)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getJoin_To()
     * @model containment="true" required="true"
     * @generated
     */
    Type getTo();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getTo <em>To</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' containment reference.
     * @see #getTo()
     * @generated
     */
    void setTo(Type value);

    /**
     * Returns the value of the '<em><b>Reference Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reference Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reference Name</em>' attribute.
     * @see #setReferenceName(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getJoin_ReferenceName()
     * @model required="true"
     * @generated
     */
    String getReferenceName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getReferenceName <em>Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference Name</em>' attribute.
     * @see #getReferenceName()
     * @generated
     */
    void setReferenceName(String value);

    /**
     * Returns the value of the '<em><b>Opposite Reference Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Opposite Reference Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Opposite Reference Name</em>' attribute.
     * @see #setOppositeReferenceName(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getJoin_OppositeReferenceName()
     * @model
     * @generated
     */
    String getOppositeReferenceName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getOppositeReferenceName <em>Opposite Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Opposite Reference Name</em>' attribute.
     * @see #getOppositeReferenceName()
     * @generated
     */
    void setOppositeReferenceName(String value);

    /**
     * Returns the value of the '<em><b>Key Mappings</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Key Mappings</em>' containment reference list.
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getJoin_KeyMappings()
     * @model containment="true" required="true"
     * @generated
     */
    EList<KeyMapping> getKeyMappings();

} // Join
