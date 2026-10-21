/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.reportes;

import Archivos.Reporte.Estilos;
import com.milton.proyecto2_lenguajes.compilador.errores.ErrorSintactico;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;
import com.milton.proyecto2_lenguajes.compilador.simbolos.Simbolo;
import com.milton.proyecto2_lenguajes.controladores.ResultadoReportes;
import java.util.List;

/**
 *
 * @author milton
 */
public class ReportesHtml {
    
    private final ResultadoReportes resultados;
    private final Estilos estilos;

    public ReportesHtml(ResultadoReportes resultados) {
        this.resultados = resultados;
        estilos = new Estilos();
    }
    
    public String escribirReporte() {
        List<Simbolo> simbolos = resultados.getSimbolos();
        List<ErrorSintactico> sintacticos = resultados.getErroresSint();
        List<Token> lexicos = resultados.getErrores();
        String reporte = "<head> \n" + estilos.getCSS() + "\n</head> \n<body> \n\t<h1>Reportes De Errores</h1> <br> <br> <br> ";
        
        reporte += 
                """
                <div class="secundario">
                    Tabla de Simbolos
                </div>
                <table class="reporte">
                    <tr>
                        <th class="azul"> Nombre</th>
                        <th class="verde">Tipo Simbolo</th>
                        <th class="azul"> Ambito</th>
                        <th class="verde">Tipo de Token</th>
                        <th class="azul"> Fila</th>
                        <th class="verde">Columna</th>
                    </tr>""";
        
        if (!simbolos.isEmpty()) {
            for (Simbolo simbolo : simbolos) {
                reporte += "<tr > \n\t <td> " + simbolo.getNombre()
                        + " </td> \n\t <td> " + simbolo.getTipoSimbolo()
                        + " </td> \n\t <td> " + simbolo.getAmbito()
                        + " </td> \n\t <td> " + simbolo.getTipoToken()
                        + " </td> \n\t <td> " + simbolo.getFila() 
                        + " </td> \n\t <td> " + simbolo.getColumna() + " </td> \n</tr>";
            }
        } else {
            reporte += "<div class=\"secundario\">No se reconocieron simbolos</div>";
        }
        
        reporte += 
                """
                </table>
                
                <div class="secundario">
                    Errores Sintacticos
                </div>
                <table class="reporte">
                    <tr>
                        <th class="azul">Mensaje</th>
                        <th class="verde">Fila</th>
                        <th class="azul">Columna</th>
                    </tr>""";
        
        if (!sintacticos.isEmpty()) {
            for (ErrorSintactico error : sintacticos) {
                reporte += "<tr > \n\t <td> " + error.getMensaje() 
                        + " </td> \n\t <td> " + error.getFila() 
                        + " </td> \n\t <td> " + error.getColumna() + " </td> \n</tr>";
            }
        } else {
            reporte += "<div class=\"secundario\">No se encontraron Errores de tipo Sintacticos</div> ";
        }
        
        reporte += 
                """
                </table>
                
                <div class="secundario">
                    Reporte de Errores Léxicos
                </div>
                <table class="reporte">
                    <tr>
                        <th class="azul"> Descripcion </th>
                        <th class="verde">Lexema</th>
                        <th class="azul"> Fila</th>
                        <th class="verde">Columna</th>
                    </tr>""";
        
        if (!lexicos.isEmpty()) {
            for (Token error : lexicos) {
                reporte += "<tr > \n\t <td> " + error.getDescripcion()
                        + " </td> \n\t <td> " + error.getLexema()
                        + " </td> \n\t <td> " + error.getFila() 
                        + " </td> \n\t <td> " + error.getColumna() + " </td> \n</tr>";
            }
        } else {
            reporte += "<div class=\"secundario\">No se encontraron Errores de tipo Lexico</div> \n </table>";
        }
        
        reporte += 
                """
                    </table>
                </body>""";
        return reporte;
    }
    
}
