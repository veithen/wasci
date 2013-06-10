/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.TransformationChain#getTransformations <em>Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getTransformationChain()
 * @model
 * @generated
 */
public interface TransformationChain extends EObject {
    /**
     * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.emf.cm.cmml.Transformation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transformations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transformations</em>' containment reference list.
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getTransformationChain_Transformations()
     * @model containment="true"
     * @generated
     */
    EList<Transformation> getTransformations();

} // TransformationChain
