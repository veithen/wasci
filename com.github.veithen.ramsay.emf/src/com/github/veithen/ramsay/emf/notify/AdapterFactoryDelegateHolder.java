package com.github.veithen.ramsay.emf.notify;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import com.github.veithen.ramsay.emf.internal.EMFPlugin;

class AdapterFactoryDelegateHolder {
    private final IConfigurationElement configurationElement;
    private AdapterFactoryDelegate delegate;
    
    public AdapterFactoryDelegateHolder(IConfigurationElement configurationElement) {
        this.configurationElement = configurationElement;
    }
    
    public synchronized AdapterFactoryDelegate getDelegate() {
        if (delegate == null) {
            try {
                delegate = (AdapterFactoryDelegate)configurationElement.createExecutableExtension("class");
            } catch (CoreException ex) {
                EMFPlugin.getInstance().getLog().log(ex.getStatus());
            }
        }
        return delegate;
    }
}
