package com.github.veithen.ramsay.emf.cm.transform.impl;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class TransformationStatus extends Status {
    public TransformationStatus(int severity, String message, EObject object) {
        this(severity, message, object, null, null);
    }
    
    public TransformationStatus(int severity, String message, EObject cmmlObject, EObject modelObject) {
        this(severity, message, cmmlObject, modelObject, null);
    }
    
    public TransformationStatus(int severity, String message, EObject cmmlObject, EObject modelObject, Throwable exception) {
        super(severity, "com.github.veithen.ramsay.emf.cm.transform", formatMessage(message, cmmlObject, modelObject), exception);
    }
    
    private static String formatMessage(String message, EObject cmmlObject, EObject modelObject) {
        if (cmmlObject == null) {
            return message;
        } else {
            StringBuilder buffer = new StringBuilder(message);
            buffer.append(" (at ");
            buffer.append(EcoreUtil.getURI(cmmlObject));
            if (modelObject != null) {
                buffer.append("; object ");
                buffer.append(EcoreUtil.getURI(modelObject));
            }
            buffer.append(")");
            return buffer.toString();
        }
    }
}
