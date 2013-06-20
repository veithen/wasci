import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ParserException;

import com.github.veithen.ramsay.report.Column;
import com.github.veithen.ramsay.report.Rows;

public class RowsHandler extends RowSourceHandler {
    private final List<ColumnHandler> columnHandlers;
    
    public RowsHandler(ContainerHandler parent, Rows rows) throws ParserException {
        super(parent, rows);
        EList<Column> columns = rows.getColumns();
        columnHandlers = new ArrayList<ColumnHandler>(columns.size());
        for (Column column : columns) {
            columnHandlers.add(new ColumnHandler(this, column));
        }
    }

    @Override
    protected void executeChildren(TableSink sink) {
        for (ColumnHandler columnHandler : columnHandlers) {
            columnHandler.execute(sink);
        }
    }
}
