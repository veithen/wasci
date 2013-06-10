package com.github.veithen.ramsay.emf.cm.transform;

import org.eclipse.core.runtime.CoreException;

import com.github.veithen.ramsay.emf.cm.Realm;

public interface Transformer {
    void transform(Realm realm) throws CoreException;
}
