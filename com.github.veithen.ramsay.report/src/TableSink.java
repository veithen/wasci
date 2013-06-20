
public interface TableSink {
    void startRow();
    void writeColumn(Object value);
    void endRow();
}
