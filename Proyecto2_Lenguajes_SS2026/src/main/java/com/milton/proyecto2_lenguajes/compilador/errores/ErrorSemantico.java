/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador.errores;

/**
 *
 * @author milton
 */
public class ErrorSemantico {
    
    private final String mensaje;
    private final int fila;
    private final int columna;

    public ErrorSemantico(String mensaje, int fila, int columna) {
        this.mensaje = mensaje;
        this.fila = fila;
        this.columna = columna;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
}
