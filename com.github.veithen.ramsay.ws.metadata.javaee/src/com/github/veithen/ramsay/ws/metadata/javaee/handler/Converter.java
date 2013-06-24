package com.github.veithen.ramsay.ws.metadata.javaee.handler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jst.j2ee.application.EjbModule;
import org.eclipse.jst.j2ee.application.WebModule;
import org.eclipse.jst.j2ee.application.internal.util.ApplicationSwitch;
import org.eclipse.jst.javaee.application.Application;
import org.eclipse.jst.javaee.application.ApplicationFactory;
import org.eclipse.jst.javaee.application.Module;
import org.eclipse.jst.javaee.application.Web;

@SuppressWarnings("restriction")
public final class Converter extends ApplicationSwitch {
    public static final Converter INSTANCE = new Converter();
    
    private Converter() {}

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
