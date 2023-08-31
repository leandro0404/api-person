package com.leandro.borders.usecases;

import com.leandro.borders.core.usecase.UseCase;
import com.leandro.borders.dto.request.PersonByIds;
import com.leandro.borders.dto.response.Person;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FindPeopleByIdsUseCase extends UseCase<PersonByIds,Mono<List<Person>>> {

}
