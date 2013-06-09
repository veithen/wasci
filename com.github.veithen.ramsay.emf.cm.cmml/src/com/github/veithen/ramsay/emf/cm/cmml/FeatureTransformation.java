/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getType <em>Type</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getFeatureTransformation()
 * @model abstract="true"
 * @generated
 */
public interface FeatureTransformation extends Transformation {
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
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getFeatureTransformation_Type()
     * @model containment="true" required="true"
     * @generated
     */
    Type getType();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(Type value);

    /**
     * Returns the value of the '<em><b>Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Feature</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Feature</em>' attribute.
     * @see #setFeature(String)
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getFeatureTransformation_Feature()
     * @model required="true"
     * @generated
     */
    String getFeature();

    /**
     * Sets the value of the '{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getFeature <em>Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Feature</em>' attribute.
     * @see #getFeature()
     * @generated
     */
    void setFeature(String value);

} // FeatureTransformation
