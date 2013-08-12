package com.github.veithen.ramsay.ws.metadata.extractor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Special class loader that defines a predefined set of classes by loading the corresponding
 * <tt>*.class</tt> files from another class loader. This can be used to "inject" classes into a
 * class loader hierarchy without the need to package these classes into a distinct artifact (loaded
 * by a {@link URLClassLoader}).
 * <p>
 * Assume e.g. that an OSGi bundle creates a custom class loader that loads classes from an external
 * JAR files (such as commercial third party libraries that cannot be packaged together with the
 * bundle). Further assume that the bundle needs to execute code that has a static dependency on
 * these classes. For this to work, that code needs to be loaded into the custom class loader or a
 * child of that class loader. In this case the present class can be used to create a child class
 * loader that loads this code (i.e. the corresponding <tt>.class</tt> files) from the bundle class
 * loader.
 * <p>
 * This class loader always uses parent-last delegation mode.
 */
public class MirrorClassLoader extends ClassLoader {
    private final ClassLoader source;
    private final Set<String> mirroredClasses;
    
    /**
     * Constructor.
     * 
     * @param parent
     *            the parent class loader
     * @param source
     *            the class loader to load the <tt>.class</tt> files from; only the
     *            {@link ClassLoader#getResourceAsStream(String)} will be called on this class
     *            loader
     * @param mirroredClasses
     *            the set of classes to be loaded by the class loader
     */
    public MirrorClassLoader(ClassLoader parent, ClassLoader source, String... mirroredClasses) {
        super(parent);
        this.source = source;
        this.mirroredClasses = new HashSet<String>(Arrays.asList(mirroredClasses));
    }
    
    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);
        if (clazz != null) {
            return clazz;
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
        if (mirroredClasses.contains(name)) {
            InputStream in = source.getResourceAsStream(name.replace('.', '/').concat(".class"));
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
