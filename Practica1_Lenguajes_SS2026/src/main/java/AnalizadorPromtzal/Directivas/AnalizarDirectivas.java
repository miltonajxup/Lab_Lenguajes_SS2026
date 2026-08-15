/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Directivas;

import AnalizadorPromtzal.Analizador;
import AnalizadorPromtzal.ProcesadorLinea;
import AnalizadorPromtzal.ResultadoAnalizado;
import Archivos.AnalizadorArchivo;
import Tokens.CaracteresToken;
import Tokens.Palabras;
import Tokens.TipoToken;

/**
 *
 * @author milton
 */
public class AnalizarDirectivas {
    
    private final AnalizadorArchivo analizadorArchivo;
    private final Analizador analizador;
    
    public AnalizarDirectivas(Palabras palabras, CaracteresToken caracteres, ProcesadorLinea procesador, AnalizadorArchivo analizadorArchivo) {
        this.analizadorArchivo = analizadorArchivo;
        this.analizador = new Analizador(palabras, caracteres, procesador);
    }
    
    public void revisarTokenDirectiva() {
        ResultadoAnalizado resultado = analizador.revisarCadenaTexto();
        if (resultado.getResultado() != null) {
            analizadorArchivo.agregarToken(TipoToken.STRING, resultado.getResultado(), resultado.getColumna());
        } else {
            analizadorArchivo.agregarError(resultado.getLexema(), resultado.getError(), resultado.getColumna());
        }
    }
    
}
