package com.github.veithen.ramsay.ws.metadata.app;

import org.eclipse.core.runtime.NullProgressMonitor;

public class SystemOutProgressMonitor extends NullProgressMonitor {
    @Override
    public void beginTask(String name, int totalWork) {
        if (name != null && name.length() > 0) {
            System.out.println(name);
        }
    }
}
