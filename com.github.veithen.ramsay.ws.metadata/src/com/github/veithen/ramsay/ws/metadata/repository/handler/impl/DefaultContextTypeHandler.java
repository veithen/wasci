package com.github.veithen.ramsay.ws.metadata.repository.handler.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.github.veithen.ramsay.emf.notify.SimpleAdapter;
import com.github.veithen.ramsay.ws.metadata.repository.DefaultContextType;
import com.github.veithen.ramsay.ws.metadata.repository.handler.ContextTypeHandler;
import com.github.veithen.ramsay.ws.metadata.repository.handler.DiscoveredContext;

public class DefaultContextTypeHandler extends SimpleAdapter<DefaultContextType> implements ContextTypeHandler {
    public DefaultContextTypeHandler(DefaultContextType target) {
        super(target);
    }

    @Override
    public Collection<DiscoveredContext> scan(Set<String> relativeURIs) {
        List<DiscoveredContext> result = new ArrayList<DiscoveredContext>();
        String prefix = target.getName() + "/";
        for (String relativeURI : relativeURIs) {
            if (relativeURI.startsWith(prefix) && relativeURI.indexOf('/', prefix.length()) == -1) {
                result.add(new DiscoveredContext(relativeURI.substring(prefix.length()), relativeURI));
            }
        }
        return result;
    }
}
