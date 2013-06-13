package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;

public abstract class AdapterBase<T extends Notifier> implements Adapter {
    protected final T target;
    private boolean added;
    
    public AdapterBase(T target) {
        this.target = target;
    }

    @Override
    public final T getTarget() {
        return added ? target : null;
    }

    @Override
    public final void setTarget(Notifier newTarget) {
        if (!added && newTarget == target) {
            added = true;
            added();
        } else if (added && newTarget == null) {
            added = false;
            removed();
        } else {
            throw new IllegalStateException();
        }
    }
    
    protected abstract void added();
    protected abstract void removed();

    @Override
    public final boolean isAdapterForType(Object type) {
        return false;
    }

    @Override
    public final void notifyChanged(Notification notification) {
        int featureId = notification.getFeatureID(null);
        switch (notification.getEventType()) {
            // TODO: other cases
            case Notification.SET:
                Object newValue = notification.getNewValue();
                if (newValue == null) {
                    unset(featureId, notification.getOldValue());
                } else {
                    set(featureId, newValue);
                }
                break;
            case Notification.ADD:
                set(featureId, notification.getNewValue());
                break;
            case Notification.ADD_MANY:
                for (Object object : (EList<?>)notification.getNewValue()) {
                    set(featureId, object);
                }
                break;
        }
    }
    
    protected abstract void set(int featureId, Object value);
    protected abstract void unset(int featureId, Object value);
}
