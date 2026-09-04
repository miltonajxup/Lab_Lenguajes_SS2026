/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Tokens;

import AnalizadorPromtzal.AnalizadorArchivo;
import AnalizadorPromtzal.ProcesadorLinea;
import Automata.ReconocimientoAutomata;
import Lenguaje.Palabras;
import Lenguaje.TipoToken;

/**
 *
 * @author milton
 */
public class AnalizadorCadena {
    
    private final Palabras palabras;
    private final ProcesadorLinea procesador;
    private final AnalizadorArchivo analizadorArchivo;
    private final ReconocimientoAutomata reconocimiento;

    public AnalizadorCadena(Palabras palabras, ProcesadorLinea procesador, AnalizadorArchivo analizadorArchivo, ReconocimientoAutomata reconocimiento) {
        this.palabras = palabras;
        this.procesador = procesador;
        this.analizadorArchivo = analizadorArchivo;
        this.reconocimiento = reconocimiento;
    }
    
    public void revisarCadenaTexto() {
        String instruccion = "";
        boolean cerrarCadena = false;
        int columnaToken = 0;
        procesador.saltarEspacios();
        if (procesador.getLetraActual() == palabras.getCOMILLAS()) {
            while (!cerrarCadena) {
                procesador.avanzar();
                reconocimiento.reconocer(procesador.getLetraActual());
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                }
                if (procesador.finLinea()) {
                    analizadorArchivo.agregarError("\"" + instruccion, "Error: No se cierra la cadena con \"", columnaToken);
                    reconocimiento.reiniciarEstado();
                    return;
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
