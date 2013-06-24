package com.github.veithen.ramsay.ws.metadata;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;

public class DelegatingAdapterFactory implements AdapterFactory {
    private final Object type;
    private final List<AdapterFactory> adapterFactories = new ArrayList<AdapterFactory>();
    
    public DelegatingAdapterFactory(Object type) throws CoreException {
        this.type = type;
        IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
        for (IConfigurationElement element : extensionRegistry.getConfigurationElementsFor(Constants.ADAPTERS_ID)) {
            AdapterFactory adapterFactory = (AdapterFactory)element.createExecutableExtension("class");
            if (adapterFactory.isFactoryForType(type)) {
                adapterFactories.add(adapterFactory);
            }
        }
    }

    @Override
    public boolean isFactoryForType(Object type) {
        return type == this.type;
    }

    @Override
    public Object adapt(Object object, Object type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    @Override
    public Adapter adapt(Notifier target, Object type) {
        for (AdapterFactory adapterFactory : adapterFactories) {
            Adapter adapter = adapterFactory.adapt(target, type);
            if (adapter != null) {
                return adapter;
            }
        }
        return null;
    }

    @Override
    public Adapter adaptNew(Notifier target, Object type) {
        for (AdapterFactory adapterFactory : adapterFactories) {
            Adapter adapter = adapterFactory.adaptNew(target, type);
            if (adapter != null) {
                return adapter;
            }
        }
        return null;
    }

    @Override
    public void adaptAllNew(Notifier notifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
