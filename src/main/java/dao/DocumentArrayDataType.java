package dao;

import java.util.List;
import java.util.Objects;

public class DocumentArrayDataType implements DocumentDatatype{
    private List<DocumentDatatype> objects;

    public DocumentArrayDataType(List<DocumentDatatype> objects) {
        this.objects = objects;
    }

    public boolean find(DocumentDatatype value) {
        return this.objects.stream().anyMatch(x -> x.find(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentArrayDataType that = (DocumentArrayDataType) o;
        return objects.equals(that.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }
}
