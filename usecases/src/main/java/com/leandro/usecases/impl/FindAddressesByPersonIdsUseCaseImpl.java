package com.leandro.usecases.impl;

import com.leandro.borders.dto.response.Address;
import com.leandro.borders.dto.response.Person;
import com.leandro.borders.repository.AddressRepository;
import com.leandro.borders.usecases.FindAddressesByPersonIdsUseCase;
import com.leandro.core.usecase.impl.UseCaseBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FindAddressesByPersonIdsUseCaseImpl
        extends UseCaseBase<List<Person>, Mono<Map<Person, List<Address>>>>
        implements FindAddressesByPersonIdsUseCase {

    private final AddressRepository addressRepository;

    @Override
    protected Mono<Map<Person, List<Address>>> onExecute(List<Person> people) {
        var ids = people.stream().map(Person::getId).toList();

        return addressRepository.findAddressesByPersonIdsAsync(ids)
                .map(addresses -> generateEntitiesForIds(people, addresses, Person::getId,
                        Address::getPersonId));

    }

}
