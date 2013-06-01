/**
 */
package com.github.veithen.ramsay.ws.model.repository;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryFactory
 * @model kind="package"
 * @generated
 */
public interface RepositoryPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "repository";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "urn:repository";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "repository";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RepositoryPackage eINSTANCE = com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl.init();

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl <em>Context Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl
     * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getContextType()
     * @generated
     */
    int CONTEXT_TYPE = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_TYPE__NAME = 0;

    /**
     * The feature id for the '<em><b>Child Context Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_TYPE__CHILD_CONTEXT_TYPES = 1;

    /**
     * The feature id for the '<em><b>Child Document Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_TYPE__CHILD_DOCUMENT_TYPES = 2;

    /**
     * The feature id for the '<em><b>Root Document Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_TYPE__ROOT_DOCUMENT_TYPE = 3;

    /**
     * The number of structural features of the '<em>Context Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_TYPE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentTypeImpl <em>Document Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.ws.model.repository.impl.DocumentTypeImpl
     * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getDocumentType()
     * @generated
     */
    int DOCUMENT_TYPE = 1;

    /**
     * The feature id for the '<em><b>File Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_TYPE__FILE_PATTERN = 0;

    /**
     * The feature id for the '<em><b>Root Ref Object Types</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES = 1;

    /**
     * The number of structural features of the '<em>Document Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_TYPE_FEATURE_COUNT = 2;


    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.ws.model.repository.ContextType <em>Context Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context Type</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.ContextType
     * @generated
     */
    EClass getContextType();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.ContextType#getName()
     * @see #getContextType()
     * @generated
     */
    EAttribute getContextType_Name();

    /**
     * Returns the meta object for the reference list '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getChildContextTypes <em>Child Context Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Child Context Types</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.ContextType#getChildContextTypes()
     * @see #getContextType()
     * @generated
     */
    EReference getContextType_ChildContextTypes();

    /**
     * Returns the meta object for the reference list '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getChildDocumentTypes <em>Child Document Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Child Document Types</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.ContextType#getChildDocumentTypes()
     * @see #getContextType()
     * @generated
     */
    EReference getContextType_ChildDocumentTypes();

    /**
     * Returns the meta object for the reference '{@link com.github.veithen.ramsay.ws.model.repository.ContextType#getRootDocumentType <em>Root Document Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Root Document Type</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.ContextType#getRootDocumentType()
     * @see #getContextType()
     * @generated
     */
    EReference getContextType_RootDocumentType();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.ws.model.repository.DocumentType <em>Document Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Type</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.DocumentType
     * @generated
     */
    EClass getDocumentType();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.ws.model.repository.DocumentType#getFilePattern <em>File Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Pattern</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.DocumentType#getFilePattern()
     * @see #getDocumentType()
     * @generated
     */
    EAttribute getDocumentType_FilePattern();

    /**
     * Returns the meta object for the reference list '{@link com.github.veithen.ramsay.ws.model.repository.DocumentType#getRootRefObjectTypes <em>Root Ref Object Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Root Ref Object Types</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.DocumentType#getRootRefObjectTypes()
     * @see #getDocumentType()
     * @generated
     */
    EReference getDocumentType_RootRefObjectTypes();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RepositoryFactory getRepositoryFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl <em>Context Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.ws.model.repository.impl.ContextTypeImpl
         * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getContextType()
         * @generated
         */
        EClass CONTEXT_TYPE = eINSTANCE.getContextType();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTEXT_TYPE__NAME = eINSTANCE.getContextType_Name();

        /**
         * The meta object literal for the '<em><b>Child Context Types</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT_TYPE__CHILD_CONTEXT_TYPES = eINSTANCE.getContextType_ChildContextTypes();

        /**
         * The meta object literal for the '<em><b>Child Document Types</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT_TYPE__CHILD_DOCUMENT_TYPES = eINSTANCE.getContextType_ChildDocumentTypes();

        /**
         * The meta object literal for the '<em><b>Root Document Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT_TYPE__ROOT_DOCUMENT_TYPE = eINSTANCE.getContextType_RootDocumentType();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentTypeImpl <em>Document Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.ws.model.repository.impl.DocumentTypeImpl
         * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getDocumentType()
         * @generated
         */
        EClass DOCUMENT_TYPE = eINSTANCE.getDocumentType();

        /**
         * The meta object literal for the '<em><b>File Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENT_TYPE__FILE_PATTERN = eINSTANCE.getDocumentType_FilePattern();

        /**
         * The meta object literal for the '<em><b>Root Ref Object Types</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_TYPE__ROOT_REF_OBJECT_TYPES = eINSTANCE.getDocumentType_RootRefObjectTypes();

    }

} //RepositoryPackage
