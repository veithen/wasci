package com.ibm.ws.sm.workspace.metadata;

import java.util.Iterator;

public interface RepositoryMetaData {
    Iterator<RepositoryDocumentType> getDocumentTypeAccess();
    Iterator<RepositoryContextType> getContextTypeAccess();
}
