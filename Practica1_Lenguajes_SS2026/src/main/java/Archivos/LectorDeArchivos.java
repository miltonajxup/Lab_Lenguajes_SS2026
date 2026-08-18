/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import AnalizadorPromtzal.AnalizadorArchivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author milton
 */
public class LectorDeArchivos {
    
    private final AnalizadorArchivo analizador;
    private final String EXTENSION_VALIDA = ".pz";
    private final int LONGITUD_EXTENSION = EXTENSION_VALIDA.length(); 
    
    public LectorDeArchivos(AnalizadorArchivo analizador) {
        this.analizador = analizador;
    }
    
    public RespuestaArchivo abrirArchivo(String rutaArchivo) {
        File file = new File(rutaArchivo);
        if (!file.exists() || file.isDirectory()) {
            return new RespuestaArchivo(false, "El archivo " + rutaArchivo + " no existe o no es un archivo");
        }
        RespuestaArchivo extension = verificarExtension(rutaArchivo);
        if (!extension.isValido()) {
            return extension;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            analizador.analizar(reader);
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer el archivo " + e.getMessage());
        }
        return new RespuestaArchivo(true, "No existe error");
    }
    
    private RespuestaArchivo verificarExtension(String rutaArchivo) {
        int finLinea = rutaArchivo.length();
        int inicio = finLinea - LONGITUD_EXTENSION;
        String extension = "";
        for (int i = inicio; i < finLinea; i++) {
            extension += rutaArchivo.charAt(i);
        }
        if (!EXTENSION_VALIDA.equals(extension)) {
            return new RespuestaArchivo(false, "\n\nLa aplicacion solo acepta extensiones que sean " + EXTENSION_VALIDA + " y " + extension + " no lo es. \nArchivo: " + rutaArchivo + "\n");
        }
        return new RespuestaArchivo(true, "No existe error");
    }
    
}
