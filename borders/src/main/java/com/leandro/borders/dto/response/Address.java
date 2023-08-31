package com.leandro.borders.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leandro.borders.dto.enumerable.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private Long personId;
}
