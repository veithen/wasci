package com.github.veithen.ramsay.ws.metadata.repository.handler.impl;

import org.eclipse.emf.common.notify.Adapter;

import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandler;
import com.github.veithen.ramsay.ws.metadata.repository.util.RepositoryAdapterFactory;

public class DefaultDocumentTypeHandlerAdapterFactory extends RepositoryAdapterFactory {
    @Override
    public boolean isFactoryForType(Object type) {
        return type == DocumentTypeHandler.class;
    }
    
    @Override
    public Adapter createDefaultDocumentTypeAdapter() {
        return new DefaultDocumentTypeHandler();
    }
}
