/**
 */
package com.github.veithen.ramsay.ws.model.repository.impl;

import com.github.veithen.ramsay.ws.model.repository.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryFactoryImpl extends EFactoryImpl implements RepositoryFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RepositoryFactory init() {
        try {
            RepositoryFactory theRepositoryFactory = (RepositoryFactory)EPackage.Registry.INSTANCE.getEFactory("urn:repository"); 
            if (theRepositoryFactory != null) {
                return theRepositoryFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RepositoryFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RepositoryFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case RepositoryPackage.CONTEXT_TYPE: return createContextType();
            case RepositoryPackage.CHILD_CONTEXT_TYPE_LINK: return createChildContextTypeLink();
            case RepositoryPackage.CHILD_DOCUMENT_TYPE_LINK: return createChildDocumentTypeLink();
            case RepositoryPackage.DOCUMENT_TYPE: return createDocumentType();
            case RepositoryPackage.CONTEXT: return createContext();
            case RepositoryPackage.CHILD_DOCUMENT: return createChildDocument();
            case RepositoryPackage.CHILD_CONTEXT: return createChildContext();
            case RepositoryPackage.DOCUMENT: return createDocument();
            case RepositoryPackage.REPOSITORY_METADATA: return createRepositoryMetadata();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContextType createContextType() {
        ContextTypeImpl contextType = new ContextTypeImpl();
        return contextType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChildContextTypeLink createChildContextTypeLink() {
        ChildContextTypeLinkImpl childContextTypeLink = new ChildContextTypeLinkImpl();
        return childContextTypeLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChildDocumentTypeLink createChildDocumentTypeLink() {
        ChildDocumentTypeLinkImpl childDocumentTypeLink = new ChildDocumentTypeLinkImpl();
        return childDocumentTypeLink;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentType createDocumentType() {
        DocumentTypeImpl documentType = new DocumentTypeImpl();
        return documentType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Context createContext() {
        ContextImpl context = new ContextImpl();
        return context;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChildDocument createChildDocument() {
        ChildDocumentImpl childDocument = new ChildDocumentImpl();
        return childDocument;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChildContext createChildContext() {
        ChildContextImpl childContext = new ChildContextImpl();
        return childContext;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Document createDocument() {
        DocumentImpl document = new DocumentImpl();
        return document;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RepositoryMetadata createRepositoryMetadata() {
        RepositoryMetadataImpl repositoryMetadata = new RepositoryMetadataImpl();
        return repositoryMetadata;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RepositoryPackage getRepositoryPackage() {
        return (RepositoryPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RepositoryPackage getPackage() {
        return RepositoryPackage.eINSTANCE;
    }

} //RepositoryFactoryImpl
