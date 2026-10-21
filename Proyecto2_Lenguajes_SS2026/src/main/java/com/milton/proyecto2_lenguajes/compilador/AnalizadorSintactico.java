/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSintactico;
import com.milton.proyecto2_lenguajes.compilador.reglas.Ambito;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoSimbolo;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorSintactico {
    
    private final List<Token> tokens;
    private final List<ErrorSintactico> errores;
    private final NodoArbol programa;
    private final List<Simbolo> simbolos;
    private Token actual;
    private int indice;
    
    public AnalizadorSintactico(List<Token> tokens, List<ErrorSintactico> errores, NodoArbol programa, List<Simbolo> simbolos) {
        this.tokens = tokens;
        this.errores = errores;
        this.programa = programa;
        this.simbolos = simbolos;
    }
    
    public void analizar() {
        if (tokens.isEmpty()) {
            return;
        }
        indice = 0;
        actual = tokens.get(indice);
        while (!esFinal()) {
            consumir(programa);
        }
    }
    
    private void consumir(NodoArbol padrePrincipal) {
        TipoToken tipo = actual.getTipo();
        if (tipo == TipoToken.MODELO || tipo == TipoToken.ROL | tipo == TipoToken.FORMATO) {
            
            Token token = actual;
            if (!avanzarRevisandoError(TipoToken.CADENA, TipoToken.CADENA)) {
                padrePrincipal.agregarHijo(new NodoArbol(tipo, actual.getLexema()));
            }
            simbolos.add(new Simbolo(token.getLexema(), TipoSimbolo.CONFIGURACION, Ambito.GLOBAL, tipo, token.getFila(), token.getColumna(), actual.getLexema()));
        } else if (tipo == TipoToken.AGENTE) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol agente = new NodoArbol(tipo, actual.getLexema());
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.AGENTE, Ambito.GLOBAL, TipoToken.IDENTIFICADOR, actual.getFila(), actual.getColumna()));
            
            if (avanzarRevisandoError(TipoToken.LLAVE_IZQ, TipoToken.LLAVE_DER)) {
                return;
            }
            avanzar();
            
            while (actual.getTipo() != TipoToken.LLAVE_DER && !esFinal()) {
                analizarAgente(agente);
            }
            
            padrePrincipal.agregarHijo(agente);
        } else if (tipo == TipoToken.EJECUTAR) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol ejecutar = new NodoArbol(TipoToken.EJECUTAR, actual.getLexema());
            padrePrincipal.agregarHijo(ejecutar);
            
        } else if (tipo == TipoToken.EXPORTAR) {
            
            NodoArbol exportar = new NodoArbol(TipoToken.EXPORTAR, null);
            padrePrincipal.agregarHijo(exportar);
            
            NodoArbol id = getIdentificador();
            if (id == null) {
                return;
            }
            exportar.agregarHijo(id);
            
            avanzar();
            while (actual.getTipo() == TipoToken.COMA && !esFinal()) {
                NodoArbol idExtra = getIdentificador();
                if (idExtra != null) {
                    exportar.agregarHijo(idExtra);
                } else {
                    return;
                }
                avanzar();
            }
            
        }else {
            errores.add(new ErrorSintactico("No se puede reconocer: '" + tokens.get(indice).getLexema() + "'", actual.getFila(), actual.getColumna()));
        }
        avanzar();
    }
    
    private NodoArbol getIdentificador() {
        if (!avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
            return new NodoArbol(TipoToken.IDENTIFICADOR, actual.getLexema());
        }
        return null;
    }
    
    private void analizarAgente(NodoArbol agente) {
        TipoToken tipo = actual.getTipo();
        
        if (tipo == TipoToken.CONTEXTO) {
            
            if (avanzarRevisandoError(TipoToken.ASIGNACION, TipoToken.CADENA)) {
                return;
            }
            if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.CADENA)) {
                return;
            }
            NodoArbol contexto = new NodoArbol(tipo, actual.getLexema());
            agente.agregarHijo(contexto);
            simbolos.add(new Simbolo("contexto", TipoSimbolo.CONFIGURACION, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna(), actual.getLexema()));
            
        } else if (tipo == TipoToken.VARIABLE) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol variable = new NodoArbol(tipo, actual.getLexema());
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.VARIABLE, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
            if (avanzarRevisandoError(TipoToken.ASIGNACION, TipoToken.ASIGNACION)) {
                return;
            }
            avanzar();
            
            analizarVariable(variable);
            
            agente.agregarHijo(variable);
            
        } else if (tipo == TipoToken.PREGUNTAR) {
            if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.IDENTIFICADOR)) {
                return;
            }
            
            NodoArbol preguntar = new NodoArbol(TipoToken.PREGUNTAR, actual.getLexema());
            agente.agregarHijo(preguntar);
            
            if (avanzarRevisandoError(TipoToken.SOBRE, TipoToken.IDENTIFICADOR)) {
                return;
            }
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            
            NodoArbol sobre = new NodoArbol(TipoToken.SOBRE, actual.getLexema());
            preguntar.agregarHijo(sobre);
            
            agregarNodoAsinar(preguntar);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
        } else if (tipo == TipoToken.GENERAR) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol generar = new NodoArbol(TipoToken.GENERAR, actual.getLexema());
            agente.agregarHijo(generar);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.VARIABLE, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
            if (avanzarRevisandoError(TipoToken.DESDE, TipoToken.IDENTIFICADOR)) {
                return;
            }
            if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.IDENTIFICADOR)) {
                return;
            }
            
            String cadenaDesde = actual.getLexema();
            analizarGenerar(generar, cadenaDesde);
            
        } else if (tipo == TipoToken.RESUMIR) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            
            NodoArbol resumir = new NodoArbol(TipoToken.RESUMIR, actual.getLexema());
            agente.agregarHijo(resumir);
            
            if (avanzarRevisandoError(TipoToken.EN, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol conector = new NodoArbol(TipoToken.EN, actual.getLexema());
            if (avanzarRevisandoError(TipoToken.ENTERO, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol entero = new NodoArbol(TipoToken.ENTERO, actual.getLexema());
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol id = new NodoArbol(TipoToken.IDENTIFICADOR, actual.getLexema());
            resumir.agregarHijo(conector);
            resumir.agregarHijo(entero);
            resumir.agregarHijo(id);
            
            agregarNodoAsinar(resumir);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
        } else if (tipo == TipoToken.ANALIZAR) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol analizar = new NodoArbol(TipoToken.ANALIZAR, actual.getLexema());
            agente.agregarHijo(analizar);
            
            if (avanzarRevisandoError(TipoToken.SOBRE, TipoToken.IDENTIFICADOR)) {
                return;
            }
            if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol sobre = new NodoArbol(TipoToken.SOBRE, actual.getLexema());
            analizar.agregarHijo(sobre);
            
            agregarNodoAsinar(analizar);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
        } else if (tipo == TipoToken.TRADUCIR) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol traducir = new NodoArbol(TipoToken.TRADUCIR, actual.getLexema());
            agente.agregarHijo(traducir);
            
            agregarEnConCadena(traducir);
            
            agregarNodoAsinar(traducir);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
        } else if (tipo == TipoToken.CLASIFICAR) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol clasificar = new NodoArbol(TipoToken.CLASIFICAR, actual.getLexema());
            agente.agregarHijo(clasificar);
            
            agregarEnConCadena(clasificar);
            
            agregarNodoAsinar(clasificar);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
        } else if (tipo == TipoToken.EXTRAER) {
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol extraer = new NodoArbol(TipoToken.EXTRAER, actual.getLexema());
            agente.agregarHijo(extraer);
            
            if (avanzarRevisandoError(TipoToken.DESDE, TipoToken.IDENTIFICADOR)) {
                return;
            }
            if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.IDENTIFICADOR)) {
                return;
            }
            NodoArbol desde = new NodoArbol(TipoToken.DESDE, actual.getLexema());
            extraer.agregarHijo(desde);
            
            agregarNodoAsinar(extraer);
            simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
            
        } else {
            errores.add(new ErrorSintactico(
                    "No se puede comenzar una secuencia con " + actual.getTipo() + "(" + tokens.get(indice).getLexema() + ") dentro de un " + TipoToken.AGENTE, 
                    actual.getFila(), 
                    actual.getColumna()));
        }
        avanzar();
    }
    
    private void analizarVariable(NodoArbol variable) {
        TipoToken tipo = actual.getTipo();
        if (tipo == TipoToken.CARGAR) {
            
            if (avanzarRevisandoError(TipoToken.PARENTESIS_IZQ, TipoToken.PARENTESIS_DER)) {
                return;
            }
            if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.PARENTESIS_DER)) {
                return;
            }
            
            NodoArbol cargar = new NodoArbol(TipoToken.CARGAR, actual.getLexema());
            
            if (avanzarRevisandoError(TipoToken.PARENTESIS_DER, TipoToken.PARENTESIS_DER)) {
                return;
            }
            variable.agregarHijo(cargar);
        } else if (tipo == TipoToken.CADENA) {
            
            variable.agregarHijo(new NodoArbol(TipoToken.CADENA, actual.getLexema()));
        } else {
            errores.add(new ErrorSintactico(
                    "Se espera un una " + TipoToken.CADENA + " o un Comando " + TipoToken.CARGAR + " pero se encuentra " + actual.getTipo(), 
                    actual.getFila(), 
                    actual.getColumna()));
        }
    }
    
    private void analizarGenerar(NodoArbol generar, String cadenaGenerar) {
        avanzar();
        TipoToken tipo = actual.getTipo();
        if (tipo == TipoToken.ASIGNAR) {
            NodoArbol desde = new NodoArbol(TipoToken.DESDE, cadenaGenerar);
            generar.agregarHijo(desde);
            
            agregarNodoAsinar(generar);
            
        } else if (tipo == TipoToken.CONCATENACION) {
            NodoArbol desde = new NodoArbol(TipoToken.DESDE, null);
            generar.agregarHijo(desde);
            
            NodoArbol cadena = new NodoArbol(TipoToken.CADENA, cadenaGenerar);
            desde.agregarHijo(cadena);
            
            NodoArbol concatenacion = new NodoArbol(TipoToken.CONCATENACION, actual.getLexema());
            desde.agregarHijo(concatenacion);
            
            if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
                return;
            }
            
            NodoArbol variableDesde = new NodoArbol(TipoToken.IDENTIFICADOR, actual.getLexema());
            desde.agregarHijo(variableDesde);
            
            agregarNodoAsinar(generar);
        }
        simbolos.add(new Simbolo(actual.getLexema(), TipoSimbolo.ASIGNAR, Ambito.AGENTE, tipo, actual.getFila(), actual.getColumna()));
    }
    
    private void agregarNodoAsinar(NodoArbol nodo) {
        if (avanzarRevisandoError(TipoToken.ASIGNAR, TipoToken.IDENTIFICADOR)) {
            return;
        }
        if (avanzarRevisandoError(TipoToken.IDENTIFICADOR, TipoToken.IDENTIFICADOR)) {
            return;
        }

        NodoArbol asignar = new NodoArbol(TipoToken.ASIGNAR, actual.getLexema());
        nodo.agregarHijo(asignar);
    }
    
    private void agregarEnConCadena(NodoArbol nodo) {
        if (avanzarRevisandoError(TipoToken.EN, TipoToken.IDENTIFICADOR)) {
            return;
        }
        if (avanzarRevisandoError(TipoToken.CADENA, TipoToken.IDENTIFICADOR)) {
            return;
        }
        NodoArbol conector = new NodoArbol(TipoToken.EN, actual.getLexema());
        nodo.agregarHijo(conector);
    }
    
    
    
    private boolean esFinal() {
        return indice >= tokens.size();
    }
    
    private void avanzar() {
        indice++;
        if (!esFinal()) {
            actual = tokens.get(indice);
        }
    }
    
    private boolean avanzarRevisandoError(TipoToken tokenEsperado, TipoToken tokenDeCierrre) {
        avanzar();
        if (actual.getTipo() != tokenEsperado) {
            while (actual.getTipo() != tokenDeCierrre && !esFinal()) {
                errores.add(new ErrorSintactico(
                        "Error sintactico: Se espera '" + tokenEsperado + "' pero encuentra '" + actual.getTipo() + "'", 
                        actual.getFila(), 
                        actual.getColumna()));
                avanzar();
            }
            return true;
        }
        return false;
    }
    
}
