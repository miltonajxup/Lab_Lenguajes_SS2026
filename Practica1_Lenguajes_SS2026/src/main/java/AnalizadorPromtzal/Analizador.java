/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

import Tokens.CaracteresToken;
import Tokens.PalabraReservada;
import Tokens.Palabras;
import java.util.List;

/**
 *
 * @author milton
 */
public class Analizador {
    
    private final CaracteresToken caracteres;
    private final List<PalabraReservada> listaPalabras;
    private final ProcesadorLinea procesador;

    public Analizador(Palabras palabras, CaracteresToken caracteres, ProcesadorLinea procesador) {
        this.caracteres = caracteres;
        this.listaPalabras = palabras.getPalabras();
        this.procesador = procesador;
    }
    
    public ResultadoAnalizado revisarCadenaTexto() {
        return revisarCadenaTexto(true);
    }

    public ResultadoAnalizado revisarCadenaTexto(boolean soloCadena) {
        String instruccion = "";
        boolean cerrarCadena = false;
        int columnaToken = 0;
        procesador.saltarEspacios();
        if (procesador.getLetraActual() == caracteres.getCOMILLAS()) {
            while (!cerrarCadena) {
                procesador.avanzar();
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                }
                if (procesador.finLinea()) {
                    return new ResultadoAnalizado(null, "Error no se esta cerrando la cadena de texto despues de \"" + instruccion, columnaToken, instruccion);
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
            if (procesador.getLetraActual() != caracteres.getCOMILLAS() && !esEspacio() && soloCadena) {
                String error = textoPostError();
                return new ResultadoAnalizado(null, "Error: no se reconoce " + error, procesador.getColumna(), error);
            }
        } else {
            String error = textoPostError();
            return new ResultadoAnalizado(null, "Se espera una cadena y " + error + " no es una cadena", procesador.getColumna(), error);
        }
        return new ResultadoAnalizado(instruccion, null, columnaToken);
    }
    
    public ResultadoAnalizado validarIdentificador() {
        String identificador = "";
        int columnaToken = 0;
        if (caracteres.getGUION_BAJO() == procesador.getLetraActual() || primerCaracterValido(procesador.getLetraActual())) {
            while (!esEspacio() && !procesador.finLinea()) {
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                }
                identificador = identificador + procesador.getLetraActual();
                procesador.avanzar();
            }
            if (palabraValida(identificador) != null) {
                return new ResultadoAnalizado(null, "No se pueden usar " + identificador + " como una variable", columnaToken, identificador);
            }
        } else {
            return new ResultadoAnalizado(null, "Error: los identificadores no pueden iniciar con " + procesador.getLetraActual(), procesador.getColumna(), identificador);
        }
        return new ResultadoAnalizado(identificador, null, columnaToken);
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

    public PalabraReservada palabraValida(String token) {
        for (PalabraReservada palabraReservada : listaPalabras) {
            if (palabraReservada.getLexema().equals(token)) {
                return palabraReservada;
            }
        }
        return null;
    }
    
    public boolean esEspacio() {
        return procesador.getLetraActual() == ' ' || procesador.getLetraActual() == '\t';
    }
}
