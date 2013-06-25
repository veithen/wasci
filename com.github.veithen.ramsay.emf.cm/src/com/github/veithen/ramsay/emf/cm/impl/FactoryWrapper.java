package com.github.veithen.ramsay.emf.cm.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Internal;

import com.github.veithen.ramsay.emf.util.EMFUtil;

public class FactoryWrapper implements EFactory, InternalEObject {
    private final EFactory target;

    public FactoryWrapper(EFactory target) {
        this.target = target;
    }
    
    public EList<Adapter> eAdapters() {
        return target.eAdapters();
    }

    public boolean eDeliver() {
        return target.eDeliver();
    }

    public EList<EAnnotation> getEAnnotations() {
        return target.getEAnnotations();
    }

    public void eSetDeliver(boolean deliver) {
        target.eSetDeliver(deliver);
    }

    public EPackage getEPackage() {
        return target.getEPackage();
    }

    public void eNotify(Notification notification) {
        target.eNotify(notification);
    }

    public EAnnotation getEAnnotation(String source) {
        return target.getEAnnotation(source);
    }

    public void setEPackage(EPackage value) {
        target.setEPackage(value);
    }

    public EObject create(EClass eClass) {
        return EMFUtil.getAdapter(CovariantClassAdapter.class, eClass).getInstances().newInstance();
    }

    public Object createFromString(EDataType eDataType, String literalValue) {
        return target.createFromString(eDataType, literalValue);
    }

    public String convertToString(EDataType eDataType, Object instanceValue) {
        return target.convertToString(eDataType, instanceValue);
    }

    public EClass eClass() {
        return target.eClass();
    }

    public Resource eResource() {
        return target.eResource();
    }

    public EObject eContainer() {
        return target.eContainer();
    }

    public EStructuralFeature eContainingFeature() {
        return target.eContainingFeature();
    }

    public EReference eContainmentFeature() {
        return target.eContainmentFeature();
    }

    public EList<EObject> eContents() {
        return target.eContents();
    }

    public TreeIterator<EObject> eAllContents() {
        return target.eAllContents();
    }

    public boolean eIsProxy() {
        return target.eIsProxy();
    }

    public EList<EObject> eCrossReferences() {
        return target.eCrossReferences();
    }

    public Object eGet(EStructuralFeature feature) {
        return target.eGet(feature);
    }

    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return target.eGet(feature, resolve);
    }

    public void eSet(EStructuralFeature feature, Object newValue) {
        target.eSet(feature, newValue);
    }

    public boolean eIsSet(EStructuralFeature feature) {
        return target.eIsSet(feature);
    }

    public void eUnset(EStructuralFeature feature) {
        target.eUnset(feature);
    }

    public Object eInvoke(EOperation operation, EList<?> arguments)
            throws InvocationTargetException {
        return target.eInvoke(operation, arguments);
    }

    public boolean eNotificationRequired() {
        return ((InternalEObject)target).eNotificationRequired();
    }

    public String eURIFragmentSegment(EStructuralFeature eFeature,
            EObject eObject) {
        return ((InternalEObject)target).eURIFragmentSegment(eFeature, eObject);
    }

    public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
        return ((InternalEObject)target).eObjectForURIFragmentSegment(uriFragmentSegment);
    }

    public void eSetClass(EClass eClass) {
        ((InternalEObject)target).eSetClass(eClass);
    }

    public Setting eSetting(EStructuralFeature feature) {
        return ((InternalEObject)target).eSetting(feature);
    }

    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        return ((InternalEObject)target).eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    public int eContainerFeatureID() {
        return ((InternalEObject)target).eContainerFeatureID();
    }

    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        return ((InternalEObject)target).eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
        return ((InternalEObject)target).eDerivedOperationID(baseOperationID, baseClass);
    }

    public NotificationChain eSetResource(Internal resource,
            NotificationChain notifications) {
        return ((InternalEObject)target).eSetResource(resource, notifications);
    }

    public NotificationChain eInverseAdd(InternalEObject otherEnd,
            int featureID, Class<?> baseClass, NotificationChain notifications) {
        return ((InternalEObject)target)
                .eInverseAdd(otherEnd, featureID, baseClass, notifications);
    }

    public NotificationChain eInverseRemove(InternalEObject otherEnd,
            int featureID, Class<?> baseClass, NotificationChain notifications) {
        return ((InternalEObject)target).eInverseRemove(otherEnd, featureID, baseClass,
                notifications);
    }

    public NotificationChain eBasicSetContainer(InternalEObject newContainer,
            int newContainerFeatureID, NotificationChain notifications) {
        return ((InternalEObject)target).eBasicSetContainer(newContainer, newContainerFeatureID,
                notifications);
    }

    public NotificationChain eBasicRemoveFromContainer(
            NotificationChain notifications) {
        return ((InternalEObject)target).eBasicRemoveFromContainer(notifications);
    }

    public URI eProxyURI() {
        return ((InternalEObject)target).eProxyURI();
    }

    public void eSetProxyURI(URI uri) {
        ((InternalEObject)target).eSetProxyURI(uri);
    }

    public EObject eResolveProxy(InternalEObject proxy) {
        return ((InternalEObject)target).eResolveProxy(proxy);
    }

    public InternalEObject eInternalContainer() {
        return ((InternalEObject)target).eInternalContainer();
    }

    public Internal eInternalResource() {
        return ((InternalEObject)target).eInternalResource();
    }

    public Internal eDirectResource() {
        return ((InternalEObject)target).eDirectResource();
    }

    public EStore eStore() {
        return ((InternalEObject)target).eStore();
    }

    public void eSetStore(EStore store) {
        ((InternalEObject)target).eSetStore(store);
    }

    public Object eGet(EStructuralFeature eFeature, boolean resolve,
            boolean coreType) {
        return ((InternalEObject)target).eGet(eFeature, resolve, coreType);
    }

    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        return ((InternalEObject)target).eGet(featureID, resolve, coreType);
    }

    public void eSet(int featureID, Object newValue) {
        ((InternalEObject)target).eSet(featureID, newValue);
    }

    public void eUnset(int featureID) {
        ((InternalEObject)target).eUnset(featureID);
    }

    public boolean eIsSet(int featureID) {
        return ((InternalEObject)target).eIsSet(featureID);
    }

    public Object eInvoke(int operationID, EList<?> arguments)
            throws InvocationTargetException {
        return ((InternalEObject)target).eInvoke(operationID, arguments);
    }
}
