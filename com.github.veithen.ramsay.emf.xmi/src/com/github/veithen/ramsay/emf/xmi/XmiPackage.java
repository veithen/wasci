/**
 */
package com.github.veithen.ramsay.emf.xmi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see com.github.veithen.ramsay.emf.xmi.XmiFactory
 * @model kind="package"
 * @generated
 */
public interface XmiPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "xmi";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.omg.org/XMI";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "xmi";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    XmiPackage eINSTANCE = com.github.veithen.ramsay.emf.xmi.impl.XmiPackageImpl.init();

    /**
     * The meta object id for the '{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl <em>Documentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl
     * @see com.github.veithen.ramsay.emf.xmi.impl.XmiPackageImpl#getDocumentation()
     * @generated
     */
    int DOCUMENTATION = 0;

    /**
     * The feature id for the '<em><b>Contact</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__CONTACT = 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__EXPORTER = 1;

    /**
     * The feature id for the '<em><b>Exporter Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__EXPORTER_VERSION = 2;

    /**
     * The feature id for the '<em><b>Long Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__LONG_DESCRIPTION = 3;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__SHORT_DESCRIPTION = 4;

    /**
     * The feature id for the '<em><b>Notice</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__NOTICE = 5;

    /**
     * The feature id for the '<em><b>Owner</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION__OWNER = 6;

    /**
     * The number of structural features of the '<em>Documentation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTATION_FEATURE_COUNT = 7;


    /**
     * Returns the meta object for class '{@link com.github.veithen.ramsay.emf.xmi.Documentation <em>Documentation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Documentation</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation
     * @generated
     */
    EClass getDocumentation();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getContact <em>Contact</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Contact</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getContact()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_Contact();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getExporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exporter</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getExporter()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_Exporter();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getExporterVersion <em>Exporter Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exporter Version</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getExporterVersion()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_ExporterVersion();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getLongDescription <em>Long Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Long Description</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getLongDescription()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_LongDescription();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getShortDescription <em>Short Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Short Description</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getShortDescription()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_ShortDescription();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getNotice <em>Notice</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Notice</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getNotice()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_Notice();

    /**
     * Returns the meta object for the attribute '{@link com.github.veithen.ramsay.emf.xmi.Documentation#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Owner</em>'.
     * @see com.github.veithen.ramsay.emf.xmi.Documentation#getOwner()
     * @see #getDocumentation()
     * @generated
     */
    EAttribute getDocumentation_Owner();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    XmiFactory getXmiFactory();

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
         * The meta object literal for the '{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl <em>Documentation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl
         * @see com.github.veithen.ramsay.emf.xmi.impl.XmiPackageImpl#getDocumentation()
         * @generated
         */
        EClass DOCUMENTATION = eINSTANCE.getDocumentation();

        /**
         * The meta object literal for the '<em><b>Contact</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__CONTACT = eINSTANCE.getDocumentation_Contact();

        /**
         * The meta object literal for the '<em><b>Exporter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__EXPORTER = eINSTANCE.getDocumentation_Exporter();

        /**
         * The meta object literal for the '<em><b>Exporter Version</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__EXPORTER_VERSION = eINSTANCE.getDocumentation_ExporterVersion();

        /**
         * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__LONG_DESCRIPTION = eINSTANCE.getDocumentation_LongDescription();

        /**
         * The meta object literal for the '<em><b>Short Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__SHORT_DESCRIPTION = eINSTANCE.getDocumentation_ShortDescription();

        /**
         * The meta object literal for the '<em><b>Notice</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__NOTICE = eINSTANCE.getDocumentation_Notice();

        /**
         * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTATION__OWNER = eINSTANCE.getDocumentation_Owner();

    }

} //XmiPackage
