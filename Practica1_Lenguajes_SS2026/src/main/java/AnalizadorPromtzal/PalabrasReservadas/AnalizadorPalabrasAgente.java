/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.PalabrasReservadas;

import AnalizadorPromtzal.Analizador;
import AnalizadorPromtzal.PalabrasReservadas.Agente.AnalizadorTokenCarga;
import AnalizadorPromtzal.ProcesadorLinea;
import AnalizadorPromtzal.ResultadoAnalizado;
import Archivos.AnalizadorArchivo;
import Tokens.CaracteresToken;
import Tokens.PalabraReservada;
import Tokens.Palabras;
import Tokens.TipoToken;
import java.io.IOException;

/**
 *
 * @author milton
 */
public class AnalizadorPalabrasAgente {
    
    private final Palabras palabras;
    private final CaracteresToken caracteres;
    private final ProcesadorLinea procesador;
    private final AnalizadorArchivo analizadorArchivo;
    private final Analizador analizador;
    private final AnalizadorTokenCarga analizadorCarga;
    private String identificadorVariable;
    
    public AnalizadorPalabrasAgente(Palabras tokens, CaracteresToken caracteres, ProcesadorLinea procesador, AnalizadorArchivo analizadorArchivo) {
        this.palabras = tokens;
        this.caracteres = caracteres;
        this.procesador = procesador;
        this.analizadorArchivo = analizadorArchivo;
        this.analizador = new Analizador(tokens, caracteres, procesador);
        this.analizadorCarga = new AnalizadorTokenCarga(tokens, caracteres, procesador, analizadorArchivo, analizador);
    }

    public void revisarTokenAgente() throws IOException {
        procesador.saltarEspacios();
        ResultadoAnalizado variableAgente = analizador.validarIdentificador();
        analizadorArchivo.agregarToken(TipoToken.IDENTIFICADOR, variableAgente.getResultado(), variableAgente.getColumna());
        procesador.saltarEspacios();
        if (caracteres.getLLAVE_IZQUIERDA() == procesador.getLetraActual()) {
            analizadorArchivo.agregarToken(TipoToken.SIMBOLO, String.valueOf(procesador.getLetraActual()), procesador.getColumna());
            procesador.avanzar();
            if (procesador.finLinea()) {
                analizadorArchivo.actualizarLinea();
            }
            analizarContenidoAgente();
            return;
        } 
        analizadorArchivo.agregarError(String.valueOf(procesador.getIndiceLetra()), "Se espera un delimitador de tipo '{' para aperturar el agente", procesador.getColumna());
        analizarContenidoAgente();
    }
    
    private void analizarContenidoAgente() throws IOException {
        String token = "";
        int columnaToken = 0;
        while (procesador.getLetraActual() != caracteres.getLLAVE_DERECHA()) {
            if (!analizador.esEspacio()) {
                procesador.avanzar();
            } else {
                procesador.saltarEspacios();
            }
            if (procesador.finLinea()) {
                analizadorArchivo.actualizarLinea();
                if (procesador.esLineaNula()) {
                    analizadorArchivo.agregarError("}", "Nunca se cerro el agente con un delimitador de tipo '}'", procesador.getColumna());
                    return;
                }
            }
            if (!analizador.esEspacio()) {
                token += procesador.getLetraActual();
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                }
            } else if (!"".equals(token)) {
                PalabraReservada palabra = tokenAgenteValido(token, columnaToken);
                if (palabra != null) {
                    analizadorArchivo.agregarToken(palabra.getTipo(), token, columnaToken);
                    revisarTokensInternosAgente(token);
                }
                token = "";
                columnaToken = 0;
            }
        }
        analizadorArchivo.agregarToken(TipoToken.SIMBOLO, String.valueOf(procesador.getLetraActual()), procesador.getColumna());
    }
    
    private void revisarTokensInternosAgente(String token) {
        procesador.saltarEspacios();
        if (palabras.getCONTEXTO().equals(token)) {
            igualarConVariable();
        } else if (palabras.getVARIABLE().equals(token)) {
            ResultadoAnalizado nombreVariable = analizador.validarIdentificador();
            if (nombreVariable.getResultado() == null) {
                analizadorArchivo.agregarError(nombreVariable.getLexema(), nombreVariable.getError(), nombreVariable.getColumna());
                return;
            }
            identificadorVariable = nombreVariable.getResultado();
            analizadorArchivo.agregarToken(TipoToken.IDENTIFICADOR, nombreVariable.getResultado(), nombreVariable.getColumna());
            procesador.saltarEspacios();
            //Usar token de AGENTE (variable)
            igualarConVariable();
        } else if (palabras.getPREGUNTAR().equals(token)) {
            ResultadoAnalizado pregunta = analizador.revisarCadenaTexto();
        }
    }
    
    private void igualarConVariable() {
        int columnaToken = 0;
        if (caracteres.getIGUAL() == procesador.getLetraActual()) {
            analizadorArchivo.agregarToken(TipoToken.SIMBOLO, String.valueOf(procesador.getLetraActual()), procesador.getColumna());
            procesador.avanzar();
            procesador.saltarEspacios();
            if (columnaToken == 0) {
                columnaToken = procesador.getColumna();
            }
            if (caracteres.getC() == procesador.getLetraActual()) {
                analizadorCarga.analizarCarga(columnaToken);
                return;
            } else {
                ResultadoAnalizado cadenaTexto = analizador.revisarCadenaTexto();
                if (cadenaTexto.getResultado() != null) {
                    analizadorArchivo.agregarToken(TipoToken.STRING, cadenaTexto.getResultado(), cadenaTexto.getColumna());
                } else {
                    analizadorArchivo.agregarError(cadenaTexto.getLexema(), cadenaTexto.getError(), columnaToken);
                }
                return;
            }
        }
        analizadorArchivo.agregarError(String.valueOf(procesador.getLetraActual()), "Error: se espera un simbolo " + caracteres.getIGUAL(), columnaToken);
    }
    
    private PalabraReservada tokenAgenteValido(String token, int columna) throws IOException {
        PalabraReservada palabra = tokenInternoAgente(token);
        if (palabra == null) {
            analizadorArchivo.agregarError(token, "Error: " + token + " no puede ser reconocido dentro de agente", columna);
            analizadorArchivo.actualizarLinea();
            return null;
        }
        return palabra;
    }
    
    private PalabraReservada tokenInternoAgente(String tokenActual) {
        for (PalabraReservada palabra : palabras.getPalabras()) {
            if (!palabras.getMODELO().equals(tokenActual) && 
                !palabras.getROL().equals(tokenActual) && 
                !palabras.getFORMATO().equals(tokenActual) &&
                !palabras.getEJECUTAR().equals(tokenActual) &&
                !palabras.getEXPORTAR().equals(tokenActual) && 
                palabra.getLexema().equals(tokenActual) ) {
                return palabra;
            }
        }
        return null;
    }
    
}
