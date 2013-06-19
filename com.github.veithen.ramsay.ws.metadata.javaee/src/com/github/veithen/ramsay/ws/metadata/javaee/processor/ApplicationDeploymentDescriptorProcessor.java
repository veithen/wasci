package com.github.veithen.ramsay.ws.metadata.javaee.processor;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jst.javaee.application.ApplicationFactory;

import com.github.veithen.ramsay.ws.model.repository.DocumentProcessor;

public class ApplicationDeploymentDescriptorProcessor implements DocumentProcessor {
    public static final DocumentProcessor INSTANCE = new ApplicationDeploymentDescriptorProcessor();
    
    private ApplicationDeploymentDescriptorProcessor() {}
    
    @Override
    public void processDocument(XMIResource resource, InputStream in) throws IOException {
        // TODO: parse/convert deployment descriptor
        resource.getContents().add((EObject)ApplicationFactory.eINSTANCE.createApplication());
    }
}
