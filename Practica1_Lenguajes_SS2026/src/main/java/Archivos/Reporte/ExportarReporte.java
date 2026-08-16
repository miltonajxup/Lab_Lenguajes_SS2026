/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author milton
 */
public class ExportarReporte {
    
    private final String CARPETA = "reportes/";
    private final String ARCHIVO = "reportes_practica1.html";
    private final FormatoReporte formato;
    private String carpetaElegida;

    public ExportarReporte(FormatoReporte formato) {
        this.formato = formato;
        carpetaElegida = "";
    }
    
    public void setCarpetaElegida(String carpetaElegida) {
        this.carpetaElegida = carpetaElegida + "/";
    }
    
    public void exportarReporte() {
        String ruta = carpetaElegida + CARPETA + ARCHIVO;
        existeCarpeta();
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            formato.escribirReporte(writer);
        } catch (IOException e) {
            System.out.println("Error al acceder a la carpeta: " + e.getMessage());
        }
    }
    
    private void existeCarpeta() {
        String rutaFinal = carpetaElegida + CARPETA;
        File file = new File(rutaFinal);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
}
