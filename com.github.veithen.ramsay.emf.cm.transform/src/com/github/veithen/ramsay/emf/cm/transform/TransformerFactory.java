package com.github.veithen.ramsay.emf.cm.transform;

import com.github.veithen.ramsay.emf.cm.cmml.Transformation;
import com.github.veithen.ramsay.emf.cm.cmml.TransformationChain;
import com.github.veithen.ramsay.emf.cm.transform.impl.TransformerFactoryImpl;

public interface TransformerFactory {
    TransformerFactory INSTANCE = new TransformerFactoryImpl();
    
    Transformer createTransformer(Transformation transformation);
    
    Transformer createTransformer(TransformationChain transformationChain);
}
