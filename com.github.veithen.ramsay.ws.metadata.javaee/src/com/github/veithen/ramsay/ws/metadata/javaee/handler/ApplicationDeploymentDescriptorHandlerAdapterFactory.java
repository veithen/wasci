package com.github.veithen.ramsay.ws.metadata.javaee.handler;

import org.eclipse.emf.common.notify.Adapter;

import com.github.veithen.ramsay.ws.metadata.javaee.util.JavaeeAdapterFactory;
import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandler;

public class ApplicationDeploymentDescriptorHandlerAdapterFactory extends JavaeeAdapterFactory {
    @Override
    public boolean isFactoryForType(Object type) {
        return type == DocumentTypeHandler.class;
    }
    
    @Override
    public Adapter createApplicationDeploymentDescriptorAdapter() {
        return ApplicationDeploymentDescriptorHandler.INSTANCE;
    }
}
