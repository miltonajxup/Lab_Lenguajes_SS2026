/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lenguajes_ss2026;

import Archivos.LectorDeArchivos;

/**
 *
 * @author milton
 */
public class Inicializador {
    
    public void iniciar() {
        LectorDeArchivos lector = new LectorDeArchivos();
        lector.abrirArchivo("/home/milton/Descargas/lenguajes.txt");
    }
    
}
