package com.ceiba.clientes.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoClientes {

    private Long id;
    private String documentType;
    private String documentNumber;
    private String clientName;
    private String phoneNumber;
    private String namePlan;
    private String valuePlan;
    private Long time;


}
