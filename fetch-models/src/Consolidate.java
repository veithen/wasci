import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.github.veithen.ramsay.ws.extract.Loader;
import com.github.veithen.ramsay.ws.metadata.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.ModelMapper;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryPackage;
import com.ibm.websphere.management.AdminClient;
import com.ibm.ws.management.repository.client.JMXRemoteConfigRepositoryClient;

public class Consolidate {
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
    
    public static void main(String[] args) throws Exception {
        EPackage.Registry registry = new EPackageRegistryImpl();
        EMFUtil.registerPackage(registry, createXMIPackage());
        File[] ecoreFiles = new File("models").listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".ecore");
            }
        });
        RepositoryPackage.eINSTANCE.eClass();
        ResourceSet resourceSet = new ResourceSetImpl();
        Map extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl());
        extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl());
        for (File ecoreFile : ecoreFiles) {
            Resource resource = resourceSet.createResource(URI.createFileURI(ecoreFile.getAbsolutePath()));
            resource.load(null);
            for (EObject content : (List<EObject>)resource.getContents()) {
                EMFUtil.registerPackage(registry, (EPackage)content);
            }
        }
        registry.put("http://www.ibm.com/websphere/appserver/schemas/6.0/pmiservice.xmi", registry.get("http://www.ibm.com/websphere/appserver/schemas/5.0/pmiservice.xmi"));
        Resource resource = resourceSet.createResource(URI.createFileURI(new File("models/repository-metadata.xmi").getAbsolutePath()));
        resource.load(null);
        ContextType cellContextType = null;
        for (EObject object : (List<EObject>)resource.getContents()) {
            if (object instanceof ContextType) {
                ContextType contextType = (ContextType)object;
                if (contextType.getName().equals("cells")) {
                    cellContextType = contextType;
                    break;
                }
            }
        }
        System.out.println(cellContextType);
        ModelMapper modelMapper = new ModelMapper();
        EClass cellClass = modelMapper.map(cellContextType);
        ResourceSet outResourceSet = new ResourceSetImpl();
        extensionToFactoryMap = outResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        extensionToFactoryMap.put("ecore", new XMIResourceFactoryImpl());
        extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl());
        Resource outResource = outResourceSet.createResource(URI.createURI("wsconfig.ecore"));
        outResource.getContents().add(modelMapper.getEPackage());
        outResource.save(null);
        
        JMXRemoteConfigRepositoryClient repository = new JMXRemoteConfigRepositoryClient();
        Properties props = new Properties();
        props.setProperty(AdminClient.CONNECTOR_HOST, "localhost");
        props.setProperty(AdminClient.CONNECTOR_PORT, "8879");
        props.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_SOAP);
        repository.connect(props);
        EObject cell = EcoreUtil.create(cellClass);
        outResource = outResourceSet.createResource(URI.createURI("wsconfig.xmi"));
        outResource.getContents().addAll(new Loader(repository, registry, modelMapper).load("cells/test", "cell.xml"));
        outResource.save(null);
    }
}
