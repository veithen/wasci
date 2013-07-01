package com.github.veithen.ramsay.emf.notify;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

public abstract class SimpleAdapter<T extends Notifier> implements Adapter {
    protected final T target;
    private boolean added;

    public SimpleAdapter(T target) {
        this.target = target;
    }

    @Override
    public final boolean isAdapterForType(Object type) {
        if (type instanceof Class<?>) {
            return ((Class<?>)type).isInstance(this);
        } else {
            return false;
        }
    }

    @Override
    public final T getTarget() {
        return added ? target : null;
    }

    @Override
    public final void setTarget(Notifier newTarget) {
        if (!added && newTarget == target) {
            added = true;
        } else if (added && newTarget == null) {
            added = false;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void notifyChanged(Notification notification) {
    }
}
