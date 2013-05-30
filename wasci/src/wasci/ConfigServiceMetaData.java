package wasci;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import javax.management.ObjectName;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.websphere.management.AdminServiceFactory;
import com.ibm.websphere.management.exception.AdminException;
import com.ibm.websphere.management.exception.InvalidConfigDataTypeException;
import com.ibm.ws.exception.RuntimeError;
import com.ibm.ws.exception.RuntimeWarning;
import com.ibm.ws.management.collaborator.DefaultRuntimeCollaborator;
import com.ibm.ws.management.configservice.TypeRegistry;
import com.ibm.wsspi.runtime.component.WsComponentImpl;

public class ConfigServiceMetaData extends WsComponentImpl {
    private ObjectName mbeanName;

    @Override
    public void start() throws RuntimeError, RuntimeWarning {
        System.out.println("Registering ConfigServiceMetaData MBean");
        try {
            mbeanName = AdminServiceFactory.getMBeanFactory().activateMBean("ConfigServiceMetaData",
                    new DefaultRuntimeCollaborator(this), null, "META-INF/ConfigServiceMetaData.xml");
        } catch (AdminException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public byte[] extractMetaData() {
        Collection<EPackage> ePackages = new HashSet<EPackage>();
        for (String shortTypeName : (Set<String>)TypeRegistry.getAllTypes()) {
            EClass eClass;
            try {
                eClass = TypeRegistry.getMetaObject(shortTypeName);
            } catch (InvalidConfigDataTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                continue;
            }
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
        // Need to copy the packages because we are going to assign new resources
        ePackages = (Collection<EPackage>)EcoreUtil.copyAll(ePackages);
        ResourceSet resourceSet = new ResourceSetImpl();
        List<Resource> resources = new ArrayList<Resource>();
        for (EPackage ePackage : ePackages) {
            Resource resource = resourceSet.createResource(URI.createURI(ePackage.getNsPrefix() + ".ecore"));
            resource.getContents().add(ePackage);
            resources.add(resource);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            JarOutputStream jar = new JarOutputStream(baos);
            for (Resource resource : resources) {
                jar.putNextEntry(new JarEntry(resource.getURI().toString()));
                resource.save(jar, null);
            }
            jar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return baos.toByteArray();
    }
    
    @Override
    public void stop() {
        if (mbeanName != null) {
            try {
                AdminServiceFactory.getMBeanFactory().deactivateMBean(mbeanName);
            } catch (AdminException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
