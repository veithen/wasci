package com.github.veithen.ramsay.ws.extract;

import java.net.Proxy;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.visualwas.connector.factory.Attributes;
import com.github.veithen.visualwas.connector.factory.ConnectorConfiguration;
import com.github.veithen.visualwas.connector.factory.ConnectorFactory;
import com.github.veithen.visualwas.connector.security.BasicAuthCredentials;
import com.github.veithen.visualwas.connector.security.Credentials;
import com.github.veithen.visualwas.connector.transport.Endpoint;
import com.github.veithen.visualwas.connector.transport.TransportConfiguration;
import com.github.veithen.visualwas.repoclient.ConfigRepository;
import com.github.veithen.visualwas.repoclient.RepositoryClientFeature;

public class DataProject {
    private static final ConnectorConfiguration connectorConfig = ConnectorConfiguration.custom()
            .addFeatures(RepositoryClientFeature.INSTANCE)
            .setTransportConfiguration(TransportConfiguration.custom().setProxy(Proxy.NO_PROXY).build()).build();
    
    private final IProject project;

    public DataProject(IProject project) {
        this.project = project;
    }
    
    private ConfigRepository connect() throws CoreException {
        IEclipsePreferences prefs = new ProjectScope(project).getNode(Constants.PREFERENCES_NODE);
        Credentials credentials;
        String username = prefs.get(Constants.PREF_USERNAME, null);
        if (username == null || username.length() == 0) {
            credentials = null;
        } else {
            credentials = new BasicAuthCredentials(username, prefs.get(Constants.PREF_PASSWORD, null));
        }
        Endpoint endpoint = new Endpoint(prefs.get(Constants.PREF_HOST, null), prefs.getInt(Constants.PREF_PORT, -1), credentials != null);
        Attributes attributes = new Attributes();
        if (credentials != null) {
            attributes.set(Credentials.class, credentials);
        }
        return ConnectorFactory.getInstance().createConnector(endpoint, connectorConfig, attributes).getAdapter(ConfigRepository.class);
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
