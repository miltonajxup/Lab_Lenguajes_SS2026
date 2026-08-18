/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Tokens;

import AnalizadorPromtzal.AnalizadorArchivo;
import AnalizadorPromtzal.ProcesadorLinea;
import Tokens.Palabras;
import Tokens.TipoToken;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorNumero {
    
    private final Palabras palabras;
    private final ProcesadorLinea procesador;
    private final AnalizadorArchivo analizadorArchivo;
    private int contadorPunto;

    public AnalizadorNumero(Palabras palabras, ProcesadorLinea procesador, AnalizadorArchivo analizadorArchivo) {
        this.palabras = palabras;
        this.procesador = procesador;
        this.analizadorArchivo = analizadorArchivo;
        contadorPunto = 0;
    }
    
    public String analizarNumero() throws IOException {
        String numero = "";
        int columna = 0;
        char actual = ' ';
        boolean sigueNumero = true;
        
        while (sigueNumero) {
            if (columna == 0) {
                columna = procesador.getColumna();
            }
            actual = procesador.getLetraActual();
            if (actual == ' ' || !esNumero(actual) || procesador.finLinea() || contadorPunto > 1) {
                sigueNumero = false;
            } else {
                numero += actual;
                if (actual == palabras.getPUNTO()) {
                    contadorPunto++;
                }
                procesador.avanzar();
            }
        }
        if (actual == ' ') {
            procesador.saltarEspacios();
        }
        
        if ((actual == ' ' || procesador.finLinea()) && contadorPunto == 0) {
            analizadorArchivo.agregarToken(TipoToken.ENTERO, numero, columna);
        } else if ((actual == ' ' || procesador.finLinea()) && contadorPunto == 1) {
            analizadorArchivo.agregarToken(TipoToken.DECIMAL, numero, columna);
        } else if (contadorPunto > 1) {
            while (procesador.getLetraActual() != ' ' && !procesador.finLinea()) {
                numero += procesador.getLetraActual();
                procesador.avanzar();
            }
            contadorPunto = 0;
            return numero;  
        } else {
            contadorPunto = 0;
            return numero;
        }
        
        if (procesador.finLinea()) {
            actualizarLinea();
        }
        
        contadorPunto = 0;
        return null;
    }
    
    private void actualizarLinea() throws IOException {
        if (procesador.finLinea()) {
            analizadorArchivo.actualizarLinea();
            if (!procesador.esLineaNula()) {
                procesador.saltarEspacios();
            }
        }
    }
    
    public boolean esNumero(char caracter) {
        List<String> numeros = palabras.getNumeros();
        for (String numero : numeros) {
            if (numero.equals(String.valueOf(caracter))) {
                return true;
            }
        }
        return false;
    }

}
