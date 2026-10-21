/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.compilador;

import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSemantico;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoSimbolo;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorSemantico {
    
    private final List<Simbolo> simbolos;
    private final List<ErrorSemantico> errores;
    private final List<Simbolo> agentes;
    private final List<Simbolo> variables;
    private Simbolo agenteActual;

    public AnalizadorSemantico(List<Simbolo> simbolos, List<ErrorSemantico> errores) {
        this.simbolos = simbolos;
        this.errores = errores;
        agentes = new ArrayList<>();
        variables = new ArrayList<>();
    }
    
    public void agregar(Simbolo nuevo) {
        if (nuevo.getTipoSimbolo() == TipoSimbolo.AGENTE) {
            for (Simbolo agente : agentes) {
                if (agente.getNombre().equals(nuevo.getNombre())) {
                    errores.add(new ErrorSemantico(
                            "Error Semantico: La variable '" + agente.getNombre() + "' ya se ha declarado", 
                            nuevo.getFila(), 
                            nuevo.getColumna()));
                    return;
                }
            }
            agenteActual = nuevo;
            agentes.add(nuevo);
        }
        
        if (agenteActual != null && (nuevo.getTipoSimbolo() == TipoSimbolo.VARIABLE || nuevo.getTipoSimbolo() == TipoSimbolo.ASIGNAR)) {
            if (nuevo.getNombre().equals(agenteActual.getNombre())) {
                errores.add(new ErrorSemantico(
                        "Error Semantico: La nombre de la variable '" + nuevo.getNombre() + "' ya esta siendo utilizada", 
                        nuevo.getFila(), 
                        nuevo.getColumna()));
                return;
            }
            for (Simbolo variable : variables) {
                if (variable.getNombre().equals(nuevo.getNombre())) {
                    errores.add(new ErrorSemantico(
                            "Error Semantico: La variable '" + variable.getNombre() + "' ya esta siento utilizada", 
                            nuevo.getFila(), 
                            nuevo.getColumna()));
                    return;
                }
            }
            variables.add(nuevo);
        }
        
        simbolos.add(nuevo);
    }
    
    public void revisarEjecucionAgente(Token agente) {
        for (Simbolo actual : agentes) {
            if (actual.getNombre().equals(agente.getLexema())) {
                return;
            }
        }
        errores.add(new ErrorSemantico(
                "El agente '" + agente.getLexema() + "' no se ha podido encontrar", 
                agente.getFila(), 
                agente.getColumna()));
    }
    
    public void revisarVariables(Token variable) {
        for (Simbolo actual : variables) {
            if (actual.getNombre().equals(variable.getLexema())) {
                return;
            }
        }
        errores.add(new ErrorSemantico(
                "La variable '" + variable.getLexema() + "' no se ha podido encontrar", 
                variable.getFila(), 
                variable.getColumna()));
    }
    
}
