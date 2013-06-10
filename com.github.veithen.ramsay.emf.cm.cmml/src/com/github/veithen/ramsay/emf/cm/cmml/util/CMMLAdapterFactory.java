/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.util;

import com.github.veithen.ramsay.emf.cm.cmml.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage
 * @generated
 */
public class CMMLAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static CMMLPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMLAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = CMMLPackage.eINSTANCE;
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
    protected CMMLSwitch<Adapter> modelSwitch =
        new CMMLSwitch<Adapter>() {
            @Override
            public Adapter caseTransformation(Transformation object) {
                return createTransformationAdapter();
            }
            @Override
            public Adapter caseTransformationChain(TransformationChain object) {
                return createTransformationChainAdapter();
            }
            @Override
            public Adapter caseType(Type object) {
                return createTypeAdapter();
            }
            @Override
            public Adapter caseKeyMapping(KeyMapping object) {
                return createKeyMappingAdapter();
            }
            @Override
            public Adapter caseJoin(Join object) {
                return createJoinAdapter();
            }
            @Override
            public Adapter caseFeatureTransformation(FeatureTransformation object) {
                return createFeatureTransformationAdapter();
            }
            @Override
            public Adapter caseChangeMultiplicity(ChangeMultiplicity object) {
                return createChangeMultiplicityAdapter();
            }
            @Override
            public Adapter caseRemoveFeature(RemoveFeature object) {
                return createRemoveFeatureAdapter();
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
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.Transformation <em>Transformation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Transformation
     * @generated
     */
    public Adapter createTransformationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.TransformationChain <em>Transformation Chain</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.TransformationChain
     * @generated
     */
    public Adapter createTransformationChainAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Type
     * @generated
     */
    public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping <em>Key Mapping</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.KeyMapping
     * @generated
     */
    public Adapter createKeyMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.Join <em>Join</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join
     * @generated
     */
    public Adapter createJoinAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation <em>Feature Transformation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation
     * @generated
     */
    public Adapter createFeatureTransformationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity <em>Change Multiplicity</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity
     * @generated
     */
    public Adapter createChangeMultiplicityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature <em>Remove Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature
     * @generated
     */
    public Adapter createRemoveFeatureAdapter() {
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

} //CMMLAdapterFactory
