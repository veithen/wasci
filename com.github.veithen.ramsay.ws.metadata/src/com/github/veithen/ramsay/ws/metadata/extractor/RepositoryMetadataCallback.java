package com.github.veithen.ramsay.ws.metadata.extractor;

public interface RepositoryMetadataCallback {
    void createDocumentType(String name, String filePattern);
    void addRootRefObjectType(String documentTypeName, String nsURI, String name);
    void createContextType(String name, String rootDocumentTypeName);
    void linkDocumentTypeToContextType(String parent, String child);
    void linkContextTypes(String parent, String child);
}
