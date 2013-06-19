package com.github.veithen.ramsay.ws.metadata;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.emf.cm.transform.TransformerFactory;
import com.github.veithen.ramsay.util.FolderSubset;
import com.github.veithen.ramsay.ws.model.repository.ChildContext;
import com.github.veithen.ramsay.ws.model.repository.ChildContextTypeLink;
import com.github.veithen.ramsay.ws.model.repository.ChildDocument;
import com.github.veithen.ramsay.ws.model.repository.ChildDocumentTypeLink;
import com.github.veithen.ramsay.ws.model.repository.Context;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryMetadata;

public class Metadata {
    private final FolderSubset folderSubset;
    private final IFolder transformationsFolder;
    private final IFolder outputFolder;
    private final Realm realm;
    private final EPackage.Registry registry;
    private final RepositoryMetadata repositoryMetadata;
    private Context rootContext;
    
    public Metadata(FolderSubset folderSubset, IFolder transformationsFolder, IFolder outputFolder, Realm realm, Registry registry, RepositoryMetadata repositoryMetadata) {
        this.folderSubset = folderSubset;
        this.transformationsFolder = transformationsFolder;
        this.outputFolder = outputFolder;
        this.realm = realm;
        this.registry = registry;
        this.repositoryMetadata = repositoryMetadata;
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

    public ContextType getCellContextType() {
        for (ContextType contextType : repositoryMetadata.getContextTypes()) {
            if (contextType.getName().equals("cells")) {
                return contextType;
            }
        }
        return null;
    }
    
    public void setRootContext(Context rootContext) {
        this.rootContext = rootContext;
    }

    public void transform() throws CoreException {
        folderSubset.mapTo(outputFolder);
        
        Resource generatedPackages = folderSubset.createResource(new Path("_generated_packages.ecore"));
        EPackage contextPackage = realm.createEPackage();
        contextPackage.setName("context");
        contextPackage.setNsURI("http://github.com/veithen/ramsay/ws/context");
        contextPackage.setNsPrefix("context");
        generatedPackages.getContents().add(contextPackage);
        
        Map<ContextType,EClass> contextTypeMap = new HashMap<ContextType,EClass>();
        for (ContextType contextType : repositoryMetadata.getContextTypes()) {
            DocumentType rootDocumentType = contextType.getRootDocumentType();
            EClass clazz = null;
            if (rootDocumentType != null) {
                clazz = rootDocumentType.getObjectType();
            }
            if (clazz == null) {
                clazz = EcoreFactory.eINSTANCE.createEClass();
                if (contextType.getName().length() == 0) {
                    clazz.setName("RootContext");
                } else {
                    clazz.setName(contextType.getName());
                    EAttribute nameAttr = EcoreFactory.eINSTANCE.createEAttribute();
                    nameAttr.setName("name");
                    nameAttr.setEType(EcorePackage.eINSTANCE.getEString());
                    nameAttr.setLowerBound(1);
                    clazz.getEStructuralFeatures().add(nameAttr);
                }
                contextPackage.getEClassifiers().add(clazz);
                contextType.setGeneratedClass(clazz);
            }
            contextTypeMap.put(contextType, clazz);
        }
        for (Map.Entry<ContextType,EClass> entry : contextTypeMap.entrySet()) {
            ContextType contextType = entry.getKey();
            EClass clazz = entry.getValue();
            for (ChildContextTypeLink childContextTypeLink : contextType.getChildContextTypeLinks()) {
                ContextType childContextType = childContextTypeLink.getContextType();
                if (childContextType.getName().equals("repository")) {
                    continue;
                }
                EClass type = contextTypeMap.get(childContextType);
                if (type == null) {
                    // TODO: only necessary because we skipped some context types earlier
                    continue;
                }
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                ref.setName(childContextType.getName());
                ref.setEType(type);
                ref.setUpperBound(-1);
                // Normally, the object representing the context is stored in a different resource. The only
                // exception is for generated classes (that are used for context types that don't have a
                // root document type).
                ref.setContainment(type.getEPackage() == contextPackage);
                clazz.getEStructuralFeatures().add(ref);
                childContextTypeLink.setReference(ref);
            }
            for (ChildDocumentTypeLink childDocumentTypeLink : contextType.getChildDocumentTypeLinks()) {
                DocumentType childDocumentType = childDocumentTypeLink.getDocumentType();
                EClass type = childDocumentType.getObjectType();
                if (type == null) {
                    continue;
                }
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                String referenceName = childDocumentType.getReferenceName();
                if (referenceName == null) {
                    referenceName = childDocumentType.getFilePattern();
                    int idx = referenceName.lastIndexOf('/');
                    if (idx != -1) {
                        referenceName = referenceName.substring(idx+1);
                    }
                    referenceName = referenceName.substring(0, referenceName.lastIndexOf('.'));
                }
                ref.setName(referenceName);
                ref.setEType(type);
                ref.setUpperBound(-1); // This is actually just a guess...
                clazz.getEStructuralFeatures().add(ref);
                childDocumentTypeLink.setReference(ref);
            }
        }
        
        if (rootContext != null) {
            processContext(rootContext);
        }
        
        if (transformationsFolder.exists()) {
            final Realm realm = this.realm;
            transformationsFolder.accept(new IResourceVisitor() {
                @Override
                public boolean visit(IResource resource) throws CoreException {
                    if (resource.getType() == IResource.FILE && resource.getName().endsWith(".cmml")) {
                        TransformerFactory.INSTANCE.createTransformer((IFile)resource).transform(realm);
                    }
                    return true;
                }
            });
        }
    }
    
    private EObject processContext(Context context) {
        EObject object;
        EClass generatedClass = context.getType().getGeneratedClass();
        if (generatedClass != null) {
            object = EcoreUtil.create(generatedClass);
            object.eSet(generatedClass.getEStructuralFeature("name"), context.getName());
        } else {
            object = context.getRootDocument().getContents().get(0);
        }
        for (ChildContext childContext : context.getChildContexts()) {
            ((EList<EObject>)object.eGet(childContext.getLink().getReference())).add(processContext(childContext.getContext()));
        }
        for (ChildDocument childDocument : context.getChildDocuments()) {
            if (childDocument.getDocument().getType().getFilePattern().equals("ws-security.xml")) {
                continue; // TODO: hack!
            }
            ((EList<EObject>)object.eGet(childDocument.getLink().getReference())).addAll(childDocument.getDocument().getContents());
        }
        return object;
    }
}
