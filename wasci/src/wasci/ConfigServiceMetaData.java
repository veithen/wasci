package wasci;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import javax.management.ObjectName;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jst.j2ee.application.ApplicationPackage;

import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;
import com.github.veithen.ramsay.ws.model.repository.RepositoryFactory;
import com.ibm.websphere.management.AdminServiceFactory;
import com.ibm.websphere.management.exception.AdminException;
import com.ibm.websphere.management.exception.InvalidConfigDataTypeException;
import com.ibm.websphere.models.datatype.DatatypePackage;
import com.ibm.ws.exception.RuntimeError;
import com.ibm.ws.exception.RuntimeWarning;
import com.ibm.ws.management.collaborator.DefaultRuntimeCollaborator;
import com.ibm.ws.management.configservice.TypeRegistry;
import com.ibm.ws.sm.workspace.metadata.RepositoryContextType;
import com.ibm.ws.sm.workspace.metadata.RepositoryDocumentType;
import com.ibm.ws.sm.workspace.metadata.RepositoryMetaData;
import com.ibm.ws.sm.workspace.metadata.RepositoryMetaDataFactory;
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

    private static List<EObject> extractRepositoryMetaData() {
        RepositoryMetaData repositoryMetaData = RepositoryMetaDataFactory.getRepositoryMetaData();
        List<EObject> result = new ArrayList<EObject>();
        Map<RepositoryDocumentType,DocumentType> documentTypeMap = new HashMap<RepositoryDocumentType,DocumentType>();
        for (Iterator<RepositoryDocumentType> it = repositoryMetaData.getDocumentTypeAccess(); it.hasNext(); ) {
            RepositoryDocumentType repositoryDocumentType = it.next();
            DocumentType documentType = RepositoryFactory.eINSTANCE.createDocumentType();
            documentType.setFilePattern(repositoryDocumentType.getFilePattern());
            for (String rootRefObjectType : repositoryDocumentType.getRootRefObjectTypes()) {
                try {
                    documentType.getRootRefObjectTypes().add(TypeRegistry.getMetaObject(rootRefObjectType));
                } catch (InvalidConfigDataTypeException e) {
                    System.out.println("Config object type " + rootRefObjectType + " not found");
                }
            }
            documentTypeMap.put(repositoryDocumentType, documentType);
            result.add(documentType);
        }
        Map<RepositoryContextType,ContextType> contextTypeMap = new HashMap<RepositoryContextType,ContextType>();
        for (Iterator<RepositoryContextType> it = repositoryMetaData.getContextTypeAccess(); it.hasNext(); ) {
            RepositoryContextType repositoryContextType = it.next();
            ContextType contextType = RepositoryFactory.eINSTANCE.createContextType();
            contextType.setName(repositoryContextType.getName());
            for (RepositoryDocumentType childDocumentType : (List<RepositoryDocumentType>)repositoryContextType.getChildDocumentTypes()) {
                contextType.getChildDocumentTypes().add(documentTypeMap.get(childDocumentType));
            }
            contextType.setRootDocumentType(documentTypeMap.get(repositoryContextType.getRootDocumentType()));
            contextTypeMap.put(repositoryContextType, contextType);
            result.add(contextType);
        }
        for (Map.Entry<RepositoryContextType,ContextType> entry : contextTypeMap.entrySet()) {
            RepositoryContextType repositoryContextType = entry.getKey();
            ContextType contextType = entry.getValue();
            for (RepositoryContextType childContextType : (List<RepositoryContextType>)repositoryContextType.getChildContextTypes()) {
                contextType.getChildContextTypes().add(contextTypeMap.get(childContextType));
            }
        }
        return result;
    }
    
    private static Collection<EPackage> extractConfigPackages() {
        Collection<EPackage> ePackages = new HashSet<EPackage>();
        for (String shortTypeName : (Set<String>)TypeRegistry.getAllTypes()) {
            EClass eClass;
            try {
                eClass = TypeRegistry.getMetaObject(shortTypeName);
            } catch (InvalidConfigDataTypeException ex) {
                throw new Error("Unexpected exception", ex);
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
        // Add packages that are referenced in the models, but that are not seen in the TypeRegistry
        ePackages.add(DatatypePackage.eINSTANCE);
        ePackages.add(ApplicationPackage.eINSTANCE);
        return ePackages;
    }
        
    public byte[] extractMetaData() {
        // We need to add all the stuff to a single collection because we need to pass these
        // objects together to copyAll.
        Collection<EObject> objects = new ArrayList<EObject>();
        objects.addAll(extractRepositoryMetaData());
        objects.addAll(extractConfigPackages());
        // Need to copy the packages because we are going to assign new resources. Since the
        // repository metadata has references to EClasses belonging to these packages, we also
        // need to copy the repository metadata.
        objects = (Collection<EObject>)EcoreUtil.copyAll(objects);
        ResourceSet resourceSet = new ResourceSetImpl();
        List<Resource> resources = new ArrayList<Resource>();
        Resource repositoryMetaData = resourceSet.createResource(URI.createURI("repository-metadata.xmi"));
        resources.add(repositoryMetaData);
        for (EObject object : objects) {
            if (object instanceof EPackage) {
                EPackage ePackage = (EPackage)object;
                Resource resource = resourceSet.createResource(URI.createURI(ePackage.getNsPrefix() + ".ecore"));
                resource.getContents().add(ePackage);
                resources.add(resource);
            } else {
                repositoryMetaData.getContents().add(object);
            }
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
        byte[] result = baos.toByteArray();
        System.out.println("Config models exported; size=" + result.length);
        return result;
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
