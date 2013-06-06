package com.github.veithen.ramsay.ws.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import com.github.veithen.ramsay.emf.cm.Realm;
import com.github.veithen.ramsay.ws.model.repository.ContextType;
import com.github.veithen.ramsay.ws.model.repository.DocumentType;

public class ModelMapper {
    private final Realm realm;
    private final EPackage rootPackage;
    private final EPackage contextPackage;
    private Map<EPackage,EPackage> packageMap = new HashMap<EPackage,EPackage>();
    private Map<ContextType,EClass> contextTypeMap = new HashMap<ContextType,EClass>();
    private Map<DocumentType,EClass> documentTypeMap = new HashMap<DocumentType,EClass>();
    private Map<EDataType,EDataType> dataTypeMap = new HashMap<EDataType,EDataType>();
    private Map<EClass,EClass> classMap = new HashMap<EClass,EClass>();
    private Map<EStructuralFeature,EStructuralFeature> featureMap = new HashMap<EStructuralFeature,EStructuralFeature>();
    
    public ModelMapper(Realm realm) {
        this.realm = realm;
        rootPackage = realm.createEPackage();
        rootPackage.setName("wsconfig");
        contextPackage = realm.createEPackage();
        contextPackage.setName("context");
        rootPackage.getESubpackages().add(contextPackage);
    }
    
    public EPackage getEPackage() {
        return rootPackage;
    }

    private EPackage map(EPackage in) {
        EPackage out = packageMap.get(in);
        if (out == null) {
            out = realm.createEPackage();
            out.setName(in.getName());
            packageMap.put(in, out);
            EPackage inSuperPackage = in.getESuperPackage();
            if (inSuperPackage == null) {
                rootPackage.getESubpackages().add(out);
            } else {
                map(inSuperPackage).getESubpackages().add(out);
            }
        }
        return out;
    }
    
    public EClass map(ContextType contextType) {
        EClass clazz = contextTypeMap.get(contextType);
        if (clazz == null) {
            DocumentType rootDocumentType = contextType.getRootDocumentType();
            if (rootDocumentType != null) {
                List<EClass> rootRefObjectTypes = (List<EClass>)rootDocumentType.getRootRefObjectTypes();
                if (rootRefObjectTypes.size() == 1) {
                    clazz = map(rootRefObjectTypes.get(0));
                } else if (rootRefObjectTypes.size() > 1) {
                    System.out.println(rootDocumentType.getFilePattern());
                    System.out.println(rootDocumentType.getRootRefObjectTypes());
                    // TODO
                    throw new RuntimeException();
                }
            }
            if (clazz == null) {
                clazz = EcoreFactory.eINSTANCE.createEClass();
                if (contextType.getName().length() == 0) {
                    clazz.setName("RootContext");
                } else {
                    clazz.setName(contextType.getName());
                    // TODO: add name attribute
                }
                contextPackage.getEClassifiers().add(clazz);
            }
            for (ContextType childContextType : (List<ContextType>)contextType.getChildContextTypes()) {
                if (childContextType.getName().equals("repository")) {
                    continue;
                }
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                ref.setName(childContextType.getName());
                ref.setEType(map(childContextType));
                ref.setUpperBound(-1);
                ref.setContainment(true);
                EAnnotation ann = EcoreFactory.eINSTANCE.createEAnnotation();
                ann.setSource("fetch");
                EMap details = ann.getDetails();
                DocumentType childContextRootDocumentType = childContextType.getRootDocumentType();
                if (childContextRootDocumentType != null) {
                    details.put("file", childContextType.getName() + "/{name}/" + childContextRootDocumentType.getFilePattern());
                } else {
                    details.put("dir", childContextType.getName() + "/{name}");
                }
                ref.getEAnnotations().add(ann);
                clazz.getEStructuralFeatures().add(ref);
            }
            for (DocumentType childDocumentType : (List<DocumentType>)contextType.getChildDocumentTypes()) {
                if (childDocumentType == rootDocumentType || childDocumentType.getRootRefObjectTypes().isEmpty()) {
                    continue;
                }
                EReference ref = EcoreFactory.eINSTANCE.createEReference();
                String filePattern = childDocumentType.getFilePattern();
                ref.setName(filePattern.substring(0, filePattern.lastIndexOf('.')));
                ref.setEType(map(childDocumentType));
                ref.setUpperBound(-1); // This is actually just a guess...
                ref.setContainment(true);
                EAnnotation ann = EcoreFactory.eINSTANCE.createEAnnotation();
                ann.setSource("fetch");
                ann.getDetails().put("file", filePattern);
                ref.getEAnnotations().add(ann);
                clazz.getEStructuralFeatures().add(ref);
            }
            contextTypeMap.put(contextType, clazz);
        }
        return clazz;
    }
    
