import org.eclipse.ocl.ParserException;

import com.github.veithen.ramsay.report.RowGroup;

public class RowGroupHandler extends RowSourceHandler {
    private final RowContainerHandlerSupport rowContainerHandlerSupport;
    
    public RowGroupHandler(ContainerHandler parent, RowGroup rowGroup) throws ParserException {
        super(parent, rowGroup);
        rowContainerHandlerSupport = new RowContainerHandlerSupport(this, rowGroup.getRowSources());
    }

    @Override
    protected void executeChildren(TableSink sink) throws ReportExecutionException, TableSinkException {
        rowContainerHandlerSupport.executeChildren(sink);
    }
}
