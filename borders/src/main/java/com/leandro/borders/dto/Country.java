package com.leandro.borders.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Country {
    private String iso;
    private String code;
    private String name;
}
