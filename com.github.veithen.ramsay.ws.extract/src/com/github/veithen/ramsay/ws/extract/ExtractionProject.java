package com.github.veithen.ramsay.ws.extract;

import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.ws.metadata.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.Metadata;
import com.github.veithen.ramsay.ws.metadata.MetadataProject;
import com.github.veithen.ramsay.ws.metadata.ModelMapper;
import com.ibm.websphere.management.AdminClient;
import com.ibm.ws.management.repository.client.JMXRemoteConfigRepositoryClient;

public class ExtractionProject {
    private final IProject project;

    public ExtractionProject(IProject project) {
        this.project = project;
    }
    
    private static EPackage createXMIPackage() {
        EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("xmi");
        pkg.setNsPrefix("xmi");
        pkg.setNsURI("http://www.omg.org/XMI");
        EClass clazz = EcoreFactory.eINSTANCE.createEClass();
        clazz.setName("Documentation");
        EAttribute att = EcoreFactory.eINSTANCE.createEAttribute();
        att.setName("contact");
        att.setEType(EcorePackage.eINSTANCE.getEString());
        clazz.getEStructuralFeatures().add(att);
        pkg.getEClassifiers().add(clazz);
        return pkg;
    }
    
    public void extract(IFile outFile) throws CoreException {
        Metadata metadata = getMetadataProject().loadMetadata();
        EPackage.Registry registry = metadata.getRegistry();
        EMFUtil.registerPackage(registry, createXMIPackage());
        JMXRemoteConfigRepositoryClient repository = new JMXRemoteConfigRepositoryClient();
        Properties props = new Properties();
        props.setProperty(AdminClient.CONNECTOR_HOST, "localhost");
        props.setProperty(AdminClient.CONNECTOR_PORT, "8879");
        props.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_SOAP);
        ModelMapper modelMapper = metadata.getModelMapper();
        EClass cellClass = modelMapper.map(metadata.getCellContextType());
        EObject cell = EcoreUtil.create(cellClass);
        ResourceSet outResourceSet = new ResourceSetImpl();
        Resource outResource = EMFUtil.createResource(outResourceSet, outFile);
        try {
            repository.connect(props);
            outResource.getContents().addAll(new Loader(repository, registry, modelMapper).load("cells/test", "cell.xml"));
        } catch (Exception ex) {
            throw new CoreException(new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Failed to extract configuration", ex));
        }
        EMFUtil.save(outResource);
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
}
