package com.ceiba.infraestructura.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;



public interface MapperResult {

	default LocalDate extraerLocalDate(ResultSet resultSet, String label) throws SQLException {
        Timestamp fecha = resultSet.getTimestamp(label);
        LocalDate resultado = null;
        if (!resultSet.wasNull()) {
            resultado = fecha.toLocalDateTime().toLocalDate();
        }
        return resultado;
    } 
	
	default LocalDateTime extraerLocalDateTime(ResultSet resultSet, String label) throws SQLException {
        Timestamp fecha = resultSet.getTimestamp(label);
        LocalDateTime resultado = null;
        if (!resultSet.wasNull()) {
            resultado = fecha.toLocalDateTime();
        }
        return resultado;
    }

    default Long diffDays(ResultSet resultset, String label) throws SQLException {


        Timestamp fecha = resultset.getTimestamp(label);
        Timestamp fechaactual = new Timestamp(System.currentTimeMillis());

        return (fechaactual.getTime() - fecha.getTime())/86400000;


    }

    default String valueCalculate( String value,  Long days) {

        Double valued = Double.valueOf(value);

        if ( days == null || days == 0 || (30 < days && 90 >= days)) {

            valued = valued - (valued * 0.05);

        }

        else if(90 < days && 180 >= days) {
            valued = valued - (valued * 0.1);
        }
        else if(180 < days && 365 >= days) {
            valued = valued - (valued * 0.3);
        }

        else if ( 365 < days) {
            valued = valued - (valued * 0.5);
        }


        return String.valueOf(valued);
    }


}
