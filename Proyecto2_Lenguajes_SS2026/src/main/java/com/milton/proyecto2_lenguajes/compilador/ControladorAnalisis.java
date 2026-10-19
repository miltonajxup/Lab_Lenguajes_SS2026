/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
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
    private NodoArbol programa;
    private List<Simbolo> simbolos;

    public List<Token> getTokens() {
        return tokens;
    }

    public List<Token> getErrores() {
        return errores;
    }

    public NodoArbol getPrograma() {
        return programa;
    }

    public List<Simbolo> getSimbolos() {
        return simbolos;
    }
    
    public void analizar(BufferedReader reader) throws IOException {
        tokens = new ArrayList<>();
        errores = new ArrayList<>();
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
        
        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico(tokens, programa, simbolos);
        analizadorSintactico.analizar();
        
    }
    
}
