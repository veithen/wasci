package com.github.veithen.ramsay.ws.extract;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.github.veithen.ramsay.ws.metadata.Constants;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.ibm.websphere.management.repository.ConfigRepository;
import com.ibm.ws.management.repository.client.JMXRemoteConfigRepositoryClient;

public class DataProject {
    private final IProject project;

    public DataProject(IProject project) {
        this.project = project;
    }
    
    private ConfigRepository connect() throws CoreException {
        Properties props = new Properties();
        try {
            InputStream in = project.getFile("adminclient.properties").getContents();
            try {
                props.load(in);
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to load properties", ex));
        }
        JMXRemoteConfigRepositoryClient repository = new JMXRemoteConfigRepositoryClient();
        try {
            repository.connect(props);
        } catch (Exception ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to connect to WebSphere", ex));
        }
        return repository;
    }
    
    /**
     * Get the metadata project corresponding to this extraction project.
     * 
     * @return the metadata project; never <code>null</code>
     * @throws CoreException
     *             if the metadata project was not found or if there was some
     *             other problem
     */
    public MetadataProject getMetadataProject() throws CoreException {
        MetadataProject metadataProject = null;
        for (IProject refProject : project.getReferencedProjects()) {
            MetadataProject mp = (MetadataProject)refProject.getAdapter(MetadataProject.class);
            if (mp != null) {
                if (metadataProject == null) {
                    metadataProject = mp;
                } else {
                    throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "The project has references to more than one metadata project"));
                }
            }
        }
        if (metadataProject == null) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "The project has no reference to a metadata project"));
        }
        return metadataProject;
    }
    
    public void extractRaw(IProgressMonitor monitor) throws CoreException {
        MetadataProject metadataProject = getMetadataProject();
        IFolder folder = project.getFolder(Constants.RAW_PATH);
        ConfigRepository repository = connect();
        project.getWorkspace().run(new ExtractRawDataRunnable(metadataProject, folder, repository),
                null, IWorkspace.AVOID_UPDATE, monitor);
    }
}
