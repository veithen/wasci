package com.github.veithen.ramsay.emf.cm.transform.impl;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;

public class ChangeMultiplicityTransformer implements Transformer {
    private final ChangeMultiplicity spec;

    public ChangeMultiplicityTransformer(ChangeMultiplicity spec) {
        this.spec = spec;
    }

    @Override
    public void transform(Realm realm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
