/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automata.Escritor;

import Automata.Diccionario;
import Automata.Transicion;
import Lenguaje.Alfabeto;
import Lenguaje.PalabraReservada;
import Lenguaje.Palabras;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class FormatoDOT {
    
    private final Diccionario diccionario;
    private final Alfabeto alfabeto;
    private final Palabras palabras;
    private List<Transicion> transicionesEncontradas;
    private String automatadot;
    private boolean identificadorTomado;
    private boolean letrasComillaTomado;
    private boolean numeroTomado;
    private boolean simboloTomado;
    
    public FormatoDOT() {
        diccionario = new Diccionario();
        alfabeto = new Alfabeto();
        palabras = new Palabras();
        transicionesEncontradas = new ArrayList<>();
        iniciarAutomataOdt();
    }
    
    public void agregarAutomataPalabra(Transicion transicion, boolean esFinal) {
        if (transicionTomada(transicion)) {
            return;
        }
        String nodoActual = "\n\t" + transicion.getEstadoActual() + " [shape=circle]";
        automatadot += nodoActual;
        if (esFinal) {
            String nodoSiguiente = "\n\t" + transicion.getSiguiente()+ " [shape=doublecircle];" ;
            automatadot += nodoSiguiente;
        }
        String caracter;
        if (transicion.getLetraActual() != palabras.getCOMILLAS()) {
            caracter = "" + transicion.getLetraActual();
        } else {
            caracter = "''";
        }
        String nuevaTransicion = "\n\t" + transicion.getEstadoActual() + " -> " + transicion.getSiguiente() + " [label=\"" + caracter + "\"];\n";
        automatadot += nuevaTransicion;
    }
    
    public void agregarNodoLetra() {
        if (!letrasComillaTomado) {
            letrasComillaTomado = true;
            String nodo = "\n\t" + diccionario.getQ_LETRA() + " [shape=circle]; \n\t" 
                    + diccionario.getQ_COMILLA() + " -> " + diccionario.getQ_LETRA() + " [label=\"letra, numero, simbolo\"]\n";
            automatadot += nodo;
        }
    }
    
    public void terminarComoIdentificador(String estadoActual) {
        String finId = "\n\tq_identificador [shape=doublecircle] \n\t" 
                + estadoActual + " -> " + "q_identificador [label=\"_,letra,numero\"]\n";
        automatadot += finId;
    }
    
    public void agregarAutomataIdentificador() {
        if (!identificadorTomado) {
            identificadorTomado = true;
            String nodoId = "\n\tletra [shape=circle]; \n\tq_identificador [shape=doublecircle]; \n\t" 
                    + diccionario.getINICIO() + " -> letra [label=\"_ , letra\"] "
                    + "\n\tletra -> q_identificador [label=\"_ ,letra,numero\"] "
                    + "\n\tq_identificador -> q_identificador [label=\"_ ,letra,numero\"]\n";
            automatadot += nodoId;
        }
    }
    
    public void agregarAutomataNumero() {
        if (!numeroTomado) {
            numeroTomado = true;
            String numeros = "";
            String numerosSinPunto = "";
            for (Character numero : alfabeto.getNumeros()) {
                numeros += numero + ",";
                if (numero != alfabeto.getPUNTO()) {
                    numerosSinPunto += numero;
                }
            }
            String nodoNumero = "\n\tnumero [shape=doublecircle]; \n\t" 
                    + diccionario.getINICIO() + " -> numero [label=\"" + numeros + "\"];\n\tnumero -> numero [label=\"" + numerosSinPunto + "\"];\n";
            automatadot += nodoNumero;
        }
    }
    
    public void agregarAutomataSimbolo() {
        if (!simboloTomado) {
            simboloTomado = true;
            String simbolos = "";
            for (PalabraReservada simbolo : palabras.getCaracteres()) {
                if (!simbolo.getLexema().equals(String.valueOf(palabras.getCOMILLAS()))) {
                    simbolos += simbolo.getLexema() + ", ";
                }
            }
            String nodoSimbolo = "\n\tsimbolo [shape=doublecircle]; \n\t" 
                    + diccionario.getINICIO() + " -> simbolo [label=\"" + simbolos + "\"];\n\tsimbolo -> simbolo [label=\"" + simbolos + "\"];";
            automatadot += nodoSimbolo;
        }
    }
    
    private boolean transicionTomada(Transicion transicion) {
        for (Transicion actual : transicionesEncontradas) {
            if (actual.equals(transicion)) {
                return true;
            }
        }
        transicionesEncontradas.add(transicion);
        return false;
    }
    
    public String getAutomataDOT() {
        return automatadot + "\n}";
    }
    
    public void reiniciarAutomataOdt() {
        transicionesEncontradas = new ArrayList<>();
        iniciarAutomataOdt();
        identificadorTomado = false;
        numeroTomado = false;
        simboloTomado = false;
    }
    
    private void iniciarAutomataOdt() {
        automatadot = "digraph Automata { \n\trankdir=LR;\n\tinicio [shape=point];\n\tinicio -> " + diccionario.getINICIO() + ";\n";
    }
    
}
