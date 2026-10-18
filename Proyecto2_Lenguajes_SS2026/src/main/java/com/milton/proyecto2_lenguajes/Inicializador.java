/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes;

/**
 *
 * @author milton
 */
public class Inicializador {
    
    public void comenzar() {
        
    }
    
    private void analizar() {
        String comilla = "/*";
        AnalizadorLexico analizador = new AnalizadorLexico(new FileReader("nombre_archivo.txt"));
        
        Token token;
        
        while ( (token = analizador.yylex()) != null ) {
            //Utilizar el Token token
        }
    }
    
}
