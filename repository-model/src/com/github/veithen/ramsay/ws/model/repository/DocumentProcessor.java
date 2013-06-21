package com.github.veithen.ramsay.ws.model.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.ecore.xmi.XMIResource;

public interface DocumentProcessor {
    String getReferenceName();
    String scan(Set<String> relativeURIs);
    void processDocument(XMIResource resource, InputStream in) throws IOException;
}
