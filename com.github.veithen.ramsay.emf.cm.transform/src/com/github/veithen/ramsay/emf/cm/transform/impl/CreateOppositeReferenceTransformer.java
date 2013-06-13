package com.github.veithen.ramsay.emf.cm.transform.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;

public class CreateOppositeReferenceTransformer implements Transformer {
    private final CreateOppositeReference spec;
    
    public CreateOppositeReferenceTransformer(CreateOppositeReference spec) {
        this.spec = spec;
    }

    @Override
    public void transform(Realm realm) throws CoreException {
        EClass fromClass = Util.resolve(realm, spec.getType());
        // TODO: check cast here
        EReference reference = (EReference)fromClass.getEStructuralFeature(spec.getReferenceName());
        if (reference == null) {
            throw new CoreException(new TransformationStatus(IStatus.ERROR, "Feature " + spec.getReferenceName() + " doesn't exist in " + fromClass.getName(), spec));
        }
        // TODO: check cast here
        EClass toClass = (EClass)reference.getEType();
        EReference oppositeReference = EcoreFactory.eINSTANCE.createEReference();
        oppositeReference.setName(spec.getOppositeReferenceName());
        oppositeReference.setEType(fromClass);
        oppositeReference.setLowerBound(spec.getLowerBound());
        oppositeReference.setUpperBound(spec.getUpperBound());
        toClass.getEStructuralFeatures().add(oppositeReference);
        oppositeReference.setEOpposite(reference);
        reference.setEOpposite(oppositeReference);
        /*
        for (EObject fromObject : realm.getInstances(fromClass)) {
            List<EObject> toObjects;
            if (reference.isMany()) {
                toObjects = (EList<EObject>)fromObject.eGet(reference);
            } else {
                EObject toObject = (EObject)fromObject.eGet(reference);
                toObjects = toObject == null ? Collections.<EObject>emptyList() : Arrays.asList(toObject);
            }
            for (EObject toObject : toObjects) {
                // TODO: only valid for certain multiplicities
                // TODO: need to check if reference already set
                toObject.eSet(oppositeReference, fromObject);
            }
        }
        */
    }
}
