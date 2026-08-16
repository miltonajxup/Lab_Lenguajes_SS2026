/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

import AnalizadorPromtzal.AnalizadorArchivo;
import Errores.ErrorLexico;
import Tokens.Token;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author milton
 */
public class FormatoReporte {
    
    private final AnalizadorArchivo analizador;

    public FormatoReporte(AnalizadorArchivo analizador) {
        this.analizador = analizador;
    }
    
    public void escribirReporte(PrintWriter writer) {
        List<Token> tokens = analizador.getColeccionTokens();
        List<ErrorLexico> errores = analizador.getColeccionErrores();
        String inicio = """
                        <head>
                            <style>
                                body {
                                    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', 
                                    Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                                    font-size: 30px;
                                }
                                h1 {
                                    text-align: center;
                                    font-size: 40px;
                                }
                                .reporte {
                                    width: 1500px;
                                    border: 2px solid black;
                                    margin: auto;
                                    margin-bottom: 100px;
                                    border-radius: 5px;
                                    font-size: inherit;
                                    padding: 20px;
                                }
                                .azul {
                                    background-color: rgb(83, 150, 244);
                                } 
                                .verde {
                                    background-color: rgb(104, 209, 86);
                                }
                                .celeste {
                                    background-color: rgb(176, 247, 247);
                                }
                                td {
                                    text-align: center;
                                    border: 2px solid black;
                                    margin: 5px;
                                }
                                .secundario {
                                    text-align: center;
                                    margin: 50px;
                                }
                            </style>
                        </head>
                        <body>
                            <h1>Reportes Practica 1</h1>
                                """;
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
        if (tokens.size() > 0) {
            for (Token token : tokens) {
                String lineaTabla = "<tr class=\"celeste\"> \n <td> " + token.getNumero() 
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
        if (errores.size() >  0) {
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
