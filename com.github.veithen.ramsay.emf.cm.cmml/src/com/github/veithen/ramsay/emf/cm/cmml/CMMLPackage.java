/**
 */
package com.github.veithen.ramsay.emf.cm.cmml;

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
 * @see com.github.veithen.ramsay.emf.cm.cmml.CMMLFactory
 * @model kind="package"
 * @generated
 */
public interface CMMLPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "cmml";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://github.com/veithen/ramsay/cm/cmml";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "cmml";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CMMLPackage eINSTANCE = com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl.init();

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationImpl <em>Transformation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getTransformation()
     * @generated
     */
    int TRANSFORMATION = 0;

    /**
     * The number of structural features of the '<em>Transformation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSFORMATION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationsImpl <em>Transformations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationsImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getTransformations()
     * @generated
     */
    int TRANSFORMATIONS = 1;

    /**
     * The feature id for the '<em><b>Transformation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSFORMATIONS__TRANSFORMATION = 0;

    /**
     * The number of structural features of the '<em>Transformations</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSFORMATIONS_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.TypeImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getType()
     * @generated
     */
    int TYPE = 2;

    /**
     * The feature id for the '<em><b>Ns URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__NS_URI = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE__NAME = 1;

    /**
     * The number of structural features of the '<em>Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.KeyMappingImpl <em>Key Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.KeyMappingImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getKeyMapping()
     * @generated
     */
    int KEY_MAPPING = 3;

    /**
     * The feature id for the '<em><b>From</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_MAPPING__FROM = 0;

    /**
     * The feature id for the '<em><b>To</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_MAPPING__TO = 1;

    /**
     * The number of structural features of the '<em>Key Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_MAPPING_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl <em>Join</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getJoin()
     * @generated
     */
    int JOIN = 4;

    /**
     * The feature id for the '<em><b>From</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOIN__FROM = TRANSFORMATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>To</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOIN__TO = TRANSFORMATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Reference Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOIN__REFERENCE_NAME = TRANSFORMATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Opposite Reference Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOIN__OPPOSITE_REFERENCE_NAME = TRANSFORMATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Key Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOIN__KEY_MAPPINGS = TRANSFORMATION_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Join</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOIN_FEATURE_COUNT = TRANSFORMATION_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.FeatureTransformationImpl <em>Feature Transformation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.FeatureTransformationImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getFeatureTransformation()
     * @generated
     */
    int FEATURE_TRANSFORMATION = 5;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_TRANSFORMATION__TYPE = TRANSFORMATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_TRANSFORMATION__FEATURE = TRANSFORMATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Feature Transformation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FEATURE_TRANSFORMATION_FEATURE_COUNT = TRANSFORMATION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.ChangeMultiplicityImpl <em>Change Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.ChangeMultiplicityImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getChangeMultiplicity()
     * @generated
     */
    int CHANGE_MULTIPLICITY = 6;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_MULTIPLICITY__TYPE = FEATURE_TRANSFORMATION__TYPE;

    /**
     * The feature id for the '<em><b>Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_MULTIPLICITY__FEATURE = FEATURE_TRANSFORMATION__FEATURE;

    /**
     * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_MULTIPLICITY__LOWER_BOUND = FEATURE_TRANSFORMATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_MULTIPLICITY__UPPER_BOUND = FEATURE_TRANSFORMATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Change Multiplicity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_MULTIPLICITY_FEATURE_COUNT = FEATURE_TRANSFORMATION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.RemoveFeatureImpl <em>Remove Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.RemoveFeatureImpl
     * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getRemoveFeature()
     * @generated
     */
    int REMOVE_FEATURE = 7;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REMOVE_FEATURE__TYPE = FEATURE_TRANSFORMATION__TYPE;

    /**
     * The feature id for the '<em><b>Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REMOVE_FEATURE__FEATURE = FEATURE_TRANSFORMATION__FEATURE;

    /**
     * The feature id for the '<em><b>Consistency Check</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REMOVE_FEATURE__CONSISTENCY_CHECK = FEATURE_TRANSFORMATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Remove Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REMOVE_FEATURE_FEATURE_COUNT = FEATURE_TRANSFORMATION_FEATURE_COUNT + 1;


    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.Transformation <em>Transformation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transformation</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Transformation
     * @generated
     */
    EClass getTransformation();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.Transformations <em>Transformations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transformations</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Transformations
     * @generated
     */
    EClass getTransformations();

    /**
     * Returns the meta object for the containment reference list '{@link com.github.veithen.ramsay.emf.cm.cmml.Transformations#getTransformation <em>Transformation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Transformation</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Transformations#getTransformation()
     * @see #getTransformations()
     * @generated
     */
    EReference getTransformations_Transformation();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Type
     * @generated
     */
    EClass getType();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.Type#getNsURI <em>Ns URI</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ns URI</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Type#getNsURI()
     * @see #getType()
     * @generated
     */
    EAttribute getType_NsURI();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.Type#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Type#getName()
     * @see #getType()
     * @generated
     */
    EAttribute getType_Name();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping <em>Key Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Key Mapping</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.KeyMapping
     * @generated
     */
    EClass getKeyMapping();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>From</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getFrom()
     * @see #getKeyMapping()
     * @generated
     */
    EAttribute getKeyMapping_From();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>To</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.KeyMapping#getTo()
     * @see #getKeyMapping()
     * @generated
     */
    EAttribute getKeyMapping_To();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.Join <em>Join</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Join</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join
     * @generated
     */
    EClass getJoin();

    /**
     * Returns the meta object for the containment reference '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>From</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join#getFrom()
     * @see #getJoin()
     * @generated
     */
    EReference getJoin_From();

    /**
     * Returns the meta object for the containment reference '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>To</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join#getTo()
     * @see #getJoin()
     * @generated
     */
    EReference getJoin_To();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getReferenceName <em>Reference Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reference Name</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join#getReferenceName()
     * @see #getJoin()
     * @generated
     */
    EAttribute getJoin_ReferenceName();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getOppositeReferenceName <em>Opposite Reference Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Opposite Reference Name</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join#getOppositeReferenceName()
     * @see #getJoin()
     * @generated
     */
    EAttribute getJoin_OppositeReferenceName();

    /**
     * Returns the meta object for the containment reference list '{@link com.github.veithen.ramsay.emf.cm.cmml.Join#getKeyMappings <em>Key Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Key Mappings</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.Join#getKeyMappings()
     * @see #getJoin()
     * @generated
     */
    EReference getJoin_KeyMappings();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation <em>Feature Transformation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Feature Transformation</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation
     * @generated
     */
    EClass getFeatureTransformation();

    /**
     * Returns the meta object for the containment reference '{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getType()
     * @see #getFeatureTransformation()
     * @generated
     */
    EReference getFeatureTransformation_Type();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getFeature <em>Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Feature</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.FeatureTransformation#getFeature()
     * @see #getFeatureTransformation()
     * @generated
     */
    EAttribute getFeatureTransformation_Feature();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity <em>Change Multiplicity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Change Multiplicity</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity
     * @generated
     */
    EClass getChangeMultiplicity();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getLowerBound <em>Lower Bound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lower Bound</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getLowerBound()
     * @see #getChangeMultiplicity()
     * @generated
     */
    EAttribute getChangeMultiplicity_LowerBound();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getUpperBound <em>Upper Bound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Upper Bound</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity#getUpperBound()
     * @see #getChangeMultiplicity()
     * @generated
     */
    EAttribute getChangeMultiplicity_UpperBound();

    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature <em>Remove Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Remove Feature</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature
     * @generated
     */
    EClass getRemoveFeature();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature#getConsistencyCheck <em>Consistency Check</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Consistency Check</em>'.
     * @see com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature#getConsistencyCheck()
     * @see #getRemoveFeature()
     * @generated
     */
    EAttribute getRemoveFeature_ConsistencyCheck();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CMMLFactory getCMMLFactory();

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
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationImpl <em>Transformation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getTransformation()
         * @generated
         */
        EClass TRANSFORMATION = eINSTANCE.getTransformation();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationsImpl <em>Transformations</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.TransformationsImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getTransformations()
         * @generated
         */
        EClass TRANSFORMATIONS = eINSTANCE.getTransformations();

        /**
         * The meta object literal for the '<em><b>Transformation</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TRANSFORMATIONS__TRANSFORMATION = eINSTANCE.getTransformations_Transformation();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.TypeImpl <em>Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.TypeImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getType()
         * @generated
         */
        EClass TYPE = eINSTANCE.getType();

        /**
         * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE__NS_URI = eINSTANCE.getType_NsURI();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPE__NAME = eINSTANCE.getType_Name();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.KeyMappingImpl <em>Key Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.KeyMappingImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getKeyMapping()
         * @generated
         */
        EClass KEY_MAPPING = eINSTANCE.getKeyMapping();

        /**
         * The meta object literal for the '<em><b>From</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KEY_MAPPING__FROM = eINSTANCE.getKeyMapping_From();

        /**
         * The meta object literal for the '<em><b>To</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KEY_MAPPING__TO = eINSTANCE.getKeyMapping_To();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl <em>Join</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.JoinImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getJoin()
         * @generated
         */
        EClass JOIN = eINSTANCE.getJoin();

        /**
         * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOIN__FROM = eINSTANCE.getJoin_From();

        /**
         * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOIN__TO = eINSTANCE.getJoin_To();

        /**
         * The meta object literal for the '<em><b>Reference Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JOIN__REFERENCE_NAME = eINSTANCE.getJoin_ReferenceName();

        /**
         * The meta object literal for the '<em><b>Opposite Reference Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JOIN__OPPOSITE_REFERENCE_NAME = eINSTANCE.getJoin_OppositeReferenceName();

        /**
         * The meta object literal for the '<em><b>Key Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOIN__KEY_MAPPINGS = eINSTANCE.getJoin_KeyMappings();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.FeatureTransformationImpl <em>Feature Transformation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.FeatureTransformationImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getFeatureTransformation()
         * @generated
         */
        EClass FEATURE_TRANSFORMATION = eINSTANCE.getFeatureTransformation();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FEATURE_TRANSFORMATION__TYPE = eINSTANCE.getFeatureTransformation_Type();

        /**
         * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FEATURE_TRANSFORMATION__FEATURE = eINSTANCE.getFeatureTransformation_Feature();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.ChangeMultiplicityImpl <em>Change Multiplicity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.ChangeMultiplicityImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getChangeMultiplicity()
         * @generated
         */
        EClass CHANGE_MULTIPLICITY = eINSTANCE.getChangeMultiplicity();

        /**
         * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHANGE_MULTIPLICITY__LOWER_BOUND = eINSTANCE.getChangeMultiplicity_LowerBound();

        /**
         * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHANGE_MULTIPLICITY__UPPER_BOUND = eINSTANCE.getChangeMultiplicity_UpperBound();

        /**
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.cm.cmml.impl.RemoveFeatureImpl <em>Remove Feature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.RemoveFeatureImpl
         * @see com.github.veithen.ramsay.emf.cm.cmml.impl.CMMLPackageImpl#getRemoveFeature()
         * @generated
         */
        EClass REMOVE_FEATURE = eINSTANCE.getRemoveFeature();

        /**
         * The meta object literal for the '<em><b>Consistency Check</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REMOVE_FEATURE__CONSISTENCY_CHECK = eINSTANCE.getRemoveFeature_ConsistencyCheck();

    }

} //CMMLPackage
