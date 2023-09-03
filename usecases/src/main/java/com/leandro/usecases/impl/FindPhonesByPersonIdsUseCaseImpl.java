package com.leandro.usecases.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.leandro.borders.dto.response.Person;
import com.leandro.borders.dto.response.Phone;
import com.leandro.borders.repository.PhoneRepository;
import com.leandro.borders.usecases.FindPhonesByPersonIdsUseCase;
import com.leandro.core.usecase.impl.UseCaseBase;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindPhonesByPersonIdsUseCaseImpl
        extends UseCaseBase<List<Person>, Mono<Map<Person, List<Phone>>>>
        implements FindPhonesByPersonIdsUseCase {

    private final PhoneRepository phoneRepository;

    @Override
    protected Mono<Map<Person, List<Phone>>> onExecute(List<Person> people) {

        var ids = people.stream().map(Person::getId).toList();
        return phoneRepository.findPhonesByPersonIdsAsync(ids)
                .map(phones -> generateEntitiesForIds(people, phones, Person::getId,
                        Phone::getPersonId));

    }
}
