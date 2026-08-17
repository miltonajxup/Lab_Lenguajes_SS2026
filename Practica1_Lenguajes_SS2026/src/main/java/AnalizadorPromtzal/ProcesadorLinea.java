/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorPromtzal;

/**
 *
 * @author milton
 */
public class ProcesadorLinea {
    
    private String linea;
    private char letraActual;
    private int indiceLetra;
    
    public void setLinea(String linea) {
        this.linea = linea;
        indiceLetra = 0;
        if (linea != null && !"".equals(linea)) {
            letraActual = linea.charAt(0);
        }
    }
    
    public void setPosicion(int indice) {
        indiceLetra = indice;
        letraActual = linea.charAt(indice);
    }
    
    public void setLineaEIndice(String linea, int indice) {
        setLinea(linea);
        setPosicion(indice);
    }
    
    public boolean esLineaNula() {
        return linea == null;
    }
    
    public boolean lineaVacia() {
        return "".equals(linea);
    }
    
    public String getLinea() {
        return linea;
    }
    
    public char getLetraActual() {
        return letraActual;
    }

    public int getIndiceLetra() {
        return indiceLetra;
    }
    
    public int getColumna() {
        return indiceLetra + 1;
    }

    public void avanzar() {
        indiceLetra++;
        if (indiceLetra < linea.length()) {
            letraActual = linea.charAt(indiceLetra);
        }
    }
    
    public void saltarEspacios() {
        while (indiceLetra < linea.length() && (letraActual == ' ' || letraActual == '\t')) {
            avanzar();
        }
    }
    
    public boolean finLinea() {
        return indiceLetra >= linea.length();
    }
    
    public boolean inicioLinea() {
        return indiceLetra == 0;
    }
    
    public char getSiguiente() {
        if (indiceLetra < linea.length() - 1) {
            return linea.charAt(indiceLetra + 1);
        }
        return ' ';
    }
    
}
