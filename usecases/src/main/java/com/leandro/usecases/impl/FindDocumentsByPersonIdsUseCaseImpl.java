package com.leandro.usecases.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.leandro.borders.dto.response.Document;
import com.leandro.borders.dto.response.Person;
import com.leandro.borders.repository.DocumentRepository;
import com.leandro.borders.usecases.FindDocumentsByPersonIdsUseCase;
import com.leandro.core.usecase.impl.UseCaseBase;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindDocumentsByPersonIdsUseCaseImpl extends UseCaseBase<List<Person>, Mono<Map<Person, List<Document>>>>
        implements FindDocumentsByPersonIdsUseCase {

    private final DocumentRepository documentRepository;

    @Override
    protected Mono<Map<Person, List<Document>>> onExecute(List<Person> people) {
        var ids = people.stream().map(Person::getId).toList();
        return documentRepository.findDocumentsByPersonIdsAsync(ids)
                .map(documents -> generateEntitiesForIds(people, documents, Person::getId, Document::getPersonId));
    }
}
