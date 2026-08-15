/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tokens;

/**
 *
 * @author milton
 */
public class PalabraReservada {
    
    private final String lexema;
    private final TipoToken tipo;

    public PalabraReservada(String lexema, TipoToken tipo) {
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public TipoToken getTipo() {
        return tipo;
    }
    
}
