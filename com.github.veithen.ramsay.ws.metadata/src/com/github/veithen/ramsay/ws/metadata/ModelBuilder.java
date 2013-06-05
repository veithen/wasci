package com.github.veithen.ramsay.ws.metadata;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

public class ModelBuilder extends IncrementalProjectBuilder {
    public static final String ID = "com.github.veithen.ramsay.ws.metadata.builder";
    
    @Override
    protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        IResourceDelta delta = getDelta(project);
        // Note: delta == null means unspecified changes
        if (kind == FULL_BUILD || delta == null || delta.findMember(new Path("models")) != null) {
            System.out.println("Build required");
        }
        return null;
    }
}
