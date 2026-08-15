/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

/**
 *
 * @author milton
 */
public class ResultadoAnalizado {
    
    private final String resultado;
    private final String error;
    private final int columna;
    private String lexema;

    public ResultadoAnalizado(String resultado, String error, int columna) {
        this.resultado = resultado;
        this.error = error;
        this.columna = columna;
    }

    public ResultadoAnalizado(String resultado, String error, int columna, String lexema) {
        this.resultado = resultado;
        this.error = error;
        this.columna = columna;
        this.lexema = lexema;
    }

    public String getResultado() {
        return resultado;
    }

    public String getError() {
        return error;
    }

    public int getColumna() {
        return columna;
    }

    public String getLexema() {
        return lexema;
    }
    
}
