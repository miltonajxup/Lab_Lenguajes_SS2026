/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

/**
 *
 * @author milton
 */
public class ResultadoAnalizado {
    
    private final String resultado;
    private final String error;

    public ResultadoAnalizado(String resultado, String error) {
        this.resultado = resultado;
        this.error = error;
    }

    public String getResultado() {
        return resultado;
    }

    public String getError() {
        return error;
    }
    
}
