package com.github.veithen.ramsay.ws.metadata.repository.handler.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

import com.github.veithen.ramsay.emf.notify.AdapterFactoryDelegate;
import com.github.veithen.ramsay.ws.metadata.repository.DefaultDocumentType;
import com.github.veithen.ramsay.ws.metadata.repository.util.RepositoryMetadataSwitch;

public class DocumentTypeHandlerAdapterFactoryDelegate extends RepositoryMetadataSwitch<Adapter> implements AdapterFactoryDelegate {
    @Override
    public Adapter createAdapter(Notifier target) {
        return doSwitch((EObject)target);
    }

    @Override
    public Adapter caseDefaultDocumentType(DefaultDocumentType object) {
        return new DefaultDocumentTypeHandler();
    }
}
