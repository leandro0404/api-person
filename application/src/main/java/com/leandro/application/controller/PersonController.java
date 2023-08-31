package com.leandro.application.controller;


import com.leandro.borders.dto.Address;
import com.leandro.borders.dto.Document;
import com.leandro.borders.dto.Person;
import com.leandro.borders.dto.Phone;
import com.leandro.borders.usecases.FindDocumentsByPersonIdsUseCase;
import com.leandro.borders.usecases.FindPeopleByIdsUseCase;
import com.leandro.borders.usecases.FindPhonesByPersonIdsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PersonController {

    private final FindPeopleByIdsUseCase findPeopleByIdsUseCase;
    private final FindPhonesByPersonIdsUseCase findPhonesByPersonIdsUseCase;
    private final FindDocumentsByPersonIdsUseCase findDocumentsByPersonIdsUseCase;

    @QueryMapping
    public List<Person> people(@Argument List<Long> ids) {
        return findPeopleByIdsUseCase.execute(ids);
    }


    @BatchMapping
    public Map<Person, List<Phone>> phones(List<Person> persons) {
        log.info("Fetching phones for persons {} ", persons);
        return findPhonesByPersonIdsUseCase.execute(persons);
    }

    @BatchMapping
    public Map<Person, List<Document>> documents(List<Person> persons) {
        log.info("Fetching documents for persons {} ", persons);
        return findDocumentsByPersonIdsUseCase.execute(persons);
    }

}

