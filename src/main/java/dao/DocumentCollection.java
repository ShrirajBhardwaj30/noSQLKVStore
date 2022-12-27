package dao;

import utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentCollection extends AndSearchable {
    private Map<String, Document> collection;
    private Map<Pair<String, DocumentDatatype>, Document> index;

    private static DocumentCollection instance;

    protected DocumentCollection() {
        this.collection = new HashMap<>();
        this.index = new HashMap<>();
    }

    public static synchronized DocumentCollection getInstance() {
        if (instance == null) {
           instance = new DocumentCollection();
        }
        return instance;
    }

    public void addIndex(String key, DocumentDatatype data, Document doc) throws IndexException {
        if (this.index.containsKey(new Pair<>(key, data))) {
            throw new IndexException("Index exists for unique key");
        }

        this.index.put(new Pair<>(key, data), doc);
    }

    public void removeIndex(String key, DocumentDatatype data) {
        this.index.remove(new Pair<>(key, data));
    }

    public void addDocument(String docKey, Document doc) throws IndexException {
        for(String key: doc.getKeys()) {
            if (this.index.containsKey(new Pair<>(key, doc.getDocument(key)))) {
                throw new IndexException("Index exists for unique key");
            }
        }
        this.collection.put(docKey, doc);
    }

    public void removeDocument(String key) {
        if (this.collection.containsKey(key)) {
            Document doc = this.collection.get(key);
            for(String k: doc.getKeys()) {
                this.removeIndex(k, doc.getDocument(k));
            }
        }

        this.collection.remove(key);
    }

    public Document getDocument(String key) {
        return this.collection.getOrDefault(key, null);
    }

    public void upsertKeyValuePair(String docKey, String key, DocumentDatatype data) throws IndexException {
        Document document = this.collection.getOrDefault(docKey, new Document());
        if (this.index.containsKey(new Pair<>(key, data))) {
            throw new IndexException("unique index");
        }
        document.addKey(key, data);
    }

    public void removeKeyValuePair(String docKey, String key) {
        Document document = this.collection.getOrDefault(docKey, new Document());
        this.removeIndex(key, document.getDocument(key));
        document.removeKey(key);
    }

    @Override
    protected List<Document> getAllDocuments() {
        return new ArrayList<>(this.collection.values());
    }
}
