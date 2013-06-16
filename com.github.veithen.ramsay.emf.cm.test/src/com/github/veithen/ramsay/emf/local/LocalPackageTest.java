package com.github.veithen.ramsay.emf.local;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

public class LocalPackageTest {
    @Test
    public void testMakeLocalBeforeAddingToResource() {
        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("Test");
        ePackage.setNsURI("urn:test");
        LocalPackageUtil.makePackageLocal(resourceSet, ePackage);
        assertEquals("urn:test", ePackage.getNsURI());
        Resource resource = resourceSet.createResource(URI.createURI("dummy.ecore"));
        resource.getContents().add(ePackage);
        assertEquals("dummy.ecore#/", ePackage.getNsURI());
        assertEquals("urn:test", LocalPackageUtil.getOriginalNsURI(ePackage));
    }

    @Test
    public void testMakeLocalAfterAddingToResource() {
        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("Test");
        ePackage.setNsURI("urn:test");
        assertEquals("urn:test", ePackage.getNsURI());
        Resource resource = resourceSet.createResource(URI.createURI("dummy.ecore"));
        resource.getContents().add(ePackage);
        LocalPackageUtil.makePackageLocal(resourceSet, ePackage);
        assertEquals("dummy.ecore#/", ePackage.getNsURI());
        assertEquals("urn:test", LocalPackageUtil.getOriginalNsURI(ePackage));
    }
    
    @Test
    public void testChangeResourceURI() {
        ResourceSet resourceSet = new ResourceSetImpl();
        EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("Test");
        ePackage.setNsURI("urn:test");
        assertEquals("urn:test", ePackage.getNsURI());
        Resource resource = resourceSet.createResource(URI.createURI("dummy.ecore"));
        resource.getContents().add(ePackage);
        LocalPackageUtil.makePackageLocal(resourceSet, ePackage);
        assertEquals("dummy.ecore#/", ePackage.getNsURI());
        resource.setURI(URI.createURI("dummy2.ecore"));
        assertEquals("dummy2.ecore#/", ePackage.getNsURI());
    }
}
