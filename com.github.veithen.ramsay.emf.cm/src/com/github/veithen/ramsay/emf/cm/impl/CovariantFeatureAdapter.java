package com.github.veithen.ramsay.emf.cm.impl;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;

public class CovariantFeatureAdapter extends AdapterBase<EStructuralFeature.Internal> {
    private SettingDelegate currentSettingDelegate;
    
    public CovariantFeatureAdapter(EStructuralFeature.Internal target) {
        super(target);
    }

    @Override
    protected void added() {
        updateCurrentSettingDelegate();
    }

    @Override
    protected void removed() {
    }

    private CovariantClassAdapter getClassAdapter() {
        return EMFUtil.getAdapter(CovariantClassAdapter.class, target.eContainer());
    }
    
    private void updateCurrentSettingDelegate() {
        currentSettingDelegate = target.getEType() == null ? null : target.getSettingDelegate();
    }
    
    @Override
    protected void set(int featureId, Object value) {
        switch (featureId) {
            case EcorePackage.ESTRUCTURAL_FEATURE__ETYPE:
                updateCurrentSettingDelegate();
                break;
            case EcorePackage.EREFERENCE__EOPPOSITE:
                if (currentSettingDelegate != null) {
                    target.setSettingDelegate(null);
                    getClassAdapter().resetFeature(target, currentSettingDelegate);
                    currentSettingDelegate = target.getSettingDelegate();
                }
                break;
        }
    }

    @Override
    protected void unset(int featureId, Object value) {
    }
}
