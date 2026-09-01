/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automata;

import Automata.Escritor.FormatoDOT;
import java.util.List;

/**
 *
 * @author milton
 */
public class ReconocimientoAutomata {
    
    private final Diccionario diccionario;
    private final List<Transicion> transiciones;
    private final FormatoDOT formatodot;
    private String estadoActual;
    
    public ReconocimientoAutomata(FormatoDOT formatodot) {
        diccionario = new Diccionario();
        transiciones = diccionario.getTransiciones();
        this.formatodot = formatodot;
        estadoActual = diccionario.getINICIO();
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    public void reconocer(char letraActual) {
        if (letraActual == ' ') {
            estadoActual = diccionario.getINICIO();
            return;
        }
        for (Transicion transicion : transiciones) {
            if (transicion.getEstados() != null) {
                for (Transicion siguiente : transicion.getEstados()) {
                    if (transicionTomada(siguiente, letraActual)) {
                        return;
                    }
                }
            } else if (transicionTomada(transicion, letraActual)) {
                return;
            }
        }
        estadoActual = diccionario.getINICIO();
    }
    
    private boolean transicionTomada(Transicion transicion, char letraActual) {
        if (transicion.getEstadoActual().equals(estadoActual) && transicion.getLetraActual() == letraActual) {
            formatodot.agregarAutomataPalabra(transicion, esFinal(transicion));
            estadoActual = transicion.getSiguiente();
            return true;
        }
        return false;
    }
    
    public void reconocerIdentificador() {
        formatodot.agregarAutomataIdentificador();
    }
    
    public void reconocerNumero() {
        formatodot.agregarAutomataNumero();
    }
    
    public void reconocerSimbolo() {
        formatodot.agregarAutomataSimbolo();
    }
    
    public void reiciniar() {
        estadoActual = diccionario.getINICIO();
    }
    
    private boolean esFinal(Transicion transicion) {
        for (Transicion actual : diccionario.getEstadosDeAceptacion()) {
            if (actual.equals(transicion)) {
                return true;
            }
        }
        return false;
    }
    
}
