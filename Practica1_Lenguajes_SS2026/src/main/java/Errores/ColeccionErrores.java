/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Errores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class ColeccionErrores {
    
    private final List<ErrorLexico> errores;
    private int contador;

    public ColeccionErrores() {
        this.errores = new ArrayList<>();
        contador = 0;
    }
    
    public void agregarError(String lexema, String descripcion, int fila, int columna) {
        contador++;
        errores.add(new ErrorLexico(contador, lexema, descripcion, fila, columna));
    }

    public List<ErrorLexico> getErrores() {
        return errores;
    }
    
}