    private EClass map(DocumentType documentType) {
        EClass clazz = documentTypeMap.get(documentType);
        if (clazz == null) {
            List<EClass> classes = new ArrayList<EClass>();
            for (EClass in : (List<EClass>)documentType.getRootRefObjectTypes()) {
                classes.add(map(in));
            }
            // TODO: if there are multiple classes, we should get the commons superclass
            clazz = classes.size() == 1 ? classes.get(0) : EcorePackage.eINSTANCE.getEObject();
            documentTypeMap.put(documentType, clazz);
        }
        return clazz;
    }
    
    private EDataType map(EDataType in) {
        if (in.getEPackage() == EcorePackage.eINSTANCE) {
            return in;
        }
        EDataType out = dataTypeMap.get(in);
        if (out == null) {
            if (in instanceof EEnum) {
                out = EcoreFactory.eINSTANCE.createEEnum();
            } else {
                out = EcoreFactory.eINSTANCE.createEDataType();
            }
            out.setName(in.getName());
            map(in.getEPackage()).getEClassifiers().add(out);
            dataTypeMap.put(in, out);
            if (in instanceof EEnum) {
                EEnum inEnum = (EEnum)in;
                EEnum outEnum = (EEnum)out;
                for (EEnumLiteral inLiteral : (List<EEnumLiteral>)inEnum.getELiterals()) {
                    EEnumLiteral outLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
                    outLiteral.setName(inLiteral.getName());
                    outLiteral.setValue(inLiteral.getValue());
                    outLiteral.setLiteral(inLiteral.getLiteral());
                    outEnum.getELiterals().add(outLiteral);
                }
            }
        }
        return out;
    }
    
    public EClass map(EClass in) {
        EClass out = classMap.get(in);
        if (out == null) {
            out = EcoreFactory.eINSTANCE.createEClass();
            map(in.getEPackage()).getEClassifiers().add(out);
            out.setName(in.getName());
            classMap.put(in, out);
            for (EClass superType : (List<EClass>)in.getESuperTypes()) {
                out.getESuperTypes().add(map(superType));
            }
            for (EStructuralFeature feature : (List<EStructuralFeature>)in.getEStructuralFeatures()) {
                out.getEStructuralFeatures().add(map(feature));
            }
        }
        return out;
    }
    
    private EClassifier map(EClassifier in) {
        if (in instanceof EDataType) {
            return map((EDataType)in);
        } else {
            return map((EClass)in);
        }
    }
    
    private EStructuralFeature map(EStructuralFeature in) {
        if (in == null) {
            return null;
        }
        EStructuralFeature out = featureMap.get(in);
        if (out == null) {
            if (in instanceof EAttribute) {
                out = EcoreFactory.eINSTANCE.createEAttribute();
            } else if (in instanceof EReference) {
                out = EcoreFactory.eINSTANCE.createEReference();;
            }
            out.setName(in.getName());
            out.setLowerBound(in.getLowerBound());
            out.setUpperBound(in.getUpperBound());
            // Need to put this into the map early to avoid infinite recursion
            featureMap.put(in, out);
            out.setEType(map(in.getEType()));
            if (in instanceof EReference) {
                EReference inRef = (EReference)in;
                EReference outRef = (EReference)out;
                outRef.setContainment(inRef.isContainment());
                outRef.setEOpposite((EReference)map(inRef.getEOpposite()));
            }
        }
        return out;
    }
}
