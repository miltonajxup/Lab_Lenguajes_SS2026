/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSintactico;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
import com.milton.proyecto2_lenguajes.controladores.ResultadoAnalisis;
import com.milton.proyecto2_lenguajes.controladores.ResultadoReportes;
import com.milton.proyecto2_lenguajes.resultados.OrdenarResultados;
import com.milton.proyecto2_lenguajes.resultados.ControladorPromt;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControladorAnalisis {
    
    private List<Token> tokens;
    private List<Token> errores;
    private List<ErrorSintactico> erroresSint;
    private NodoArbol programa;
    private List<Simbolo> simbolos;
    private ResultadoAnalisis resultado;
    private ResultadoReportes resultadoReporte;

    public NodoArbol getPrograma() {
        return programa;
    }

    public ResultadoAnalisis getResultado() {
        return resultado;
    }

    public ResultadoReportes getResultadoReporte() {
        return resultadoReporte;
    }
    
    public void analizar(BufferedReader reader) throws IOException {
        tokens = new ArrayList<>();
        errores = new ArrayList<>();
        erroresSint = new ArrayList<>();
        simbolos = new ArrayList<>();
        
        AnalizadorLexico analizador = new AnalizadorLexico(reader);
        
        Token token;
        while ( (token = analizador.yylex()) != null ) {
            if (token.getTipo() == TipoToken.ERROR) {
                errores.add(token);
            } else {
                tokens.add(token);
            }
        }
        
        programa = new NodoArbol(TipoToken.PROGRAMA, "Programa Promtzal");
        
        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(tokens, erroresSint, programa, simbolos);
        analizadorSintactico.analizar();
        
        ControladorPromt promt = new ControladorPromt();
        promt.generarPromtzal(programa);
        
        OrdenarResultados ordenar = new OrdenarResultados();
        String[][] erroresSintacticos = ordenar.ordenarErroresSintacticos(erroresSint);
        String[][] erroresLexicos = ordenar.ordenarErroresLexicos(errores);
        String[][] simbolosEncontrados = ordenar.ordenarSimbolos(simbolos);
        
        resultado = new  ResultadoAnalisis(promt.getPromt(), erroresSintacticos, erroresLexicos, simbolosEncontrados);
        resultadoReporte = new ResultadoReportes(promt.getPromt(), programa, errores, erroresSint, simbolos);
        
    }
    
}
