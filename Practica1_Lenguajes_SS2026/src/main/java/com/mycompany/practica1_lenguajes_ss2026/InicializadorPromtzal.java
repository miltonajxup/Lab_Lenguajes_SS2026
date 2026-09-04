/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lenguajes_ss2026;

import AnalizadorPromtzal.AnalizadorArchivo;
import Archivos.Reporte.ExportarReporteTokens;
import Archivos.Reporte.FormatoReporte;
import Automata.Escritor.ExportarAutomataDOT;
import Automata.Escritor.FormatoDOT;
import Backend.ControladorDeArchivo;
import Backend.ControladorImagen;
import Backend.ControladorRegistros;
import Frontent.PromtZal;
import Frontent.VentanaImagen;

/**
 *
 * @author milton
 */
public class InicializadorPromtzal {
    
    private final ControladorDeArchivo controladorIde;
    private final ControladorRegistros controladorRegistros;
    private final ControladorImagen controladorImagen;
    private final AnalizadorArchivo analizador;
    private final ExportarReporteTokens exportar;
    private final ExportarAutomataDOT exportarAutomata;
    private final PromtZal promtZal;

    public InicializadorPromtzal() {
        FormatoDOT formatodot = new FormatoDOT();
        analizador = new AnalizadorArchivo(formatodot);
        controladorIde = new ControladorDeArchivo(analizador);
        controladorRegistros = new ControladorRegistros(analizador);
        FormatoReporte formatoReporte = new FormatoReporte(analizador);
        exportar = new ExportarReporteTokens(controladorIde, formatoReporte);
        exportarAutomata = new ExportarAutomataDOT(controladorIde, formatodot);
        VentanaImagen ventanaImagen = new VentanaImagen();
        controladorImagen = new ControladorImagen(exportarAutomata, ventanaImagen);
        promtZal = new PromtZal(controladorIde, controladorRegistros, controladorImagen, exportar, exportarAutomata);
        controladorRegistros.setPromtzal(promtZal);
    }
    
    public void iniciarMenuPromtzal() {
        promtZal.setVisible(true);
        
//        Scanner scanner = new Scanner(System.in);
//        String eleccion;
//        boolean salir = false;
//        
//        while (!salir) {
//            String textoMenu = """
//                          -------------------------------------------------------
//                          |                 Menu de Promtzal                    |
//                          |                                                     |
//                          | 1. Cargar un Archivo promtzal                       |
//                          | 2. Definir una carpeta para almacenar los reportes  |
//                          | 3. Salir                                            |
//                          |                                                     |
//                          | Ingresa un numero para elegir la opcion             |
//                          |                                                     |
//                          |-----------------------------------------------------|
//                          """;
//            System.out.println(textoMenu);
//            eleccion = scanner.nextLine();
//            switch (eleccion) {
//                case "1": 
//                    opcionCargarArchivo.cargar();
//                    break;
//                case "2":
//                    System.out.println("Ejemplo: /carpeta/carpeta2");
//                    String carpetaGuardado = scanner.nextLine();
//                    exportar.setCarpetaElegida(carpetaGuardado);
//                    break;
//                case "3":
//                    salir = true;
//            }
//        }
//        System.out.println("\nCerrando Promtzal ...");
    }
    
}
