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
    private String automataodt;
    private boolean identificadorTomado;
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
        automataodt += nodoActual;
//        String nodoSiguiente;
//        if (esFinal) {
//            nodoSiguiente = "\n\t" + transicion.getSiguiente()+ "[shape=doublecircle];" ;
//        } else {
//            nodoSiguiente = "\n\t" + transicion.getSiguiente()+ "[shape=circle];" ;
//        }
//        automataodt += nodoSiguiente;
        if (esFinal) {
            String nodoSiguiente = "\n\t" + transicion.getSiguiente()+ " [shape=doublecircle];" ;
            automataodt += nodoSiguiente;
        }
        String nuevaTransicion = "\n\t" + transicion.getEstadoActual() + " -> " + transicion.getSiguiente() + " [label=\"" + transicion.getLetraActual() + "\"];\n";
        automataodt += nuevaTransicion;
    }
    
    public void agregarAutomataIdentificador() {
        if (!identificadorTomado) {
            identificadorTomado = true;
            String nodoId = "\n\tletra [shape=circle]; \n\tletra/numero [shape=doublecircle]; \n\t" 
                    + diccionario.getINICIO() + " -> letra [label=\"_, letra\"] "
                    + "\n\tletra -> letra/numero [label=\"_,letra,numero\"] "
                    + "\n\tletra/numero -> letra/numero [label=\"_,letra,numero\"]";
            automataodt += nodoId;
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
                    + diccionario.getINICIO() + " -> numero [label=\"" + numeros + "\"];\n\tnumero -> numero [label=\"" + numerosSinPunto + "\"];";
            automataodt += nodoNumero;
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
            automataodt += nodoSimbolo;
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
        return automataodt + "\n}";
    }
    
    public void reiniciarAutomataOdt() {
        transicionesEncontradas = new ArrayList<>();
        iniciarAutomataOdt();
        identificadorTomado = false;
        numeroTomado = false;
        simboloTomado = false;
    }
    
    private void iniciarAutomataOdt() {
        automataodt = "digraph Automata { \n\trankdir=LR;\n\tinicio [shape=point];\n\tinicio -> " + diccionario.getINICIO() + ";";
    }
    
}
