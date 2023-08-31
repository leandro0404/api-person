package com.leandro.borders.usecases;

import com.leandro.borders.dto.Person;
import com.leandro.borders.dto.Phone;

import java.util.List;
import java.util.Map;

public interface FindPhonesByPersonIdsUseCase {
    Map<Person, List<Phone>> execute(List<Person> persons);
}
