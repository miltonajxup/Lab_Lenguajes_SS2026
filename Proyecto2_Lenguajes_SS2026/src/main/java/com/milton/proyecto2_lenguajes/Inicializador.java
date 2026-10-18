/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes;

import com.milton.proyecto2_lenguajes.compilador.ControladorAnalisis;
import com.milton.proyecto2_lenguajes.controladores.ControladorDeArchivo;
import com.milton.proyecto2_lenguajes.frontend.PromtZal;

/**
 *
 * @author milton
 */
public class Inicializador {
    
    public void comenzar() {
        
        ControladorAnalisis recolector = new ControladorAnalisis();
        ControladorDeArchivo controlador = new ControladorDeArchivo(recolector);
        
        PromtZal ventana = new PromtZal(controlador);
        ventana.setVisible(true);
        
    }
    
}
