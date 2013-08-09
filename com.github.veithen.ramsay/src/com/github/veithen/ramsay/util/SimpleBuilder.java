package com.github.veithen.ramsay.util;

import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Base class for simple builders that take the files in one or more input folders and transform
 * them to a new set of files written to an output folder. Note that this type of builder is not
 * really incremental. It will do a full build each time a file in the input directory is modified.
 */
public abstract class SimpleBuilder extends IncrementalProjectBuilder {
    public static class BuildInput {
        private final IPath path;
        private final boolean required;
        
        /**
         * Constructor.
         * 
         * @param path
         *            the paths to the input folder relative to the project
         * @param required
         *            <code>true</code> if the input folder is required; <code>false</code> if the
         *            input folder is optional
         */
        public BuildInput(IPath path, boolean required) {
            this.path = path;
            this.required = required;
        }

        public IPath getPath() {
            return path;
        }

        public boolean isRequired() {
            return required;
        }
    }
    
    @Override
    protected final IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
        IProject project = getProject();
        IResourceDelta delta = getDelta(project);
        BuildInput[] inputs = getInputs();
        // Note: delta == null means unspecified changes
        boolean buildRequired = kind == FULL_BUILD || delta == null;
        if (!buildRequired) {
            for (BuildInput input : inputs) {
                if (delta.findMember(input.getPath()) != null) {
                    buildRequired = true;
                    break;
                }
            }
        }
        if (buildRequired) {
            // TODO: create/clean output folder
            boolean canBuild = true;
            IFolder[] inputFolders = new IFolder[inputs.length];
            for (int i=0; i<inputs.length; i++) {
                BuildInput input = inputs[i];
                IFolder folder = project.getFolder(input.getPath());
                if (input.isRequired() && !folder.exists()) {
                    canBuild = false;
                    break;
                }
                inputFolders[i] = folder;
            }
            if (canBuild) {
                doBuild(inputFolders, project.getFolder(getOutputPath()), monitor);
            }
        }
        return null;
    }
    
    /**
     * Get the build inputs.
     * 
     * @return the build inputs
     */
    protected abstract BuildInput[] getInputs();
    
    /**
     * Get the path to the output folder relative to the project.
     * 
     * @return the path to the output folder
     */
    protected abstract IPath getOutputPath();
    
    protected abstract void doBuild(IFolder[] inputFolders, IFolder outputFolder, IProgressMonitor monitor) throws CoreException;
}
