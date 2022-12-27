package services;

import dao.AndSearchable;
import dao.Document;
import dao.DocumentCollection;
import dao.DocumentDatatype;

import java.util.List;

public class SearchService {

    public static List<Document> search(String key, DocumentDatatype value) {
        AndSearchable andSearchable = (DocumentCollection.getInstance());
        return andSearchable.search(key, value);
    }

    public static List<Document> search(Document document) {
        AndSearchable andSearchable = (DocumentCollection.getInstance());
        return andSearchable.search(document);

    }
}
