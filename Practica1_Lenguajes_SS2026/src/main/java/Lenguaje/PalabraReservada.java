/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lenguaje;

/**
 *
 * @author milton
 */
public class PalabraReservada {
    
    private final String lexema;
    private final TipoToken tipo;
    private final String colorCss;

    public PalabraReservada(String lexema, TipoToken tipo, String colorCss) {
        this.lexema = lexema;
        this.tipo = tipo;
        this.colorCss = colorCss;
    }

    public String getLexema() {
        return lexema;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getColorCss() {
        return colorCss;
    }
    
}
