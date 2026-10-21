/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.controladores;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSintactico;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
import java.util.List;

/**
 *
 * @author milton
 */
public class ResultadoReportes {
    
    private final String promt;
    private final NodoArbol programa;
    private final List<Token> errores;
    private final List<ErrorSintactico> erroresSint;
    private final List<Simbolo> simbolos;

    public ResultadoReportes(String promt, NodoArbol programa, List<Token> errores, List<ErrorSintactico> erroresSint, List<Simbolo> simbolos) {
        this.promt = promt;
        this.programa = programa;
        this.errores = errores;
        this.erroresSint = erroresSint;
        this.simbolos = simbolos;
    }
    
    public String getPromt() {
        return promt;
    }

    public NodoArbol getPrograma() {
        return programa;
    }

    public List<Token> getErrores() {
        return errores;
    }

    public List<ErrorSintactico> getErroresSint() {
        return erroresSint;
    }

    public List<Simbolo> getSimbolos() {
        return simbolos;
    }
    
}
