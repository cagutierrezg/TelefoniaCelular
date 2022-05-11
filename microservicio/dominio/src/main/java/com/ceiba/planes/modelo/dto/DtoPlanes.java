package com.ceiba.planes.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class DtoPlanes {

    private Long id;
    private String planName;
    private String planValue;
    private String planSpecification;
}
