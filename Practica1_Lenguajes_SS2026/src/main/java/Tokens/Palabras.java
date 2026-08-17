/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tokens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class Palabras {
    
    private final List<PalabraReservada> palabras;
    private final List<PalabraReservada> caracteres;
    private final List<String> numeros;
    private final char GUION_BAJO = '_';
    private final char COMILLAS = '"';
    private final char ARROBA = '@';
    private final char PUNTO = '.';
    private final char SLASH = '/';
    private final char ASTERISCO = '*';
    private final String COMENTARIO_LINEA = "//";
    private final String COMENT_BLOQUE_INICIO = "/*";
    private final String COMENT_BLOQUE_FIN = "*/";
    
    public Palabras() {
        palabras = new ArrayList<>();
        palabras.add(new PalabraReservada("@modelo", TipoToken.MODELO));
        palabras.add(new PalabraReservada("@rol", TipoToken.ROL));
        palabras.add(new PalabraReservada("@formato", TipoToken.FORMATO));
        palabras.add(new PalabraReservada("AGENTE", TipoToken.AGENTE));
        palabras.add(new PalabraReservada("contexto", TipoToken.CONTEXTO));
        palabras.add(new PalabraReservada("variable", TipoToken.VARIABLE));
        palabras.add(new PalabraReservada("EJECUTAR", TipoToken.EJECUTAR));
        palabras.add(new PalabraReservada("EXPORTAR", TipoToken.EXPORTAR));
        palabras.add(new PalabraReservada("PREGUNTAR", TipoToken.PREGUNTAR));
        palabras.add(new PalabraReservada("GENERAR", TipoToken.GENERAR));
        palabras.add(new PalabraReservada("RESUMIR", TipoToken.RESUMIR));
        palabras.add(new PalabraReservada("ANALIZAR", TipoToken.ANALIZAR));
        palabras.add(new PalabraReservada("TRADUCIR", TipoToken.TRADUCIR));
        palabras.add(new PalabraReservada("CLASIFICAR", TipoToken.CLASIFICAR));
        palabras.add(new PalabraReservada("EXTRAER", TipoToken.EXTRAER));
        palabras.add(new PalabraReservada("CARGAR", TipoToken.CARGAR));
        palabras.add(new PalabraReservada("SOBRE", TipoToken.SOBRE));
        palabras.add(new PalabraReservada("DESDE", TipoToken.DESDE));
        palabras.add(new PalabraReservada("EN", TipoToken.EN));
        palabras.add(new PalabraReservada("COMO", TipoToken.COMO));
        palabras.add(new PalabraReservada("->", TipoToken.ASIGNACION));
        
        caracteres = new ArrayList<>();
        caracteres.add(new PalabraReservada(String.valueOf(COMILLAS), TipoToken.COMILLAS));
        caracteres.add(new PalabraReservada("=", TipoToken.IGUAL));
        caracteres.add(new PalabraReservada("+", TipoToken.CONCATENACION));
        caracteres.add(new PalabraReservada("{", TipoToken.LLAVE_IZQUIERDA));
        caracteres.add(new PalabraReservada("}", TipoToken.LLAVE_DERECHA));
        caracteres.add(new PalabraReservada("(", TipoToken.PARENTESIS_IZQUIERDA));
        caracteres.add(new PalabraReservada(")", TipoToken.PARENTESIS_DERECHA));
        caracteres.add(new PalabraReservada(String.valueOf(ASTERISCO), TipoToken.ASTERISCO));
        caracteres.add(new PalabraReservada(COMENTARIO_LINEA, TipoToken.COMENTARIO_LINEA));
        caracteres.add(new PalabraReservada(COMENT_BLOQUE_INICIO, TipoToken.COMENTARIO_BLOQUE));
        caracteres.add(new PalabraReservada(COMENT_BLOQUE_FIN, TipoToken.COMENTARIO_BLOQUE));
        caracteres.add(new PalabraReservada("/", TipoToken.SLASH));
        
        numeros = new ArrayList<>();
        numeros.add("0");
        numeros.add("1");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
        numeros.add("5");
        numeros.add("6");
        numeros.add("7");
        numeros.add("8");
        numeros.add("9");
        numeros.add(String.valueOf(PUNTO));
    }
    
    public List<PalabraReservada> getPalabras() {
        return palabras;
    }

    public String getMODELO() {
        return buscarPalabra(TipoToken.MODELO);
    }
    
    public String getROL() {
        return buscarPalabra(TipoToken.ROL);
    }

    public String getFORMATO() {
        return buscarPalabra(TipoToken.FORMATO);
    }

    public String getAGENTE() {
        return buscarPalabra(TipoToken.AGENTE);
    }

    public String getCONTEXTO() {
        return buscarPalabra(TipoToken.CONTEXTO);
    }

    public String getVARIABLE() {
        return buscarPalabra(TipoToken.VARIABLE);
    }

    public String getEJECUTAR() {
        return buscarPalabra(TipoToken.EJECUTAR);
    }

    public String getEXPORTAR() {
        return buscarPalabra(TipoToken.EXPORTAR);
    }

    public String getPREGUNTAR() {
        return buscarPalabra(TipoToken.PREGUNTAR);
    }

    public String getGENERAR() {
        return buscarPalabra(TipoToken.GENERAR);
    }

    public String getRESUMIR() {
        return buscarPalabra(TipoToken.RESUMIR);
    }

    public String getANALIZAR() {
        return buscarPalabra(TipoToken.ANALIZAR);
    }

    public String getTRADUCIR() {
        return buscarPalabra(TipoToken.TRADUCIR);
    }

    public String getCLASIFICAR() {
        return buscarPalabra(TipoToken.CLASIFICAR);
    }

    public String getEXTRAER() {
        return buscarPalabra(TipoToken.EXTRAER);
    }

    public String getCARGAR() {
        return buscarPalabra(TipoToken.CARGAR);
    }

    public String getSOBRE() {
        return buscarPalabra(TipoToken.SOBRE);
    }

    public String getDESDE() {
        return buscarPalabra(TipoToken.DESDE);
    }

    public String getEN() {
        return buscarPalabra(TipoToken.EN);
    }

    public String getCOMO() {
        return buscarPalabra(TipoToken.COMO);
    }

    public String getASIGNACION() {
        return buscarPalabra(TipoToken.ASIGNACION);
    }
    
    private String buscarPalabra(TipoToken tipo) {
        for (PalabraReservada palabra : palabras) {
            if (palabra.getTipo() == tipo) {
                return palabra.getLexema();
            }
        }
        return null;
    }

    public List<PalabraReservada> getCaracteres() {
        return caracteres;
    }
    
    public List<String> getNumeros() {
        return numeros;
    }

    public char getARROBA() {
        return ARROBA;
    }

    public char getPUNTO() {
        return PUNTO;
    }

    public char getGUION_BAJO() {
        return GUION_BAJO;
    }

    public char getCOMILLAS() {
        return COMILLAS;
    }
    
    public char getSLASH() {
        return SLASH;
    }
    
    public char getASTERISCO() {
        return ASTERISCO;
    }
    
    public String getCOMENTARIO_LINEA() {
        return COMENTARIO_LINEA;
    }
    
    public String getCOMENT_BLOQUE_INICIO() {
        return COMENT_BLOQUE_INICIO;
    }
    
    public String getCOMENT_BLOQUE_FIN() {
        return COMENT_BLOQUE_FIN;
    }
    
}
