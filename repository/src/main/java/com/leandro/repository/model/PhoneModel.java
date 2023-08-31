package com.leandro.repository.model;

import com.leandro.repository.model.enumerator.PhoneModelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "phone")
@Getter
@Setter
public class PhoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String area;
    private String number;

    @ManyToOne
    private CountryModel country;
    @Enumerated(EnumType.STRING)
    private PhoneModelType type;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonModel person;

}
