package com.github.veithen.ramsay.ws.metadata.extractor;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsolatedClassLoader extends URLClassLoader {
    /**
     * Classes that are loaded from the parent. They provide the interface between the Eclipse
     * plug-in and the custom code running in the isolated class loader.
     */
    private static final Set<String> classesLoadedFromParent = new HashSet<String>(Arrays.asList(
            MetadataExtractor.class.getName(),
            ConfigMetadataCallback.class.getName(),
            RepositoryMetadataCallback.class.getName()));

    public IsolatedClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
        } else if (classesLoadedFromParent.contains(name)) {
            return super.loadClass(name, resolve);
        } else {
            try {
                clazz = findClass(name);
                if (resolve) {
                    resolveClass(clazz);
                }
                return clazz;
            } catch (ClassNotFoundException ex) {
                return super.loadClass(name, resolve);
            }
        }
    }
}
