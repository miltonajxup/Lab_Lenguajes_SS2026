/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

import Backend.ControladorDeArchivo;
import Excepciones.ErrorDeArchivoException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author milton
 */
public class ExportarReporteTokens {
    
    private final ControladorDeArchivo controlador;
    private final String ARCHIVO = "reportes_practica1_";
    private int NUMERO_GENERADO = 0;
    private final String EXTENSION = ".html";
    private final FormatoReporte formato;

    public ExportarReporteTokens(ControladorDeArchivo controlador, FormatoReporte formato) {
        this.controlador = controlador;
        this.formato = formato;
    }
    
    public void exportarReporte() throws ErrorDeArchivoException {
        if (controlador.getCarpeta() == null) {
            return;
        }
        existeCarpeta();
        NUMERO_GENERADO++;
        String ruta = controlador.getCarpeta() + ARCHIVO + NUMERO_GENERADO + EXTENSION;
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            formato.escribirReporte(writer);
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Error al acceder a la carpeta: " + e.getMessage());
        }
    }
    
    private void existeCarpeta() {
        String lugarGuardado = controlador.getCarpeta();
        File file = new File(lugarGuardado);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
}
