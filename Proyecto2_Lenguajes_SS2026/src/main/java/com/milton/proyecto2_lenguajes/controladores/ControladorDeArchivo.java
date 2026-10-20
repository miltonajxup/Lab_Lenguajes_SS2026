/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.controladores;

import com.milton.proyecto2_lenguajes.compilador.ControladorAnalisis;
import com.milton.proyecto2_lenguajes.exceptions.ErrorDeArchivoException;
import com.milton.proyecto2_lenguajes.exceptions.ValorInvalidoException;
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
    
    private final ControladorAnalisis controladorAnalisis;
    private final String EXTENSION_VALIDA = ".pz";
    private final int LONGITUD_EXTENSION = EXTENSION_VALIDA.length();
    private final String CARPETA_GENERADA = "/Archivos_Generados/";
    private final String[] formatosGuardado;
    private final String NOMBRE_PROMT = "Promt";
    private int promtsGenerados;
    
    public ControladorDeArchivo(ControladorAnalisis controladorAnalisis) {
        this.controladorAnalisis = controladorAnalisis;
        formatosGuardado = new String[2];
        formatosGuardado[0] = ".md";
        formatosGuardado[1] = ".txt";
        promtsGenerados = 0;
    }
    
    public String[] getFormatosGuardado() {
        return formatosGuardado;
    }
    
    public RespuestaArchivo cargarArchivo(File archivo) throws ErrorDeArchivoException {
        String nombre = archivo.getName();
        RespuestaArchivo respuesta = verificarExtension(nombre);
        if (!respuesta.isValido()) {
            return respuesta;
        }
        
        String textoArchivo = "";
        int lineas = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea = reader.readLine();
            while (linea != null) {
                lineas++;
                textoArchivo += linea + "\n";
                linea = reader.readLine();
            }
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Ocurrio un error al cargar el archivo " + nombre + " : " + e.getMessage());
        }
        return new RespuestaArchivo(true, textoArchivo, lineas);
    }
    
    public File crearArchivo(File archivo) throws ErrorDeArchivoException {
        int contador = 1;
        String rutaArchivo = archivo.getAbsolutePath();
        while (archivo.exists()) {
            rutaArchivo = archivo.getParent() + "/" + contador + archivo.getName();
            archivo = new File(rutaArchivo);
            contador++;
        }
        archivo = new File(rutaArchivo + EXTENSION_VALIDA);
        try (PrintWriter writer = new PrintWriter(archivo)) {
            writer.print("");
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Ocurrio un error al crear un archivo: " + e.getMessage());
        }
        return archivo;
    }
    
    public void guardarCambios(File archivo, String contenidoActual) throws ErrorDeArchivoException {
        if (archivo.exists()) {
            try (PrintWriter writer = new PrintWriter(archivo)) {
                writer.print(contenidoActual);
            } catch (IOException e) {
                throw new ErrorDeArchivoException("Ocurrio un error al guardar los cambios del archivo " + archivo.getName());
            }
        }
    }
    
    public ResultadoAnalisis analizarArchivo(File archivo, String contenidoActual, int eleccion) throws ErrorDeArchivoException, ValorInvalidoException {
        String formato = buscarFormato(eleccion);
        if (archivo.exists()) {
            guardarCambios(archivo, contenidoActual);
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                controladorAnalisis.analizar(reader);
            } catch (IOException e) {
                throw new ErrorDeArchivoException("Ocurrio un error al leer el archivo: " + e.getMessage());
            }
        }
        generarArchivoPromt(archivo.getParent(), formato);
        return controladorAnalisis.getResultado();
    }
    
    private void generarArchivoPromt(String carpeta, String formato) throws ErrorDeArchivoException {
        String promt = controladorAnalisis.getResultado().getPromt();
        promtsGenerados++;
        String carpetaCompleta = carpeta + CARPETA_GENERADA;
        String ruta = carpetaCompleta + NOMBRE_PROMT + promtsGenerados + formato;
        revisarExistenciaCarpeta(carpetaCompleta);
        try (PrintWriter writer = new PrintWriter(new File(ruta))) {
            writer.print(promt);
        } catch (IOException e) {
            throw new ErrorDeArchivoException("Ocurrio un error al generar el arhivo del promt: " + e.getMessage());
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
    
    private String buscarFormato(int eleccion) throws ValorInvalidoException {
        switch (eleccion) {
            case 0:
                return formatosGuardado[eleccion];
            case 1:
                return formatosGuardado[eleccion];
            default: 
                throw new ValorInvalidoException("El formato es invalido");
        }
    }
    
    private void revisarExistenciaCarpeta(String carpeta) {
        File file = new File(carpeta);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
}
