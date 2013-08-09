package com.github.veithen.ramsay.ws.metadata.app;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.github.veithen.ramsay.ws.metadata.Constants;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.metadata.ProjectHelper;

public class MetadataExtractorApplication implements IApplication {
    @Override
    public Object start(IApplicationContext context) throws Exception {
        // Parse and check arguments
        String installDir = null;
        String profileDir = null;
        String projectName = null;
        String[] args = (String[])context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
        for (int i=0; i<args.length; ) {
            String arg = args[i++];
            if (arg.equals("-installDir")) {
                installDir = args[i++];
            } else if (arg.equals("-profileDir")) {
                profileDir = args[i++];
            } else if (arg.equals("-projectName")) {
                projectName = args[i++];
            } else {
                System.err.println("Unrecognized option: " + arg);
                return EXIT_OK;
            }
        }
        if (installDir == null) {
            System.err.println("No WebSphere installation directory specified");
            return EXIT_OK;
        }
        if (profileDir == null) {
            System.err.println("No profile directory specified");
            return EXIT_OK;
        }
        if (projectName == null) {
            System.err.println("No project name specified");
            return EXIT_OK;
        }
        
        IProgressMonitor monitor = new SystemOutProgressMonitor();
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        
        // Turn off workspace auto-build
        IWorkspaceDescription desc = workspace.getDescription();
        desc.setAutoBuilding(false);
        workspace.setDescription(desc);
        
        // Create and configure project
        IProject project = workspace.getRoot().getProject(projectName);
        ProjectHelper.createProject(project, monitor);
        IEclipsePreferences prefs = new ProjectScope(project).getNode(Constants.PREFERENCES_NODE);
        prefs.put(Constants.PREF_INSTALL_DIR, installDir);
        prefs.put(Constants.PREF_PROFILE_DIR, profileDir);
        prefs.flush();
        
        // Extract metadata
        MetadataProject metadataProject = (MetadataProject)project.getAdapter(MetadataProject.class);
        metadataProject.extractRaw(monitor);
        
        // Build the workspace
        workspace.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
        
        return EXIT_OK;
    }

    @Override
    public void stop() {
    }
}
