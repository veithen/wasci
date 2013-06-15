package com.github.veithen.ramsay.ws.metadata.extractor;

/**
 * Defines the interface between the Eclipse plug-in and the custom code injected into the isolated
 * class loader.
 */
public interface MetadataExtractor {
    void extractConfigMetadata(ConfigMetadataCallback callback) throws Exception;
    void extractRepositoryMetadata(String dir, RepositoryMetadataCallback callback) throws Exception;
}
