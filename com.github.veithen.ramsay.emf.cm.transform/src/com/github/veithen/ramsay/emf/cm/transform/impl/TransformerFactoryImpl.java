package com.github.veithen.ramsay.emf.cm.transform.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.cm.cmml.ChangeMultiplicity;
import com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference;
import com.github.veithen.ramsay.emf.cm.cmml.Join;
import com.github.veithen.ramsay.emf.cm.cmml.RemoveFeature;
import com.github.veithen.ramsay.emf.cm.cmml.Transformation;
import com.github.veithen.ramsay.emf.cm.cmml.TransformationChain;
import com.github.veithen.ramsay.emf.cm.cmml.util.CMMLSwitch;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;
import com.github.veithen.ramsay.emf.cm.transform.TransformerFactory;
import com.github.veithen.ramsay.util.Constants;
import com.github.veithen.ramsay.util.EMFUtil;

public class TransformerFactoryImpl extends CMMLSwitch<Transformer> implements TransformerFactory {
    @Override
    public Transformer createTransformer(Transformation transformation) {
        Transformer transformer = doSwitch(transformation);
        if (transformer == null) {
            throw new IllegalArgumentException("Unknown transformation type " + transformation.eClass().getName());
        }
        return transformer;
    }

    @Override
    public Transformer caseJoin(Join spec) {
        return new JoinTransformer(spec);
    }

    @Override
    public Transformer caseChangeMultiplicity(ChangeMultiplicity spec) {
        return new ChangeMultiplicityTransformer(spec);
    }

    @Override
    public Transformer caseRemoveFeature(RemoveFeature spec) {
        return new RemoveFeatureTransformer(spec);
    }

    @Override
    public Transformer caseCreateOppositeReference(CreateOppositeReference spec) {
        return new CreateOppositeReferenceTransformer(spec);
    }

    @Override
    public Transformer caseTransformationChain(TransformationChain spec) {
        return createTransformer(spec);
    }

    @Override
    public Transformer createTransformer(TransformationChain transformationChain) {
        List<Transformer> transformers = new ArrayList<Transformer>();
        for (Transformation transformation : transformationChain.getTransformations()) {
            transformers.add(createTransformer(transformation));
        }
        return createTransformer(transformers);
    }

    @Override
    public Transformer createTransformer(Collection<Transformer> transformers) {
        return new TransformerChain(transformers.toArray(new Transformer[transformers.size()]));
    }

    @Override
    public Transformer createTransformer(IFile file) throws CoreException {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = EMFUtil.load(resourceSet, file);
        List<Transformer> transformers = new ArrayList<Transformer>();
        for (EObject object : resource.getContents()) {
            Transformer transformer = doSwitch(object);
            if (transformer == null) {
                throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Object " + EcoreUtil.getURI(object) + " doesn't define a transformation"));
            }
            transformers.add(transformer);
        }
        if (transformers.size() == 1) {
            return transformers.get(0);
        } else {
            return createTransformer(transformers);
        }
    }
}
