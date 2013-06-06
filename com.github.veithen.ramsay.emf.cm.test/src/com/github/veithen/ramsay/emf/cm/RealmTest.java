package com.github.veithen.ramsay.emf.cm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import com.github.veithen.ramsay.emf.cm.impl.CovariantClassAdapter;
import com.github.veithen.ramsay.emf.cm.impl.EMFUtil;

public class RealmTest {
    private static void execute(Scenario scenario) {
        try {
            scenario.execute(DefaultEPackageFactory.INSTANCE);
        } catch (AssertionError ex) {
            fail("Invalid test case; scenario failed with standard EPackage instances");
        }
        scenario.execute(new CovariantEPackageFactory());
    }
    
    @Test
    public void testAddToRealmAfterEClassCreation() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        ePackage.getEClassifiers().add(eClass);
        Realm realm = new Realm();
        realm.addPackage(ePackage);
        assertNotNull(EMFUtil.getAdapter(CovariantClassAdapter.class, eClass));
    }

    @Test
    public void testAddToRealmBeforeEClassCreation() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        Realm realm = new Realm();
        realm.addPackage(ePackage);
        EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        ePackage.getEClassifiers().add(eClass);
        assertNotNull(EMFUtil.getAdapter(CovariantClassAdapter.class, eClass));
    }
    
    @Test
    public void testAddAttribute() {
        Realm realm = new Realm();
        EPackage ePackage = realm.createEPackage();
        EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("TestClass");
        ePackage.getEClassifiers().add(eClass);
        EObject object = EcoreUtil.create(eClass);
        EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName("test");
        feature.setEType(EcorePackage.eINSTANCE.getEString());
        eClass.getEStructuralFeatures().add(feature);
        assertNull(object.eGet(feature));
        object.eSet(feature, "value");
        assertEquals("value", object.eGet(feature));
    }
    
    @Test
    public void testAddReferenceMany() {
        Realm realm = new Realm();
        EPackage ePackage = realm.createEPackage();
        EClass class1 = EcoreFactory.eINSTANCE.createEClass();
        class1.setName("Class1");
        ePackage.getEClassifiers().add(class1);
        EClass class2 = EcoreFactory.eINSTANCE.createEClass();
        class2.setName("Class2");
        ePackage.getEClassifiers().add(class2);
        EObject object = EcoreUtil.create(class1);
        EReference feature = EcoreFactory.eINSTANCE.createEReference();
        feature.setName("ref");
        feature.setEType(class2);
        feature.setUpperBound(-1);
        class1.getEStructuralFeatures().add(feature);
        EList<EObject> val = (EList<EObject>)object.eGet(feature);
        assertNotNull(val);
        val.add(EcoreUtil.create(class2));
        val.add(EcoreUtil.create(class2));
    }
    
    @Test
    public void testPreexistingSupertypeFeature() {
        execute(new Scenario() {
            @Override
            public void execute(EPackageFactory factory) {
                EClass superclass = EcoreFactory.eINSTANCE.createEClass();
                EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
                attr.setEType(EcorePackage.eINSTANCE.getEString());
                superclass.getEStructuralFeatures().add(attr);
                EClass subclass = EcoreFactory.eINSTANCE.createEClass();
                subclass.getESuperTypes().add(superclass);
                EPackage ePackage = factory.createEPackage();
                ePackage.getEClassifiers().add(subclass);
                ePackage.getEClassifiers().add(superclass);
                EObject object = EcoreUtil.create(subclass);
                object.eSet(attr, "test");
            }
        });
    }
    
    @Test
    public void testAddingSupertypeFeature() {
        execute(new Scenario() {
            @Override
            public void execute(EPackageFactory factory) {
                EPackage ePackage = factory.createEPackage();
                EClass superclass = EcoreFactory.eINSTANCE.createEClass();
                superclass.setName("SuperClass");
                ePackage.getEClassifiers().add(superclass);
                EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
                attr.setName("attr");
                attr.setEType(EcorePackage.eINSTANCE.getEInt());
                superclass.getEStructuralFeatures().add(attr);
                EClass subclass = EcoreFactory.eINSTANCE.createEClass();
                subclass.setName("Subclass");
                ePackage.getEClassifiers().add(subclass);
                subclass.getESuperTypes().add(superclass);
                EObject object = EcoreUtil.create(subclass);
                object.eSet(attr, new Integer(1));
            }
        });
    }
    
    @Test
    public void testContainment() {
        execute(new Scenario() {
            @Override
            public void execute(EPackageFactory factory) {
                EPackage ePackage = factory.createEPackage();
                EClass class1 = EcoreFactory.eINSTANCE.createEClass();
                EClass class2 = EcoreFactory.eINSTANCE.createEClass();
                ePackage.getEClassifiers().addAll(Arrays.asList(class1, class2));
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                ref.setEType(class2);
                ref.setContainment(true);
                class1.getEStructuralFeatures().add(ref);
                EObject object1 = EcoreUtil.create(class1);
                EObject object2 = EcoreUtil.create(class2);
                object1.eSet(ref, object2);
                assertSame(object1, object2.eContainer());
                EList<EObject> contents = object1.eContents();
                assertEquals(1, contents.size());
                assertSame(object2, contents.get(0));
            }
        });
    }
}
