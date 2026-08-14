/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

import Tokens.CaracteresToken;
import Tokens.Tokens;
import java.util.List;

/**
 *
 * @author milton
 */
public class Analizador {
    
    private final CaracteresToken caracteres;
    private final List<String> listaTokens;
    private final ProcesadorLinea procesador;

    public Analizador(Tokens tokens, CaracteresToken caracteres, ProcesadorLinea procesador) {
        //this.tokens = tokens;
        this.caracteres = caracteres;
        this.listaTokens = tokens.getTokens();
        this.procesador = procesador;
    }

    public ResultadoAnalizado revisarCadenaTexto() {
        String instruccion = "";
        boolean cerrarCadena = false;
        procesador.saltarEspacios();
        if (procesador.getLetraActual() == caracteres.getCOMILLAS()) {
            while (!cerrarCadena) {
                procesador.avanzar();
                if (procesador.finLinea()) {
                    return new ResultadoAnalizado(null, "Error no se esta cerrando la cadena de texto despues de \"" + instruccion);
                }
                if (procesador.getLetraActual() != '"') {   
                    instruccion = instruccion + procesador.getLetraActual();
                } else {
                    cerrarCadena = true;
                }
            }
            if (procesador.numeroParaFinLinea(1)) {
                procesador.avanzar();
            }
            procesador.saltarEspacios();
            if (procesador.getLetraActual() != caracteres.getCOMILLAS() && !esEspacio()) {
                String error = textoPostError();
                return new ResultadoAnalizado(null, "Error: no se reconoce " + error);
            }
        } else {
            String error = textoPostError();
            return new ResultadoAnalizado(null, "Se espera una cadena y " + error + " no es una cadena");
        }
        return new ResultadoAnalizado(instruccion, null);
    }
    
    public ResultadoAnalizado validarIdentificador() {
        String identificador = "";
        if (caracteres.getGUION_BAJO() == procesador.getLetraActual() || primerCaracterValido(procesador.getLetraActual())) {
            while (!esEspacio() && !procesador.finLinea()) {
                identificador = identificador + procesador.getLetraActual();
                procesador.avanzar();
            }
            if (tokenValido(identificador)) {
                return new ResultadoAnalizado(null, "No se pueden usar " + " como una variable");
            }
        } else {
            return new ResultadoAnalizado(null, "Error: los identificadores no pueden iniciar con " + procesador.getLetraActual());
        }
        return new ResultadoAnalizado(identificador, null);
    }
    
    public boolean primerCaracterValido(char primero) {
        List<Character> listaCaracteres = this.caracteres.getCaracteres();
        for (int i = 0; i < listaCaracteres.size(); i++) {
            if (primero == listaCaracteres.get(i)) {
                return true;
            }
        }
        return false;
    }
    
    public String textoPostError() {
        String error = "";
        while (!procesador.finLinea()) {
            error += procesador.getLetraActual();
            procesador.avanzar();
        }
        return error;
    }

    public boolean tokenValido(String token) {
        for (int i = 0; i < listaTokens.size(); i++) {
            if (listaTokens.get(i).equals(token)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean esEspacio() {
        return procesador.getLetraActual() == ' ' || procesador.getLetraActual() == '\t';
    }
}
