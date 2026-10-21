/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos.Reporte;

/**
 *
 * @author milton
 */
public class Estilos {
    
    private final String COLOR_DIRECTIVA = "directiva";
    private final String COLOR_PALABRA_RESERVADA = "palabraReservada";
    private final String COLOR_COMANDO = "comando";
    private final String COLOR_CARGAR = "cargar";
    private final String COLOR_CONECTOR = "conector";
    private final String COLOR_SIMBOLO = "simbolo";
    private final String COLOR_CADENA = "cadena";
    private final String COLOR_NUMERO = "numero";
    private final String COLOR_IDENTIFICADOR = "identificador";
    
    private final String CSS =  """
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
                                   td {
                                       text-align: center;
                                       border: 2px solid black;
                                       margin: 5px;
                                   }
                                   .secundario {
                                       text-align: center;
                                       margin: 50px;
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
                                   .directiva {
                                       background-color: rgb(43, 176, 242);
                                   }
                                   .palabraReservada {
                                       background-color: rgb(87, 138, 240);
                                   }
                                   .comando {
                                       background-color: rgb(227, 87, 87);
                                   }
                                   .cargar {
                                       background-color: rgb(204, 62, 62);
                                   }
                                   .conector {
                                       background-color: orange;
                                   }
                                   .simbolo {
                                       background-color: rgb(176, 247, 247);
                                   }
                                   .cadena {
                                       background-color: rgb(52, 187, 52);
                                   }
                                   .numero {
                                       background-color: rgb(255, 230, 42);
                                   }
                                   .identificador {
                                       background-color: rgb(144, 161, 208);
                                   }
                                </style>
                                """;

    public String getCOLOR_DIRECTIVA() {
        return COLOR_DIRECTIVA;
    }

    public String getCOLOR_PALABRA_RESERVADA() {
        return COLOR_PALABRA_RESERVADA;
    }

    public String getCOLOR_COMANDO() {
        return COLOR_COMANDO;
    }

    public String getCOLOR_CARGAR() {
        return COLOR_CARGAR;
    }

    public String getCOLOR_CONECTOR() {
        return COLOR_CONECTOR;
    }

    public String getCOLOR_SIMBOLO() {
        return COLOR_SIMBOLO;
    }

    public String getCOLOR_CADENA() {
        return COLOR_CADENA;
    }

    public String getCOLOR_NUMERO() {
        return COLOR_NUMERO;
    }

    public String getCOLOR_IDENTIFICADOR() {
        return COLOR_IDENTIFICADOR;
    }
    
    public String getCSS() {
        return CSS;
    }
    
}
