/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.controladores;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSemantico;
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
    private final List<ErrorSemantico> erroresSemanticos;
    private final List<ErrorSintactico> erroresSint;
    private final List<Token> errores;
    private final List<Simbolo> simbolos;

    public ResultadoReportes(String promt, NodoArbol programa, List<ErrorSemantico> erroresSemanticos, List<ErrorSintactico> erroresSint, List<Token> errores, List<Simbolo> simbolos) {
        this.promt = promt;
        this.programa = programa;
        this.erroresSemanticos = erroresSemanticos;
        this.erroresSint = erroresSint;
        this.errores = errores;
        this.simbolos = simbolos;
    }
    
    public String getPromt() {
        return promt;
    }

    public NodoArbol getPrograma() {
        return programa;
    }

    public List<ErrorSemantico> getErroresSemanticos() {
        return erroresSemanticos;
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
