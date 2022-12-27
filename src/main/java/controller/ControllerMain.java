package controller;

import dao.IndexException;
import services.CRUDService;
import services.DocumentBuilder;

import dao.Document;
import services.DocumentDataTypeBuilder;
import services.SearchService;

import java.util.Arrays;
import java.util.List;

public class ControllerMain {
    public static void main(String []args) throws IndexException {
        Document doc =
                (new DocumentBuilder())
                .addString("a", "shriraj")
                .addInteger("b", 1)
                .addArray("c", Arrays.asList("a", "b", "c"))
                .addDocument("d", (new DocumentBuilder()).addInteger("a", 1).build())
                .build();

        Document doc2 =
                (new DocumentBuilder())
                        .addString("a", "shriraj")
                        .addInteger("b", 1)
                        .addArray("c", Arrays.asList("a", "b", "c"))
                        .addDocument("d", (new DocumentBuilder()).addInteger("a", 1).build())
                        .build();

        CRUDService.addDocument("firstDocument", doc);
        CRUDService.addIndex("a", doc);
        CRUDService.addDocument("secondDocument", doc2);

        CRUDService.removeDocument("firstDocument");

        List<Document> docs = SearchService.search("b", DocumentDataTypeBuilder.buildInteger(1));
        System.out.println(docs.size());

        Document doc2SearchDoc = (new DocumentBuilder())
                .addString("a", "shriraj")
                .addString("c", "a")
                .addDocument("d", (new DocumentBuilder()).addInteger("a", 1).build()).build();

        List<Document> doc2search = SearchService.search(doc2SearchDoc);
        System.out.println(doc2search.size());

    }
}
