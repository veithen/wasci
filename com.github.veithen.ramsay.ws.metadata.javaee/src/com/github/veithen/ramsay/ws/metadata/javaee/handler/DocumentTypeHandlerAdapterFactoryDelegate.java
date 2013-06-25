package com.github.veithen.ramsay.ws.metadata.javaee.handler;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;

import com.github.veithen.ramsay.emf.notify.AdapterFactoryDelegate;
import com.github.veithen.ramsay.ws.metadata.javaee.ApplicationDeploymentDescriptor;
import com.github.veithen.ramsay.ws.metadata.javaee.util.JavaeeSwitch;

public class DocumentTypeHandlerAdapterFactoryDelegate extends JavaeeSwitch<Adapter> implements AdapterFactoryDelegate {
    @Override
    public Adapter createAdapter(Notifier target) {
        return doSwitch((EObject)target);
    }

    @Override
    public Adapter caseApplicationDeploymentDescriptor(ApplicationDeploymentDescriptor object) {
        return ApplicationDeploymentDescriptorHandler.INSTANCE;
    }
}
