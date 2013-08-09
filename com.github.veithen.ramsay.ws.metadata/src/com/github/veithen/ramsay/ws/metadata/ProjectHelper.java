package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public final class ProjectHelper {
    private ProjectHelper() {}
    
    public static void createProject(IProject project, IProgressMonitor monitor) throws CoreException {
        IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
        desc.setLocationURI(project.getLocationURI());
        project.create(desc, monitor);
        project.open(monitor);
        // Now set the project nature. Note that if we do that before project creation, then
        // the builder will not be configured.
        desc = project.getDescription();
        desc.setNatureIds(new String[] { ProjectNature.ID });
        project.setDescription(desc, monitor);
    }
}
