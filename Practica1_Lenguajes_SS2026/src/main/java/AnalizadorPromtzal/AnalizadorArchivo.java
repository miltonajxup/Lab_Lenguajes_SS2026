/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

import AnalizadorPromtzal.Tokens.AnalizadorCadena;
import AnalizadorPromtzal.Tokens.AnalizadorComentario;
import AnalizadorPromtzal.Tokens.AnalizadorIdentificador;
import AnalizadorPromtzal.Tokens.AnalizadorNumero;
import Automata.Escritor.FormatoDOT;
import Automata.ReconocimientoAutomata;
import DatosReporte.ColeccionEstadisticas;
import DatosReporte.Errores.ColeccionErrores;
import DatosReporte.Errores.ErrorLexico;
import Lenguaje.Alfabeto;
import DatosReporte.ColeccionTokens;
import Lenguaje.PalabraReservada;
import Lenguaje.Palabras;
import Lenguaje.TipoToken;
import Lenguaje.Token;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author milton
 */
public class AnalizadorArchivo {
    
    private final Palabras palabras;
    private final Alfabeto alfabeto;
    private final ProcesadorLinea procesador;
    private ColeccionEstadisticas coleccionEstadisticas;
    private ColeccionTokens coleccionTokens;
    private ColeccionErrores coleccionErrores;
    private final ReconocimientoAutomata reconocimiento;
    private final AnalizadorCadena analizadorCadena;
    private final AnalizadorIdentificador analizadorIdentificador;
    private final AnalizadorComentario analizadorComentario;
    private final AnalizadorNumero analizadorNumero;
    private BufferedReader reader;
    private int fila;
    private String tokenActual;
    private int columnaToken;
    private boolean tokenTomado;
    
    public AnalizadorArchivo(FormatoDOT formatodot) {
        palabras = new Palabras();
        alfabeto = new Alfabeto();
        procesador = new ProcesadorLinea();
        coleccionEstadisticas = new ColeccionEstadisticas(palabras);
        coleccionTokens = new ColeccionTokens(coleccionEstadisticas);
        coleccionErrores = new ColeccionErrores();
        reconocimiento = new ReconocimientoAutomata(formatodot);
        analizadorCadena = new AnalizadorCadena(palabras, procesador, this, reconocimiento);
        analizadorIdentificador = new AnalizadorIdentificador(palabras, this, reconocimiento);
        analizadorComentario = new AnalizadorComentario(palabras, procesador, this);
        analizadorNumero = new AnalizadorNumero(palabras, alfabeto, procesador, this);
        fila = 0;
    }

    public List<Token> getColeccionTokens() {
        return coleccionTokens.getTokens();
    }

    public List<ErrorLexico> getColeccionErrores() {
        return coleccionErrores.getErrores();
    }
    
    public void reiniciarListas() {
        coleccionTokens = new ColeccionTokens(coleccionEstadisticas);
        coleccionErrores = new ColeccionErrores();
        fila = 0;
    }
    
    public void agregarToken(TipoToken tipo, String lexema, int columna) {
        coleccionTokens.agregarToken(tipo, lexema, fila, columna);
    }
    
    public void agregarError(String lexema, String descripcion, int columna) {
        coleccionErrores.agregarError(lexema, descripcion, fila, columna);
    }

    public void analizar(BufferedReader reader) throws IOException {
        reconocimiento.reiciniar();
        this.reader = reader;
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
                reconocimiento.reconocer(procesador.getLetraActual());
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
            reconocimiento.reconocer(procesador.getLetraActual());
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
                reconocimiento.reconocerNumero();
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
            reconocimiento.reconocerSimbolo();
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
