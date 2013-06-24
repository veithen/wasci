package com.github.veithen.ramsay.ws.metadata.repository.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.ecore.xmi.XMIResource;

public interface DocumentTypeHandler {
    String getReferenceName();
    String scan(Set<String> relativeURIs);
    void processDocument(XMIResource resource, InputStream in) throws IOException;
}
