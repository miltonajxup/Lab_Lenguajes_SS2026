/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.resultados;

import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSintactico;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
import java.util.List;

/**
 *
 * @author milton
 */

public class OrdenarResultados {
    
    public String[][] ordenarErroresSintacticos(List<ErrorSintactico> sintacticos) {
        String[][] errores = new String[sintacticos.size()][3];
        int i = 0;
        for (ErrorSintactico error: sintacticos) {
            errores[i][0] = error.getMensaje();
            errores[i][1] = String.valueOf(error.getFila());
            errores[i][2] = String.valueOf(error.getColumna());
            i++;
        }
        return errores;
    }
    
    public String[][] ordenarErroresLexicos(List<Token> lexicos) {
        String[][] errores = new String[lexicos.size()][4];
        int i = 0;
        for (Token error : lexicos) {
            errores[i][0] = error.getDescripcion();
            errores[i][2] = error.getLexema();
            errores[i][3] = String.valueOf(error.getFila());
            errores[i][4] = String.valueOf(error.getColumna());
            i++;
        }
        return errores;
    }
    
    public String[][] ordenarSimbolos(List<Simbolo> simbolos) {
        String[][] valores = new String[simbolos.size()][6];
        int i = 0;
        for (Simbolo simbolo : simbolos) {
            valores[i][0] = simbolo.getNombre();
            valores[i][1] = simbolo.getTipoSimbolo().name();
            valores[i][2] = simbolo.getAmbito().name();
            valores[i][3] = simbolo.getTipoToken().name();
            valores[i][4] = String.valueOf(simbolo.getFila());
            valores[i][5] = String.valueOf(simbolo.getColumna());
            i++;
        }
        return valores;
    }
    
}
