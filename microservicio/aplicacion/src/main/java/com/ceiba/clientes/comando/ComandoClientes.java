package com.ceiba.clientes.comando;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoClientes {

    private Long id;
    private String documentType;
    private String documentNumber;
    private String clientName;
    private String phoneNumber;
    private String planId;
    private String planValue;
    private LocalDateTime startDate;
}
