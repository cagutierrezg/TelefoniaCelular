package com.ceiba.clientes.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.servicio.testdatabuilder.ClientesTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class ClientesTest {
    @Test
    @DisplayName("Deberia crear correctamente el cliente")
    void deberiaCrearCorrectamenteElCliente() {

        LocalDateTime fechaCreacion = LocalDateTime.now();
        // arrange
        Clientes clientes = new ClientesTestDataBuilder().conStartDate(fechaCreacion).build();
        //assert
        assertEquals(3, clientes.getId());
        assertEquals("CC", clientes.getDocumentType());
        assertEquals("106548941", clientes.getDocumentNumber());
        assertEquals("Alejandro", clientes.getClientName());
        assertEquals("3456218741", clientes.getPhoneNumber());
        assertEquals("1", clientes.getPlanId());
        assertEquals("30.000", clientes.getPlanValue());
        assertEquals(fechaCreacion, clientes.getStartDate());
    }

    @Test
    void deberiaFallarSinTipoDeDocumento() {

        //Arrange
        ClientesTestDataBuilder clientesTestDataBuilder = new ClientesTestDataBuilder().conDocumentType(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clientesTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de documento");
    }

     @Test
     void deberiaFallarSinFechaInicio() {

         //Arrange
         ClientesTestDataBuilder clientesTestDataBuilder = new ClientesTestDataBuilder().conStartDate(null).conId(1L);
         //act-assert
         BasePrueba.assertThrows(() -> {
                     clientesTestDataBuilder.build();
                 },
                 ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de inicio");
     }

    @Test
    void deberiaFallarSinNumeroDeDocumento() {

        //Arrange
        ClientesTestDataBuilder clientesTestDataBuilder = new ClientesTestDataBuilder().conDocumentNumber(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clientesTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el n??mero de documento");
    }

    @Test
    void deberiaFallarSinNombreDeCliente() {

        //Arrange
        ClientesTestDataBuilder clientesTestDataBuilder = new ClientesTestDataBuilder().conClientName(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    clientesTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente");
    }

}
