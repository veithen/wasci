/**
 */
package repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link repository.DocumentType#getFilePattern <em>File Pattern</em>}</li>
 *   <li>{@link repository.DocumentType#getRootRefObjectTypes <em>Root Ref Object Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see repository.RepositoryPackage#getDocumentType()
 * @model
 * @generated
 */
public interface DocumentType extends EObject {
    /**
     * Returns the value of the '<em><b>File Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Pattern</em>' attribute.
     * @see #setFilePattern(String)
     * @see repository.RepositoryPackage#getDocumentType_FilePattern()
     * @model
     * @generated
     */
    String getFilePattern();

    /**
     * Sets the value of the '{@link repository.DocumentType#getFilePattern <em>File Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Pattern</em>' attribute.
     * @see #getFilePattern()
     * @generated
     */
    void setFilePattern(String value);

    /**
     * Returns the value of the '<em><b>Root Ref Object Types</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Ref Object Types</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root Ref Object Types</em>' reference list.
     * @see repository.RepositoryPackage#getDocumentType_RootRefObjectTypes()
     * @model type="org.eclipse.emf.ecore.EClass"
     * @generated
     */
    EList getRootRefObjectTypes();

} // DocumentType
