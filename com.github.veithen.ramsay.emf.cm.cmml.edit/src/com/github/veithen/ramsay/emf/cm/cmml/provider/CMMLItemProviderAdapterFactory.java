/**
 */
package com.github.veithen.ramsay.emf.cm.cmml.provider;

import com.github.veithen.ramsay.emf.cm.cmml.util.CMMLAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CMMLItemProviderAdapterFactory extends CMMLAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CMMLItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link com.github.veithen.ramsay.emf.cm.cmml.Transformations} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TransformationsItemProvider transformationsItemProvider;

    /**
     * This creates an adapter for a {@link com.github.veithen.ramsay.emf.cm.cmml.Transformations}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTransformationsAdapter() {
        if (transformationsItemProvider == null) {
            transformationsItemProvider = new TransformationsItemProvider(this);
        }

        return transformationsItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link com.github.veithen.ramsay.emf.cm.cmml.Type} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeItemProvider typeItemProvider;

    /**
     * This creates an adapter for a {@link com.github.veithen.ramsay.emf.cm.cmml.Type}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeAdapter() {
        if (typeItemProvider == null) {
            typeItemProvider = new TypeItemProvider(this);
        }

        return typeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected KeyMappingItemProvider keyMappingItemProvider;

    /**
     * This creates an adapter for a {@link com.github.veithen.ramsay.emf.cm.cmml.KeyMapping}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createKeyMappingAdapter() {
        if (keyMappingItemProvider == null) {
            keyMappingItemProvider = new KeyMappingItemProvider(this);
        }

        return keyMappingItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link com.github.veithen.ramsay.emf.cm.cmml.Join} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JoinItemProvider joinItemProvider;

    /**
     * This creates an adapter for a {@link com.github.veithen.ramsay.emf.cm.cmml.Join}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createJoinAdapter() {
        if (joinItemProvider == null) {
            joinItemProvider = new JoinItemProvider(this);
        }

        return joinItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChangeMultiplicityItemProvider changeMultiplicityItemProvider;

    /**
     * This creates an adapter for a {@link com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createChangeMultiplicityAdapter() {
        if (changeMultiplicityItemProvider == null) {
            changeMultiplicityItemProvider = new ChangeMultiplicityItemProvider(this);
        }

        return changeMultiplicityItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RemoveFeatureItemProvider removeFeatureItemProvider;

    /**
     * This creates an adapter for a {@link com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRemoveFeatureAdapter() {
        if (removeFeatureItemProvider == null) {
            removeFeatureItemProvider = new RemoveFeatureItemProvider(this);
        }

        return removeFeatureItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (transformationsItemProvider != null) transformationsItemProvider.dispose();
        if (typeItemProvider != null) typeItemProvider.dispose();
        if (keyMappingItemProvider != null) keyMappingItemProvider.dispose();
        if (joinItemProvider != null) joinItemProvider.dispose();
        if (changeMultiplicityItemProvider != null) changeMultiplicityItemProvider.dispose();
        if (removeFeatureItemProvider != null) removeFeatureItemProvider.dispose();
    }

}
