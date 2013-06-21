
public interface TableSink {
    void startRow() throws TableSinkException;
    void writeColumn(Object value) throws TableSinkException;
    void endRow() throws TableSinkException;
}
