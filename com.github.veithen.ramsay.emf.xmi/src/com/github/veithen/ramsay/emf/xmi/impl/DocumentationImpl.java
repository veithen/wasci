/**
 */
package com.github.veithen.ramsay.emf.xmi.impl;

import com.github.veithen.ramsay.emf.xmi.Documentation;
import com.github.veithen.ramsay.emf.xmi.XmiPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getContact <em>Contact</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getExporterVersion <em>Exporter Version</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getNotice <em>Notice</em>}</li>
 *   <li>{@link com.github.veithen.ramsay.emf.xmi.impl.DocumentationImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentationImpl extends EObjectImpl implements Documentation {
    /**
     * The default value of the '{@link #getContact() <em>Contact</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContact()
     * @generated
     * @ordered
     */
    protected static final String CONTACT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContact() <em>Contact</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContact()
     * @generated
     * @ordered
     */
    protected String contact = CONTACT_EDEFAULT;

    /**
     * The default value of the '{@link #getExporter() <em>Exporter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporter()
     * @generated
     * @ordered
     */
    protected static final String EXPORTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExporter() <em>Exporter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporter()
     * @generated
     * @ordered
     */
    protected String exporter = EXPORTER_EDEFAULT;

    /**
     * The default value of the '{@link #getExporterVersion() <em>Exporter Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporterVersion()
     * @generated
     * @ordered
     */
    protected static final String EXPORTER_VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExporterVersion() <em>Exporter Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporterVersion()
     * @generated
     * @ordered
     */
    protected String exporterVersion = EXPORTER_VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLongDescription()
     * @generated
     * @ordered
     */
    protected static final String LONG_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLongDescription() <em>Long Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLongDescription()
     * @generated
     * @ordered
     */
    protected String longDescription = LONG_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getNotice() <em>Notice</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNotice()
     * @generated
     * @ordered
     */
    protected static final String NOTICE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNotice() <em>Notice</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNotice()
     * @generated
     * @ordered
     */
    protected String notice = NOTICE_EDEFAULT;

    /**
     * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwner()
     * @generated
     * @ordered
     */
    protected static final String OWNER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwner()
     * @generated
     * @ordered
     */
    protected String owner = OWNER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XmiPackage.Literals.DOCUMENTATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContact() {
        return contact;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContact(String newContact) {
        String oldContact = contact;
        contact = newContact;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__CONTACT, oldContact, contact));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExporter() {
        return exporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExporter(String newExporter) {
        String oldExporter = exporter;
        exporter = newExporter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__EXPORTER, oldExporter, exporter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExporterVersion() {
        return exporterVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExporterVersion(String newExporterVersion) {
        String oldExporterVersion = exporterVersion;
        exporterVersion = newExporterVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__EXPORTER_VERSION, oldExporterVersion, exporterVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLongDescription(String newLongDescription) {
        String oldLongDescription = longDescription;
        longDescription = newLongDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__LONG_DESCRIPTION, oldLongDescription, longDescription));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShortDescription(String newShortDescription) {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__SHORT_DESCRIPTION, oldShortDescription, shortDescription));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNotice() {
        return notice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNotice(String newNotice) {
        String oldNotice = notice;
        notice = newNotice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__NOTICE, oldNotice, notice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOwner() {
        return owner;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOwner(String newOwner) {
        String oldOwner = owner;
        owner = newOwner;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.DOCUMENTATION__OWNER, oldOwner, owner));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case XmiPackage.DOCUMENTATION__CONTACT:
                return getContact();
            case XmiPackage.DOCUMENTATION__EXPORTER:
                return getExporter();
            case XmiPackage.DOCUMENTATION__EXPORTER_VERSION:
                return getExporterVersion();
            case XmiPackage.DOCUMENTATION__LONG_DESCRIPTION:
                return getLongDescription();
            case XmiPackage.DOCUMENTATION__SHORT_DESCRIPTION:
                return getShortDescription();
            case XmiPackage.DOCUMENTATION__NOTICE:
                return getNotice();
            case XmiPackage.DOCUMENTATION__OWNER:
                return getOwner();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case XmiPackage.DOCUMENTATION__CONTACT:
                setContact((String)newValue);
                return;
            case XmiPackage.DOCUMENTATION__EXPORTER:
                setExporter((String)newValue);
                return;
            case XmiPackage.DOCUMENTATION__EXPORTER_VERSION:
                setExporterVersion((String)newValue);
                return;
            case XmiPackage.DOCUMENTATION__LONG_DESCRIPTION:
                setLongDescription((String)newValue);
                return;
            case XmiPackage.DOCUMENTATION__SHORT_DESCRIPTION:
                setShortDescription((String)newValue);
                return;
            case XmiPackage.DOCUMENTATION__NOTICE:
                setNotice((String)newValue);
                return;
            case XmiPackage.DOCUMENTATION__OWNER:
                setOwner((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case XmiPackage.DOCUMENTATION__CONTACT:
                setContact(CONTACT_EDEFAULT);
                return;
            case XmiPackage.DOCUMENTATION__EXPORTER:
                setExporter(EXPORTER_EDEFAULT);
                return;
            case XmiPackage.DOCUMENTATION__EXPORTER_VERSION:
                setExporterVersion(EXPORTER_VERSION_EDEFAULT);
                return;
            case XmiPackage.DOCUMENTATION__LONG_DESCRIPTION:
                setLongDescription(LONG_DESCRIPTION_EDEFAULT);
                return;
            case XmiPackage.DOCUMENTATION__SHORT_DESCRIPTION:
                setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
                return;
            case XmiPackage.DOCUMENTATION__NOTICE:
                setNotice(NOTICE_EDEFAULT);
                return;
            case XmiPackage.DOCUMENTATION__OWNER:
                setOwner(OWNER_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case XmiPackage.DOCUMENTATION__CONTACT:
                return CONTACT_EDEFAULT == null ? contact != null : !CONTACT_EDEFAULT.equals(contact);
            case XmiPackage.DOCUMENTATION__EXPORTER:
                return EXPORTER_EDEFAULT == null ? exporter != null : !EXPORTER_EDEFAULT.equals(exporter);
            case XmiPackage.DOCUMENTATION__EXPORTER_VERSION:
                return EXPORTER_VERSION_EDEFAULT == null ? exporterVersion != null : !EXPORTER_VERSION_EDEFAULT.equals(exporterVersion);
            case XmiPackage.DOCUMENTATION__LONG_DESCRIPTION:
                return LONG_DESCRIPTION_EDEFAULT == null ? longDescription != null : !LONG_DESCRIPTION_EDEFAULT.equals(longDescription);
            case XmiPackage.DOCUMENTATION__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
            case XmiPackage.DOCUMENTATION__NOTICE:
                return NOTICE_EDEFAULT == null ? notice != null : !NOTICE_EDEFAULT.equals(notice);
            case XmiPackage.DOCUMENTATION__OWNER:
                return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (contact: ");
        result.append(contact);
        result.append(", exporter: ");
        result.append(exporter);
        result.append(", exporterVersion: ");
        result.append(exporterVersion);
        result.append(", longDescription: ");
        result.append(longDescription);
        result.append(", shortDescription: ");
        result.append(shortDescription);
        result.append(", notice: ");
        result.append(notice);
        result.append(", owner: ");
        result.append(owner);
        result.append(')');
        return result.toString();
    }

} //DocumentationImpl
