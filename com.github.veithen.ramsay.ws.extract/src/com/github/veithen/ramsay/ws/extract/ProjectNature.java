package com.github.veithen.ramsay.ws.extract;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ProjectNature implements IProjectNature {
    public static final String ID = Constants.PLUGIN_ID + ".nature";
    
    private IProject project;
    
    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(IProject project) {
        this.project = project;
    }

    @Override
    public void configure() throws CoreException {
        
    }

    @Override
    public void deconfigure() throws CoreException {
        
    }
}
