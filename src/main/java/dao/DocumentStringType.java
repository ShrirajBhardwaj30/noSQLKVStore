package dao;

import java.util.Objects;

public class DocumentStringType implements DocumentDatatype {
    private String value;

    public DocumentStringType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean find(DocumentDatatype value) {
        if (!(value instanceof DocumentStringType)) {
            return false;
        }

        DocumentStringType val1 = (DocumentStringType) value;
        return val1.getValue().equals(this.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentStringType that = (DocumentStringType) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
