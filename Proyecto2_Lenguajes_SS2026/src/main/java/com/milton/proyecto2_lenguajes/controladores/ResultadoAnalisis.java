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
    private final String[] columnasErrSint;
    private final String[][] erroresSintacticos;
    private final String[] columnasErrLexicos;
    private final String[][] erroresLexicos;
    private final String[] columnasSimbolos;
    private final String[][] simbolos;

    public ResultadoAnalisis(String promt, String[][] erroresSintacticos, String[][] erroresLexicos, String[][] simbolos) {
        this.promt = promt;
        
        columnasErrSint = new String[3];
        columnasErrSint[0] = "Mensaje";
        columnasErrSint[1] = "Fila";
        columnasErrSint[2] = "Columna";
        this.erroresSintacticos = erroresSintacticos;
        
        columnasErrLexicos = new String[4];
        columnasErrLexicos[0] = "Descripcion";
        columnasErrLexicos[1] = "Lexema";
        columnasErrLexicos[2] = "Fila";
        columnasErrLexicos[3] = "Columna";
        this.erroresLexicos = erroresLexicos;
        
        
        columnasSimbolos = new String[7];
        columnasSimbolos[0] = "Nombre";
        columnasSimbolos[1] = "Tipo de Simbolo";
        columnasSimbolos[2] = "Ambito";
        columnasSimbolos[3] = "Tipo de Token";
        columnasSimbolos[4] = "Fila";
        columnasSimbolos[5] = "Columna";
        columnasSimbolos[6] = "Valor";
        this.simbolos = simbolos;
    }

    public String getPromt() {
        return promt;
    }

    public String[] getColumnasErrSint() {
        return columnasErrSint;
    }

    public String[][] getErroresSintacticos() {
        return erroresSintacticos;
    }

    public String[] getColumnasErrLexicos() {
        return columnasErrLexicos;
    }

    public String[][] getErroresLexicos() {
        return erroresLexicos;
    }

    public String[] getColumnasSimbolos() {
        return columnasSimbolos;
    }

    public String[][] getSimbolos() {
        return simbolos;
    }
    
}
