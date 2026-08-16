/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lenguajes_ss2026;

import AnalizadorPromtzal.AnalizadorArchivo;
import Archivos.LectorDeArchivos;
import Archivos.Reporte.ExportarReporte;
import Archivos.Reporte.FormatoReporte;
import java.util.Scanner;

/**
 *
 * @author milton
 */
public class Inicializador {
    
    public void iniciar() {
        AnalizadorArchivo analizador = new AnalizadorArchivo();
        LectorDeArchivos lector = new LectorDeArchivos(analizador);
        lector.abrirArchivo("/home/milton/Descargas/lenguajes.txt");
        FormatoReporte formatoReporte = new FormatoReporte(analizador);
        ExportarReporte exportar = new ExportarReporte(formatoReporte);
        exportar.setCarpetaElegida("/home/milton/Descargas");
        exportar.exportarReporte();
        Scanner scanner = new Scanner(System.in);
        //String rutaArchivo = scanner.nextLine();
    }
    
}
