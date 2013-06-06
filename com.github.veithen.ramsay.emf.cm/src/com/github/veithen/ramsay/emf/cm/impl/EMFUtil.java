package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

public final class EMFUtil {
    private EMFUtil() {}

    public static <T> T getAdapter(Class<T> clazz, Notifier notifier) {
        for (Adapter adapter : notifier.eAdapters()) {
            if (clazz.isInstance(adapter)) {
                return clazz.cast(adapter);
            }
        }
        return null;
    }
}
