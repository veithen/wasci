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
     * The meta object id for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl
     * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getContext()
     * @generated
     */
    int CONTEXT = 2;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT__TYPE = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT__NAME = 1;

    /**
     * The feature id for the '<em><b>Root Document</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT__ROOT_DOCUMENT = 2;

    /**
     * The feature id for the '<em><b>Child Documents</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT__CHILD_DOCUMENTS = 3;

    /**
     * The feature id for the '<em><b>Child Contexts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT__CHILD_CONTEXTS = 4;

    /**
     * The number of structural features of the '<em>Context</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTEXT_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentImpl <em>Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.ws.model.repository.impl.DocumentImpl
     * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getDocument()
     * @generated
     */
    int DOCUMENT = 3;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT__TYPE = 0;

    /**
     * The feature id for the '<em><b>Contents</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT__CONTENTS = 1;

    /**
     * The number of structural features of the '<em>Document</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_FEATURE_COUNT = 2;


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
     * Returns the meta object for class '{@link com.github.veithen.ramsay.ws.model.repository.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Context
     * @generated
     */
    EClass getContext();

    /**
     * Returns the meta object for the reference '{@link com.github.veithen.ramsay.ws.model.repository.Context#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Context#getType()
     * @see #getContext()
     * @generated
     */
    EReference getContext_Type();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.ws.model.repository.Context#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Context#getName()
     * @see #getContext()
     * @generated
     */
    EAttribute getContext_Name();

    /**
     * Returns the meta object for the containment reference '{@link com.github.veithen.ramsay.ws.model.repository.Context#getRootDocument <em>Root Document</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root Document</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Context#getRootDocument()
     * @see #getContext()
     * @generated
     */
    EReference getContext_RootDocument();

    /**
     * Returns the meta object for the containment reference list '{@link com.github.veithen.ramsay.ws.model.repository.Context#getChildDocuments <em>Child Documents</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Child Documents</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Context#getChildDocuments()
     * @see #getContext()
     * @generated
     */
    EReference getContext_ChildDocuments();

    /**
     * Returns the meta object for the containment reference list '{@link com.github.veithen.ramsay.ws.model.repository.Context#getChildContexts <em>Child Contexts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Child Contexts</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Context#getChildContexts()
     * @see #getContext()
     * @generated
     */
    EReference getContext_ChildContexts();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.ws.model.repository.Document <em>Document</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Document
     * @generated
     */
    EClass getDocument();

    /**
     * Returns the meta object for the reference '{@link com.github.veithen.ramsay.ws.model.repository.Document#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Document#getType()
     * @see #getDocument()
     * @generated
     */
    EReference getDocument_Type();

    /**
     * Returns the meta object for the reference list '{@link com.github.veithen.ramsay.ws.model.repository.Document#getContents <em>Contents</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Contents</em>'.
     * @see com.github.veithen.ramsay.ws.model.repository.Document#getContents()
     * @see #getDocument()
     * @generated
     */
    EReference getDocument_Contents();

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

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl <em>Context</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.ws.model.repository.impl.ContextImpl
         * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getContext()
         * @generated
         */
        EClass CONTEXT = eINSTANCE.getContext();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT__TYPE = eINSTANCE.getContext_Type();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTEXT__NAME = eINSTANCE.getContext_Name();

        /**
         * The meta object literal for the '<em><b>Root Document</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT__ROOT_DOCUMENT = eINSTANCE.getContext_RootDocument();

        /**
         * The meta object literal for the '<em><b>Child Documents</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT__CHILD_DOCUMENTS = eINSTANCE.getContext_ChildDocuments();

        /**
         * The meta object literal for the '<em><b>Child Contexts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTEXT__CHILD_CONTEXTS = eINSTANCE.getContext_ChildContexts();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.ws.model.repository.impl.DocumentImpl <em>Document</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.ws.model.repository.impl.DocumentImpl
         * @see com.github.veithen.ramsay.ws.model.repository.impl.RepositoryPackageImpl#getDocument()
         * @generated
         */
        EClass DOCUMENT = eINSTANCE.getDocument();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT__TYPE = eINSTANCE.getDocument_Type();

        /**
         * The meta object literal for the '<em><b>Contents</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT__CONTENTS = eINSTANCE.getDocument_Contents();

    }

} //RepositoryPackage
