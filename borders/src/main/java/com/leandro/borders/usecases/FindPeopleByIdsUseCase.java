package com.leandro.borders.usecases;

import com.leandro.borders.dto.Person;
import java.util.List;

public interface FindPeopleByIdsUseCase {
    List<Person> execute(List<Long> ids);
}
