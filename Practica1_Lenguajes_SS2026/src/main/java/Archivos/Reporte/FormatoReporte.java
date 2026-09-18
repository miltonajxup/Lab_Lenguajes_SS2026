/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

import AnalizadorPromtzal.AnalizadorArchivo;
import DatosReporte.Errores.ErrorLexico;
import Lenguaje.Token;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author milton
 */
public class FormatoReporte {
    
    private final AnalizadorArchivo analizador;
    private final Estilos estilos;

    public FormatoReporte(AnalizadorArchivo analizador) {
        this.analizador = analizador;
        this.estilos = new Estilos();
    }
    
    public void escribirReporte(PrintWriter writer) {
        List<Token> tokens = analizador.getColeccionTokens();
        List<ErrorLexico> errores = analizador.getColeccionErrores();
        String inicio = "<head> \n" + estilos.getCSS() + "\n</head> \n<body> \n\t<h1>Reportes Practica 1</h1>";
        writer.println(inicio);
        
        String colunasTablaTokens = """
                            <div class="secundario">
                                Reporte de tokens reconocidos
                            </div>
                            <table class="reporte">
                                <tr>
                                    <th class="azul">#Token</th>
                                    <th class="verde">Tipo de Token</th>
                                    <th class="azul">Lexema</th>
                                    <th class="verde">Fila</th>
                                    <th class="azul">Columna</th>
                                </tr>
                                    """;
        writer.print(colunasTablaTokens);
        
        String finTabla = "    </table>";
        if (!tokens.isEmpty()) {
            for (Token token : tokens) {
                String lineaTabla = "<tr class=\"" + token.getColorCss() + "\"> \n <td> " + token.getNumero() 
                        + " </td> \n <td> " + token.getTipo() 
                        + " </td> \n <td> " + token.getLexema() 
                        + " </td> \n <td> " + token.getFila() 
                        + " </td> \n <td> " + token.getColumna() 
                    + "</tr>";
                writer.println(lineaTabla);
            }
            writer.println(finTabla);
        } else {
            String informacionLista = """
                        </table>
                            <div class="secundario">
                                    La lista de tokens reconocidos esta vacia
                            </div>
                                      """;
            writer.println(informacionLista);
        }
        String columnasTablaErrores = """
                            <div class="secundario">
                                Reporte de Errores Lexicos
                            </div>
                            <table class="reporte">
                                <tr>
                                    <th class="azul">#Error</th>
                                    <th class="verde">Error Lexico</th>
                                    <th class="azul">Descripcion</th>
                                    <th class="verde">Fila</th>
                                    <th class="azul">Columna</th>
                                </tr>
                                      """;
        writer.println(columnasTablaErrores);
        if (!errores.isEmpty()) {
            for (ErrorLexico error : errores) {
                String lineaTabla = "<tr class=\"celeste\"> \n <td> " + error.getNumero() 
                        + " </td> \n <td> " + error.getErrorLexico() 
                        + " </td> \n <td> " + error.getDescripcion() 
                        + " </td> \n <td> " + error.getFila() 
                        + " </td> \n <td> " + error.getColumna() 
                    + "</tr>";
                writer.println(lineaTabla);
            }
            writer.println(finTabla);
        } else {
            String informacionLista = """
                        </table>
                            <div class="secundario">
                                    La lista de Errores esta vacia
                            </div>
                                      """;
            writer.println(informacionLista);
        }
        String fin = """
                        </body>
                     """;
        writer.println(fin);
    }
    
}
