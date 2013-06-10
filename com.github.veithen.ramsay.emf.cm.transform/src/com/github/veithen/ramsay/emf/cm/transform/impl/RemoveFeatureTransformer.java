package com.github.veithen.ramsay.emf.cm.transform.impl;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;

public class RemoveFeatureTransformer implements Transformer {
    private final RemoveFeature spec;

    public RemoveFeatureTransformer(RemoveFeature spec) {
        this.spec = spec;
    }

    @Override
    public void transform(Realm realm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
