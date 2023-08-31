package com.leandro.repository.model;

import com.leandro.repository.model.enumerator.DocumentModelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "document")
@Getter
@Setter
public class DocumentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String documentValue;

    @Enumerated(EnumType.STRING)
    private DocumentModelType type;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonModel person;
}
