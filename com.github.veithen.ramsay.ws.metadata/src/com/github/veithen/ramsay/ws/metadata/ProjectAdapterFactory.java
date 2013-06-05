package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.resources.IProject;

import com.github.veithen.ramsay.util.AbstractProjectAdapterFactory;

public class ProjectAdapterFactory extends AbstractProjectAdapterFactory<MetadataProject> {
    @Override
    protected String getNatureId() {
        return ProjectNature.ID;
    }

    @Override
    protected Class<MetadataProject> getAdapterClass() {
        return MetadataProject.class;
    }

    @Override
    protected MetadataProject createAdapter(IProject project) {
        return new MetadataProject(project);
    }
}
