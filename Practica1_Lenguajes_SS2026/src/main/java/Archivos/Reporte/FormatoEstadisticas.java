/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

import AnalizadorPromtzal.AnalizadorArchivo;
import DatosReporte.EstadisticaToken;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author milton
 */
public class FormatoEstadisticas {
    
    private final AnalizadorArchivo analizador;
    private final Estilos estilos;

    public FormatoEstadisticas(AnalizadorArchivo analizador) {
        this.analizador = analizador;
        estilos = new Estilos();
    }
    
    public void escribirReporte(PrintWriter writer) {
        List<EstadisticaToken> estadisticas = analizador.getEstadisticas();
        String inicio = "<head> \n" + estilos.getCSS() + "\n</head> \n<body> \n\t<h1>Reportes Practica 1</h1>";
        writer.println(inicio);
        
        String filasLeidas = "<div class=\"reporte\"> \nNúmero de Lineas Leidas: <br> " + analizador.getFila() + " filas \n</div>";
        writer.println(filasLeidas);
        
        String erroresEncontrados = "<div class=\"reporte\"> \nCantidad de Errores encontrados: <br> " + analizador.getColeccionErrores().size() + " errores \n</div>";
        writer.println(erroresEncontrados);
        
        String inicioTabla ="""
                            <div class="secundario">
                                Reporte de tokens reconocidos
                            </div>
                            <table class="reporte">
                                <tr>
                                    <th class="azul">Tipo de Token</th>
                                    <th class="verde">Cantidad de Veces Encontrada</th>
                                </tr>
                            """;
        writer.println(inicioTabla);
        
        for (EstadisticaToken estadistica : estadisticas) {
            String linea = "<tr class=\"" + estadistica.getColorCss() + "\"> \n\t<td> " + estadistica.getTipoToken().name() + " </td> \n\t<td> " + estadistica.getVecesEncontradas() + " </td> \n</tr>";
            writer.println(linea);
        }
        
        
        String fin = "    </table> \n</body>";
        writer.println(fin);
    }
    
}
