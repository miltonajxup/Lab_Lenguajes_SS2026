/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.controladores;

/**
 *
 * @author milton
 */
public class ResultadoAnalisis {
    
    private final String promt;
    private final String erroresSintacticos;
    private final String arbol;

    public ResultadoAnalisis(String promt, String erroresSintacticos, String arbol) {
        this.promt = promt;
        this.erroresSintacticos = erroresSintacticos;
        this.arbol = arbol;
    }

    public String getPromt() {
        return promt;
    }

    public String getErroresSintacticos() {
        return erroresSintacticos;
    }

    public String getArbol() {
        return arbol;
    }
    
}
