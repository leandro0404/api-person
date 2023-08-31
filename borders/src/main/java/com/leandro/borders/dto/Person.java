package com.leandro.borders.dto;

import com.leandro.borders.dto.enumerable.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private List<Document> documents;
    private List<Phone> phones;
    private PersonType type;
}
