package com.leandro.usecases.impl;

import com.leandro.borders.dto.Document;
import com.leandro.borders.dto.Person;
import com.leandro.borders.dto.enumerable.DocumentType;
import com.leandro.borders.usecases.FindDocumentsByPersonIdsUseCase;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FindDocumentsByPersonIdsUseCaseImpl implements FindDocumentsByPersonIdsUseCase {

    @Override
    public Map<Person, List<Document>> execute(List<Person> persons) {
        return generateDocumentsForPersonIds(persons);
    }

    public static Map<Person, List<Document>> generateDocumentsForPersonIds(List<Person> persons) {
        var documentMap = new HashMap<Person, List<Document>>();
        persons.forEach(person -> {
            List<Document> documents = new ArrayList<>();
            documents.add(new Document(person.getId(),
                    UUID.randomUUID().toString(),
                    DocumentType.CPF
            ));
            documentMap.put(person, documents);
        });
        return documentMap;
    }
}
