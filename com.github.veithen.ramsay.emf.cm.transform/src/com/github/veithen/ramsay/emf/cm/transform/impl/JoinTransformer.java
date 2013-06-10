package com.github.veithen.ramsay.emf.cm.transform.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.cmml.Join;
import com.github.veithen.ramsay.emf.cm.cmml.KeyMapping;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;

public class JoinTransformer implements Transformer {
    private final Join spec;

    public JoinTransformer(Join spec) {
        this.spec = spec;
    }

    @Override
    public void transform(Realm realm) throws CoreException {
        EClass from = Util.resolve(realm, spec.getFrom());
        EClass to = Util.resolve(realm, spec.getTo());
        
        // Create key factories
        EList<KeyMapping> keyMappings = spec.getKeyMappings();
        int keySize = keyMappings.size();
        SimpleKeyFactory[] fromKeyFactories = new SimpleKeyFactory[keySize];
        SimpleKeyFactory[] toKeyFactories = new SimpleKeyFactory[keySize];
        for (int i=0; i<keySize; i++) {
            KeyMapping keyMapping = keyMappings.get(i);
            fromKeyFactories[i] = createKeyFactory(keyMapping, from, keyMapping.getFrom());
            toKeyFactories[i] = createKeyFactory(keyMapping, to, keyMapping.getTo());
        }
        KeyFactory fromKeyFactory = createKeyFactory(fromKeyFactories);
        KeyFactory toKeyFactory = createKeyFactory(toKeyFactories);
        
        // Create features
        EReference reference = EcoreFactory.eINSTANCE.createEReference();
        reference.setName(spec.getReferenceName());
        reference.setEType(to);
        reference.setLowerBound(fromKeyFactory.isNotNull() ? 1 : 0);
        from.getEStructuralFeatures().add(reference);
        if (spec.getOppositeReferenceName() != null) {
            EReference oppositeReference = EcoreFactory.eINSTANCE.createEReference();
            oppositeReference.setName(spec.getOppositeReferenceName());
            oppositeReference.setEType(from);
            oppositeReference.setUpperBound(-1);
            oppositeReference.setEOpposite(reference);
            reference.setEOpposite(oppositeReference);
            to.getEStructuralFeatures().add(oppositeReference);
        }
        
        // Create index
        Map<Object,EObject> index = new HashMap<Object,EObject>();
        for (EObject object : realm.getInstances(to)) {
            Object key = toKeyFactory.getKey(object);
            if (key != null) {
                if (index.put(key, object) != null) {
                    throw new CoreException(new TransformationStatus(IStatus.ERROR, "Duplicate key " + Util.formatKey(key), spec, object));
                }
            }
        }
        
        // Perform the join
        for (EObject fromObject : realm.getInstances(from)) {
            Object key = fromKeyFactory.getKey(fromObject);
            if (key != null) {
                EObject toObject = index.get(key);
                if (toObject == null) {
                    throw new CoreException(new TransformationStatus(IStatus.ERROR, "No object found for key " + Util.formatKey(key), spec, fromObject));
                }
                fromObject.eSet(reference, toObject);
            }
        }
        
        // Remove foreign key features
        for (SimpleKeyFactory keyFactory : fromKeyFactories) {
            EStructuralFeature[] featurePath = keyFactory.getFeaturePath();
            if (featurePath.length == 1) {
                from.getEStructuralFeatures().remove(featurePath[0]);
            }
        }
    }
    
    private static SimpleKeyFactory createKeyFactory(KeyMapping keyMapping, EClass eClass, String expression) throws CoreException {
        String[] path = expression.split("\\.");
        EStructuralFeature[] featurePath = new EStructuralFeature[path.length];
        for (int i=0; ; i++) {
            EStructuralFeature feature = eClass.getEStructuralFeature(path[i]);
            if (feature == null) {
                throw new CoreException(new TransformationStatus(IStatus.ERROR, "No feature " + path[i] + " found in class " + eClass.getName(), keyMapping));
            }
            if (feature.isMany()) {
                throw new CoreException(new TransformationStatus(IStatus.ERROR, "Feature " + path[i] + " in class " + eClass.getName() + " is many", keyMapping));
            }
            featurePath[i] = feature;
            if (i == path.length-1) {
                break;
            }
            if (!(feature instanceof EReference)) {
                throw new CoreException(new TransformationStatus(IStatus.ERROR, "Feature " + path[i] + " in class " + eClass.getName() + " is not a reference", keyMapping));
            }
            eClass = (EClass)((EReference)feature).getEType();
        }
        return new SimpleKeyFactory(featurePath);
    }
    
    private static KeyFactory createKeyFactory(SimpleKeyFactory[] factories) {
        return factories.length == 1 ? factories[0] : new CompositeKeyFactory(factories);
    }
}
