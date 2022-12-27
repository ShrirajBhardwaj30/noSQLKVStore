package dao;

import java.util.ArrayList;
import java.util.List;

public abstract class AndSearchable {

    protected abstract List<Document> getAllDocuments();

    public List<Document> search(String key, DocumentDatatype value) {
        List<Document> documents = this.getAllDocuments();
        List<Document> filtered = new ArrayList<>();
        for (Document document: documents) {
            if (document.search(key, value)) {
                filtered.add(document);
            }
        }
        return filtered;
    }

    public List<Document> search(Document doc) {
        List<Document> documents = this.getAllDocuments();
        List<Document> filtered = new ArrayList<>();
        for (Document document: documents) {
            if (document.find(doc)) {
                filtered.add(document);
            }
        }
        return filtered;
    }
}
