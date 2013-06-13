/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.impl;

import com.github.veithen.ramsay.emf.cm.cmml.CMMLFactory;
import com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage;
import com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity;
import com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference;
import com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation;
import com.github.veithen.ramsay.emf.cm.cmml.Join;
import com.github.veithen.ramsay.emf.cm.cmml.KeyMapping;
import com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature;
import com.github.veithen.ramsay.emf.cm.cmml.Transformation;
import com.github.veithen.ramsay.emf.cm.cmml.TransformationChain;
import com.github.veithen.ramsay.emf.cm.cmml.Type;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CMMLPackageImpl extends EPackageImpl implements CMMLPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transformationChainEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass keyMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass joinEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass featureTransformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass changeMultiplicityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass removeFeatureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass createOppositeReferenceEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CMMLPackageImpl() {
        super(eNS_URI, CMMLFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link CMMLPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CMMLPackage init() {
        if (isInited) return (CMMLPackage)EPackage.Registry.INSTANCE.getEPackage(CMMLPackage.eNS_URI);

        // Obtain or create and register package
        CMMLPackageImpl theCMMLPackage = (CMMLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CMMLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CMMLPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theCMMLPackage.createPackageContents();

        // Initialize created meta-data
        theCMMLPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCMMLPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CMMLPackage.eNS_URI, theCMMLPackage);
        return theCMMLPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransformation() {
        return transformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransformationChain() {
        return transformationChainEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTransformationChain_Transformations() {
        return (EReference)transformationChainEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getType() {
        return typeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_NsURI() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_Name() {
        return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getKeyMapping() {
        return keyMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKeyMapping_From() {
        return (EAttribute)keyMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getKeyMapping_To() {
        return (EAttribute)keyMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJoin() {
        return joinEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJoin_From() {
        return (EReference)joinEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJoin_To() {
        return (EReference)joinEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJoin_ReferenceName() {
        return (EAttribute)joinEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getJoin_OppositeReferenceName() {
        return (EAttribute)joinEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJoin_KeyMappings() {
        return (EReference)joinEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFeatureTransformation() {
        return featureTransformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFeatureTransformation_Type() {
        return (EReference)featureTransformationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFeatureTransformation_Feature() {
        return (EAttribute)featureTransformationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getChangeMultiplicity() {
        return changeMultiplicityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChangeMultiplicity_LowerBound() {
        return (EAttribute)changeMultiplicityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChangeMultiplicity_UpperBound() {
        return (EAttribute)changeMultiplicityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRemoveFeature() {
        return removeFeatureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRemoveFeature_ConsistencyCheck() {
        return (EAttribute)removeFeatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCreateOppositeReference() {
        return createOppositeReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCreateOppositeReference_Type() {
        return (EReference)createOppositeReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCreateOppositeReference_ReferenceName() {
        return (EAttribute)createOppositeReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCreateOppositeReference_OppositeReferenceName() {
        return (EAttribute)createOppositeReferenceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCreateOppositeReference_LowerBound() {
        return (EAttribute)createOppositeReferenceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCreateOppositeReference_UpperBound() {
        return (EAttribute)createOppositeReferenceEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMLFactory getCMMLFactory() {
        return (CMMLFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        transformationEClass = createEClass(TRANSFORMATION);

        transformationChainEClass = createEClass(TRANSFORMATION_CHAIN);
        createEReference(transformationChainEClass, TRANSFORMATION_CHAIN__TRANSFORMATIONS);

        typeEClass = createEClass(TYPE);
        createEAttribute(typeEClass, TYPE__NS_URI);
        createEAttribute(typeEClass, TYPE__NAME);

        keyMappingEClass = createEClass(KEY_MAPPING);
        createEAttribute(keyMappingEClass, KEY_MAPPING__FROM);
        createEAttribute(keyMappingEClass, KEY_MAPPING__TO);

        joinEClass = createEClass(JOIN);
        createEReference(joinEClass, JOIN__FROM);
        createEReference(joinEClass, JOIN__TO);
        createEAttribute(joinEClass, JOIN__REFERENCE_NAME);
        createEAttribute(joinEClass, JOIN__OPPOSITE_REFERENCE_NAME);
        createEReference(joinEClass, JOIN__KEY_MAPPINGS);

        featureTransformationEClass = createEClass(FEATURE_TRANSFORMATION);
        createEReference(featureTransformationEClass, FEATURE_TRANSFORMATION__TYPE);
        createEAttribute(featureTransformationEClass, FEATURE_TRANSFORMATION__FEATURE);

        changeMultiplicityEClass = createEClass(CHANGE_MULTIPLICITY);
        createEAttribute(changeMultiplicityEClass, CHANGE_MULTIPLICITY__LOWER_BOUND);
        createEAttribute(changeMultiplicityEClass, CHANGE_MULTIPLICITY__UPPER_BOUND);

        removeFeatureEClass = createEClass(REMOVE_FEATURE);
        createEAttribute(removeFeatureEClass, REMOVE_FEATURE__CONSISTENCY_CHECK);

        createOppositeReferenceEClass = createEClass(CREATE_OPPOSITE_REFERENCE);
        createEReference(createOppositeReferenceEClass, CREATE_OPPOSITE_REFERENCE__TYPE);
        createEAttribute(createOppositeReferenceEClass, CREATE_OPPOSITE_REFERENCE__REFERENCE_NAME);
        createEAttribute(createOppositeReferenceEClass, CREATE_OPPOSITE_REFERENCE__OPPOSITE_REFERENCE_NAME);
        createEAttribute(createOppositeReferenceEClass, CREATE_OPPOSITE_REFERENCE__LOWER_BOUND);
        createEAttribute(createOppositeReferenceEClass, CREATE_OPPOSITE_REFERENCE__UPPER_BOUND);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        joinEClass.getESuperTypes().add(this.getTransformation());
        featureTransformationEClass.getESuperTypes().add(this.getTransformation());
        changeMultiplicityEClass.getESuperTypes().add(this.getFeatureTransformation());
        removeFeatureEClass.getESuperTypes().add(this.getFeatureTransformation());
        createOppositeReferenceEClass.getESuperTypes().add(this.getTransformation());

        // Initialize classes and features; add operations and parameters
        initEClass(transformationEClass, Transformation.class, "Transformation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(transformationChainEClass, TransformationChain.class, "TransformationChain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTransformationChain_Transformations(), this.getTransformation(), null, "transformations", null, 0, -1, TransformationChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getType_NsURI(), ecorePackage.getEString(), "nsURI", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getType_Name(), ecorePackage.getEString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(keyMappingEClass, KeyMapping.class, "KeyMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getKeyMapping_From(), ecorePackage.getEString(), "from", null, 1, 1, KeyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getKeyMapping_To(), ecorePackage.getEString(), "to", null, 1, 1, KeyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(joinEClass, Join.class, "Join", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getJoin_From(), this.getType(), null, "from", null, 1, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getJoin_To(), this.getType(), null, "to", null, 1, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getJoin_ReferenceName(), ecorePackage.getEString(), "referenceName", null, 1, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getJoin_OppositeReferenceName(), ecorePackage.getEString(), "oppositeReferenceName", null, 0, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getJoin_KeyMappings(), this.getKeyMapping(), null, "keyMappings", null, 1, -1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(featureTransformationEClass, FeatureTransformation.class, "FeatureTransformation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFeatureTransformation_Type(), this.getType(), null, "type", null, 1, 1, FeatureTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFeatureTransformation_Feature(), ecorePackage.getEString(), "feature", null, 1, 1, FeatureTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(changeMultiplicityEClass, ChangeMultiplicity.class, "ChangeMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getChangeMultiplicity_LowerBound(), ecorePackage.getEIntegerObject(), "lowerBound", null, 0, 1, ChangeMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getChangeMultiplicity_UpperBound(), ecorePackage.getEIntegerObject(), "upperBound", null, 0, 1, ChangeMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(removeFeatureEClass, RemoveFeature.class, "RemoveFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRemoveFeature_ConsistencyCheck(), ecorePackage.getEString(), "consistencyCheck", null, 0, 1, RemoveFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(createOppositeReferenceEClass, CreateOppositeReference.class, "CreateOppositeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getCreateOppositeReference_Type(), this.getType(), null, "type", null, 1, 1, CreateOppositeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCreateOppositeReference_ReferenceName(), ecorePackage.getEString(), "referenceName", null, 1, 1, CreateOppositeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCreateOppositeReference_OppositeReferenceName(), ecorePackage.getEString(), "oppositeReferenceName", null, 1, 1, CreateOppositeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCreateOppositeReference_LowerBound(), ecorePackage.getEInt(), "lowerBound", "0", 0, 1, CreateOppositeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getCreateOppositeReference_UpperBound(), ecorePackage.getEInt(), "upperBound", "-1", 0, 1, CreateOppositeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //CMMLPackageImpl
