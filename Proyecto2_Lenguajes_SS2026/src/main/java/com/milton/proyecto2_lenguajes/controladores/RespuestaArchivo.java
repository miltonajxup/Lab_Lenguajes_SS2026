/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.controladores;

/**
 *
 * @author milton
 */
public class RespuestaArchivo {
    
    private final boolean valido;
    private final String mensaje;
    private int lineas;

    public RespuestaArchivo(boolean valido, String mensaje) {
        this.valido = valido;
        this.mensaje = mensaje;
    }

    public RespuestaArchivo(boolean valido, String mensaje, int lineas) {
        this.valido = valido;
        this.mensaje = mensaje;
        this.lineas = lineas;
    }

    public boolean isValido() {
        return valido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getLineas() {
        return lineas;
    }
    
}
