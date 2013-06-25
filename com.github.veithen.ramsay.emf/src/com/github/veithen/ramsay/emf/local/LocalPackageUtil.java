package com.github.veithen.ramsay.emf.local;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.github.veithen.ramsay.emf.util.EMFUtil;

public final class LocalPackageUtil {
    private LocalPackageUtil() {}
    
    /**
     * Configure local package support on the given resource set. If this method has already been
     * called previously on the resource set, it will do nothing and return the existing
     * {@link LocalPackageSupport}. Otherwise it will configure local package support and return the
     * newly created {@link LocalPackageSupport} object for the resource set.
     * 
     * @param resourceSet
     *            the resource set
     * @return the {@link LocalPackageSupport} object for the resource set
     */
    public static LocalPackageSupport configureLocalPackageSupport(ResourceSet resourceSet) {
        for (Adapter adapter : resourceSet.eAdapters()) {
            if (adapter instanceof ResourceSetAdapter) {
                return ((ResourceSetAdapter)adapter).getLocalPackageSupport();
            }
        }
        return new LocalPackageSupport(resourceSet);
    }
    
    /**
     * Mark the given package as local. This method will add the an {@link EAnnotation} with source
     * {@link LocalPackageSupport#ANNOTATION_URI} to the {@link EPackage} object. If the package is
     * contained in a resource set with local package support enabled, then the namespace URI of the
     * package will immediately change.
     * 
     * @param ePackage
     *            the package
     * @see #configureLocalPackageSupport(ResourceSet)
     */
    public static void makePackageLocal(EPackage ePackage) {
        EAnnotation ann = ePackage.getEAnnotation(LocalPackageSupport.ANNOTATION_URI);
        if (ann == null) {
            ann = EcoreFactory.eINSTANCE.createEAnnotation();
            ann.setSource(LocalPackageSupport.ANNOTATION_URI);
            ePackage.getEAnnotations().add(ann);
            EPackageAdapter adapter = EMFUtil.getAdapter(EPackageAdapter.class, ePackage);
            // TODO: actually EPackageAdapter should react itself to the addition of the annotation!
            if (adapter != null) {
                adapter.makeLocal();
            }
        }
    }

    /**
     * Get the original namespace URI of the given package.
     * 
     * @param ePackage
     *            the package
     * @return the original namespace URI
     */
    public static String getOriginalNsURI(EPackage ePackage) {
        EAnnotation ann = ePackage.getEAnnotation(LocalPackageSupport.ANNOTATION_URI);
        if (ann != null) {
            EMap<String,String> details = ann.getDetails();
            if (details.containsKey(LocalPackageSupport.ORIGINAL_NS_URI)) {
                return details.get(LocalPackageSupport.ORIGINAL_NS_URI);
            }
        }
        // If we didn't find the original namespace URI, return the current one
        return ePackage.getNsURI();
    }
}
