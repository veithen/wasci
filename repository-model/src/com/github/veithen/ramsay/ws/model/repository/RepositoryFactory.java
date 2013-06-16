/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage
 * @generated
 */
public interface RepositoryFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RepositoryFactory eINSTANCE = com.github.veithen.ramsay.ws.model.repository.impl.RepositoryFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Context Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Context Type</em>'.
     * @generated
     */
    ContextType createContextType();

    /**
     * Returns a new object of class '<em>Child Context Type Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Child Context Type Link</em>'.
     * @generated
     */
    ChildContextTypeLink createChildContextTypeLink();

    /**
     * Returns a new object of class '<em>Child Document Type Link</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Child Document Type Link</em>'.
     * @generated
     */
    ChildDocumentTypeLink createChildDocumentTypeLink();

    /**
     * Returns a new object of class '<em>Document Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Document Type</em>'.
     * @generated
     */
    DocumentType createDocumentType();

    /**
     * Returns a new object of class '<em>Context</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Context</em>'.
     * @generated
     */
    Context createContext();

    /**
     * Returns a new object of class '<em>Child Document</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Child Document</em>'.
     * @generated
     */
    ChildDocument createChildDocument();

    /**
     * Returns a new object of class '<em>Child Context</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Child Context</em>'.
     * @generated
     */
    ChildContext createChildContext();

    /**
     * Returns a new object of class '<em>Document</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Document</em>'.
     * @generated
     */
    Document createDocument();

    /**
     * Returns a new object of class '<em>Metadata</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Metadata</em>'.
     * @generated
     */
    RepositoryMetadata createRepositoryMetadata();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    RepositoryPackage getRepositoryPackage();

} //RepositoryFactory
