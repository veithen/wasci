package com.github.veithen.ramsay.ws.metadata.extractor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsolatedClassLoader extends ClassLoader {
    /**
     * Classes that are loaded from the parent. They provide the interface between the Eclipse
     * plug-in and the custom code running in the isolated class loader.
     */
    private final Set<String> classesLoadedFromParent;

    public IsolatedClassLoader(ClassLoader parent, String... classesLoadedFromParent) {
        super(parent);
        this.classesLoadedFromParent = new HashSet<String>(Arrays.asList(classesLoadedFromParent)); 
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
                // Always delegate to the system class loader (but not to the parent)
                clazz = findSystemClass(name);
            } catch (ClassNotFoundException ex) {
                clazz = findClass(name);
            }
            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
    }
}
