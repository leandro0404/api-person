package com.leandro.borders.repository;

import com.leandro.borders.dto.Person;

import java.util.List;

public interface PersonRepository {

    List<Person> findPeopleByIds(List<Long> ids);
}
