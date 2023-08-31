package com.leandro.usecases.impl;

import com.leandro.borders.dto.Country;
import com.leandro.borders.dto.Person;
import com.leandro.borders.dto.Phone;
import com.leandro.borders.dto.enumerable.PhoneType;
import com.leandro.borders.usecases.FindPhonesByPersonIdsUseCase;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FindPhonesByPersonIdsUseCaseImpl implements FindPhonesByPersonIdsUseCase {


    @Override
    public Map<Person, List<Phone>> execute(List<Person> persons) {
        return generatePhonesForPersonIds(persons);
    }

    public static Map<Person, List<Phone>> generatePhonesForPersonIds(List<Person> persons) {
        var phoneMap = new HashMap<Person, List<Phone>>();
        persons.forEach(person -> {
            List<Phone> phones = new ArrayList<>();
            phones.add(new Phone(person.getId(),
                    "31",
                    UUID.randomUUID().toString(),
                    new Country("BR", "55", "Brazil"),
                    PhoneType.PERSONAL
            ));
            phoneMap.put(person, phones);
        });
        return phoneMap;
    }
}
