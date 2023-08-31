package com.leandro.repository.impl;

import com.leandro.borders.dto.response.Person;
import com.leandro.borders.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl extends BaseRepository implements PersonRepository {

    @Override
    public Mono<List<Person>> findPeopleByIdsAsync(List<Long> ids) {
        return get(queryParameters("/person", ids), Person.class);
    }
}
