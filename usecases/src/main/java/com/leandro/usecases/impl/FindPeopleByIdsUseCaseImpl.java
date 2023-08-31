package com.leandro.usecases.impl;

import com.leandro.borders.dto.Person;
import com.leandro.borders.repository.PersonRepository;
import com.leandro.borders.usecases.FindPeopleByIdsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPeopleByIdsUseCaseImpl implements FindPeopleByIdsUseCase {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> execute(List<Long> ids) {
        return personRepository.findPeopleByIds(ids);
    }
}