package com.github.veithen.ramsay.ws.metadata.javaee.processor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jst.j2ee.application.EjbModule;
import org.eclipse.jst.j2ee.application.WebModule;
import org.eclipse.jst.j2ee.application.internal.impl.ApplicationResourceFactory;
import org.eclipse.jst.j2ee.application.internal.util.ApplicationSwitch;
import org.eclipse.jst.javaee.application.Application;
import org.eclipse.jst.javaee.application.ApplicationDeploymentDescriptor;
import org.eclipse.jst.javaee.application.ApplicationFactory;
import org.eclipse.jst.javaee.application.Module;
import org.eclipse.jst.javaee.application.Web;
import org.eclipse.jst.javaee.application.internal.util.ApplicationResourceFactoryImpl;
import org.eclipse.jst.jee.util.internal.JavaEEQuickPeek;
import org.eclipse.wst.common.internal.emf.resource.EMF2SAXRendererFactory;

import com.github.veithen.ramsay.ws.model.repository.DocumentProcessor;

@SuppressWarnings("restriction")
public class ApplicationDeploymentDescriptorProcessor extends ApplicationSwitch implements DocumentProcessor {
    public static final DocumentProcessor INSTANCE = new ApplicationDeploymentDescriptorProcessor();
    
    private ApplicationDeploymentDescriptorProcessor() {}
    
    @Override
    public void processDocument(XMIResource resource, InputStream in) throws IOException {
        // Replace the InputStream with a ByteArrayInputStream to enable JavaEEQuickPeek
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int c;
        while ((c = in.read(buffer)) != -1) {
            baos.write(buffer, 0, c);
        }
        in = new ByteArrayInputStream(baos.toByteArray());
        
        JavaEEQuickPeek quickPeek = new JavaEEQuickPeek(in);
        if (quickPeek.getJavaEEVersion() < JavaEEQuickPeek.VERSION_5_0) {
            Resource appResource = new ApplicationResourceFactory(EMF2SAXRendererFactory.INSTANCE).createResource(resource.getURI());
            appResource.load(in, null);
            ApplicationDeploymentDescriptor dd = ApplicationFactory.eINSTANCE.createApplicationDeploymentDescriptor();
            dd.setApplication((Application)doSwitch(appResource.getContents().get(0)));
            resource.getContents().add((EObject)dd);
        } else {
            Resource appResource = new ApplicationResourceFactoryImpl().createResource(resource.getURI());
            appResource.load(in, null);
            resource.getContents().addAll(appResource.getContents());
        }
    }
    
    @Override
    public Object caseApplication(org.eclipse.jst.j2ee.application.Application in) {
        Application out = ApplicationFactory.eINSTANCE.createApplication();
        out.setApplicationName(in.getDisplayName());
        for (Object module : in.getModules()) {
            out.getModules().add((Module)doSwitch((EObject)module));
        }
        return out;
    }

    @Override
    public Object caseEjbModule(EjbModule in) {
        Module out = ApplicationFactory.eINSTANCE.createModule();
        out.setEjb(in.getUri());
        return out;
    }

    @Override
    public Object caseWebModule(WebModule in) {
        Module out = ApplicationFactory.eINSTANCE.createModule();
        Web web = ApplicationFactory.eINSTANCE.createWeb();
        web.setWebUri(in.getUri());
        web.setContextRoot(in.getContextRoot());
        out.setWeb(web);
        return out;
    }
}