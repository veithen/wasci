/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadata</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.RepositoryMetadata#getContextTypes <em>Context Types</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.ws.model.repository.RepositoryMetadata#getDocumentTypes <em>Document Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getRepositoryMetadata()
 * @model
 * @generated
 */
public interface RepositoryMetadata extends EObject {
    /**
     * Returns the value of the '<em><b>Context Types</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.ContextType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Types</em>' containment reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getRepositoryMetadata_ContextTypes()
     * @model containment="true"
     * @generated
     */
    EList<ContextType> getContextTypes();

    /**
     * Returns the value of the '<em><b>Document Types</b></em>' containment reference list.
     * The list contents are of type {@link com.github.veithen.ramsay.ws.model.repository.DocumentType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Document Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Document Types</em>' containment reference list.
     * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage#getRepositoryMetadata_DocumentTypes()
     * @model containment="true"
     * @generated
     */
    EList<DocumentType> getDocumentTypes();

} // RepositoryMetadata
