package com.github.veithen.ramsay.emf.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class EMFPlugin extends Plugin {
    private static EMFPlugin instance;

    public static EMFPlugin getInstance() {
        return instance;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        instance = this;
    }
}
