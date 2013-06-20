import java.util.Collection;
import java.util.Iterator;

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
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCL.Query;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;

import com.github.veithen.ramsay.report.RowSource;

public abstract class RowSourceHandler extends ContainerHandler {
    private final ContainerHandler parent;
    private final Query query;
    private final Environment<EPackage,EClassifier,EOperation,EStructuralFeature,EEnumLiteral,EParameter,EObject,CallOperationAction,SendSignalAction,Constraint,EClass,EObject> environment;
    private final String varName;
    private EObject current;
    
    public RowSourceHandler(ContainerHandler parent, RowSource rowSource) throws ParserException {
        this.parent = parent;
        OCL ocl = OCL.newInstance(parent.getEnvironment());
        Helper helper = ocl.createOCLHelper();
        OCLExpression expression = helper.createQuery(rowSource.getExpression());
        query = ocl.createQuery(expression);
        
        environment = parent.getEnvironment().getFactory().createEnvironment(parent.getEnvironment());
        Variable variable = EcoreFactory.eINSTANCE.createVariable();
        variable.setType(((CollectionType)expression.getType()).getElementType());
        varName = rowSource.getVar();
        environment.addElement(varName, variable, true);
    }

    @Override
    public Environment<EPackage,EClassifier,EOperation,EStructuralFeature,EEnumLiteral,EParameter,EObject,CallOperationAction,SendSignalAction,Constraint,EClass,EObject> getEnvironment() {
        return environment;
    }

    @Override
    public void populate(EvaluationEnvironment<EClassifier,?,?,EClass,EObject> evalEnvironment) {
        parent.populate(evalEnvironment);
        evalEnvironment.add(varName, current);
    }

    public void execute(TableSink sink) {
        EvaluationEnvironment<EClassifier,?,?,EClass,EObject> evalEnvironment = query.getEvaluationEnvironment();
        evalEnvironment.clear();
        parent.populate(evalEnvironment);
        for (Iterator<?> it = ((Collection<?>)query.evaluate()).iterator(); it.hasNext(); ) {
            current = (EObject)it.next();
            executeChildren(sink);
        }
    }
    
    protected abstract void executeChildren(TableSink sink);
}
