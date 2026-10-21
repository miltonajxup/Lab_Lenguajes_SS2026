/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.resultados;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;
import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;

/**
 *
 * @author milton
 */
public class ControladorPromt {
    
    private String promt;
    
    public ControladorPromt() {
        promt = "";
    }
    
    public String getPromt() {
        return promt;
    }
    
    public void generarPromtzal(NodoArbol nodo) {
        for (NodoArbol hijo : nodo.getHijos()) {
            analizarHijo(hijo);
            generarPromtzal(hijo);
        }
    }
    
    private void analizarHijo(NodoArbol nodo) {
        TipoToken tipo = nodo.getTipo();
        switch (tipo) {
            case MODELO: {
                promt += nodo.getValor() + "\n";
                break;
            }
            case ROL: {
                promt += "Toma el rol de " + nodo.getValor() + "\n";
                break;
            }
            case FORMATO: {
                promt += "En un formato: " + nodo.getValor() + " regresa la respuesta \n";
                break;
            }
            case CONTEXTO: {
                promt += "\nEn la situacion de: " + nodo.getValor() + "\n";
                break;
            }
            case VARIABLE:  {
                gestionarVariable(nodo);
                break;
            }
            case PREGUNTAR: {
                gestionarPregunta(nodo);
                break;
            }
            case GENERAR: {
                gestionarGenerar(nodo);
                break;
            }
            case RESUMIR: {
                gestionarResumir(nodo);
                break;
            }
            case ANALIZAR: {
                gestionGenerica("Analiza", nodo);
                break;
            }
            case TRADUCIR: {
                gestionGenerica("Traduce", nodo);
                break;
            }
            case CLASIFICAR: {
                gestionGenerica("Clasifica", nodo);
                break;
            }
            case EXTRAER: {
                gestionGenerica("Extrae", nodo);
                break;
            }
        }
    }
    
    private void gestionarVariable(NodoArbol nodo) {
        if (!nodo.getHijos().isEmpty()) {
            if (nodo.getHijos().size() < 1) {
                return;
            }
            promt += "Toma los archivo: \n";
            String archivos = "";
            for (NodoArbol hijo : nodo.getHijos()) {
                archivos += hijo.getValor() + "   ";
            }
            promt += archivos + "\n\nY guardalos en la variable: " + nodo.getValor() + "\n";
        } else  {
            String valorVariable = "Toma el valor: ";
            for (NodoArbol hijo : nodo.getHijos()) {
                valorVariable += hijo.getValor() + "   ";
            }
            promt += "\n" + valorVariable + "\nY guardalo en la variable: " + nodo.getValor() + "\n";
        }
    }
    
    private void gestionarPregunta(NodoArbol pregunta) {
        if (pregunta.getHijos().size() < 1) {
            return;
        }
        promt += "\nEntonces, " + pregunta.getValor() 
                + "\nEn base al valor " + pregunta.getHijos().get(0).getValor() + " y asignalo a la variable "  + pregunta.getHijos().get(1).getValor() + "\n";
    }
    
    private void gestionarGenerar(NodoArbol generar) {
        if (generar.getHijos().size() < 1) {
            return;
        }
        NodoArbol desde = generar.getHijos().get(0);
        NodoArbol asignar = generar.getHijos().get(1);
        if (desde.getValor() == null) {
            promt += "\nAhora Genera " + generar.getValor() + " a partir de " + desde.getHijos().get(0).getValor() + " junto con " + desde.getHijos().get(2).getValor()
                    + "\nY asignalo a la variable " + asignar.getValor() + "\n";
        } else {
            promt += "Ahora Genera " + generar.getValor() + " a partir de " + desde.getValor() + "\nY asignalo a la variable " + asignar.getValor() + "\n";
        }
    }
    
    private void gestionarResumir(NodoArbol nodo) {
        if (nodo.getHijos().size() < 3) {
            return;
        }
        String cantidad = nodo.getHijos().get(1).getValor();
        String id = nodo.getHijos().get(2).getValor();
        String asignar = nodo.getHijos().get(3).getValor();
        promt += "\nResume el valor de " + nodo.getValor() + " en " + cantidad + " " + id + " y asignalo a la variable " + asignar + "\n";
    }
    
    private void gestionGenerica(String tipoGestion, NodoArbol nodo) {
        if (nodo.getHijos().size() < 1) {
            return;
        }
        String valorOpciones = nodo.getHijos().get(0).getValor();
        String asignar = nodo.getHijos().get(1).getValor();
        promt += "\n" + tipoGestion + " el valor de " + nodo.getValor() + " en " + valorOpciones + " y asignarlo a la variable " + asignar + "\n";
    }
    
}
