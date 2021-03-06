package com.github.veithen.ramsay.ws.metadata.javaee.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jst.j2ee.application.internal.impl.ApplicationResourceFactory;
import org.eclipse.jst.javaee.application.Application;
import org.eclipse.jst.javaee.application.ApplicationDeploymentDescriptor;
import org.eclipse.jst.javaee.application.ApplicationFactory;
import org.eclipse.jst.javaee.application.Module;
import org.eclipse.jst.javaee.application.Web;
import org.eclipse.jst.javaee.application.internal.metadata.ApplicationPackage;
import org.eclipse.jst.javaee.application.internal.util.ApplicationResourceFactoryImpl;
import org.eclipse.jst.jee.util.internal.JavaEEQuickPeek;
import org.eclipse.wst.common.internal.emf.resource.EMF2SAXRendererFactory;

import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandlerAdapter;

@SuppressWarnings("restriction")
public class ApplicationDeploymentDescriptorHandler extends DocumentTypeHandlerAdapter {
    public static final ApplicationDeploymentDescriptorHandler INSTANCE = new ApplicationDeploymentDescriptorHandler();
    
    private static final String[] names = { "META-INF/application_merged.xml", "META-INF/application.xml" };
    
    private ApplicationDeploymentDescriptorHandler() {}

    @Override
    public EClass getObjectType() {
        return ApplicationPackage.eINSTANCE.getApplicationDeploymentDescriptor();
    }

    @Override
    public String getReferenceName() {
        return "deploymentDescriptor";
    }
    
    @Override
    public String scan(Set<String> relativeURIs) {
        for (String name : names) {
            if (relativeURIs.contains(name)) {
                return name;
            }
        }
        return null;
    }

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
        ApplicationDeploymentDescriptor dd;
        if (quickPeek.getJavaEEVersion() < JavaEEQuickPeek.VERSION_5_0) {
            Resource appResource = new ApplicationResourceFactory(EMF2SAXRendererFactory.INSTANCE).createResource(resource.getURI());
            appResource.load(in, null);
            dd = ApplicationFactory.eINSTANCE.createApplicationDeploymentDescriptor();
            dd.setApplication((Application)Converter.INSTANCE.doSwitch(appResource.getContents().get(0)));
        } else {
            Resource appResource = new ApplicationResourceFactoryImpl().createResource(resource.getURI());
            appResource.load(in, null);
            dd = (ApplicationDeploymentDescriptor)appResource.getContents().get(0);
        }
        
        // Normalize context roots
        // TODO: should probably be handled elsewhere
        for (Module module : dd.getApplication().getModules()) {
            Web web = module.getWeb();
            if (web != null) {
                String contextRoot = web.getContextRoot();
                if (contextRoot.endsWith("/")) {
                    contextRoot = contextRoot.substring(0, contextRoot.length()-1);
                }
                if (!contextRoot.startsWith("/")) {
                    contextRoot = "/" + contextRoot;
                }
                web.setContextRoot(contextRoot);
            }
        }
        
        resource.getContents().add((EObject)dd);
    }
}
