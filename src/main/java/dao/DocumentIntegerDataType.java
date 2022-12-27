package dao;

import java.util.Objects;

public class DocumentIntegerDataType implements DocumentDatatype  {
    private Integer value;

    public DocumentIntegerDataType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean find(DocumentDatatype value) {
        if (!(value instanceof DocumentIntegerDataType)) {
            return false;
        }

        DocumentIntegerDataType val1 = (DocumentIntegerDataType) value;
        return val1.getValue().equals(this.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentIntegerDataType that = (DocumentIntegerDataType) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
