/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.lenguaje;

/**
 *
 * @author milton
 */
public class Token {
    
    private final TipoToken tipo;
    private final String lexema;
    private String descripcion;

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public Token(TipoToken tipo, String lexema, String descripcion) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.descripcion = descripcion;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
