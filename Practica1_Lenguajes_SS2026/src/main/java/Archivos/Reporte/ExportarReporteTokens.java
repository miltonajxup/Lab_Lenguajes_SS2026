/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

import AnalizadorPromtzal.AnalizadorArchivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author milton
 */
public class ExportarReporte {
    
    private final String CARPETA = "reportes/";
    private final String ARCHIVO = "reportes_practica1_";
    private final String EXTENSION = ".html";
    private final FormatoReporte formato;
    private final AnalizadorArchivo analizador;
    private String carpetaElegida;
    private String ruta;

    public ExportarReporte(FormatoReporte formato, AnalizadorArchivo analizador) {
        this.formato = formato;
        this.analizador = analizador;
        carpetaElegida = "";
    }
    
    public void setCarpetaElegida(String carpetaElegida) {
        File file = new File(carpetaElegida);
        if (!file.isDirectory()) {
            System.out.println("\n\nLa direccion " + carpetaElegida + " no existe, si se desea continuar y crear Presione ENTER \nPara cancelar y regresar ingrese 'n'");
            Scanner scanner = new Scanner(System.in);
            String resuesta = scanner.nextLine();
            if (resuesta.equals("n")) {
                return;
            } else {
                file.mkdirs();
            }
        }
        System.out.println("\nLa carpeta de guardado ahora es: " + carpetaElegida + "\n");
        this.carpetaElegida = carpetaElegida + "/";
    }

    public String getCarpetaElegida() {
        return carpetaElegida;
    }
    
    public String getRuta() {
        return ruta;
    }
    
    public void exportarReporte() {
        ruta = carpetaElegida + CARPETA + ARCHIVO + analizador.getNumeroAnalisis() + EXTENSION;
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
