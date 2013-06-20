import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.junit.Test;

import com.github.veithen.ramsay.report.Table;
import com.github.veithen.ramsay.util.EMFUtil;

public class ReportTest {
    @Test
    public void test() throws Exception {
        final ResourceSet resourceSet = new ResourceSetImpl();
        ResourcesPlugin.getWorkspace().getRoot().getProject("test").getFolder("transformed").accept(new IResourceVisitor() {
            @Override
            public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE && resource.getName().endsWith(".ecore")) {
                    EMFUtil.load(resourceSet, (IFile)resource);
                }
                return true;
            }
        });
        EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
        for (Resource resource : resourceSet.getResources()) {
            for (EObject content : resource.getContents()) {
                if (content instanceof EPackage) {
                    EMFUtil.registerPackage(registry, (EPackage)content);
                }
            }
        }
        Resource resource = resourceSet.getResource(URI.createURI("platform:/resource/localhost/test.rrp"), true);
        Table table = (Table)resource.getContents().get(0);
        TableHandler tableHandler = new TableHandler(new EcoreEnvironmentFactory(registry), table);
        
        /*
        EPackage pkg = registry.getEPackage("platform:/resource/test/transformed/com.ibm.websphere.models.config.topology.cell.ecore#/");
        OCL<?,EClassifier,EOperation,EStructuralFeature,?,?,?,?,?,Constraint,?,?> ocl = OCL.newInstance(new EcoreEnvironmentFactory(registry));
        OCLHelper<EClassifier,EOperation,EStructuralFeature,Constraint> helper = ocl.createOCLHelper();
        helper.setContext(pkg.getEClassifier("Cell"));
        OCLExpression<EClassifier> expression = helper.createQuery(
                "self.applications.deployments.deployedObject.oclAsType(appdeployment::ApplicationDeployment).modules->select(m|m.oclIsKindOf(appdeployment::WebModuleDeployment))");
        System.out.println(((SequenceType)expression.getType()).getElementType());
        Query<EClassifier,?,?> query = ocl.createQuery(expression);
        */
        
        Resource dataResource = resourceSet.createResource(URI.createURI("platform:/resource/localhost/transformed/cell.xmi"));
        dataResource.load(null);
        EObject cell = dataResource.getContents().get(1);
        
        tableHandler.setObject(cell);
        tableHandler.execute(null);
        
        /*
        System.out.println(cell);
        System.out.println(query.evaluate(cell));
        */
    }
}
