package com.github.veithen.ramsay.ws.metadata.repository.handler.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.XMIResource;

import com.github.veithen.ramsay.ws.metadata.repository.DefaultDocumentType;
import com.github.veithen.ramsay.ws.metadata.repository.handler.DocumentTypeHandler;
import com.github.veithen.ramsay.ws.metadata.repository.util.RepositoryMetadataUtil;

public class DefaultDocumentTypeHandler extends AdapterImpl implements DocumentTypeHandler {
    @Override
    public EClass getObjectType() {
        EList<EClass> rootRefObjectTypes = ((DefaultDocumentType)target).getRootRefObjectTypes();
        if (rootRefObjectTypes.isEmpty()) {
            return null;
        } else if (rootRefObjectTypes.size() == 1) {
            return rootRefObjectTypes.get(0);
        } else {
            // Try to determine the common supertype
            Set<EClass> commonSuperTypes = null;
            for (EClass rootRefObjectType : rootRefObjectTypes) {
                EList<EClass> superTypes = rootRefObjectType.getEAllSuperTypes();
                if (commonSuperTypes == null) {
                    commonSuperTypes = new HashSet<EClass>(superTypes);
                } else {
                    commonSuperTypes.retainAll(superTypes);
                }
            }
            if (commonSuperTypes.size() == 1) {
                return commonSuperTypes.iterator().next();
            } else {
                return EcorePackage.eINSTANCE.getEObject();
            }
        }
    }

    @Override
    public String getReferenceName() {
        String filePattern = ((DefaultDocumentType)target).getFilePattern();
        return RepositoryMetadataUtil.toIdentifier(filePattern.substring(filePattern.lastIndexOf('/') + 1, filePattern.lastIndexOf('.')), false);
    }
    
    @Override
    public String scan(Set<String> relativeURIs) {
        String filePattern = ((DefaultDocumentType)target).getFilePattern();
        return relativeURIs.contains(filePattern) ? filePattern : null;
    }

    @Override
    public void processDocument(XMIResource resource, InputStream in) throws IOException {
        resource.load(in, null);
    }
}
