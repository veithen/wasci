/**
 */
package com.github.veithen.ramsay.ws.model.repository.util;

import com.github.veithen.ramsay.ws.model.repository.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.ws.model.repository.RepositoryPackage
 * @generated
 */
public class RepositoryAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static RepositoryPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RepositoryAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = RepositoryPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RepositorySwitch<Adapter> modelSwitch =
        new RepositorySwitch<Adapter>() {
            @Override
            public Adapter caseContextType(ContextType object) {
                return createContextTypeAdapter();
            }
            @Override
            public Adapter caseDocumentType(DocumentType object) {
                return createDocumentTypeAdapter();
            }
            @Override
            public Adapter caseContext(Context object) {
                return createContextAdapter();
            }
            @Override
            public Adapter caseDocument(Document object) {
                return createDocumentAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.ws.model.repository.ContextType <em>Context Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.ws.model.repository.ContextType
     * @generated
     */
    public Adapter createContextTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.ws.model.repository.DocumentType <em>Document Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.ws.model.repository.DocumentType
     * @generated
     */
    public Adapter createDocumentTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.ws.model.repository.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.ws.model.repository.Context
     * @generated
     */
    public Adapter createContextAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.ws.model.repository.Document <em>Document</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.ws.model.repository.Document
     * @generated
     */
    public Adapter createDocumentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //RepositoryAdapterFactory
