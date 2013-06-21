import java.util.Collection;

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
    
    public void execute(TableSink sink) throws ReportExecutionException, TableSinkException {
        EvaluationEnvironment<EClassifier,?,?,EClass,EObject> evalEnvironment = query.getEvaluationEnvironment();
        evalEnvironment.clear();
        parent.populate(evalEnvironment);
        Object result = query.evaluate();
        if (result instanceof Collection<?>) {
            Collection<?> collection = (Collection<?>)result;
            switch (collection.size()) {
                case 0:
                    sink.writeColumn(null);
                    break;
                case 1:
                    sink.writeColumn(collection.iterator().next());
                    break;
                default:
                    throw new ReportExecutionException("Column expression returned multiple values");
            }
        } else if (result == parent.getEnvironment().getOCLStandardLibrary().getInvalid()) {
            sink.writeColumn(null);
        } else {
            sink.writeColumn(result);
        }
    }
}
