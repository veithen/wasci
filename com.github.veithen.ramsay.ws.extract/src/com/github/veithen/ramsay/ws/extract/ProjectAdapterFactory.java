package com.github.veithen.ramsay.ws.extract;

import org.eclipse.core.resources.IProject;

import com.github.veithen.ramsay.util.AbstractProjectAdapterFactory;

public class ProjectAdapterFactory extends AbstractProjectAdapterFactory<DataProject> {
    @Override
    protected String getNatureId() {
        return ProjectNature.ID;
    }

    @Override
    protected Class<DataProject> getAdapterClass() {
        return DataProject.class;
    }

    @Override
    protected DataProject createAdapter(IProject project) {
        return new DataProject(project);
    }
}
