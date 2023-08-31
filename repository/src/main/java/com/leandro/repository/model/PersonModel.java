package com.leandro.repository.model;

import com.leandro.repository.model.enumerator.PersonModelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person")
    private List<DocumentModel> documents;

    @OneToMany(mappedBy = "person")
    private List<PhoneModel> phones;

    @Enumerated(EnumType.STRING)
    private PersonModelType type;

}
