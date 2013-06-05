package com.github.veithen.ramsay.ws.extract;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.github.veithen.ramsay.ws.metadata.ModelMapper;
import com.ibm.websphere.management.exception.DocumentNotFoundException;
import com.ibm.websphere.management.repository.ConfigRepository;

public class Loader {
    private final ConfigRepository repository;
    private final EPackage.Registry registry;
    private final ModelMapper modelMapper;
    private final Map<EObject,EObject> objectMap = new HashMap<EObject,EObject>();
    
    public Loader(ConfigRepository repository, EPackage.Registry registry, ModelMapper modelMapper) {
        this.repository = repository;
        this.registry = registry;
        this.modelMapper = modelMapper;
    }

    public List<EObject> load(String baseURI, String file) throws Exception {
        String uri = baseURI + "/" + file;
        System.out.println("Extracting " + uri);
        List<EObject> result = new ArrayList<EObject>();
        InputStream in = repository.extract(uri).getSource();
        try {
            ResourceSet resourceSet = new ResourceSetImpl();
            resourceSet.setPackageRegistry(registry);
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
            Resource resource = resourceSet.createResource(URI.createURI("dummy.xml"));
            resource.load(in, null);
            for (EObject object : (List<EObject>)resource.getContents()) {
                if (!object.eClass().getEPackage().getNsPrefix().equals("xmi")) {
                    result.add(map(baseURI, object));
                }
            }
        } finally {
            in.close();
        }
        return result;
    }
    
    private EObject map(String baseURI, EObject in) throws Exception {
        if (in == null) {
            return null;
        }
        EObject out = objectMap.get(in);
        if (out == null) {
            EClass inClass = in.eClass();
            EClass outClass = modelMapper.map(inClass);
            out = EcoreUtil.create(outClass);
            objectMap.put(in, out);
            for (EAttribute outAttr : (List<EAttribute>)outClass.getEAttributes()) {
                EAttribute inAttr = (EAttribute)inClass.getEStructuralFeature(outAttr.getName());
                Object inValue = in.eGet(inAttr);
                Object outValue;
                if (inValue instanceof EEnumLiteral) {
                    outValue = ((EEnum)outAttr.getEType()).getEEnumLiteral(((EEnumLiteral)inValue).getValue());
                } else {
                    outValue = inValue;
                }
                out.eSet(outAttr, outValue);
            }
            for (EReference outRef : (List<EReference>)outClass.getEReferences()) {
                EAnnotation fetch = outRef.getEAnnotation("fetch");
                if (fetch != null) {
                    String file = (String)fetch.getDetails().get("file");
                    if (file != null) {
                        int idx = file.indexOf("/{name}/");
                        if (idx == -1) {
                            try {
                                ((List)out.eGet(outRef)).addAll(load(baseURI, file));
                            } catch (DocumentNotFoundException ex) {
                                continue;
                            }
                        } else {
                            String dir = baseURI + "/" + file.substring(0, idx);
                            String actualFile = file.substring(idx+8);
                            List outCollection = (List)out.eGet(outRef);
                            for (String uri : Arrays.asList(repository.listResourceNames(dir, 2, 1))) {
                                // TODO: check collection size and name attribute
                                outCollection.addAll(load(uri, actualFile));
                            }
                        }
                    } else {
                        String dir = (String)fetch.getDetails().get("dir");
                        // TODO
                    }
                } else {
                    EReference inRef = (EReference)inClass.getEStructuralFeature(outRef.getName());
                    if (outRef.isMany()) {
                        List outCollection = (List)out.eGet(outRef);
                        for (EObject inObject : (List<EObject>)in.eGet(inRef)) {
                            outCollection.add(map(baseURI, inObject));
                        }
                    } else {
                        out.eSet(outRef, map(baseURI, (EObject)in.eGet(inRef)));
                    }
                }
            }
        }
        return out;
    }
}
