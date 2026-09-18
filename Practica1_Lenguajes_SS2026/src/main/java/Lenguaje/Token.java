/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lenguaje;

/**
 *
 * @author milton
 */
public class Token {
    
    private final int numero;
    private final PalabraReservada palabra;
    private final String lexema;
    private final int fila;
    private final int columna;

    public Token(int numero, PalabraReservada palabra, String lexema, int fila, int columna) {
        this.numero = numero;
        this.palabra = palabra;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public int getNumero() {
        return numero;
    }

    public TipoToken getTipo() {
        return palabra.getTipo();
    }
    
    public String getColorCss() {
        return palabra.getColorCss();
    }

    public String getLexema() {
        return lexema;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
}
