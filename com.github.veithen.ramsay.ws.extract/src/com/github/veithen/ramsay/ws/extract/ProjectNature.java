package com.github.veithen.ramsay.ws.extract;

import org.eclipse.core.runtime.CoreException;

import com.github.veithen.ramsay.util.AbstractProjectNature;

public class ProjectNature extends AbstractProjectNature {
    public static final String ID = Constants.PLUGIN_ID + ".nature";
    
    @Override
    public void configure() throws CoreException {
        installBuilder(Builder.ID);
    }

    @Override
    public void deconfigure() throws CoreException {
        removeBuilder(Builder.ID);
    }
}
