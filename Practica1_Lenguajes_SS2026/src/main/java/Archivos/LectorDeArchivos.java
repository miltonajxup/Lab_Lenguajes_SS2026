/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import AnalizadorPromtzal.AnalizadorArchivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author milton
 */
public class LectorDeArchivos {
    
    private final AnalizadorArchivo analizador;
    
    public LectorDeArchivos(AnalizadorArchivo analizador) {
        this.analizador = analizador;
    }
    
    public void abrirArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            analizador.analizar(reader);
        } catch (IOException e) {
            System.out.println("Ocurrio un error al buscar el archivo " + e.getMessage());
        }
    }
    
}
