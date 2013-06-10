package com.github.veithen.ramsay.emf.cm.transform.impl;

import org.eclipse.emf.ecore.EObject;

public class CompositeKeyFactory implements KeyFactory {
    private final SimpleKeyFactory[] componentFactories;

    public CompositeKeyFactory(SimpleKeyFactory[] componentFactories) {
        this.componentFactories = componentFactories;
    }

    @Override
    public boolean isNotNull() {
        for (SimpleKeyFactory componentFactory : componentFactories) {
            if (!componentFactory.isNotNull()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getKey(EObject object) {
        int l = componentFactories.length;
        Object[] components = null;
        for (int i=0; i<l; i++) {
            Object component = componentFactories[i].getKey(object);
            if (component == null) {
                return null;
            }
            if (components == null) {
                components = new Object[l];
            }
            components[i] = component;
        }
        return new CompositeKey(components);
    }
}
