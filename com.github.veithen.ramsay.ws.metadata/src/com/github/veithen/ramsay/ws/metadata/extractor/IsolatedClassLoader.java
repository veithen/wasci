package com.github.veithen.ramsay.ws.metadata.extractor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    /**
     * Classes that are injected into the isolated class loader. The class loader will load the
     * class files for these classes from the parent class loader, but define them itself.
     */
    private static final Set<String> injectedClasses = new HashSet<String>(Arrays.asList(
            MetadataExtractorImpl.class.getName()));
    
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

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (injectedClasses.contains(name)) {
            InputStream in = getParent().getResourceAsStream(name.replace('.', '/').concat(".class"));
            if (in == null) {
                throw new ClassNotFoundException(name);
            }
            try {
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int c;
                    byte[] buffer = new byte[4096];
                    while ((c = in.read(buffer)) != -1) {
                        baos.write(buffer, 0, c);
                    }
                    byte[] byteCode = baos.toByteArray();
                    return defineClass(name, byteCode, 0, byteCode.length);
                } finally {
                    in.close();
                }
            } catch (IOException ex) {
                throw new ClassNotFoundException(name, ex);
            }
        } else {
            return super.findClass(name);
        }
    }
}
