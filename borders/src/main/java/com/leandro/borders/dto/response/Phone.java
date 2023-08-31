package com.leandro.borders.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leandro.borders.dto.enumerable.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone {
    private Long id;
    private String area;
    private String number;
    private Country country;
    private PhoneType type;
    private Long personId;
}

