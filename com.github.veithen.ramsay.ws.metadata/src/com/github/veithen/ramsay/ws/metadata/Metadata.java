package com.github.veithen.ramsay.ws.metadata;

import java.util.HashMap;
import java.util.List;
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
        Map<DocumentType,EClass> documentTypeMap = new HashMap<DocumentType,EClass>();
        for (ContextType contextType : repositoryMetadata.getContextTypes()) {
            DocumentType rootDocumentType = contextType.getRootDocumentType();
            EClass clazz = null;
            if (rootDocumentType != null) {
                List<EClass> rootRefObjectTypes = rootDocumentType.getRootRefObjectTypes();
                if (rootRefObjectTypes.size() == 1) {
                    clazz = rootRefObjectTypes.get(0);
                } else if (rootRefObjectTypes.size() > 1) {
                    System.out.println(rootDocumentType.getFilePattern());
                    System.out.println(rootDocumentType.getRootRefObjectTypes());
                    // TODO
                    continue;
                }
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
        for (DocumentType documentType : repositoryMetadata.getDocumentTypes()) {
            List<EClass> classes = documentType.getRootRefObjectTypes();
            // TODO: if there are multiple classes, we should get the common superclass
            documentTypeMap.put(documentType, classes.size() == 1 ? classes.get(0) : EcorePackage.eINSTANCE.getEObject());
        }
        for (Map.Entry<ContextType,EClass> entry : contextTypeMap.entrySet()) {
            ContextType contextType = entry.getKey();
            EClass clazz = entry.getValue();
            for (ChildContextTypeLink childContextTypeLink : contextType.getChildContextTypeLinks()) {
                ContextType childContextType = childContextTypeLink.getContextType();
                if (childContextType.getName().equals("repository")) {
                    continue;
                }
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                ref.setName(childContextType.getName());
                ref.setEType(contextTypeMap.get(childContextType));
                ref.setUpperBound(-1);
                ref.setContainment(true);
                clazz.getEStructuralFeatures().add(ref);
                childContextTypeLink.setReference(ref);
            }
            for (ChildDocumentTypeLink childDocumentTypeLink : contextType.getChildDocumentTypeLinks()) {
                DocumentType childDocumentType = childDocumentTypeLink.getDocumentType();
                if (childDocumentType.getRootRefObjectTypes().isEmpty()) {
                    continue;
                }
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                String filePattern = childDocumentType.getFilePattern();
                ref.setName(filePattern.substring(0, filePattern.lastIndexOf('.')));
                ref.setEType(documentTypeMap.get(childDocumentType));
                ref.setUpperBound(-1); // This is actually just a guess...
                ref.setContainment(true);
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
