/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador.ast;

import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class NodoArbol {
    
    private final TipoToken tipo;
    private final String valor;
    private final List<NodoArbol> hijos;
    
    public NodoArbol(TipoToken tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
        hijos = new ArrayList<>();
    }
    
    public TipoToken getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public List<NodoArbol> getHijos() {
        return hijos;
    }
    
    public void agregarHijo(NodoArbol hijo) {
        hijos.add(hijo);
    }
    
}
