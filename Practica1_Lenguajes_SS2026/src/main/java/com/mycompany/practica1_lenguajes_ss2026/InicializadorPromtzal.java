/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lenguajes_ss2026;

import AnalizadorPromtzal.AnalizadorArchivo;
import Archivos.Reporte.ExportarReporteTokens;
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
        exportar = new ExportarReporteTokens(controladorIde, analizador);
        exportarAutomata = new ExportarAutomataDOT(controladorIde, formatodot);
        VentanaImagen ventanaImagen = new VentanaImagen();
        controladorImagen = new ControladorImagen(exportarAutomata, ventanaImagen);
        promtZal = new PromtZal(controladorIde, controladorRegistros, controladorImagen, exportar, exportarAutomata, analizador);
        controladorRegistros.setPromtzal(promtZal);
    }
    
    public void iniciarMenuPromtzal() {
        promtZal.setVisible(true);
    }
    
}
