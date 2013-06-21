package com.github.veithen.ramsay.ws.metadata.javaee.extension;

import com.github.veithen.ramsay.ws.metadata.extension.MetadataExtension;
import com.github.veithen.ramsay.ws.metadata.javaee.ApplicationDeploymentDescriptor;
import com.github.veithen.ramsay.ws.metadata.javaee.JavaeeFactory;
import com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryFactory;
import com.github.veithen.ramsay.ws.model.repository.RepositoryMetadata;

public class JavaEEMetadataExtension implements MetadataExtension {
    @Override
    public void enhanceMetadata(RepositoryMetadata repositoryMetadata) {
        ContextType contextType = repositoryMetadata.getContextType("deployments");
        if (contextType != null) {
            ApplicationDeploymentDescriptor dd = JavaeeFactory.eINSTANCE.createApplicationDeploymentDescriptor();
            repositoryMetadata.getDocumentTypes().add(dd);
            ChildDocumentTypeLink link = RepositoryFactory.eINSTANCE.createChildDocumentTypeLink();
            link.setDocumentType(dd);
            contextType.getChildDocumentTypeLinks().add(link);
        }
    }
}
