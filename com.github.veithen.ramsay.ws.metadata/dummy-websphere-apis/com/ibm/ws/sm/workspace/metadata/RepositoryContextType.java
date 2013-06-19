package com.ibm.ws.sm.workspace.metadata;

import java.util.List;

public interface RepositoryContextType {
    String getName();
    RepositoryDocumentType getRootDocumentType();
    List<RepositoryDocumentType> getChildDocumentTypes();
    List<RepositoryContextType> getChildContextTypes();
}
