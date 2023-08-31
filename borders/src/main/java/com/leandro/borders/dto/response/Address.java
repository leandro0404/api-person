package com.leandro.borders.dto;

import com.leandro.borders.dto.enumerable.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private Long id;
    private String zipCode;
    private String state;
    private String city;
    private String district;
    private String street;
    private String number;
    private String complement;
    private AddressType type;
    private Country Country;
}
