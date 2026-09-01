/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class Transicion {
    
    private final String estadoActual;
    private char letraActual;
    private String siguiente;
    private List<Transicion> estados;

    public Transicion(String estadoActual, char letraActual, String siguiente) {
        this.estadoActual = estadoActual;
        this.letraActual = letraActual;
        this.siguiente = siguiente;
    }
    
    public Transicion(String estadoActual) {
        this.estadoActual = estadoActual;
        estados = new ArrayList<>();
    }
    
    public String getEstadoActual() {
        return estadoActual;
    }

    public char getLetraActual() {
        return letraActual;
    }

    public String getSiguiente() {
        return siguiente;
    }
    
    public void agregarSiguiente(char letraActual, String siguiente) {
        estados.add(new Transicion(estadoActual, letraActual, siguiente));
    }
    
    public void agregarSiguiente(Transicion transicion) {
        estados.add(transicion);
    }
    
    public List<Transicion> getEstados() {
        return estados;
    }

}
