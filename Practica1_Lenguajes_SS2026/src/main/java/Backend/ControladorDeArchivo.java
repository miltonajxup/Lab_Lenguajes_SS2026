/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import AnalizadorPromtzal.AnalizadorArchivo;
import Excepciones.ErrorDeArchivoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author milton
 */
public class ControladorDeArchivo {
    
    private final AnalizadorArchivo analizador;
    private final String EXTENSION_VALIDA = ".pz";
    private final int LONGITUD_EXTENSION = EXTENSION_VALIDA.length(); 
    private String archivoAbierto;
    private String carpeta;
    
    public ControladorDeArchivo(AnalizadorArchivo analizador) {
        this.analizador = analizador;
    }
    
    public void setArchivoAbierto(String archivoAbierto) {
        this.archivoAbierto = archivoAbierto;
    }
    
    public String getCarpeta() {
        return carpeta;
    }
    
    public RespuestaArchivo cargarArchivo(File archivo) throws ErrorDeArchivoException {
        RespuestaArchivo respuesta = verificarExtension(archivo.getAbsolutePath());
        if (!respuesta.isValido()) {
            return respuesta;
        }
        archivoAbierto = archivo.getAbsolutePath();
        carpeta = archivo.getParent() + "/Archivos_Generados/";
        
        String textoArchivo = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea = reader.readLine();
            while (linea != null) {
                textoArchivo += linea + "\n";
                linea = reader.readLine();
            }
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Ocurrio un error al cargar el archivo " + archivo.getName() + " : " + e.getMessage());
        }
        return new RespuestaArchivo(true, textoArchivo);
    }
    
    public void crearArchivo(File archivo, String contenidoArchivo) throws ErrorDeArchivoException {
        revisarExistencia(archivo);
        guardarCambios(contenidoArchivo);
    }
    
    public void guardarCambios(String contenidoActual) throws ErrorDeArchivoException {
        if (archivoAbierto != null) {
            try (PrintWriter writer = new PrintWriter(new File(archivoAbierto))) {
                writer.print(contenidoActual);
            } catch (IOException e) {
                throw new ErrorDeArchivoException("Ocurrio un error al guardar los cambios del archivo " + archivoAbierto);
            }
        }
    }
    
    public void analizarArchivo(String contenidoActual) throws ErrorDeArchivoException {
        if (archivoAbierto != null) {
            guardarCambios(contenidoActual);
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoAbierto))) {
                analizador.analizar(reader);
            } catch (IOException e) {
                throw new ErrorDeArchivoException("Ocurrio un error al leer el archivo: " + e.getMessage());
            }
        }
    }
    
    private RespuestaArchivo verificarExtension(String rutaArchivo) {
        int finLinea = rutaArchivo.length();
        int inicio = finLinea - LONGITUD_EXTENSION;
        String extension = "";
        for (int i = inicio; i < finLinea; i++) {
            extension += rutaArchivo.charAt(i);
        }
        if (!EXTENSION_VALIDA.equals(extension)) {
            return new RespuestaArchivo(false, "La aplicacion solo acepta extensiones que sean " + EXTENSION_VALIDA + " y " + extension + " no lo es. \nArchivo: " + rutaArchivo + "\n");
        }
        return new RespuestaArchivo(true, "No existe error");
    }
    
    private void revisarExistencia(File archivo) {
        archivoAbierto = archivo.getAbsolutePath();
        int contador = 1;
        while (archivo.exists()) {
            archivoAbierto = archivo.getParent() + "/" + contador + archivo.getName();
            archivo = new File(archivoAbierto);
            contador++;
        }
    }
    
}
