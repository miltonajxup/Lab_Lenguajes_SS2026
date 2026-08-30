/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lenguajes_ss2026;

import AnalizadorPromtzal.AnalizadorArchivo;
import Archivos.Reporte.ExportarReporte;
import Archivos.Reporte.FormatoReporte;
import Backend.ControladorDeArchivo;
import Frontent.PromtZal;
import Menu.OpcionCargarArchivo;

/**
 *
 * @author milton
 */
public class InicializadorPromtzal {
    
    private final ControladorDeArchivo controladorIde;
    private final PromtZal promtZal;
    private final AnalizadorArchivo analizador;
    private final ExportarReporte exportar;
    private final OpcionCargarArchivo opcionCargarArchivo;

    public InicializadorPromtzal() {
        controladorIde = new ControladorDeArchivo();
        promtZal = new PromtZal(controladorIde);
        analizador = new AnalizadorArchivo();
        FormatoReporte formatoReporte = new FormatoReporte(analizador);
        exportar = new ExportarReporte(formatoReporte, analizador);
        opcionCargarArchivo = new OpcionCargarArchivo(analizador, exportar);
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
