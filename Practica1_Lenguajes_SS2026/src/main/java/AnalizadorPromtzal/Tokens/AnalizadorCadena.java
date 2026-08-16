/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Tokens;

import AnalizadorPromtzal.AnalizadorArchivo;
import AnalizadorPromtzal.ProcesadorLinea;
import Tokens.Palabras;
import Tokens.TipoToken;

/**
 *
 * @author milton
 */
public class AnalizadorCadena {
    
    private final Palabras palabras;
    private final ProcesadorLinea procesador;
    private final AnalizadorArchivo analizadorArchivo;

    public AnalizadorCadena(Palabras palabras, ProcesadorLinea procesador, AnalizadorArchivo analizadorArchivo) {
        this.palabras = palabras;
        this.procesador = procesador;
        this.analizadorArchivo = analizadorArchivo;
    }
    
    public void revisarCadenaTexto() {
        String instruccion = "";
        boolean cerrarCadena = false;
        int columnaToken = 0;
        procesador.saltarEspacios();
        if (procesador.getLetraActual() == palabras.getCOMILLAS()) {
            while (!cerrarCadena) {
                procesador.avanzar();
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                }
                if (procesador.finLinea()) {
                    analizadorArchivo.agregarError(instruccion, "Error: No se cierra la cadena con \"", columnaToken);
                }
                if (procesador.getLetraActual() != '"') {   
                    instruccion = instruccion + procesador.getLetraActual();
                } else {
                    cerrarCadena = true;
                }
            }
            procesador.saltarEspacios();
        }
        analizadorArchivo.agregarToken(TipoToken.STRING, instruccion, columnaToken);
    }
    
}
