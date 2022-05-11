package com.ceiba.infraestructura.error;

public class Error {
    
    private String nombreExcepcion;
    private String mensaje;


    private String codigoExcepcion;
    
    public Error(String nombreExcepcion, String mensaje, String codigoExcepcion) {
        this.nombreExcepcion = nombreExcepcion;
        this.mensaje = mensaje;
        this.codigoExcepcion = codigoExcepcion;
    }

    public String getNombreExcepcion() {
        return nombreExcepcion;
    }

    public String getMensaje() {
        return mensaje;
    }


    public String getCodigoExcepcion() {
        return codigoExcepcion;
    }
}
