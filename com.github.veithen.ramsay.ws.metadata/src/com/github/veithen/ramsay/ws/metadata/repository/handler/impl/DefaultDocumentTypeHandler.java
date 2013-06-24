package com.github.veithen.ramsay.ws.metadata.repository.handler.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandler;
import com.github.veithen.ramsay.ws.metadata.repository.util.RepositoryMetadataUtil;
import com.github.veithen.ramsay.ws.model.repository.DefaultDocumentType;

public class DefaultDocumentTypeHandler extends AdapterImpl implements DocumentTypeHandler {
    @Override
    public String getReferenceName() {
        String filePattern = ((DefaultDocumentType)target).getFilePattern();
        return RepositoryMetadataUtil.toIdentifier(filePattern.substring(filePattern.lastIndexOf('/') + 1, filePattern.lastIndexOf('.')), false);
    }
    
    @Override
    public String scan(Set<String> relativeURIs) {
        String filePattern = ((DefaultDocumentType)target).getFilePattern();
        return relativeURIs.contains(filePattern) ? filePattern : null;
    }

    @Override
    public void processDocument(XMIResource resource, InputStream in) throws IOException {
        resource.load(in, null);
    }
}
