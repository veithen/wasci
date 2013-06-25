package com.github.veithen.ramsay.emf.notify;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

public interface AdapterFactoryDelegate {
    Adapter createAdapter(Notifier target);
}
