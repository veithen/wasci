/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature#getConsistencyCheck <em>Consistency Check</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getRemoveFeature()
 * @model
 * @generated
 */
public interface RemoveFeature extends FeatureTransformation {
    /**
     * Returns the value of the '<em><b>Consistency Check</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Consistency Check</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Consistency Check</em>' attribute.
     * @see #setConsistencyCheck(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getRemoveFeature_ConsistencyCheck()
     * @model
     * @generated
     */
    String getConsistencyCheck();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature#getConsistencyCheck <em>Consistency Check</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Consistency Check</em>' attribute.
     * @see #getConsistencyCheck()
     * @generated
     */
    void setConsistencyCheck(String value);

} // RemoveFeature
