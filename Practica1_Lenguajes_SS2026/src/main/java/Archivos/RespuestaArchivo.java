/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

/**
 *
 * @author milton
 */
public class RespuestaArchivo {
    
    private final boolean valido;
    private final String mensaje;

    public RespuestaArchivo(boolean valido, String mensaje) {
        this.valido = valido;
        this.mensaje = mensaje;
    }

    public boolean isValido() {
        return valido;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
