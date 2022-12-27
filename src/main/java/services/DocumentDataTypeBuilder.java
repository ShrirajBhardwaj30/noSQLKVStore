package services;

import dao.DocumentArrayDataType;
import dao.DocumentIntegerDataType;
import dao.DocumentStringType;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentDataTypeBuilder {

    public static DocumentIntegerDataType buildInteger(Integer e) {
        return new DocumentIntegerDataType(e);
    }

    public static DocumentStringType buildString(String e) {
        return new DocumentStringType(e);
    }

    public static DocumentArrayDataType buildArray(List<String> e) {
        return new DocumentArrayDataType(e.stream().map(DocumentStringType::new).collect(Collectors.toList()));
    }
}
