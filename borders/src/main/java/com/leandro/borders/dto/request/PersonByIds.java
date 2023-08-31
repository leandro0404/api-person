package com.leandro.borders.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonByIds {
    private List<Long> ids ;
}
