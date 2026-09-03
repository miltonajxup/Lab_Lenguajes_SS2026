/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Automata.Escritor.ExportarAutomataDOT;
import Excepciones.GeneracionImagenException;
import Frontent.VentanaImagen;
import java.io.IOException;

/**
 *
 * @author milton
 */
public class ControladorImagen {
    
    private final ExportarAutomataDOT automata;
    private final VentanaImagen ventana;
    private int numeroGenerado;
    private String archivoImagen;

    public ControladorImagen(ExportarAutomataDOT automata, VentanaImagen ventana) {
        this.automata = automata;
        this.ventana = ventana;
        numeroGenerado = 0;
    }
    
    public void generarYMostrarImagen() throws GeneracionImagenException {
        String archivoOdt = automata.getUltimoAutomata();
        if (automata.getCarpeta() == null || archivoOdt == null) {
            ventana.mostrarMensaje("Aun no se ha analizado nada para mostrar una imagen de automata");
            return;
        }
        numeroGenerado++;
        archivoImagen = automata.getCarpeta() + "automata" + numeroGenerado + ".png";
        
        ProcessBuilder pb = new ProcessBuilder(
                "dot", 
                "-Tpng", 
                archivoOdt, 
                "-o", 
                archivoImagen
        );
        
        try {
            Process proceso = pb.start();
            int resultado = proceso.waitFor();
            if (resultado != 0) {
                throw new GeneracionImagenException("Graphviz encontro un error: " + resultado);
            }
        } catch (IOException | InterruptedException e) {
            throw new GeneracionImagenException("Ocurrio un error al genera la imagen " + e.getMessage());
        }
        
        ventana.mostrar(true);
        ventana.colocarImagen(archivoImagen);
    }
    
}
