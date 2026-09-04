/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosReporte;

import Lenguaje.TipoToken;
import Lenguaje.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class ColeccionTokens {
    
    private final List<Token> tokens;
    private final ColeccionEstadisticas coleccion;
    private int contador;

    public ColeccionTokens(ColeccionEstadisticas coleccion) {
        this.coleccion = coleccion;
        tokens = new ArrayList<>();
        contador = 0;
    }
    
    public void agregarToken(TipoToken tipo, String lexema, int fila, int columna) {
        contador++;
        tokens.add(new Token(contador, tipo, lexema, fila, columna));
        coleccion.agregarEstadistica(tipo);
    }

    public List<Token> getTokens() {
        return tokens;
    }
    
}