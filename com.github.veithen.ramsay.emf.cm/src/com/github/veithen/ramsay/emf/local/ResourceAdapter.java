package com.github.veithen.ramsay.emf.local;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import com.github.veithen.ramsay.emf.cm.impl.EMFUtil;
import com.github.veithen.ramsay.emf.notify.AdapterBase;

final class ResourceAdapter extends AdapterBase<Resource> {
    private final ResourceSetAdapter resourceSetAdapter;
    
    ResourceAdapter(ResourceSetAdapter resourceSetAdapter, Resource target) {
        super(target);
        this.resourceSetAdapter = resourceSetAdapter;
    }

    @Override
    protected void added() {
        for (EObject content : target.getContents()) {
            if (content instanceof EPackage) {
                resourceSetAdapter.addAdapter((EPackage)content);
            }
        }
    }

    @Override
    protected void removed() {
        for (EObject content : target.getContents()) {
            if (content instanceof EPackage) {
                resourceSetAdapter.removeAdapter((EPackage)content);
            }
        }
    }

    @Override
    protected void set(int featureId, Object value) {
        switch (featureId) {
            case Resource.RESOURCE__CONTENTS:
                if (value instanceof EPackage) {
                    resourceSetAdapter.addAdapter((EPackage)value);
                }
                break;
            case Resource.RESOURCE__URI:
                for (EObject content : target.getContents()) {
                    if (content instanceof EPackage) {
                        EMFUtil.getAdapter(EPackageAdapter.class, content).resourceURIChanged();
                    }
                }
        }
    }

    @Override
    protected void unset(int featureId, Object value) {
        switch (featureId) {
            case Resource.RESOURCE__CONTENTS:
                if (value instanceof EPackage) {
                    resourceSetAdapter.removeAdapter((EPackage)value);
                }
                break;
        }
    }
}
