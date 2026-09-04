/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automata.Escritor;

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
public class ExportarAutomataDOT {
    
    private final ControladorDeArchivo controlador;
    private final FormatoDOT formatodot;
    private final String NOMBRE = "automata";
    private int NUMERO_GENERADO = 0;
    private final String EXTENSION = ".dot";
    private String ultimoAutomata;

    public ExportarAutomataDOT(ControladorDeArchivo controlador, FormatoDOT formatodot) {
        this.controlador = controlador;
        this.formatodot = formatodot;
    }
    
    public String getUltimoAutomata() {
        return ultimoAutomata;
    }
    
    public String getCarpeta() {
        return controlador.getCarpeta();
    }
    
    public void exportar() throws ErrorDeArchivoException {
        if (controlador.getCarpeta() == null) {
            return;
        }
        existeCarpeta();
        NUMERO_GENERADO++;
        ultimoAutomata = controlador.getCarpeta() + NOMBRE + NUMERO_GENERADO + EXTENSION;
        try (PrintWriter writer = new PrintWriter(new FileWriter(ultimoAutomata))) {
            writer.print(formatodot.getAutomataDOT());
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Ocurrio un error al exportar el automata: " + e.getMessage());
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
