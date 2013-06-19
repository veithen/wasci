package com.github.veithen.ramsay.ws.model.repository;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.xmi.XMIResource;

public interface DocumentProcessor {
    void processDocument(XMIResource resource, InputStream in) throws IOException;
}
