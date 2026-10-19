/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador.simbolos;

import com.milton.proyecto2_lenguajes.compilador.reglas.Ambito;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoSimbolo;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;

/**
 *
 * @author milton
 */
public class Simbolo {
    
    private final String nombre;
    private final TipoSimbolo tipoSimbolo;
    private final Ambito ambito;
    private final TipoToken tipoToken;
    private final int fila;
    private final int columna;
    private final String valor;

    public Simbolo(String nombre, TipoSimbolo tipo, Ambito ambito, TipoToken tipoToken, int fila, int columna, String valor) {
        this.nombre = nombre;
        this.tipoSimbolo = tipo;
        this.ambito = ambito;
        this.tipoToken = tipoToken;
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

    public Simbolo(String nombre, TipoSimbolo tipo, Ambito ambito, TipoToken tipoToken, int fila, int columna) {
        this.nombre = nombre;
        this.tipoSimbolo = tipo;
        this.ambito = ambito;
        this.tipoToken = tipoToken;
        this.fila = fila;
        this.columna = columna;
        this.valor = null;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoSimbolo getTipoSimbolo() {
        return tipoSimbolo;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public TipoToken getTipoToken() {
        return tipoToken;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getValor() {
        return valor;
    }
    
}
