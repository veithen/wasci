package com.github.veithen.ramsay.emf.cm.transform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.cmml.CMMLFactory;
import com.github.veithen.ramsay.emf.cm.cmml.CreateOppositeReference;
import com.github.veithen.ramsay.emf.cm.cmml.Type;

public class CreateOppositeReferenceTest {
    private static Type createType(EClass clazz) {
        Type type = CMMLFactory.eINSTANCE.createType();
        type.setNsURI(clazz.getEPackage().getNsURI());
        type.setName(clazz.getName());
        return type;
    }
    
    /**
     * Tests a scenario with a reference having multiplicity 0..1, an opposite reference with the
     * same multiplicity and without constraint violations.
     * 
     * @throws CoreException
     */
    @Test
    public void test__0_1__0_1() throws CoreException {
        Realm realm = new Realm();
        // Create the Ecore model
        EPackage ePackage = realm.createEPackage();
        ePackage.setNsURI("urn:test");
        EClass class1 = EcoreFactory.eINSTANCE.createEClass();
        class1.setName("Class1");
        EClass class2 = EcoreFactory.eINSTANCE.createEClass();
        class2.setName("Class2");
        ePackage.getEClassifiers().addAll(Arrays.asList(class1, class2));
        EReference reference = EcoreFactory.eINSTANCE.createEReference();
        reference.setName("ref1");
        reference.setEType(class2);
        class1.getEStructuralFeatures().add(reference);
        // Create instances
        EObject object1 = EcoreUtil.create(class1);
        EObject object2 = EcoreUtil.create(class2);
        object1.eSet(reference, object2);
        // Create CMML
        CreateOppositeReference spec = CMMLFactory.eINSTANCE.createCreateOppositeReference();
        spec.setType(createType(class1));
        spec.setReferenceName(reference.getName());
        spec.setOppositeReferenceName("ref2");
        spec.setLowerBound(0);
        spec.setUpperBound(1);
        // Execute transformation
        TransformerFactory.INSTANCE.createTransformer(spec).transform(realm);
        // Validate results
        EReference oppositeReference = (EReference)class2.getEStructuralFeature("ref2");
        assertNotNull(oppositeReference);
        assertEquals(0, oppositeReference.getLowerBound());
        assertEquals(1, oppositeReference.getUpperBound());
        assertSame(reference, oppositeReference.getEOpposite());
        assertSame(oppositeReference, reference.getEOpposite());
        assertSame(class1, oppositeReference.getEType());
        assertSame(object1, object2.eGet(oppositeReference));
        assertSame(object2, object1.eGet(reference));
    }

    /**
     * Tests a scenario with a reference having multiplicity 0..inf, an opposite reference with
     * multiplicity 0..1 and without constraint violations.
     * 
     * @throws CoreException
     */
    @Test
    public void test__0_inf__0_1() throws CoreException {
        Realm realm = new Realm();
        // Create the Ecore model
        EPackage ePackage = realm.createEPackage();
        ePackage.setNsURI("urn:test");
        EClass class1 = EcoreFactory.eINSTANCE.createEClass();
        class1.setName("Class1");
        EClass class2 = EcoreFactory.eINSTANCE.createEClass();
        class2.setName("Class2");
        ePackage.getEClassifiers().addAll(Arrays.asList(class1, class2));
        EReference reference = EcoreFactory.eINSTANCE.createEReference();
        reference.setName("ref1");
        reference.setEType(class2);
        reference.setUpperBound(-1);
        class1.getEStructuralFeatures().add(reference);
        // Create instances
        EObject object1 = EcoreUtil.create(class1);
        EObject object2 = EcoreUtil.create(class2);
        EObject object3 = EcoreUtil.create(class2);
        ((EList<EObject>)object1.eGet(reference)).addAll(Arrays.asList(object2, object3));
        // Create CMML
        CreateOppositeReference spec = CMMLFactory.eINSTANCE.createCreateOppositeReference();
        spec.setType(createType(class1));
        spec.setReferenceName(reference.getName());
        spec.setOppositeReferenceName("ref2");
        spec.setLowerBound(0);
        spec.setUpperBound(1);
        // Execute transformation
        TransformerFactory.INSTANCE.createTransformer(spec).transform(realm);
        // Validate results
        EReference oppositeReference = (EReference)class2.getEStructuralFeature("ref2");
        assertNotNull(oppositeReference);
        assertEquals(0, oppositeReference.getLowerBound());
        assertEquals(1, oppositeReference.getUpperBound());
        assertSame(reference, oppositeReference.getEOpposite());
        assertSame(oppositeReference, reference.getEOpposite());
        assertSame(class1, oppositeReference.getEType());
        assertSame(object1, object2.eGet(oppositeReference));
        assertSame(object1, object3.eGet(oppositeReference));
        EList<EObject> list = (EList<EObject>)object1.eGet(reference);
        assertEquals(2, list.size());
        assertSame(object2, list.get(0));
        assertSame(object3, list.get(1));
    }
}
