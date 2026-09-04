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
            if (transicion.getEstadoActual().equals(diccionario.getQ_LETRA())) {
                System.out.println("letra entrante: " + letraActual);
            }
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
        if (diccionario.getQ_COMILLA().equals(estadoActual)) {
            System.out.println("letra: " + letraActual);
            formatodot.agregarNodoLetra();
            estadoActual = diccionario.getQ_LETRA();
            return;
        }
        if (esEstadoFinalAceptado()) {
            formatodot.terminarComoIdentificador(estadoActual);
        }
        reiniciarEstado();
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
        reiniciarEstado();
        formatodot.reiniciarAutomataOdt();
    }
    
    public void reiniciarEstado() {
        estadoActual = diccionario.getINICIO();
    }
    
    private boolean esFinal(Transicion transicion) {
        for (Transicion actual : diccionario.getEstadosDeAceptacion()) {
            if (actual.equals(transicion)) {
                if (actual.getSiguiente().equals(diccionario.getQ_COMILLA())) {
                    System.out.println(actual.getEstadoActual()+actual.getSiguiente()+actual.getLetraActual());
                    reiniciarEstado();
                }
                return true;
            }
        }
        return false;
    }
    
    private boolean esEstadoFinalAceptado() {
        for (Transicion actual : diccionario.getEstadosDeAceptacion()) {
            if (actual.getSiguiente().equals(estadoActual)) {
                return true;
            }
        }
        return false;
    }
    
}
