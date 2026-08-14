/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.PalabrasReservadas;

import AnalizadorPromtzal.Analizador;
import AnalizadorPromtzal.ProcesadorLinea;
import AnalizadorPromtzal.ResultadoAnalizado;
import Tokens.CaracteresToken;
import Tokens.Tokens;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author milton
 */
public class AnalizadorPalabrasReservadas {
    
    private final Tokens tokens;
    private final CaracteresToken caracteres;
    private final ProcesadorLinea procesador;
    private final Analizador analizador;
    
    public AnalizadorPalabrasReservadas(Tokens tokens, CaracteresToken caracteres) {
        this.tokens = tokens;
        this.caracteres = caracteres;
        this.procesador = new ProcesadorLinea();
        this.analizador = new Analizador(tokens, caracteres, procesador);

    }
    
    public void revisarTokenAgente(String linea, BufferedReader reader, int indice) throws IOException {
        procesador.setLineaEIndice(linea, indice);
        procesador.saltarEspacios();
        //utilizar identificadorAgente
        analizador.validarIdentificador();
        procesador.saltarEspacios();
        if (caracteres.getLLAVE_IZQUIERDA() == procesador.getLetraActual()) {
            analizarContenidoAgente(linea, reader);
            return;
        } 
        reportarError("Se espera un delimitador de tipo '{' para aperturar el agente");
        analizarContenidoAgente(linea, reader);
    }
    
    private void analizarContenidoAgente(String linea, BufferedReader reader) throws IOException {
        String token = "";
        while (procesador.getLetraActual() != caracteres.getLLAVE_DERECHA()) {
            if (!analizador.esEspacio()) {
                procesador.avanzar();
            } else {
                procesador.saltarEspacios();
            }
            if (procesador.finLinea()) {
                linea = reader.readLine();
                if (linea == null) {
                    reportarError("Nunca se cerro el agente con un delimitador de tipo '}'");
                    return;
                }
                procesador.setLineaEIndice(linea, 0);
            }
            if (!analizador.esEspacio()) {
                token += procesador.getLetraActual();
            } else if (!"".equals(token)) {
                String siguienteLinea = revisarToken(token, reader);
                if (siguienteLinea != null) {
                    linea = siguienteLinea;
                    procesador.setLineaEIndice(linea, 0);
                } else {
                    revisarTokensInternosAgente(token, linea);
                }
                token = "";
            }
        }
    }
    
    private void revisarTokensInternosAgente(String token, String linea) {
        procesador.saltarEspacios();
        if (tokens.getTOKEN_CONTEXTO().equals(token)) {
            //Usar token de AGENTE (contexto)
            ResultadoAnalizado p = igualarConVariable(linea);
        } else if (tokens.getTOKEN_VARIABLE().equals(token)) {
            //utilizar identificador
            ResultadoAnalizado variable = analizador.validarIdentificador();
            if (variable == null) {
                reportarError("No se pudo encontrar el nombre de la variable");
                return;
            }
            procesador.saltarEspacios();
            //Usar token de AGENTE (variable)
            ResultadoAnalizado resultado = igualarConVariable(linea);
        } else if (tokens.getTOKEN_PREGUNTAR().equals(token)) {
            ResultadoAnalizado pregunta = analizador.revisarCadenaTexto();
        }
    }
    
    private ResultadoAnalizado igualarConVariable(String linea) {
        if (caracteres.getIGUAL() == procesador.getLetraActual()) {
            procesador.avanzar();
            procesador.saltarEspacios();
            return analizador.revisarCadenaTexto();
        }
        return new ResultadoAnalizado(null, "Error: contexto espera un =");
    }
    
    private boolean tokenInvalidoAgente(String token) {
        return tokens.getTOKEN_MODELO().equals(token) || 
                tokens.getTOKEN_ROL().equals(token) || 
                tokens.getTOKEN_FORMATO().equals(token) ||
                tokens.getTOKEN_EJECUTAR().equals(token) ||
                tokens.getTOKEN_EXPORTAR().equals(token);
    }
    
    private void reportarError(String mensaje) {
        System.out.println(mensaje);
    }
    
    private String revisarToken(String token, BufferedReader reader) throws IOException {
        if (!analizador.tokenValido(token)) {
            reportarError("Error: " + token + " no puede reconocerse");
            return reader.readLine();
        }
        if (tokenInvalidoAgente(token)) {
            reportarError("Error: " + token + " no puede ser reconocido dentro de agente");
            return reader.readLine();
        }
        return null;
    }
    
}
