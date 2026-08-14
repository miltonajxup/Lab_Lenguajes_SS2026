/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import AnalizadorPromtzal.Directivas.AnalizarDirectivas;
import AnalizadorPromtzal.PalabrasReservadas.AnalizadorPalabrasReservadas;
import AnalizadorPromtzal.ResultadoAnalizado;
import Tokens.CaracteresToken;
import Tokens.Tokens;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorArchivo {
    
    private final CaracteresToken claseCaracteres;
    private final Tokens claseTokens;
    private final List<String> tokens;
    private final AnalizarDirectivas analizarDirectivas;
    private final AnalizadorPalabrasReservadas analizarPalabrasReservadas;
    private String lineaActual;
    private int indiceInicial;
    private char letraActual;
    private int indiceLetra;
    
    public AnalizadorArchivo() {
        claseCaracteres = new CaracteresToken();
        claseTokens = new Tokens();
        tokens = claseTokens.getTokens();
        analizarDirectivas = new AnalizarDirectivas(claseTokens, claseCaracteres);
        analizarPalabrasReservadas = new AnalizadorPalabrasReservadas(claseTokens, claseCaracteres);
    }
    
    public void analizar(String linea, BufferedReader reader) throws IOException {
        lineaActual = linea;
        saltarEspacios(reader);
        if (lineaActual == null) {
            return;
        }
        String tokenActual = "";
        for (int i = indiceInicial; i < lineaActual.length(); i++) {
            indiceLetra = i;
            letraActual = lineaActual.charAt(indiceLetra);
            if (letraActual != ' ' && letraActual != claseCaracteres.getCOMILLAS()) {
                tokenActual += letraActual;
            } else if (tokenValido(tokenActual)) {
                instruccionToken(tokenActual, lineaActual, reader);
                break;
            } else {
                System.out.println("no es valido " + tokenActual);
                break;
            }
        }
    }
    
    private boolean tokenValido(String token) {
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals(token)) {
                return true;
            }
        }
        return false;
    }
    
    private void saltarEspacios(BufferedReader reader) throws IOException {
        reiniciarIndiceYLetra();
        while (letraActual == ' ' || letraActual == '\t') {
            indiceInicial++;
            if (indiceInicial < lineaActual.length()) {
                letraActual = lineaActual.charAt(indiceInicial);
            } else {
                lineaActual = reader.readLine();
                if (lineaActual == null) {
                    return;
                }
                reiniciarIndiceYLetra();
            }
        }
    }
    
    private void reiniciarIndiceYLetra() {
        indiceInicial = 0;
        letraActual = lineaActual.charAt(indiceInicial);
    }
    
    private void instruccionToken(String token, String linea, BufferedReader reader) throws IOException {
        if (claseTokens.getTOKEN_MODELO().equals(token)) {
            analizarDirectivas.revisarTokenModelo(linea, indiceLetra);
        } else if (claseTokens.getTOKEN_ROL().equals(token)) {
            analizarDirectivas.revisarTokenRol(linea, indiceLetra);
        } else if (claseTokens.getTOKEN_FORMATO().equals(token)) {
            analizarDirectivas.revisarTokenFormato(linea, indiceLetra);
        } else if (claseTokens.getTOKEN_AGENTE().equals(token)) {
            analizarPalabrasReservadas.revisarTokenAgente(linea, reader, indiceLetra);
        }
    }
    
}
