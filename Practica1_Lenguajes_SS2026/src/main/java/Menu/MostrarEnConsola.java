/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import AnalizadorPromtzal.AnalizadorArchivo;
import Errores.ErrorLexico;
import Tokens.Token;
import java.util.List;

/**
 *
 * @author milton
 */
public class MostrarEnConsola {
    
    private final AnalizadorArchivo analizador;
    private final int TAMAÑO_FILA = 18;

    public MostrarEnConsola(AnalizadorArchivo analizador) {
        this.analizador = analizador;
    }
    
    public void mostrarAnalisisArchivo() {
        List<Token> tokens = analizador.getColeccionTokens();
        List<ErrorLexico> errores = analizador.getColeccionErrores();
        String cabeceraTokens = """
                                
                                
                                                              Tabla de los tokens Reconocidos
                                
                          |-----------------|-----------------|-----------------------------------|-----------------|-----------------|
                          |     #Numero     |  Tipo de Token  |              Lexema               |      Fila       |     Columna     |
                          |-----------------|-----------------|-----------------------------------|-----------------|-----------------|""";
        System.out.println(cabeceraTokens);
        for (Token token : tokens) {
            String fila = "|";
            fila = agregarEspacios(fila + "    " + token.getNumero(), 1);
            fila = agregarEspacios(fila + token.getTipo(), 2);
            fila = agregarEspacios(fila + token.getLexema(), 4);
            fila = agregarEspacios(fila + token.getFila(), 5);
            fila = agregarEspacios(fila + token.getColumna(), 6);
            System.out.println(fila);
        }
        String finTabla = """
                          |-----------------|-----------------|-----------------------------------|-----------------|-----------------|
                          """;
        System.out.println(finTabla);
        String cabeceraErrores = """
                                 
                                 
                                                               Tabla de Los Errores Identificados
                                 
                          |-----------------|-----------------------------------|-----------------------------------------------------|-----------------|-----------------|
                          |     #Numero     |            Error Lexico           |                     Descripcion                     |      Fila       |     Columna     |
                          |-----------------|-----------------------------------|-----------------------------------------------------|-----------------|-----------------|""";
        System.out.println(cabeceraErrores);
        String finTablaErrores = """
                          |-----------------|-----------------------------------|-----------------------------------------------------|-----------------|-----------------|
                          
                          """;
        if (errores.size() > 0) {
            for (ErrorLexico error : errores) {
                String fila = "|";
                fila = agregarEspacios(fila + "    " + error.getNumero(), 1);
                fila = agregarEspacios(fila + error.getErrorLexico(), 3);
                fila = agregarEspacios(fila + error.getDescripcion(), 6);
                fila = agregarEspacios(fila + error.getFila(), 7);
                fila = agregarEspacios(fila + error.getColumna(), 8);
                System.out.println(fila);
            }
            System.out.println(finTablaErrores);
        } else {
            System.out.println(finTablaErrores);
            System.out.println("               ---------------  La Lista de errores se encuentra vacia  ---------------  \n\n");
        }
    }
    
    private String agregarEspacios(String entrada, int numeroPalabra) {
        String espacios = "";
        int cantidadEspacios = TAMAÑO_FILA * numeroPalabra - entrada.length();
        for (int i = 0; i < cantidadEspacios; i++) {
            espacios += ' ';
        }
        entrada = entrada + espacios + "|";
        return entrada;
    }
    
}
