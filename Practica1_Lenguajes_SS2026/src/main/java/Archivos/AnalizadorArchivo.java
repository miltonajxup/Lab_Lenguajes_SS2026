/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import AnalizadorPromtzal.Directivas.AnalizarDirectivas;
import AnalizadorPromtzal.PalabrasReservadas.AnalizadorPalabrasAgente;
import AnalizadorPromtzal.ProcesadorLinea;
import Errores.ColeccionErrores;
import Tokens.CaracteresToken;
import Tokens.ColeccionTokens;
import Tokens.PalabraReservada;
import Tokens.Palabras;
import Tokens.TipoToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorArchivo {
    
    private final CaracteresToken caracteres;
    private final Palabras palabras;
    private final List<PalabraReservada> listaPalabras;
    private final ProcesadorLinea procesador;
    private final AnalizarDirectivas analizarDirectivas;
    private final AnalizadorPalabrasAgente analizarPalabrasAgente;
    private final ColeccionTokens coleccionTokens;
    private final ColeccionErrores coleccionErrores;
    private BufferedReader reader;
    private int fila;
    
    public AnalizadorArchivo() {
        caracteres = new CaracteresToken();
        palabras = new Palabras();
        listaPalabras = palabras.getPalabras();
        procesador = new ProcesadorLinea();
        analizarDirectivas = new AnalizarDirectivas(palabras, caracteres, procesador, this);
        analizarPalabrasAgente = new AnalizadorPalabrasAgente(palabras, caracteres, procesador, this);
        coleccionTokens = new ColeccionTokens();
        coleccionErrores = new ColeccionErrores();
        fila = 0;
    }
    
    public void agregarToken(TipoToken tipo, String lexema, int columna) {
        coleccionTokens.agregarToken(tipo, lexema, fila, columna);
    }
    
    public void agregarError(String lexema, String descripcion, int columna) {
        coleccionErrores.agregarError(lexema, descripcion, fila, columna);
    }
    
    public void analizar(BufferedReader reader) throws IOException {
        this.reader = reader;
        actualizarLinea();
        while (!procesador.esLineaNula()) {
            procesador.saltarEspacios();
            if (procesador.finLinea() || procesador.lineaVacia() || procesador.esLineaNula()) {
                actualizarLinea();
            } else {
                String tokenActual = "";
                int columnaToken = 0;
                while (procesador.getLetraActual() != ' ' && procesador.getLetraActual() != caracteres.getCOMILLAS() && !procesador.finLinea()) {
                    if (columnaToken == 0) {
                        columnaToken = procesador.getColumna();
                    }
                    tokenActual += procesador.getLetraActual();
                    procesador.avanzar();
                }
                PalabraReservada palabra = palabraValida(tokenActual);
                if (palabra != null) {
                    agregarToken(palabra.getTipo(), palabra.getLexema(), columnaToken);
                    instruccionToken(tokenActual);
                } else {
                    agregarError(tokenActual, "No se puede reconocer " + tokenActual, columnaToken);
                }
                actualizarLinea();
            }
        }
        System.out.println("");
    }
    
    private void instruccionToken(String token) throws IOException {
        if (token.charAt(0) == caracteres.getARROBA()) {
            analizarDirectivas.revisarTokenDirectiva();
        } else if (palabras.getAGENTE().equals(token)) {
            analizarPalabrasAgente.revisarTokenAgente();
        } else if (palabras.getPREGUNTAR().equals(token)) {
            
        }
    }
    
    public PalabraReservada palabraValida(String token) {
        for (PalabraReservada palabraReservada : listaPalabras) {
            if (palabraReservada.getLexema().equals(token)) {
                return palabraReservada;
            }
        }
        return null;
    }
    
    public void actualizarLinea() throws IOException {
        avanzarFila();
        procesador.setLinea(reader.readLine());
    }
    
    private void avanzarFila() {
        fila++;
    }
    
}
