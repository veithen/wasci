package com.github.veithen.ramsay.ws.metadata;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;

import com.github.veithen.ramsay.util.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.extractor.IsolatedClassLoader;
import com.github.veithen.ramsay.ws.metadata.extractor.MetadataExtractor;
import com.github.veithen.ramsay.ws.metadata.extractor.MetadataExtractorCallback;
import com.github.veithen.ramsay.ws.metadata.extractor.MetadataExtractorImpl;

public class ExtractRawRunnable implements IWorkspaceRunnable, MetadataExtractorCallback {
    private final IFolder folder;
    private final URIConverter uriConverter = new ExtensibleURIConverterImpl();
    
    public ExtractRawRunnable(IFolder folder) {
        this.folder = folder;
    }

    @Override
    public void run(IProgressMonitor monitor) throws CoreException {
        File installDir = new File("c:\\opt\\IBM\\WebSphere\\AppServer-8.5");
        List<File> jars = new ArrayList<File>();
        for (File file : new File(installDir, "plugins").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".jar")) {
                jars.add(file);
            }
        }
        jars.add(new File(installDir, "lib/bootstrap.jar"));
        List<URL> urls = new ArrayList<URL>(jars.size());
        for (File jar : jars) {
            try {
                urls.add(jar.toURI().toURL());
            } catch (MalformedURLException ex) {
                throw new Error("Unexpected exception", ex);
            }
        }
        ClassLoader cl = new IsolatedClassLoader(urls.toArray(new URL[urls.size()]), ExtractRawRunnable.class.getClassLoader());
        Thread thread = Thread.currentThread();
        ClassLoader savedContextClassLoader = thread.getContextClassLoader();
        thread.setContextClassLoader(cl);
        try {
            ((MetadataExtractor)cl.loadClass(MetadataExtractorImpl.class.getName()).newInstance()).extract(this);
        } catch (Exception ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Metadata extraction failed", ex));
        } finally {
            thread.setContextClassLoader(savedContextClassLoader);
        }
    }

    @Override
    public String getEcoreFileURI(String ePackageName, String ePackageNsURI, String javaPackageName) {
        return EMFUtil.createURI(folder.getFile(javaPackageName + ".ecore")).toString();
    }

    @Override
    public OutputStream createOutputStream(String uri) throws IOException {
        return uriConverter.createOutputStream(URI.createURI(uri));
    }
}
