package com.github.veithen.ramsay.util;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Base class for simple builders that take the files in an input folder and transform them to a new
 * set of files written to an output folder. Note that this type of builder is not really
 * incremental. It will do a full build each time a file in the input directory is modified.
 */
public abstract class SimpleBuilder extends IncrementalProjectBuilder {
    @Override
    protected final IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        IResourceDelta delta = getDelta(project);
        // Note: delta == null means unspecified changes
        if (kind == FULL_BUILD || delta == null || delta.findMember(getInputPath()) != null) {
            doBuild(monitor);
        }
        return null;
    }
    
    /**
     * Get the path to the input folder relative to the project.
     * 
     * @return the path to the input folder
     */
    protected abstract IPath getInputPath();
    
    protected abstract void doBuild(IProgressMonitor monitor) throws CoreException;
}
