package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Document implements Searachable, DocumentDatatype {
    private Map<String, DocumentDatatype> document;

    public Document() {
        this.document = new HashMap<String, DocumentDatatype>();
    }

    public void addKey(String key, DocumentDatatype value) {
        this.document.put(key, value);
    }

    public void removeKey(String key) {
        this.document.remove(key);
    }

    public boolean find(DocumentDatatype find) {
        Document value = find instanceof Document ? ((Document) find) : null;
        if (value == null) {
            return false;
        }
        for (String key: value.getKeys()) {
            if (!document.containsKey(key)) {
                return false;
            }
            if (!document.get(key).find(value.getDocument(key))) {
                return false;
            }
        }
        return true;
    }

    public DocumentDatatype getDocument(String key) {
        if (document.containsKey(key)) {
            return document.get(key);
        }
        return null;
    }

    public Set<String> getKeys() {
        return document.keySet();
    }

    public boolean search(String key, DocumentDatatype value) {
        if (document.containsKey(key)) {
            return document.get(key).find(value);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document1 = (Document) o;
        return document.equals(document1.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }
}
