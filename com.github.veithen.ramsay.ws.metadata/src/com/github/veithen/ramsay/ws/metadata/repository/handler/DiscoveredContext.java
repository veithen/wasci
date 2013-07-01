package com.github.veithen.ramsay.ws.metadata.repository.handler;

public class DiscoveredContext {
    private final String name;
    private final String relativeURI;
    
    public DiscoveredContext(String name, String relativeURI) {
        this.name = name;
        this.relativeURI = relativeURI;
    }

    public String getName() {
        return name;
    }

    public String getRelativeURI() {
        return relativeURI;
    }
}
