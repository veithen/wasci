/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Opposite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getReferenceName <em>Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getOppositeReferenceName <em>Opposite Reference Name</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getCreateOppositeReference()
 * @model
 * @generated
 */
public interface CreateOppositeReference extends Transformation {
    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(Type)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getCreateOppositeReference_Type()
     * @model containment="true" required="true"
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

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
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getCreateOppositeReference_ReferenceName()
     * @model required="true"
     * @generated
     */
    String getReferenceName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getReferenceName <em>Reference Name</em>}' attribute.
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
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getCreateOppositeReference_OppositeReferenceName()
     * @model required="true"
     * @generated
     */
    String getOppositeReferenceName();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getOppositeReferenceName <em>Opposite Reference Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Opposite Reference Name</em>' attribute.
     * @see #getOppositeReferenceName()
     * @generated
     */
    void setOppositeReferenceName(String value);

    /**
     * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lower Bound</em>' attribute.
     * @see #setLowerBound(int)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getCreateOppositeReference_LowerBound()
     * @model default="0"
     * @generated
     */
    int getLowerBound();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getLowerBound <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lower Bound</em>' attribute.
     * @see #getLowerBound()
     * @generated
     */
    void setLowerBound(int value);

    /**
     * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Upper Bound</em>' attribute.
     * @see #setUpperBound(int)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getCreateOppositeReference_UpperBound()
     * @model default="-1"
     * @generated
     */
    int getUpperBound();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference#getUpperBound <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Upper Bound</em>' attribute.
     * @see #getUpperBound()
     * @generated
     */
    void setUpperBound(int value);

} // CreateOppositeReference
