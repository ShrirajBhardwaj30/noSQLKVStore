package services;

import dao.Document;
import dao.DocumentArrayDataType;
import dao.DocumentIntegerDataType;
import dao.DocumentStringType;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentBuilder {
    private Document document;

    public DocumentBuilder() {
        document = new Document();
    }

    public Document build() {
        return this.document;
    }

    public DocumentBuilder addInteger(String key, Integer e) {
        document.addKey(key, new DocumentIntegerDataType(e));
        return this;
    }

    public DocumentBuilder addString(String key, String e) {
        document.addKey(key, new DocumentStringType(e));
        return this;
    }

    public DocumentBuilder addDocument(String key, Document d) {
        document.addKey(key, d);
        return this;
    }

    public DocumentBuilder addArray(String key, List<String> e) {
        document.addKey(key,
                new DocumentArrayDataType(e.stream().map(DocumentStringType::new).collect(Collectors.toList())));
        return this;
    }
}
