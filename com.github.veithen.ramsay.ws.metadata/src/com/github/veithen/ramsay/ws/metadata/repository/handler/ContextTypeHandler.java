package com.github.veithen.ramsay.ws.metadata.repository.handler;

import java.util.Collection;
import java.util.Set;

public interface ContextTypeHandler {
    Collection<DiscoveredContext> scan(Set<String> relativeURIs);
}
