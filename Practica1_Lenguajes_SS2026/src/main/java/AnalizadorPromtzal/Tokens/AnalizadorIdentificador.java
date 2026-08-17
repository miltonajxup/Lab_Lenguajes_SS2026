/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Tokens;

import AnalizadorPromtzal.AnalizadorArchivo;
import Tokens.PalabraReservada;
import Tokens.Palabras;
import Tokens.TipoToken;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorIdentificador {
    
    private final Palabras palabras;
    private final AnalizadorArchivo analizadorArchivo;

    public AnalizadorIdentificador(Palabras palabras, AnalizadorArchivo analizadorArchivo) {
        this.palabras = palabras;
        this.analizadorArchivo = analizadorArchivo;
    }
    
    public void analizarToken(String token, int columnaToken) {
        boolean tokenTomado = false;
        PalabraReservada palabra = palabraValida(token);
        if (palabra != null && !tokenTomado) {
            analizadorArchivo.agregarToken(palabra.getTipo(), palabra.getLexema(), columnaToken);
            tokenTomado = true;
        }
        
        boolean identificadorValido = primerCaracterValido(token.charAt(0));
        if (identificadorValido && !tokenTomado) {
            analizadorArchivo.agregarToken(TipoToken.IDENTIFICADOR, token, columnaToken);
            tokenTomado = true;
        }
        
        if (!tokenTomado) {
            analizadorArchivo.agregarError(token, "Error: No se pudo reconocer " + token, columnaToken);
        }
    }
    
    public PalabraReservada palabraValida(String token) {
        List<PalabraReservada> listaPalabras = palabras.getPalabras();
        for (PalabraReservada palabraReservada : listaPalabras) {
            if (palabraReservada.getLexema().equals(token)) {
                return palabraReservada;
            }
        }
        return null;
    }
    
    private boolean primerCaracterValido(char primero) {
        String primeroString = String.valueOf(primero);
        if (primero == palabras.getGUION_BAJO()) {
            return true;
        }
        List<PalabraReservada> caracteres = palabras.getCaracteres();
        for (PalabraReservada palabra : caracteres) {
            if (palabra.getLexema().equals(primeroString)) {
                return false;
            }
        }
        List<String> numeros = palabras.getNumeros();
        for (String numero : numeros) {
            if (numero.equals(primeroString)) {
                return false;
            }
        }
        return true;
    }
    
}
