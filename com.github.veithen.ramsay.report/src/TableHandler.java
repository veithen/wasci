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
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;

import com.github.veithen.ramsay.report.Table;

public class TableHandler extends ContainerHandler {
    private final Environment<EPackage,EClassifier,EOperation,EStructuralFeature,EEnumLiteral,EParameter,EObject,CallOperationAction,SendSignalAction,Constraint,EClass,EObject> environment;
    private final RowContainerHandlerSupport rowContainerHandlerSupport;
    private EObject object;
    
    public TableHandler(EcoreEnvironmentFactory environmentFactory, Table table) throws ParserException {
        environment = environmentFactory.createEnvironment();
        Variable selfVariable = EcoreFactory.eINSTANCE.createVariable();
        selfVariable.setType(table.getType());
        environment.setSelfVariable(selfVariable);
        rowContainerHandlerSupport = new RowContainerHandlerSupport(this, table.getRowSources());
    }

    @Override
    public Environment<EPackage,EClassifier,EOperation,EStructuralFeature,EEnumLiteral,EParameter,EObject,CallOperationAction,SendSignalAction,Constraint,EClass,EObject> getEnvironment() {
        return environment;
    }
    
    public void setObject(EObject object) {
        this.object = object;
    }

    @Override
    public void populate(EvaluationEnvironment<EClassifier,?,?,EClass,EObject> evalEnvironment) {
        evalEnvironment.add("self", object);
    }

    public void execute(TableSink sink) {
        rowContainerHandlerSupport.executeChildren(sink);
    }
}
