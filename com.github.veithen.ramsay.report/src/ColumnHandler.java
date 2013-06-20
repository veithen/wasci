import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCL.Query;

import com.github.veithen.ramsay.report.Column;

public class ColumnHandler {
    private final ContainerHandler parent;
    private final Query query;
    
    public ColumnHandler(ContainerHandler parent, Column column) throws ParserException {
        this.parent = parent;
        OCL ocl = OCL.newInstance(parent.getEnvironment());
        Helper helper = ocl.createOCLHelper();
        OCLExpression expression = helper.createQuery(column.getExpression());
        query = ocl.createQuery(expression);
    }
    
    public void execute(TableSink sink) {
        EvaluationEnvironment<EClassifier,?,?,EClass,EObject> evalEnvironment = query.getEvaluationEnvironment();
        evalEnvironment.clear();
        parent.populate(evalEnvironment);
        System.out.println(query.evaluate());
    }
}
