/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosReporte;

import Lenguaje.PalabraReservada;
import Lenguaje.Palabras;
import Lenguaje.TipoToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class ColeccionEstadisticas {
    
    private final List<EstadisticaToken> estadisticas;
    
    public ColeccionEstadisticas(Palabras palabras) {
        estadisticas = new ArrayList<>();
        iniciarLista(palabras);
    }
    
    public void agregarEstadistica(TipoToken tipo) {
        for (EstadisticaToken estadistica : estadisticas) {
            if (estadistica.getTipoToken() == tipo) {
                estadistica.seEncontró();
                return;
            }
        }
    }
    
    private void iniciarLista(Palabras palabras) {
        for (PalabraReservada palabra : palabras.getPalabras()) {
            estadisticas.add(new EstadisticaToken(palabra.getTipo()));
        }
    }
    
}
