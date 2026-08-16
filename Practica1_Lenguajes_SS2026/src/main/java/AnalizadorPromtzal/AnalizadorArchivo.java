/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

import AnalizadorPromtzal.Tokens.AnalizadorCadena;
import AnalizadorPromtzal.Tokens.AnalizadorToken;
import Errores.ColeccionErrores;
import Errores.ErrorLexico;
import Tokens.ColeccionTokens;
import Tokens.PalabraReservada;
import Tokens.Palabras;
import Tokens.TipoToken;
import Tokens.Token;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorArchivo {
    
    private final Palabras palabras;
    private final ProcesadorLinea procesador;
    private ColeccionTokens coleccionTokens;
    private ColeccionErrores coleccionErrores;
    private final AnalizadorCadena analizadorCadena;
    private final AnalizadorToken analizadorToken;
    private BufferedReader reader;
    private int fila;
    private int numeroAnalisis;
    
    public AnalizadorArchivo() {
        palabras = new Palabras();
        procesador = new ProcesadorLinea();
        coleccionTokens = new ColeccionTokens();
        coleccionErrores = new ColeccionErrores();
        analizadorCadena = new AnalizadorCadena(palabras, procesador, this);
        analizadorToken = new AnalizadorToken(palabras, this);
        fila = 0;
        numeroAnalisis = 0;
    }

    public List<Token> getColeccionTokens() {
        return coleccionTokens.getTokens();
    }

    public List<ErrorLexico> getColeccionErrores() {
        return coleccionErrores.getErrores();
    }
    
    public void reiniciarListas() {
        coleccionTokens = new ColeccionTokens();
        coleccionErrores = new ColeccionErrores();
    }
    
    public void agregarToken(TipoToken tipo, String lexema, int columna) {
        coleccionTokens.agregarToken(tipo, lexema, fila, columna);
    }
    
    public void agregarError(String lexema, String descripcion, int columna) {
        coleccionErrores.agregarError(lexema, descripcion, fila, columna);
    }

    public int getNumeroAnalisis() {
        return numeroAnalisis;
    }
    
    public void analizar(BufferedReader reader) throws IOException {
        this.reader = reader;
        numeroAnalisis++;
        actualizarLinea();
        while (!procesador.esLineaNula()) {
            procesador.saltarEspacios();
            if (procesador.finLinea() || procesador.lineaVacia() || procesador.esLineaNula()) {
                actualizarLinea();
            } else {
                analizarLinea();
                actualizarLinea();
            }
        }
    }
    
    private void analizarLinea() {
        while (!procesador.finLinea()) {
            String tokenActual = "";
            int columnaToken = 0;
            boolean tokenTomado = false;
            while (procesador.getLetraActual() != ' ' && !procesador.finLinea() && !tokenTomado) {
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                }
                PalabraReservada caracterEspecial = caracterEspecial(String.valueOf(procesador.getLetraActual()));
                if (caracterEspecial != null) {
                    if (palabras.getCOMILLAS() == procesador.getLetraActual()) {
                        analizadorCadena.revisarCadenaTexto();
                    } else {
                        agregarToken(caracterEspecial.getTipo(), caracterEspecial.getLexema(), procesador.getColumna());
                    }
                    if (!"".equals(tokenActual)) {
                        analizadorToken.analizarToken(tokenActual, columnaToken);
                    }
                    tokenActual = "";
                    columnaToken = 0;
                    tokenTomado = true;
                } else {
                    tokenActual += procesador.getLetraActual();
                }
                procesador.avanzar();
            }
            if (!"".equals(tokenActual)) {
                analizadorToken.analizarToken(tokenActual, columnaToken);
            }
            procesador.saltarEspacios();
        }
    }
    
    private PalabraReservada caracterEspecial(String token) {
        List<PalabraReservada> caracteresEspeciales = palabras.getCaracteres();
        for (PalabraReservada palabra : caracteresEspeciales) {
            if (palabra.getLexema().equals(token)) {
                return palabra;
            }
        }
        return null;
    }
    
    public void actualizarLinea() throws IOException {
        avanzarFila();
        procesador.setLinea(reader.readLine());
    }
    
    private void avanzarFila() {
        fila++;
    }
    
}
