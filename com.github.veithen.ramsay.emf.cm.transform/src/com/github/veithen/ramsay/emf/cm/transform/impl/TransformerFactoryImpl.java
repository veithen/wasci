package com.github.veithen.ramsay.emf.cm.transform.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity;
import com.github.veithen.ramsay.emf.cm.cmml.Join;
import com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature;
import com.github.veithen.ramsay.emf.cm.cmml.Transformation;
import com.github.veithen.ramsay.emf.cm.cmml.TransformationChain;
import com.github.veithen.ramsay.emf.cm.cmml.util.CMMLSwitch;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;
import com.github.veithen.ramsay.emf.cm.transform.TransformerFactory;

public class TransformerFactoryImpl extends CMMLSwitch<Transformer> implements TransformerFactory {
    @Override
    public Transformer createTransformer(Transformation transformation) {
        return doSwitch(transformation);
    }

    @Override
    public Transformer caseJoin(Join config) {
        return new JoinTransformer(config);
    }

    @Override
    public Transformer caseChangeMultiplicity(ChangeMultiplicity config) {
        return new ChangeMultiplicityTransformer(config);
    }

    @Override
    public Transformer caseRemoveFeature(RemoveFeature config) {
        return new RemoveFeatureTransformer(config);
    }

    @Override
    public Transformer createTransformer(TransformationChain transformationChain) {
        List<Transformer> transformers = new ArrayList<Transformer>();
        for (Transformation transformation : transformationChain.getTransformations()) {
            transformers.add(createTransformer(transformation));
        }
        return new TransformerChain(transformers.toArray(new Transformer[transformers.size()]));
    }
}
