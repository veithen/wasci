package com.github.veithen.ramsay.ws.metadata.extractor;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EPackage;

public interface MetadataExtractorCallback {
    /**
     * Get a destination URI for the given {@link EPackage}.
     * 
     * @param ePackageName
     *            the name of the package as returned by {@link EPackage#getName()}
     * @param ePackageNsURI
     *            the namespace URI of the package as returned by {@link EPackage#getNsURI()}
     * @param javaPackageName
     *            the name of the Java package from which the {@link EPackage} has been loaded
     * @return the URI of the output Ecore file; this value will later be passed to
     *         {@link #createOutputStream(String)} to create an output stream for the file
     */
    String getEcoreFileURI(String ePackageName, String ePackageNsURI, String javaPackageName);

    /**
     * Create an output stream for the given URI (returned by
     * {@link #getEcoreFileURI(String, String, String)}.
     * 
     * @param uri
     *            the URI
     * @return an output stream for the given URI
     * @throws IOException 
     */
    OutputStream createOutputStream(String uri) throws IOException;
}
