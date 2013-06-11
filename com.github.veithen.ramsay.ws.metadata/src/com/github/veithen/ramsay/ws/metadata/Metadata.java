package com.github.veithen.ramsay.ws.metadata;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.transform.Transformer;
import com.github.veithen.ramsay.emf.cm.transform.TransformerFactory;
import com.github.veithen.ramsay.util.FolderSubset;
import com.github.veithen.ramsay.ws.model.repository.ContextType;

public class Metadata {
    private final FolderSubset folderSubset;
    private final IFolder transformationsFolder;
    private final IFolder outputFolder;
    private final Realm realm;
    private final EPackage.Registry registry;
    private final Resource repositoryMetadata;
    private final ModelMapper modelMapper;
    
    public Metadata(FolderSubset folderSubset, IFolder transformationsFolder, IFolder outputFolder, Realm realm, Registry registry, Resource repositoryMetadata, ModelMapper modelMapper) {
        this.folderSubset = folderSubset;
        this.transformationsFolder = transformationsFolder;
        this.outputFolder = outputFolder;
        this.realm = realm;
        this.registry = registry;
        this.repositoryMetadata = repositoryMetadata;
        this.modelMapper = modelMapper;
    }
    
    public FolderSubset getFolderSubset() {
        return folderSubset;
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
    
    public Transformer getTransformer() throws CoreException {
        final List<Transformer> transformers = new ArrayList<Transformer>();
        transformers.add(new Transformer() {
            @Override
            public void transform(Realm realm) throws CoreException {
                folderSubset.mapTo(outputFolder);
            }
        });
        if (transformationsFolder.exists()) {
            transformationsFolder.accept(new IResourceVisitor() {
                @Override
                public boolean visit(IResource resource) throws CoreException {
                    if (resource.getType() == IResource.FILE && resource.getName().endsWith(".cmml")) {
                        transformers.add(TransformerFactory.INSTANCE.createTransformer((IFile)resource));
                    }
                    return true;
                }
            });
        }
        return TransformerFactory.INSTANCE.createTransformer(transformers);
    }
}
