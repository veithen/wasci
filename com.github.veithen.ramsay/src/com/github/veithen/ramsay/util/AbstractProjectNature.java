package com.github.veithen.ramsay.util;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public abstract class AbstractProjectNature implements IProjectNature {
    private IProject project;
    
    @Override
    public final IProject getProject() {
        return project;
    }

    @Override
    public final void setProject(IProject project) {
        this.project = project;
    }

    protected final void installBuilder(String name) throws CoreException {
        IProjectDescription desc = project.getDescription();
        ICommand[] commands = desc.getBuildSpec();
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(name)) {
                return;
            }
        }
        ICommand[] newCommands = new ICommand[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        ICommand command = desc.newCommand();
        command.setBuilderName(name);
        newCommands[newCommands.length-1] = command;
        desc.setBuildSpec(newCommands);
        project.setDescription(desc, null);
    }
    
    protected final void removeBuilder(String name) throws CoreException {
        IProjectDescription description = getProject().getDescription();
        ICommand[] commands = description.getBuildSpec();
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(name)) {
                ICommand[] newCommands = new ICommand[commands.length-1];
                System.arraycopy(commands, 0, newCommands, 0, i);
                System.arraycopy(commands, i+1, newCommands, i, commands.length-i-1);
                description.setBuildSpec(newCommands);
                project.setDescription(description, null);          
                return;
            }
        }
    }
}
