/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosReporte;

import Lenguaje.PalabraReservada;
import Lenguaje.TipoToken;

/**
 *
 * @author milton
 */
public class EstadisticaToken {
    
    private final PalabraReservada palabra;
    private int vecesEncontrada;

    public EstadisticaToken(PalabraReservada palabra) {
        this.palabra = palabra;
        vecesEncontrada = 0;
    }
    
    public int getVecesEncontradas() {
        return vecesEncontrada;
    }
    
    public TipoToken getTipoToken() {
        return palabra.getTipo();
    }
    
    public String getColorCss() {
        return palabra.getColorCss();
    }
    
    public void seEncontró() {
        vecesEncontrada++;
    }
    
    public void reiniciar() {
        vecesEncontrada = 0;
    }
    
}
