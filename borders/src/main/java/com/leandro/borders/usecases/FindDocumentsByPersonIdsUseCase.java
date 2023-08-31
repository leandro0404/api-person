package com.leandro.borders.usecases;

import com.leandro.borders.dto.Document;
import com.leandro.borders.dto.Person;

import java.util.List;
import java.util.Map;

public interface FindDocumentsByPersonIdsUseCase {
    Map<Person, List<Document>> execute(List<Person> persons);
}
