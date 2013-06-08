package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.ws.model.repository.ContextType;

public class Metadata {
    private final Realm realm;
    private final EPackage.Registry registry;
    private final Resource repositoryMetadata;
    private final ModelMapper modelMapper;
    
    public Metadata(Realm realm, Registry registry, Resource repositoryMetadata, ModelMapper modelMapper) {
        this.realm = realm;
        this.registry = registry;
        this.repositoryMetadata = repositoryMetadata;
        this.modelMapper = modelMapper;
    }
    
    public Realm getRealm() {
        return realm;
    }

    public EPackage.Registry getRegistry() {
        return registry;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public ContextType getCellContextType() {
        for (EObject object : repositoryMetadata.getContents()) {
            if (object instanceof ContextType) {
                ContextType contextType = (ContextType)object;
                if (contextType.getName().equals("cells")) {
                    return contextType;
                }
            }
        }
        return null;
    }
}
