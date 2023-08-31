package com.leandro.borders.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leandro.borders.dto.enumerable.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private Long id;
    private String name;
    private List<Document> documents;
    private List<Phone> phones;
    private List<Address> addresses;
    private PersonType type;
}
