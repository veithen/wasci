package com.github.veithen.ramsay.ws.metadata.extension;

import com.github.veithen.ramsay.ws.metadata.repository.RepositoryMetadata;

public interface MetadataExtension {
    void enhanceMetadata(RepositoryMetadata repositoryMetadata);
}
