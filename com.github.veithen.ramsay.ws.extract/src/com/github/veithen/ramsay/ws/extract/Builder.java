package com.github.veithen.ramsay.ws.extract;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.util.SimpleBuilder;
import com.github.veithen.ramsay.ws.metadata.EMFUtil;
import com.github.veithen.ramsay.ws.metadata.Metadata;

public class Builder extends SimpleBuilder {
    public static final String ID = Constants.PLUGIN_ID + ".builder";
    
    @Override
    protected IPath getInputPath() {
        return Constants.RAW_PATH;
    }

    @Override
    protected IPath getOutputPath() {
        return Constants.TRANSFORMED_PATH;
    }

    @Override
    protected void doBuild(final IFolder inputFolder, final IFolder outputFolder, IProgressMonitor monitor) throws CoreException {
        ExtractionProject project = (ExtractionProject)getProject().getAdapter(ExtractionProject.class);
        final ResourceSet resourceSet = new ResourceSetImpl();
        Metadata metadata = project.getMetadataProject().loadMetadata();
        Registry registry = metadata.getRegistry();
        resourceSet.setPackageRegistry(registry);
        final Map<Resource,IFile> resourceMap = new HashMap<Resource,IFile>();
        inputFolder.accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE) {
                    IFile file = (IFile)resource;
                    IPath relPath = file.getFullPath().makeRelativeTo(inputFolder.getFullPath());
                    resourceMap.put(EMFUtil.load(resourceSet, file), outputFolder.getFile(relPath));
                }
                return true;
            }
        });
        
        Realm realm = metadata.getRealm();
        EPackage processPackage = realm.getPackage("http://www.ibm.com/websphere/appserver/schemas/5.0/process.xmi");
        EClass serverClass = (EClass)processPackage.getEClassifier("Server");
        EPackage clusterPackage = realm.getPackage("http://www.ibm.com/websphere/appserver/schemas/5.0/topology.cluster.xmi");
        EClass clusterMemberClass = (EClass)clusterPackage.getEClassifier("ClusterMember");
        
        EStructuralFeature serverNameFeature = serverClass.getEStructuralFeature("name");
        // TODO: also need to take into account node name
        Map<String,EObject> serverMap = new HashMap<String,EObject>();
        for (EObject server : realm.getInstances(serverClass)) {
            serverMap.put((String)server.eGet(serverNameFeature), server);
        }
        EReference clusterMemberFeature = EcoreFactory.eINSTANCE.createEReference();
        clusterMemberFeature.setName("clusterMember");
        clusterMemberFeature.setEType(clusterMemberClass);
        serverClass.getEStructuralFeatures().add(clusterMemberFeature);
        
        EStructuralFeature memberNameFeature = clusterMemberClass.getEStructuralFeature("memberName");
        EReference serverFeature = EcoreFactory.eINSTANCE.createEReference();
        serverFeature.setName("server");
        serverFeature.setEType(serverClass);
        serverFeature.setLowerBound(1);
        serverFeature.setEOpposite(clusterMemberFeature);
        clusterMemberClass.getEStructuralFeatures().add(serverFeature);
        for (EObject clusterMember : realm.getInstances(clusterMemberClass)) {
            String memberName = (String)clusterMember.eGet(memberNameFeature);
            clusterMember.eSet(serverFeature, serverMap.get(memberName));
        }
        clusterMemberClass.getEStructuralFeatures().remove(memberNameFeature);
        
        // Before changing the URIs we need to make sure that all proxies are resolved.
        // If we don't do this, the output files may contain references to the input files
        for (Resource resource : resourceMap.keySet()) {
            EcoreUtil.resolveAll(resource);
        }
        // Now change the URIs.
        for (Map.Entry<Resource,IFile> entry : resourceMap.entrySet()) {
            entry.getKey().setURI(EMFUtil.createURI(entry.getValue()));
        }
        // Only save after all URIs have been changed
        for (Resource resource : resourceMap.keySet()) {
            EMFUtil.save(resource);
        }
    }
}
