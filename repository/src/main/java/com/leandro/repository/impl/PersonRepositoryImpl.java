package com.leandro.repository.impl;


import com.leandro.borders.dto.Person;
import com.leandro.borders.dto.enumerable.PersonType;
import com.leandro.borders.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonRepositoryImpl implements PersonRepository {


    @Override
    public List<Person> findPeopleByIds(List<Long> ids) {

        var persons = new ArrayList<Person>();
        ids.forEach(x -> persons.add(new Person(x, "name" + x.toString(), List.of(), List.of(), PersonType.INDIVIDUAL)));
        return persons;
    }
}