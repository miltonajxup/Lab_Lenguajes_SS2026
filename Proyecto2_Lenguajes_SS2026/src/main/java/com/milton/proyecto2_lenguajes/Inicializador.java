/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes;

import com.milton.proyecto2_lenguajes.compilador.ControladorAnalisis;
import com.milton.proyecto2_lenguajes.controladores.ControladorDeArchivo;
import com.milton.proyecto2_lenguajes.frontend.IDEPromt;

/**
 *
 * @author milton
 */
public class Inicializador {
    
    public void comenzar() {
        
        ControladorAnalisis controladorAnalisis = new ControladorAnalisis();
        ControladorDeArchivo controladorArchivo = new ControladorDeArchivo(controladorAnalisis);
        
        IDEPromt ide = new IDEPromt(controladorArchivo);
        ide.setVisible(true);
        
    }
    
}
