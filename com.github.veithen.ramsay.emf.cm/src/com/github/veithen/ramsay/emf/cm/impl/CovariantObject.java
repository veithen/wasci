package com.github.veithen.ramsay.emf.cm.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Internal;
import org.eclipse.emf.ecore.util.EContentsEList;

public class CovariantObject implements InternalEObject {
    private final Instances instances;
    private final int instanceId;
    private Internal resource;
    private EList<EObject> contents;
    
    public CovariantObject(Instances instances, int instanceId) {
        this.instances = instances;
        this.instanceId = instanceId;
    }

    @Override
    public EList<Adapter> eAdapters() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean eDeliver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eSetDeliver(boolean deliver) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eNotify(Notification notification) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EClass eClass() {
        return instances.getEClass();
    }

    @Override
    public Resource eResource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EObject eContainer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EStructuralFeature eContainingFeature() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EReference eContainmentFeature() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EList<EObject> eContents() {
        if (contents == null) {
            contents = EContentsEList.createEContentsEList(this);
        }
        return contents;
    }

    @Override
    public TreeIterator<EObject> eAllContents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean eIsProxy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EList<EObject> eCrossReferences() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
        return instances.eGet(instanceId, feature);
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return eGet(feature);
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        instances.eSet(instanceId, feature, newValue);
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return instances.eIsSet(instanceId, feature);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments)
            throws InvocationTargetException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean eNotificationRequired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public String eURIFragmentSegment(EStructuralFeature eFeature,
            EObject eObject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eSetClass(EClass eClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Setting eSetting(EStructuralFeature feature) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public int eContainerFeatureID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public NotificationChain eSetResource(Internal resource, NotificationChain notifications) {
        if (this.resource != null) {
            throw new IllegalStateException();
        }
        this.resource = resource;
        return notifications;
    }

    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd,
            int featureID, Class<?> baseClass, NotificationChain notifications) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd,
            int featureID, Class<?> baseClass, NotificationChain notifications) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public NotificationChain eBasicSetContainer(InternalEObject newContainer,
            int newContainerFeatureID, NotificationChain notifications) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public NotificationChain eBasicRemoveFromContainer(
            NotificationChain notifications) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public URI eProxyURI() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eSetProxyURI(URI uri) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public EObject eResolveProxy(InternalEObject proxy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public InternalEObject eInternalContainer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Internal eInternalResource() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Internal eDirectResource() {
        return resource;
    }

    @Override
    public EStore eStore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eSetStore(EStore store) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Object eGet(EStructuralFeature eFeature, boolean resolve,
            boolean coreType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eSet(int featureID, Object newValue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public void eUnset(int featureID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean eIsSet(int featureID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Object eInvoke(int operationID, EList<?> arguments)
            throws InvocationTargetException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
