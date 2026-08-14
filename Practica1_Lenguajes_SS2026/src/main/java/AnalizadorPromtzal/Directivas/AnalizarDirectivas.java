/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Directivas;

import AnalizadorPromtzal.Analizador;
import AnalizadorPromtzal.ProcesadorLinea;
import AnalizadorPromtzal.ResultadoAnalizado;
import Tokens.CaracteresToken;
import Tokens.Tokens;

/**
 *
 * @author milton
 */
public class AnalizarDirectivas {
    
    private final Tokens tokens;
    private final CaracteresToken caracteres;
    private final ProcesadorLinea procesador;
    private final Analizador analizador;
    
    public AnalizarDirectivas(Tokens tokens, CaracteresToken caracteres) {
        this.tokens = tokens;
        this.caracteres = caracteres;
        this.procesador =  new ProcesadorLinea();
        this.analizador = new Analizador(tokens, caracteres, procesador);
    }
    
    public void revisarTokenModelo(String linea, int indice) {
        procesador.setLineaEIndice(linea, indice);
        analizador.revisarCadenaTexto();
        ResultadoAnalizado resultado = analizador.revisarCadenaTexto();
        if (resultado.getResultado() != null && resultado.getError() == null) {
            //guarda el valor de modelo
            System.out.println("modelo reconoce: " + resultado.getResultado());
        } else if (resultado.getResultado() == null && resultado.getError() != null) {
            //guarda el error
            System.out.println(resultado.getError());
        }
    }
    
    public void revisarTokenRol(String linea, int indice) {
        procesador.setLineaEIndice(linea, indice);
        analizador.revisarCadenaTexto();
    }
    
    public void revisarTokenFormato(String linea, int indice) {
        procesador.setLineaEIndice(linea, indice);
        analizador.revisarCadenaTexto();
    }
    
}
