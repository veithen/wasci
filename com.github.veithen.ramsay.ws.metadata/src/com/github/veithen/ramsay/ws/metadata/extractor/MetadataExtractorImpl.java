package com.github.veithen.ramsay.ws.metadata.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.local.LocalPackageSupport;
import com.github.veithen.ramsay.emf.local.LocalPackageUtil;
import com.ibm.websphere.management.exception.InvalidConfigDataTypeException;
import com.ibm.ws.management.configservice.TypeRegistry;
import com.ibm.ws.sm.workspace.metadata.RepositoryContextType;
import com.ibm.ws.sm.workspace.metadata.RepositoryDocumentType;
import com.ibm.ws.sm.workspace.metadata.RepositoryMetaData;
import com.ibm.ws.sm.workspace.metadata.RepositoryMetaDataFactory;

public class MetadataExtractorImpl implements MetadataExtractor {
    /**
     * Required EPackages. These packages contain classes references by configuration object types,
     * but that are not considered as configuration object types themselves.
     */
    private static final Set<String> requiredEPackages = new HashSet<String>(Arrays.asList(
            "http://www.ibm.com/websphere/appserver/schemas/5.0/datatype.xmi",
            "application.xmi"));
    
    /**
     * Maps package namespace URIs from their original value to the local namespace URI.
     */
    private final Map<String,String> nsURIMap = new HashMap<String,String>();
    
    @Override
    public void extractConfigMetadata(ConfigMetadataCallback callback) throws Exception {
        Collection<EPackage> ePackages = new HashSet<EPackage>();
        Map<String,String> javaPackageNames = new HashMap<String,String>();
        
        // Load all EPackages found in the plug-ins
        
        URLClassLoader cl = (URLClassLoader)MetadataExtractorImpl.class.getClassLoader();
        for (URL url : cl.getURLs()) {
            File file = new File(url.toURI());
            if (file.isFile()) {
                FileInputStream fin = new FileInputStream(file);
                try {
                    JarInputStream jar = new JarInputStream(fin);
                    JarEntry entry;
                    while ((entry = jar.getNextJarEntry()) != null) {
                        String name = entry.getName();
                        if (name.indexOf('$') == -1 && name.endsWith("Package.class")) {
                            String className = name.substring(0, name.length()-6).replace('/', '.');
                            Class<?> clazz = cl.loadClass(className);
                            Field field;
                            try {
                                field = clazz.getField("eINSTANCE");
                            } catch (NoSuchFieldException ex) {
                                continue;
                            }
                            // Just getting the field value is enough to load the EPackage and have it
                            // registered in the package registry.
                            // Note: this is precisely the reason why we need an isolated class loader;
                            // we don't want that these packages get registered in the package registry
                            // of the Eclipse IDE.
                            EPackage ePackage = (EPackage)field.get(null);
                            javaPackageNames.put(ePackage.getNsURI(), className.substring(0, className.lastIndexOf('.')));
                            if (requiredEPackages.contains(ePackage.getNsURI())) {
                                ePackages.add(ePackage);
                            }
                        }
                    }
                } finally {
                    fin.close();
                }
            }
        }
        
        // Now use WebSphere's TypeRegistry to select the packages containing configuration object types
        
        for (String shortTypeName : TypeRegistry.getAllTypes()) {
            EClass eClass = TypeRegistry.getMetaObject(shortTypeName);
            EPackage ePackage = eClass.getEPackage();
            while (true) {
                EPackage eSuperPackage = ePackage.getESuperPackage();
                if (eSuperPackage == null) {
                    break;
                }
                ePackage = eSuperPackage;
            }
            ePackages.add(ePackage);
        }
        
        // Change the package URIs
        
        // Need to copy the packages because we are going to assign new resources and change the namespace URIs.
        ePackages = EcoreUtil.copyAll(ePackages);
        ResourceSet resourceSet = new ResourceSetImpl();
        List<Resource> resources = new ArrayList<Resource>();
        for (EPackage ePackage : ePackages) {
            Resource resource = resourceSet.createResource(URI.createURI(callback.getEcoreFileURI(ePackage.getName(), ePackage.getNsURI(), ePackage.getNsPrefix(), javaPackageNames.get(ePackage.getNsURI()))));
            resource.getContents().add(ePackage);
            resources.add(resource);
            changeNsURI(ePackage);
        }
        
        // Save the Ecore files
        
        for (Resource resource : resources) {
            OutputStream out = callback.createOutputStream(resource.getURI().toString());
            try {
                resource.save(out, null);
            } finally {
                out.close();
            }
        }
    }

    /**
     * Change the namespace URI of the package to a local one (i.e. make it equal to the location
     * URI of the EPackage object). Note that this is basically what we do with
     * {@link LocalPackageUtil}, but unfortunately we can't use that code in the isolated class
     * loader.
     * 
     * @param ePackage
     */
    private void changeNsURI(EPackage ePackage) {
        EAnnotation ann = EcoreFactory.eINSTANCE.createEAnnotation();
        // Note: it is safe to use the constants from the LocalPackageSupport here because
        //       the compiler will inline them
        ann.setSource(LocalPackageSupport.ANNOTATION_URI);
        ann.getDetails().put(LocalPackageSupport.ORIGINAL_NS_URI, ePackage.getNsURI());
        ePackage.getEAnnotations().add(ann);
        String newNsURI = EcoreUtil.getURI(ePackage).toString();
        nsURIMap.put(ePackage.getNsURI(), newNsURI);
        ePackage.setNsURI(newNsURI);
        for (EPackage eSubpackage : ePackage.getESubpackages()) {
            changeNsURI(eSubpackage);
        }
    }
    
    @Override
    public void extractRepositoryMetadata(String dir, RepositoryMetadataCallback callback) throws Exception {
        RepositoryMetaData repositoryMetaData = RepositoryMetaDataFactory.getFactory().getMetaData(dir);
        for (Iterator<RepositoryDocumentType> it = repositoryMetaData.getDocumentTypeAccess(); it.hasNext(); ) {
            RepositoryDocumentType documentType = it.next();
            callback.createDocumentType(documentType.getDisplayName(), documentType.getFilePattern());
            for (String rootRefObjectType : documentType.getRootRefObjectTypes()) {
                try {
                    EClass eClass = TypeRegistry.getMetaObject(rootRefObjectType);
                    callback.addRootRefObjectType(documentType.getDisplayName(), nsURIMap.get(eClass.getEPackage().getNsURI()), eClass.getName());
                } catch (InvalidConfigDataTypeException e) {
                    System.out.println("Config object type " + rootRefObjectType + " not found");
                }
            }
        }
        for (Iterator<RepositoryContextType> it = repositoryMetaData.getContextTypeAccess(); it.hasNext(); ) {
            RepositoryContextType contextType = it.next();
            RepositoryDocumentType rootDocumentType = contextType.getRootDocumentType();
            callback.createContextType(contextType.getName(), rootDocumentType == null ? null : rootDocumentType.getDisplayName());
            for (RepositoryDocumentType childDocumentType : contextType.getChildDocumentTypes()) {
                callback.linkDocumentTypeToContextType(contextType.getName(), childDocumentType.getDisplayName());
            }
        }
        for (Iterator<RepositoryContextType> it = repositoryMetaData.getContextTypeAccess(); it.hasNext(); ) {
            RepositoryContextType contextType = it.next();
            for (RepositoryContextType childContextType : contextType.getChildContextTypes()) {
                callback.linkContextTypes(contextType.getName(), childContextType.getName());
            }
        }
    }
}
