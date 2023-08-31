package com.leandro.borders.dto;

import com.leandro.borders.dto.enumerable.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Phone {
    private Long id;
    private String area;
    private String number;
    private Country country;
    private PhoneType type;
}

