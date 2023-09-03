package com.leandro.application.controller;

import java.util.List;
import java.util.Map;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.leandro.borders.dto.request.PersonByIds;
import com.leandro.borders.dto.response.Address;
import com.leandro.borders.dto.response.Document;
import com.leandro.borders.dto.response.Person;
import com.leandro.borders.dto.response.Phone;
import com.leandro.borders.usecases.FindAddressesByPersonIdsUseCase;
import com.leandro.borders.usecases.FindDocumentsByPersonIdsUseCase;
import com.leandro.borders.usecases.FindPeopleByIdsUseCase;
import com.leandro.borders.usecases.FindPhonesByPersonIdsUseCase;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final FindPeopleByIdsUseCase findPeopleByIdsUseCase;
    private final FindPhonesByPersonIdsUseCase findPhonesByPersonIdsUseCase;
    private final FindDocumentsByPersonIdsUseCase findDocumentsByPersonIdsUseCase;
    private final FindAddressesByPersonIdsUseCase findAddressesByPersonIdsUseCase;

    @QueryMapping
    public Mono<List<Person>> people(@Argument PersonByIds input) {
        return findPeopleByIdsUseCase.execute(input);
    }

    @BatchMapping
    public Mono<Map<Person, List<Phone>>> phones(List<Person> persons) {
        return findPhonesByPersonIdsUseCase.execute(persons);
    }

    @BatchMapping
    public Mono<Map<Person, List<Document>>> documents(List<Person> persons) {
        return findDocumentsByPersonIdsUseCase.execute(persons);
    }

    @BatchMapping
    public Mono<Map<Person, List<Address>>> addresses(List<Person> persons) {
        return findAddressesByPersonIdsUseCase.execute(persons);
    }
}
