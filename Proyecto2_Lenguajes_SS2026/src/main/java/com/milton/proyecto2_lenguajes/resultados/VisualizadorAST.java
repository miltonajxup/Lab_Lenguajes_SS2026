/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.milton.proyecto2_lenguajes.resultados;

import com.milton.proyecto2_lenguajes.compilador.ast.NodoArbol;

/**
 *
 * @author milton
 */
public class VisualizadorAST {
    private String html;
    
    public VisualizadorAST() {
        html = "";
        agregarCSS();
    }
    public String generarHTML(NodoArbol padre) {
        html = "";
        agregarCSS();

        if (padre == null) {
            html += """
                <p class="vacio">El árbol se encuentra vacío</p>
                """;
        } else {
            html += """
                <div class="visor">
                    <div class="arbol">
                """;

            leerHijos(padre);

            html += """
                    </div>
                </div>
                """;
        }

        html += """
            </body>
            </html>
            """;

        return html;
    }
    private void leerHijos(NodoArbol nodo) {
        html += """
            <div class="rama">
                <div class="nodo">
                    <span class="tipo">
            """ + nodo.getTipo().name() + """
                    </span>
            """;

        if (nodo.getValor() != null) {
            html += """
                    <span class="valor">
            """ + nodo.getValor() + """
                    </span>
            """;
        }

        html += """
                </div>
                <div class="horizontal">
            """;

        for (NodoArbol hijo : nodo.getHijos()) {
            leerHijos(hijo);
        }

        html += """
                </div>
            </div>
            """;
    }
    
    private void agregarCSS() {
        html += """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport"
                      content="width=device-width, initial-scale=1.0">
                <title>Visualizador AST</title>

                <style>
                    * {
                        box-sizing: border-box;
                    }

                    body {
                        margin: 0;
                        padding: 30px;
                        font-family: Arial, sans-serif;
                        background: #f1f5f9;
                        color: #1e293b;
                    }

                    h1 {
                        text-align: center;
                        margin-bottom: 30px;
                    }
                    .visor {
                        width: 100%;
                        overflow: auto;
                        padding: 20px;
                    }

                    .arbol {
                        display: flex;
                        justify-content: center;
                        width: max-content;
                        min-width: 100%;
                        margin: 0 auto;
                        padding: 20px;
                    }
                    .rama {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        flex-shrink: 0;
                    }

                    .nodo {
                        position: relative;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        min-width: 125px;
                        max-width: 230px;
                        padding: 12px;
                        border-radius: 10px;
                        border: 1px solid #cbd5e1;
                        background: white;
                        box-shadow: 0 3px 8px #0f172a12;
                        overflow-wrap: anywhere;
                        text-align: center;
                        z-index: 1;
                    }

                    .tipo {
                        display: block;
                        font-weight: bold;
                        font-size: 13px;
                        color: #1d4ed8;
                        margin-bottom: 6px;
                    }

                    .valor {
                        display: block;
                        font-size: 14px;
                        color: #334155;
                    }

                    .horizontal {
                        display: flex;
                        flex-direction: row;
                        justify-content: center;
                        align-items: flex-start;
                        gap: 24px;
                        padding-top: 30px;
                        position: relative;
                    }

                    .vacio {
                        text-align: center;
                        padding: 30px;
                        color: #64748b;
                    }
                </style>
            </head>
            <body>
                <h1>Árbol de Sintaxis Abstracta (AST)</h1>
            """;
    }
    
}
//    private void mostrarNodo(NodoArbol nodo) {
//        mostrarNodo(nodo, "", true);
//    }
//
//    private void mostrarNodo(NodoArbol nodo, String prefijo, boolean esUltimo) {
//        // Mostrar el nodo actual
//        System.out.println(prefijo
//                + (esUltimo ? "└── " : "├── ")
//                + "Tipo: " + nodo.getTipo()
//                + " | Valor: " + nodo.getValor());
//
//        // Preparar el prefijo para los hijos
//        List<NodoArbol> hijos = nodo.getHijos();
//
//        for (int i = 0; i < hijos.size(); i++) {
//            boolean ultimoHijo = (i == hijos.size() - 1);
//
//            String nuevoPrefijo = prefijo
//                    + (esUltimo ? "    " : "│   ");
//
//            mostrarNodo(hijos.get(i), nuevoPrefijo, ultimoHijo);
//        }
//    }