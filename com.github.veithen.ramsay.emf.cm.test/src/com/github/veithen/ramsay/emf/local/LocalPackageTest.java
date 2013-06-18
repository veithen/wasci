package com.github.veithen.ramsay.emf.local;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

public class LocalPackageTest {
    @Test
    public void testConfigureLocalPackageSupport() {
        ResourceSet resourceSet = new ResourceSetImpl();
        LocalPackageSupport localPackageSupport = LocalPackageUtil.configureLocalPackageSupport(resourceSet);
        assertNotNull(localPackageSupport);
        assertSame(localPackageSupport, LocalPackageUtil.configureLocalPackageSupport(resourceSet));
    }
    
    @Test
    public void testMakePackageLocal() {
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        LocalPackageUtil.makePackageLocal(ePackage);
        EAnnotation ann = ePackage.getEAnnotation(LocalPackageSupport.ANNOTATION_URI);
        assertNotNull(ann);
    }
    
    @Test
    public void testMakeLocalBeforeAddingToResource() {
        ResourceSet resourceSet = new ResourceSetImpl();
        LocalPackageUtil.configureLocalPackageSupport(resourceSet);
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("Test");
        ePackage.setNsURI("urn:test");
        LocalPackageUtil.makePackageLocal(ePackage);
        assertEquals("urn:test", ePackage.getNsURI());
        Resource resource = resourceSet.createResource(URI.createURI("dummy.ecore"));
        resource.getContents().add(ePackage);
        assertEquals("dummy.ecore#/", ePackage.getNsURI());
        assertEquals("urn:test", LocalPackageUtil.getOriginalNsURI(ePackage));
    }

    @Test
    public void testMakeLocalAfterAddingToResource() {
        ResourceSet resourceSet = new ResourceSetImpl();
        LocalPackageUtil.configureLocalPackageSupport(resourceSet);
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("Test");
        ePackage.setNsURI("urn:test");
        assertEquals("urn:test", ePackage.getNsURI());
        Resource resource = resourceSet.createResource(URI.createURI("dummy.ecore"));
        resource.getContents().add(ePackage);
        LocalPackageUtil.makePackageLocal(ePackage);
        assertEquals("dummy.ecore#/", ePackage.getNsURI());
        assertEquals("urn:test", LocalPackageUtil.getOriginalNsURI(ePackage));
    }
    
    @Test
    public void testChangeResourceURI() {
        ResourceSet resourceSet = new ResourceSetImpl();
        LocalPackageUtil.configureLocalPackageSupport(resourceSet);
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("Test");
        ePackage.setNsURI("urn:test");
        assertEquals("urn:test", ePackage.getNsURI());
        Resource resource = resourceSet.createResource(URI.createURI("dummy.ecore"));
        resource.getContents().add(ePackage);
        LocalPackageUtil.makePackageLocal(ePackage);
        assertEquals("dummy.ecore#/", ePackage.getNsURI());
        resource.setURI(URI.createURI("dummy2.ecore"));
        assertEquals("dummy2.ecore#/", ePackage.getNsURI());
    }
}
