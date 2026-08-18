/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

import AnalizadorPromtzal.Tokens.AnalizadorCadena;
import AnalizadorPromtzal.Tokens.AnalizadorComentario;
import AnalizadorPromtzal.Tokens.AnalizadorIdentificador;
import AnalizadorPromtzal.Tokens.AnalizadorNumero;
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
    private final AnalizadorIdentificador analizadorIdentificador;
    private final AnalizadorComentario analizadorComentario;
    private final AnalizadorNumero analizadorNumero;
    private BufferedReader reader;
    private int fila;
    private int numeroAnalisis;
    private String tokenActual;
    private int columnaToken;
    private boolean tokenTomado;
    
    public AnalizadorArchivo() {
        palabras = new Palabras();
        procesador = new ProcesadorLinea();
        coleccionTokens = new ColeccionTokens();
        coleccionErrores = new ColeccionErrores();
        analizadorCadena = new AnalizadorCadena(palabras, procesador, this);
        analizadorIdentificador = new AnalizadorIdentificador(palabras, this);
        analizadorComentario = new AnalizadorComentario(palabras, procesador, this);
        analizadorNumero = new AnalizadorNumero(palabras, procesador, this);
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
        fila = 0;
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
    
    private void analizarLinea() throws IOException {
        while (!procesador.finLinea()) {
            tokenActual = "";
            columnaToken = 0;
            tokenTomado = false;
            while (procesador.getLetraActual() != ' ' && !procesador.finLinea() && !tokenTomado) {
                if (columnaToken == 0) {
                    columnaToken = procesador.getColumna();
                    revisarNumero();
                    if (procesador.esLineaNula() || procesador.finLinea()) {
                        return;
                    }
                }
                if (procesador.getLetraActual() != ' ') {
                    PalabraReservada caracterEspecial = caracterEspecial(String.valueOf(procesador.getLetraActual()));
                    if (caracterEspecial != null) {
                        revisarCaracter(caracterEspecial);
                    } else {
                        tokenActual += procesador.getLetraActual();
                    }
                }
                if (procesador.esLineaNula()) {
                    agregarError(palabras.getCOMENT_BLOQUE_FIN(), "No se encuentra el cierre de comentario de bloque '"+palabras.getCOMENT_BLOQUE_FIN()+"'", procesador.getIndiceLetra());
                    return;
                }
                procesador.avanzar();
            }
            if (!"".equals(tokenActual)) {
                analizadorIdentificador.analizarToken(tokenActual, columnaToken);
            }
            procesador.saltarEspacios();
        }
    }
    
    private void revisarNumero() throws IOException {
        boolean esNumero = analizadorNumero.esNumero(procesador.getLetraActual());
        while (esNumero) {
            String respuesta = analizadorNumero.analizarNumero();
            if (respuesta != null) {
                tokenActual = respuesta;
                return;
            } else {
                columnaToken = 0;
            }
            
            esNumero = analizadorNumero.esNumero(procesador.getLetraActual());
        }
    }
    
    private void revisarCaracter(PalabraReservada caracterEspecial) throws IOException {
        if (palabras.getSLASH() == procesador.getLetraActual()) {
            analizadorComentario.analizarComentario();
        } else if (palabras.getCOMILLAS() == procesador.getLetraActual()) {
            analizadorCadena.revisarCadenaTexto();
        } else {
            agregarToken(caracterEspecial.getTipo(), caracterEspecial.getLexema(), procesador.getColumna());
        }
        if (!"".equals(tokenActual)) {
            analizadorIdentificador.analizarToken(tokenActual, columnaToken);
        }
        tokenActual = "";
        columnaToken = 0;
        tokenTomado = true;
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
