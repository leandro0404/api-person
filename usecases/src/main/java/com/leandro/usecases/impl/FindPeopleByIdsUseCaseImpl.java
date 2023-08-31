package com.leandro.usecases.impl;

import com.leandro.borders.dto.request.PersonByIds;
import com.leandro.borders.dto.response.Person;
import com.leandro.borders.repository.PersonRepository;
import com.leandro.borders.usecases.FindPeopleByIdsUseCase;
import com.leandro.core.usecase.impl.UseCaseBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPeopleByIdsUseCaseImpl
        extends UseCaseBase<PersonByIds, Mono<List<Person>>>
        implements FindPeopleByIdsUseCase {

    private final PersonRepository personRepository;

    @Override
    protected Mono<List<Person>> onExecute(PersonByIds personByIds) {
        return personRepository.findPeopleByIdsAsync(personByIds.getIds());
    }
}