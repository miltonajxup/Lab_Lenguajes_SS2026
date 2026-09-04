/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosReporte;

import Lenguaje.TipoToken;

/**
 *
 * @author milton
 */
public class EstadisticaToken {
    
    private final TipoToken tipoToken;
    private int vecesEncontrada;

    public EstadisticaToken(TipoToken tipoToken) {
        this.tipoToken = tipoToken;
        vecesEncontrada = 0;
    }
    
    public int getVecesEncontradas() {
        return vecesEncontrada;
    }
    
    public TipoToken getTipoToken() {
        return tipoToken;
    }
    
    public void seEncontró() {
        vecesEncontrada++;
    }
    
    public void reiniciar() {
        vecesEncontrada = 0;
    }
    
}
