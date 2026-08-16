/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import AnalizadorPromtzal.AnalizadorArchivo;
import Archivos.LectorDeArchivos;
import Archivos.Reporte.ExportarReporte;
import java.util.Scanner;

/**
 *
 * @author milton
 */
public class OpcionCargarArchivo {
    
    private final AnalizadorArchivo analizador;
    private final LectorDeArchivos lector;
    private final ExportarReporte exportar;
    private final MostrarEnConsola mostrar;

    public OpcionCargarArchivo(AnalizadorArchivo analizador, ExportarReporte exportar) {
        this.analizador = analizador;
        this.exportar = exportar;
        lector = new LectorDeArchivos(analizador);
        mostrar = new MostrarEnConsola(analizador);
    }
    
    public void cargar() {
        Scanner scanner = new Scanner(System.in);
        String instruccion = """
                             Ingresar la direccion completa donde se aloja el archivo agregando '/' y desues el nombre del archivo
                             Ingresa 'c' para cancelar
                             """;
        System.out.println(instruccion);
        String nombreArchivo = scanner.nextLine();
        if (nombreArchivo.equals("c")) {
            return;
        }
        boolean existe = lector.abrirArchivo(nombreArchivo);
        if (!existe) {
            String mensaje = """
                             El archivo que se intenta abrir no existe
                             Presiona ENTER para continuar
                             """;
            System.out.println(mensaje);
            scanner.nextLine();
            return;
        }
        exportar.exportarReporte();
        mostrar.mostrarAnalisisArchivo();
        
        if (exportar.getCarpetaElegida().equals("")) {
            System.out.println("La ubicacion del archivo es donde se ubica el archivo del proyecto en una carpeta llamada 'reportes'");
        } else {
            System.out.println("La ubicacion del archivo html es " + exportar.getRuta());
        }
        
        analizador.reiniciarListas();
        System.out.println("\nPresiona ENTER para continuar");
        scanner.nextLine();
    }
    
}
