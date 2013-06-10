package com.github.veithen.ramsay.emf.cm.transform.impl;

import org.eclipse.emf.ecore.EObject;

public interface KeyFactory {
    boolean isNotNull();
    Object getKey(EObject object);
}
