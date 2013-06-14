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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ws.management.configservice.TypeRegistry;

public class MetadataExtractorImpl implements MetadataExtractor {
    /**
     * Required EPackages. These packages contain classes references by configuration object types,
     * but that are not considered as configuration object types themselves.
     */
    private static final Set<String> requiredEPackages = new HashSet<String>(Arrays.asList(
            "http://www.ibm.com/websphere/appserver/schemas/5.0/datatype.xmi",
            "application.xmi"));
    
    @Override
    public void extract(MetadataExtractorCallback callback) throws Exception {
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
        
        // Need to copy the packages because we are going to assign new resources.
        ePackages = EcoreUtil.copyAll(ePackages);
        ResourceSet resourceSet = new ResourceSetImpl();
        List<Resource> resources = new ArrayList<Resource>();
        for (EPackage ePackage : ePackages) {
            Resource resource = resourceSet.createResource(URI.createURI(callback.getEcoreFileURI(ePackage.getName(), ePackage.getNsURI(), javaPackageNames.get(ePackage.getNsURI()))));
            resource.getContents().add(ePackage);
            resources.add(resource);
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
}
