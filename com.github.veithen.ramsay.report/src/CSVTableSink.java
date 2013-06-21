import java.io.IOException;
import java.io.Writer;

public class CSVTableSink implements TableSink {
    private final Writer out;
    private boolean firstColumn;
    
    public CSVTableSink(Writer out) {
        this.out = out;
    }

    @Override
    public void startRow() throws TableSinkException {
        firstColumn = true;
    }

    @Override
    public void writeColumn(Object value) throws TableSinkException {
        try {
            if (firstColumn) {
                firstColumn = false;
            } else {
                out.write(',');
            }
            if (value instanceof String) {
                String s = (String)value;
                out.write('"');
                for (int i=0, l=s.length(); i<l; i++) {
                    char c = s.charAt(i);
                    if (c == '"') {
                        out.write('"');
                    }
                    out.write(c);
                }
                out.write('"');
            } else if (value != null) {
                out.write(value.toString());
            }
        } catch (IOException ex) {
            throw new TableSinkException(ex);
        }
    }

    @Override
    public void endRow() throws TableSinkException {
        try {
            out.write("\r\n");
        } catch (IOException ex) {
            throw new TableSinkException(ex);
        }
    }
}
