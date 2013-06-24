package com.github.veithen.ramsay.ws.metadata.repository.handler;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

public abstract class DocumentTypeHandlerAdapter extends AdapterImpl implements DocumentTypeHandler {
    @Override
    public boolean isAdapterForType(Object type) {
        return type == DocumentTypeHandler.class;
    }
}
