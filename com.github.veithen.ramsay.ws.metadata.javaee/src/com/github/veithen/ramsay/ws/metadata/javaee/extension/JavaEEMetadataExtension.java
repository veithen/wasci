package com.github.veithen.ramsay.ws.metadata.javaee.extension;

import com.github.veithen.ramsay.ws.metadata.extension.MetadataExtension;
import com.github.veithen.ramsay.ws.metadata.javaee.ApplicationDeploymentDescriptor;
import com.github.veithen.ramsay.ws.metadata.javaee.JavaeeFactory;
import com.github.veithen.ramsay.ws.metadata.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.metadata.repository.ContextType;
import com.github.veithen.ramsay.ws.metadata.repository.RepositoryMetadata;
import com.github.veithen.ramsay.ws.metadata.repository.RepositoryMetadataFactory;

public class JavaEEMetadataExtension implements MetadataExtension {
    @Override
    public void enhanceMetadata(RepositoryMetadata repositoryMetadata) {
        ContextType contextType = repositoryMetadata.getContextType("deployments");
        if (contextType != null) {
            ApplicationDeploymentDescriptor dd = JavaeeFactory.eINSTANCE.createApplicationDeploymentDescriptor();
            repositoryMetadata.getDocumentTypes().add(dd);
            ChildDocumentTypeLink link = RepositoryMetadataFactory.eINSTANCE.createChildDocumentTypeLink();
            link.setDocumentType(dd);
            contextType.getChildDocumentTypeLinks().add(link);
        }
    }
}
