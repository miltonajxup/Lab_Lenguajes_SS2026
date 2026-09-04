/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal.Tokens;

import AnalizadorPromtzal.AnalizadorArchivo;
import Automata.ReconocimientoAutomata;
import Lenguaje.PalabraReservada;
import Lenguaje.Palabras;
import Lenguaje.TipoToken;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorIdentificador {
    
    private final Palabras palabras;
    private final AnalizadorArchivo analizadorArchivo;
    private final ReconocimientoAutomata reconocimiento;

    public AnalizadorIdentificador(Palabras palabras, AnalizadorArchivo analizadorArchivo, ReconocimientoAutomata reconocimiento) {
        this.palabras = palabras;
        this.analizadorArchivo = analizadorArchivo;
        this.reconocimiento = reconocimiento;
    }
    
    public void analizarToken(String token, int columnaToken) {
        PalabraReservada palabra = palabraValida(token);
        if (palabra != null) {
            analizadorArchivo.agregarToken(palabra.getTipo(), palabra.getLexema(), columnaToken);
            return;
        }
        
        boolean identificadorValido = primerCaracterValido(token.charAt(0));
        if (identificadorValido) {
            analizadorArchivo.agregarToken(TipoToken.IDENTIFICADOR, token, columnaToken);
            reconocimiento.reconocerIdentificador();
        } else {
            analizadorArchivo.agregarError(token, "Error: " + token + " porque los identificadores no pueden iniciar con " + token.charAt(0), columnaToken);
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
