package com.github.veithen.ramsay.ws.model.repository.impl;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.xmi.XMIResource;

import com.github.veithen.ramsay.ws.model.repository.DocumentProcessor;

public class DefaultDocumentProcessor implements DocumentProcessor {
    public static final DocumentProcessor INSTANCE = new DefaultDocumentProcessor();
    
    private DefaultDocumentProcessor() {}
    
    @Override
    public void processDocument(XMIResource resource, InputStream in) throws IOException {
        resource.load(in, null);
    }
}
