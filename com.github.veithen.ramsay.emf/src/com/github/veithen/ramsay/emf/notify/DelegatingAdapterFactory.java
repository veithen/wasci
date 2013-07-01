package com.github.veithen.ramsay.emf.notify;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.github.veithen.ramsay.emf.internal.Constants;

public class DelegatingAdapterFactory extends AdapterFactoryImpl {
    private static final Map<Class<?>,DelegatingAdapterFactory> instances = new HashMap<Class<?>,DelegatingAdapterFactory>();
    
    private final Class<?> type;
    private final Map<String,AdapterFactoryDelegateHolder> delegateHolders = new HashMap<String,AdapterFactoryDelegateHolder>();
    
    private DelegatingAdapterFactory(Class<?> type) {
        this.type = type;
        IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
        String typeName = type.getName();
        for (IConfigurationElement delegateElement : extensionRegistry.getConfigurationElementsFor(Constants.ADAPTER_FACTORY_DELEGATES_ID)) {
            for (IConfigurationElement supportedTypeElement : delegateElement.getChildren("supportedType")) {
                if (typeName.equals(supportedTypeElement.getAttribute("class"))) {
                    delegateHolders.put(delegateElement.getAttribute("uri"), new AdapterFactoryDelegateHolder(delegateElement));
                }
            }
        }
    }

    public static synchronized DelegatingAdapterFactory getInstance(Class<?> type) {
        DelegatingAdapterFactory instance = instances.get(type);
        if (instance == null) {
            instance = new DelegatingAdapterFactory(type);
            instances.put(type, instance);
        }
        return instance;
    }
    
    @Override
    public boolean isFactoryForType(Object type) {
        return type == this.type;
    }

    @Override
    protected Adapter createAdapter(Notifier target) {
        if (target instanceof EObject) {
            AdapterFactoryDelegateHolder delegateHolder = delegateHolders.get(((EObject)target).eClass().getEPackage().getNsURI());
            if (delegateHolder != null) {
                AdapterFactoryDelegate delegate = delegateHolder.getDelegate();
                return delegate != null ? delegate.createAdapter(target) : null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
