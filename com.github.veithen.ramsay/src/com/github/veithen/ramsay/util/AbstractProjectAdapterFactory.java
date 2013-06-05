package com.github.veithen.ramsay.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;

public abstract class AbstractProjectAdapterFactory<T> implements IAdapterFactory {
    @Override
    public final Class[] getAdapterList() {
        return new Class[] { getAdapterClass() };
    }

    @Override
    public final Object getAdapter(Object adaptableObject, Class adapterType) {
        try {
            IProject project = (IProject)adaptableObject;
            if (project.getNature(getNatureId()) != null) {
                return createAdapter(project);
            } else {
                return null;
            }
        } catch (CoreException ex) {
            return null;
        }
    }
    
    protected abstract String getNatureId();
    protected abstract Class<T> getAdapterClass();
    protected abstract T createAdapter(IProject project);
}
