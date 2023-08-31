package com.leandro.borders.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leandro.borders.dto.enumerable.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document {
    private Long id;
    private String value;
    private DocumentType type;
    private Long personId;
}
