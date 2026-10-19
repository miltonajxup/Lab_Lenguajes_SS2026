/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador.reglas;

/**
 *
 * @author milton
 */
public enum TipoToken {
    MODELO,
    ROL,
    FORMATO, 
    AGENTE,
    CONTEXTO,
    VARIABLE, 
    EJECUTAR,
    EXPORTAR,
    PREGUNTAR,
    GENERAR,
    RESUMIR,
    ANALIZAR,
    TRADUCIR,
    CLASIFICAR,
    EXTRAER,
    CARGAR, 
    SOBRE,
    DESDE,
    EN,
    COMO,
    ASIGNACION,
    
    ASIGNAR,
    CONCATENACION,
    LLAVE_IZQ,
    LLAVE_DER,
    PARENTESIS_IZQ,
    PARENTESIS_DER,
    COMA, 
    
    COMILLAS,
    SLASH,
    ASTERISCO,
    DELIMITADOR,
    
    COMENTARIO_LINEA,
    COMENTARIO_BLOQUE,
    
    IDENTIFICADOR, 
    CADENA, 
    ENTERO,
    DECIMAL, 
    
    PUNTO_Y_COMA, 
    ERROR,
    PROGRAMA
}
