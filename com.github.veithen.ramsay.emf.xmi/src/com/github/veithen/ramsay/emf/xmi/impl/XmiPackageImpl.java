/**
 */
package com.github.veithen.ramsay.emf.xmi.impl;

import com.github.veithen.ramsay.emf.xmi.Documentation;
import com.github.veithen.ramsay.emf.xmi.XmiFactory;
import com.github.veithen.ramsay.emf.xmi.XmiPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmiPackageImpl extends EPackageImpl implements XmiPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentationEClass = null;

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
     * @see com.github.veithen.ramsay.emf.xmi.XmiPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private XmiPackageImpl() {
        super(eNS_URI, XmiFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link XmiPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static XmiPackage init() {
        if (isInited) return (XmiPackage)EPackage.Registry.INSTANCE.getEPackage(XmiPackage.eNS_URI);

        // Obtain or create and register package
        XmiPackageImpl theXmiPackage = (XmiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XmiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XmiPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theXmiPackage.createPackageContents();

        // Initialize created meta-data
        theXmiPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theXmiPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(XmiPackage.eNS_URI, theXmiPackage);
        return theXmiPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentation() {
        return documentationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_Contact() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_Exporter() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_ExporterVersion() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_LongDescription() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_ShortDescription() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_Notice() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentation_Owner() {
        return (EAttribute)documentationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XmiFactory getXmiFactory() {
        return (XmiFactory)getEFactoryInstance();
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
        documentationEClass = createEClass(DOCUMENTATION);
        createEAttribute(documentationEClass, DOCUMENTATION__CONTACT);
        createEAttribute(documentationEClass, DOCUMENTATION__EXPORTER);
        createEAttribute(documentationEClass, DOCUMENTATION__EXPORTER_VERSION);
        createEAttribute(documentationEClass, DOCUMENTATION__LONG_DESCRIPTION);
        createEAttribute(documentationEClass, DOCUMENTATION__SHORT_DESCRIPTION);
        createEAttribute(documentationEClass, DOCUMENTATION__NOTICE);
        createEAttribute(documentationEClass, DOCUMENTATION__OWNER);
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

        // Initialize classes and features; add operations and parameters
        initEClass(documentationEClass, Documentation.class, "Documentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentation_Contact(), ecorePackage.getEString(), "contact", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentation_Exporter(), ecorePackage.getEString(), "exporter", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentation_ExporterVersion(), ecorePackage.getEString(), "exporterVersion", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentation_LongDescription(), ecorePackage.getEString(), "longDescription", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentation_ShortDescription(), ecorePackage.getEString(), "shortDescription", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentation_Notice(), ecorePackage.getEString(), "notice", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDocumentation_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //XmiPackageImpl
