import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ParserException;

import com.github.veithen.ramsay.report.RowGroup;
import com.github.veithen.ramsay.report.RowSource;
import com.github.veithen.ramsay.report.Rows;

public class RowContainerHandlerSupport {
    private final List<RowSourceHandler> rowSourceHandlers;
    
    public RowContainerHandlerSupport(ContainerHandler containerHandler, EList<RowSource> rowSources) throws ParserException {
        rowSourceHandlers = new ArrayList<RowSourceHandler>();
        for (RowSource rowSource : rowSources) {
            if (rowSource instanceof RowGroup) {
                rowSourceHandlers.add(new RowGroupHandler(containerHandler, (RowGroup)rowSource));
            } else {
                rowSourceHandlers.add(new RowsHandler(containerHandler, (Rows)rowSource));
            }
        }
    }
    
    public void executeChildren(TableSink sink) throws ReportExecutionException, TableSinkException {
        for (RowSourceHandler rowSourceHandler : rowSourceHandlers) {
            rowSourceHandler.execute(sink);
        }
    }
}
