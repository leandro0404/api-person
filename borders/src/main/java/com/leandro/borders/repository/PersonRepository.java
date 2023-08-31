package com.leandro.borders.repository;

import com.leandro.borders.dto.response.Person;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonRepository {

    Mono<List<Person>> findPeopleByIdsAsync(List<Long> ids);
}
