/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analizador;

import Tokens.CaracteresToken;
import java.util.List;

/**
 *
 * @author milton
 */
public class Analizador {
    
    private final CaracteresToken claseCaracteres;
    private char letraActual;
    private int indiceLetra;

    public Analizador(CaracteresToken claseCaracteres) {
        this.claseCaracteres = claseCaracteres;
    }

    public CaracteresToken getClaseCaracteres() {
        return claseCaracteres;
    }
 
    protected char getLetraActual() {
        return letraActual;
    }

    protected void setLetraActual(char letraActual) {
        this.letraActual = letraActual;
    }

    protected int getIndiceLetra() {
        return indiceLetra;
    }

    protected void setIndiceLetra(int indiceLetra) {
        this.indiceLetra = indiceLetra;
    }
    
    public void modificarLetra(String linea, int indice) {
        indiceLetra = indice;
        letraActual = linea.charAt(indice);
    }
    
    protected void avanzarIndiceYLetra(String linea) {
        indiceLetra ++;
        letraActual = linea.charAt(indiceLetra);
    }
    
    protected void actualizarLetraActual(String linea) {
        letraActual = linea.charAt(indiceLetra);
    }
    
    public ResultadoAnalizado revisarCadenaTexto(String linea, int indiceActual) {
        modificarLetra(linea, indiceActual);
        return revisarCadenaTexto(linea);
    }
    
    public ResultadoAnalizado revisarCadenaTexto(String linea) {
        String instruccion = "";
        boolean cerrarCadena = false;
        saltarEspacios(linea);
        if (letraActual == claseCaracteres.getCOMILLAS()) {
            while (!cerrarCadena) {                    
                indiceLetra++;
                if (indiceLetra >= linea.length()) {
                    return new ResultadoAnalizado(null, "Error no se esta cerrando la cadena de texto despues de \"" + instruccion);
                }
                actualizarLetraActual(linea);
                if (letraActual != '"') {   
                    instruccion = instruccion + letraActual;
                } else {
                    cerrarCadena = true;
                }
            }
            if (indiceLetra < linea.length()) {
                indiceLetra++;
                actualizarLetraActual(linea);
            }
            saltarEspacios(linea);
            if (letraActual != claseCaracteres.getCOMILLAS() && letraActual != ' ' && letraActual != '\t') {
                String error = textoPostError(linea);
                return new ResultadoAnalizado(null, "Error: no se reconoce " + error);
            }
        } else {
            String error = textoPostError(linea);
            return new ResultadoAnalizado(null, "Se espera una cadena y " + error + " no es una cadena");
        }
        return new ResultadoAnalizado(instruccion, null);
    }
    
    protected void saltarEspacios(String linea) {
        while (indiceLetra < linea.length() && letraActual == ' ') {
            indiceLetra++;
            if (indiceLetra < linea.length()) {
                letraActual = linea.charAt(indiceLetra);
            }
        }
    }
    
    public ResultadoAnalizado validarIdentificador(String linea) {
        String identificador = "";
        if (claseCaracteres.getGUION_BAJO() == letraActual || primerCaracterValido(letraActual)) {
            while (letraActual != ' ' && indiceLetra < linea.length()) {
                identificador = identificador + letraActual;
                indiceLetra++;
                if (indiceLetra < linea.length()) {
                    setLetraActual(linea.charAt(indiceLetra));
                }
            }
        } else {
            return new ResultadoAnalizado(null, "Error: los identificadores no pueden iniciar con " + getLetraActual());
        }
        return new ResultadoAnalizado(identificador, null);
    }
    
    public boolean primerCaracterValido(char primero) {
        List<Character> caracteres = claseCaracteres.getCaracteres();
        for (int i = 0; i < caracteres.size(); i++) {
            if (primero == caracteres.get(i)) {
                return true;
            }
        }
        return false;
    }
    
    public String textoPostError(String linea) {
        String error = "";
        while (indiceLetra < linea.length()) {
            letraActual = linea.charAt(indiceLetra);
            error += letraActual;
            indiceLetra++;
        }
        return error;
    }
}
