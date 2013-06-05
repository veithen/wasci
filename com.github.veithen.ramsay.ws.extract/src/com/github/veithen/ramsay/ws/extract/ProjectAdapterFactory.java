package com.github.veithen.ramsay.ws.extract;

import org.eclipse.core.resources.IProject;

import com.github.veithen.ramsay.util.AbstractProjectAdapterFactory;

public class ProjectAdapterFactory extends AbstractProjectAdapterFactory<ExtractionProject> {
    @Override
    protected String getNatureId() {
        return ProjectNature.ID;
    }

    @Override
    protected Class<ExtractionProject> getAdapterClass() {
        return ExtractionProject.class;
    }

    @Override
    protected ExtractionProject createAdapter(IProject project) {
        return new ExtractionProject(project);
    }
}
