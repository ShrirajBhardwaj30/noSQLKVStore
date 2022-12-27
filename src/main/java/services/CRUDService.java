package services;

import dao.Document;
import dao.DocumentCollection;
import dao.DocumentDatatype;
import dao.IndexException;

public class CRUDService {
    public static void addDocument(String key, Document document) throws IndexException {
        DocumentCollection.getInstance().addDocument(key, document);
    }

    public static void addIndex(String key, Document data) throws IndexException {
        DocumentCollection.getInstance().addIndex(key, data.getDocument(key), data);
    }

    public static void removeDocument(String key) {
        DocumentCollection.getInstance().removeDocument(key);
    }

    public static void getDocument(String key) {
        DocumentCollection.getInstance().getDocument(key);
    }

    public static void updateDocument(String key, Document document) throws IndexException {
        DocumentCollection.getInstance().addDocument(key, document);
    }

    public static void addKeyValuePair(String dockey, String key, DocumentDatatype value) throws IndexException {
        DocumentCollection.getInstance().upsertKeyValuePair(dockey, key, value);
    }

    public static void updateKeyValuePair(String dockey, String key, DocumentDatatype value) throws IndexException {
        DocumentCollection.getInstance().upsertKeyValuePair(dockey, key, value);
    }

    public static void removeKeyValuePair(String dockey, String key, DocumentDatatype value) {
        DocumentCollection.getInstance().removeKeyValuePair(dockey, key);
    }
}
