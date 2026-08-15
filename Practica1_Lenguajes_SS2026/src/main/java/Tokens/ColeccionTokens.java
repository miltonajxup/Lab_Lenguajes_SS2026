/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tokens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class ColeccionTokens {
    
    private final List<Token> tokens;
    private int contador;

    public ColeccionTokens() {
        this.tokens = new ArrayList<>();
        contador = 0;
    }
    
    public void agregarToken(TipoToken tipo, String lexema, int fila, int columna) {
        contador++;
        tokens.add(new Token(contador, tipo, lexema, fila, columna));
    }

    public List<Token> getTokens() {
        return tokens;
    }
    
}
