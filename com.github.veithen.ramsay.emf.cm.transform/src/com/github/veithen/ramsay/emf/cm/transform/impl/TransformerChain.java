package com.github.veithen.ramsay.emf.cm.transform.impl;

import org.eclipse.core.runtime.CoreException;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;

public class TransformerChain implements Transformer {
    private final Transformer[] chain;

    public TransformerChain(Transformer[] chain) {
        this.chain = chain;
    }

    @Override
    public void transform(Realm realm) throws CoreException {
        for (Transformer transformer : chain) {
            transformer.transform(realm);
        }
    }
}
