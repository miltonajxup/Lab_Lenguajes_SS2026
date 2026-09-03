/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import AnalizadorPromtzal.AnalizadorArchivo;
import DatosReporte.Errores.ErrorLexico;
import Frontent.PanelRegistroToken;
import Frontent.PromtZal;
import Lenguaje.Token;
import java.util.List;

/**
 *
 * @author milton
 */
public class ControladorRegistros {
    
    private final AnalizadorArchivo analizador;
    private PromtZal promtzal;

    public ControladorRegistros(AnalizadorArchivo analizador) {
        this.analizador = analizador;
    }

    public void setPromtzal(PromtZal promtzal) {
        this.promtzal = promtzal;
    }
    
    public void colocarRegistrosTokens() {
        List<Token> tokens = analizador.getColeccionTokens();
        ajustarEspacioRegistros(tokens.size());
        for (Token token : tokens) {
            PanelRegistroToken panel = new PanelRegistroToken(token.getNumero(), token.getTipo().name(), token.getLexema(), token.getFila(), token.getColumna());
            promtzal.agregarRegistro(panel);
        }
        if (tokens.isEmpty()) {
            promtzal.agregarMesajeMostrar("No se reconocio ni un token");
        }
    }
    
    public void colocarRegistrosError() {
        List<ErrorLexico> errores = analizador.getColeccionErrores();
        ajustarEspacioRegistros(errores.size());
        for (ErrorLexico error : errores) {
            PanelRegistroToken panel = new PanelRegistroToken(error.getNumero(), error.getErrorLexico(), error.getDescripcion(), error.getFila(), error.getColumna());
            promtzal.agregarRegistro(panel);
        }
        if (errores.isEmpty()) {
            promtzal.agregarMesajeMostrar("No se encontraron errores");
        }
    }
    
    
    
    private void ajustarEspacioRegistros(int filas) {
        promtzal.limipiarEspacio();
        promtzal.setTamañoPanel(filas);
    }
    
}
