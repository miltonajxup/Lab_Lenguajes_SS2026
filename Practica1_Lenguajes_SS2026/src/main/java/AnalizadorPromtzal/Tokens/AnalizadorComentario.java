/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Tokens;

import AnalizadorPromtzal.AnalizadorArchivo;
import AnalizadorPromtzal.ProcesadorLinea;
import Tokens.PalabraReservada;
import Tokens.Palabras;
import java.io.IOException;

/**
 *
 * @author milton
 */
public class AnalizadorComentario {
    
    private final Palabras palabras;
    private final ProcesadorLinea procesador;
    private final AnalizadorArchivo analizadorArchivo;

    public AnalizadorComentario(Palabras palabras, ProcesadorLinea procesador, AnalizadorArchivo analizadorArchivo) {
        this.palabras = palabras;
        this.procesador = procesador;
        this.analizadorArchivo = analizadorArchivo;
    }
    
    public void analizarComentario() throws IOException {
        String token = String.valueOf(procesador.getLetraActual()) + procesador.getSiguiente();
        PalabraReservada caracterComentario = esToken(token);
        if (caracterComentario == null) {
            return;
        } 
        if (caracterComentario.getLexema().equals(palabras.getCOMENTARIO_LINEA())) {
            while (!procesador.finLinea()) {
                procesador.avanzar();
            }
            return;
        }
        if (caracterComentario.getLexema().equals(palabras.getCOMENT_BLOQUE_INICIO())) {
            procesador.avanzar();
            boolean finComentario = false;
            while (!finComentario) {
                procesador.avanzar();
                if (procesador.finLinea()) {
                    analizadorArchivo.actualizarLinea();
                    if (procesador.esLineaNula()) {
                        return;
                    }
                }
                if (procesador.getLetraActual() == palabras.getASTERISCO()) {
                    String fin = String.valueOf(procesador.getLetraActual()) + procesador.getSiguiente();
                    if (palabras.getCOMENT_BLOQUE_FIN().equals(fin)) {
                        finComentario = true;
                    }
                }
            }
            procesador.avanzar();
        }
    }
    
    private PalabraReservada esToken(String token) {
        for (PalabraReservada palabra : palabras.getCaracteres()) {
            if (palabra.getLexema().equals(token)) {
                return palabra;
            }
        }
        return null;
    }
    
}
