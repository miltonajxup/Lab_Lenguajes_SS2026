/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tokens;

/**
 *
 * @author milton
 */
public class Token {
    
    private final int numero;
    private final TipoToken tipo;
    private final String lexema;
    private final int fila;
    private final int columna;

    public Token(int numero, TipoToken tipo, String lexema, int fila, int columna) {
        this.numero = numero;
        this.tipo = tipo;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public int getNumero() {
        return numero;
    }

    public TipoToken getTipo() {
        return tipo;
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
