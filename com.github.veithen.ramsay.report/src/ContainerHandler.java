import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

public abstract class ContainerHandler {
    public abstract Environment<EPackage,EClassifier,EOperation,EStructuralFeature,EEnumLiteral,EParameter,EObject,CallOperationAction,SendSignalAction,Constraint,EClass,EObject> getEnvironment();
    public abstract void populate(EvaluationEnvironment<EClassifier,?,?,EClass,EObject> evalEnvironment);
}
