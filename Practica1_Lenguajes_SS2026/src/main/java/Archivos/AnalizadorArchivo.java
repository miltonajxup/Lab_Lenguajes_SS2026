/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import Analizador.AnalizarDirectivas;
import Analizador.AnalizadorPalabrasReservadas;
import Analizador.ResultadoAnalizado;
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
    private char letraActual;
    private int indiceLetra;
    
    public AnalizadorArchivo() {
        claseCaracteres = new CaracteresToken();
        claseTokens = new Tokens();
        tokens = claseTokens.getTokens();
        analizarDirectivas = new AnalizarDirectivas(claseCaracteres);
        analizarPalabrasReservadas = new AnalizadorPalabrasReservadas(claseCaracteres, claseTokens);
    }
    
    public void analizar(String linea, BufferedReader reader) throws IOException {
        linea = linea.trim();
        if (linea.isEmpty()) {
            return;
        }
        String tokenActual = "";
        for (int i = 0; i < linea.length(); i++) {
            indiceLetra = i;
            letraActual = linea.charAt(indiceLetra);
            if (letraActual != ' ' && letraActual != claseCaracteres.getCOMILLAS()) {
                tokenActual += letraActual;
            } else if (tokenValido(tokenActual)) {
                instruccionToken(tokenActual, linea, reader);
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
    
    private void instruccionToken(String token, String linea, BufferedReader reader) throws IOException {
        if (claseTokens.getTOKEN_MODELO().equals(token)) {
            //analizarDirectivas.revisarTokenModelo(linea, indiceLetra);
            ResultadoAnalizado resultado = analizarDirectivas.revisarCadenaTexto(linea, indiceLetra);
            if (resultado.getResultado() != null && resultado.getError() == null) {
                //guarda el valor de modelo
                System.out.println("modelo reconoce " + resultado.getResultado());
            } else if (resultado.getResultado() == null && resultado.getError() != null) {
                //guarda el error
                System.out.println(resultado.getError());
            }
        } else if (claseTokens.getTOKEN_ROL().equals(token)) {
            analizarDirectivas.revisarTokenRol(linea, indiceLetra);
        } else if (claseTokens.getTOKEN_FORMATO().equals(token)) {
            analizarDirectivas.revisarTokenFormato(linea, indiceLetra);
        } else if (claseTokens.getTOKEN_AGENTE().equals(token)) {
            analizarPalabrasReservadas.revisarTokenAgente(linea, reader, indiceLetra);
        }
    }
    
}
