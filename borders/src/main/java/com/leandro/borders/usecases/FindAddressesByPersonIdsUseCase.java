package com.leandro.borders.usecases;

import com.leandro.borders.core.usecase.UseCase;
import com.leandro.borders.dto.response.Address;
import com.leandro.borders.dto.response.Person;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

public interface FindAddressesByPersonIdsUseCase extends UseCase<List<Person>, Mono<Map<Person, List<Address>>>> {
}
