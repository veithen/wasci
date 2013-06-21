package com.github.veithen.ramsay.ws.model.repository.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.ecore.xmi.XMIResource;

import com.github.veithen.ramsay.ws.model.repository.DefaultDocumentType;
import com.github.veithen.ramsay.ws.model.repository.DocumentProcessor;
import com.github.veithen.ramsay.ws.model.repository.util.RepositoryMetadataUtil;

public class DefaultDocumentProcessor implements DocumentProcessor {
    private final DefaultDocumentType documentType;
    
    public DefaultDocumentProcessor(DefaultDocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public String getReferenceName() {
        String filePattern = documentType.getFilePattern();
        return RepositoryMetadataUtil.toIdentifier(filePattern.substring(filePattern.lastIndexOf('/') + 1, filePattern.lastIndexOf('.')), false);
    }
    
    @Override
    public String scan(Set<String> relativeURIs) {
        String filePattern = documentType.getFilePattern();
        return relativeURIs.contains(filePattern) ? filePattern : null;
    }

    @Override
    public void processDocument(XMIResource resource, InputStream in) throws IOException {
        resource.load(in, null);
    }
}
