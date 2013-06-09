/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getChangeMultiplicity()
 * @model
 * @generated
 */
public interface ChangeMultiplicity extends FeatureTransformation {
    /**
     * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lower Bound</em>' attribute.
     * @see #setLowerBound(Integer)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getChangeMultiplicity_LowerBound()
     * @model
     * @generated
     */
    Integer getLowerBound();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getLowerBound <em>Lower Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lower Bound</em>' attribute.
     * @see #getLowerBound()
     * @generated
     */
    void setLowerBound(Integer value);

    /**
     * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Upper Bound</em>' attribute.
     * @see #setUpperBound(Integer)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getChangeMultiplicity_UpperBound()
     * @model
     * @generated
     */
    Integer getUpperBound();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getUpperBound <em>Upper Bound</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Upper Bound</em>' attribute.
     * @see #getUpperBound()
     * @generated
     */
    void setUpperBound(Integer value);

} // ChangeMultiplicity
