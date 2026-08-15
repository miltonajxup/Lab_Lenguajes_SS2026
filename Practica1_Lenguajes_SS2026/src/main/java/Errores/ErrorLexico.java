/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Errores;

/**
 *
 * @author milton
 */
public class ErrorLexico {
    
    private final int numero;
    private final String errorLexico;
    private final String descripcion;
    private final int fila;
    private final int columna;

    public ErrorLexico(int numero, String errorLexico, String descripcion, int fila, int columna) {
        this.numero = numero;
        this.errorLexico = errorLexico;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    public int getNumero() {
        return numero;
    }

    public String getErrorLexico() {
        return errorLexico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
}
