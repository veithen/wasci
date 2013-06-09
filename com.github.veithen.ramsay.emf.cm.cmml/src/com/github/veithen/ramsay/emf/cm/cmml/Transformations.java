/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.cm.cmml.Transformations#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getTransformations()
 * @model
 * @generated
 */
public interface Transformations extends EObject {
    /**
     * Returns the value of the '<em><b>Transformation</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.emf.cm.cmml.Transformation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transformation</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transformation</em>' containment reference list.
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#getTransformations_Transformation()
     * @model containment="true"
     * @generated
     */
    EList<Transformation> getTransformation();

} // Transformations
