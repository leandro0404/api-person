package com.leandro.borders.dto;

import com.leandro.borders.dto.enumerable.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Document {
    private Long id;
    private String value;
    private DocumentType type;
}
