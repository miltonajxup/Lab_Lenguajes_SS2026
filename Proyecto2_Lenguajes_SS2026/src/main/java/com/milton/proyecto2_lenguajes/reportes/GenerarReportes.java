/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.reportes;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.controladores.ResultadoReportes;
import com.milton.proyecto2_lenguajes.exceptions.ErrorDeArchivoException;
import com.milton.proyecto2_lenguajes.resultados.VisualizadorAST;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author milton
 */
public class GenerarReportes {
    
    private final String CARPETA_GENERADA = "/Archivos_Generados/";
    private final String NOMBRE_PROMT = "Promt";
    private final String NOMBRE_REPORTE = "Reporte_Proyecto2";
    private final String NOMBRE_AST = "Reporte_Arbol";
    private final String EXTENSION_HTML = ".html";
    private int promtsGenerados = 1;
    
    public void generar(ResultadoReportes resultados, String carpeta, String formatoPromt) throws ErrorDeArchivoException {
        String carpetaCompleta = carpeta + CARPETA_GENERADA;
        generarArchivoPromt(carpetaCompleta, formatoPromt, resultados.getPromt());
        exportarArbol(resultados.getPrograma(), carpetaCompleta);
        generarReporteErrores(resultados, carpetaCompleta);
        promtsGenerados++;
    }
    
    private void generarArchivoPromt(String carpeta, String formato, String promt) throws ErrorDeArchivoException {
        String ruta = carpeta + NOMBRE_PROMT + promtsGenerados + formato;
        revisarExistenciaCarpeta(carpeta);
        try (PrintWriter writer = new PrintWriter(new File(ruta))) {
            writer.print(promt);
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Ocurrio un error al generar el arhivo del promt: " + e.getMessage());
        }
    }
    
    private void exportarArbol(NodoArbol programa, String carpeta) throws ErrorDeArchivoException {
        VisualizadorAST ast = new VisualizadorAST();
        String arbol = ast.generarHTML(programa);
        
        revisarExistenciaCarpeta(carpeta);
        String rutaCompleta = carpeta + NOMBRE_AST + promtsGenerados + EXTENSION_HTML;
        try (PrintWriter writer = new PrintWriter(new File(rutaCompleta))) {
            writer.print(arbol);
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Error al generar el arbol en formato html: " + e.getMessage());
        }
    }
    
    private void generarReporteErrores(ResultadoReportes resultados, String carpeta) throws ErrorDeArchivoException {
        ReportesHtml errores = new ReportesHtml(resultados);
        String reporte = errores.escribirReporte();
        
        revisarExistenciaCarpeta(carpeta);
        String rutaCompleta = carpeta + NOMBRE_REPORTE + promtsGenerados + EXTENSION_HTML;
        try (PrintWriter writer = new PrintWriter(new File(rutaCompleta))) {
            writer.print(reporte);
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Error al generar el archivo de reportes en html: " + e.getMessage());
        }
    }
    
    private void revisarExistenciaCarpeta(String carpeta) {
        File file = new File(carpeta);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
}
