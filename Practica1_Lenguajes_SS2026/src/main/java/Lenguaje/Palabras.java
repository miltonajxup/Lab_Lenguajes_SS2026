/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lenguaje;

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
    private final PalabraReservada modelo;
    private final PalabraReservada rol;
    private final PalabraReservada formato;
    private final PalabraReservada agente;
    private final PalabraReservada contexto;
    private final PalabraReservada variable;
    private final PalabraReservada ejecutar;
    private final PalabraReservada exportar;
    private final PalabraReservada preguntar;
    private final PalabraReservada generar;
    private final PalabraReservada resumir;
    private final PalabraReservada analizar;
    private final PalabraReservada traducir;
    private final PalabraReservada clasificar;
    private final PalabraReservada extraer;
    private final PalabraReservada cargar;
    private final PalabraReservada sobre;
    private final PalabraReservada desde;
    private final PalabraReservada en;
    private final PalabraReservada como;
    private final PalabraReservada asignacion;
    private final char GUION_BAJO = '_';
    private final char COMILLAS = '"';
    private final char ARROBA = '@';
    private final char PUNTO = '.';
    private final char SLASH = '/';
    private final char ASTERISCO = '*';
    private final char PUNTO_Y_COMA = ';';
    private final char COMA = ',';
    private final char DOS_PUNTOS = ':';
    private final String COMENTARIO_LINEA = "//";
    private final String COMENT_BLOQUE_INICIO = "/*";
    private final String COMENT_BLOQUE_FIN = "*/";
    
    public Palabras() {
        modelo = new PalabraReservada("@modelo", TipoToken.MODELO);
        rol = new PalabraReservada("@rol", TipoToken.ROL);
        formato = new PalabraReservada("@formato", TipoToken.FORMATO);
        agente = new PalabraReservada("AGENTE", TipoToken.AGENTE);
        contexto = new PalabraReservada("contexto", TipoToken.CONTEXTO);
        variable = new PalabraReservada("variable", TipoToken.VARIABLE);
        ejecutar = new PalabraReservada("EJECUTAR", TipoToken.EJECUTAR);
        exportar = new PalabraReservada("EXPORTAR", TipoToken.EXPORTAR);
        preguntar = new PalabraReservada("PREGUNTAR", TipoToken.PREGUNTAR);
        generar = new PalabraReservada("GENERAR", TipoToken.GENERAR);
        resumir = new PalabraReservada("RESUMIR", TipoToken.RESUMIR);
        analizar = new PalabraReservada("ANALIZAR", TipoToken.ANALIZAR);
        traducir = new PalabraReservada("TRADUCIR", TipoToken.TRADUCIR);
        clasificar = new PalabraReservada("CLASIFICAR", TipoToken.CLASIFICAR);
        extraer = new PalabraReservada("EXTRAER", TipoToken.EXTRAER);
        cargar = new PalabraReservada("CARGAR", TipoToken.CARGAR);
        sobre = new PalabraReservada("SOBRE", TipoToken.SOBRE); 
        desde = new PalabraReservada("DESDE", TipoToken.DESDE);
        en = new PalabraReservada("EN", TipoToken.EN);
        como = new PalabraReservada("COMO", TipoToken.COMO);
        asignacion = new PalabraReservada("->", TipoToken.ASIGNACION);
        
        palabras = new ArrayList<>();
        palabras.add(modelo);
        palabras.add(rol);
        palabras.add(formato);
        palabras.add(agente);
        palabras.add(contexto);
        palabras.add(variable);
        palabras.add(ejecutar);
        palabras.add(exportar);
        palabras.add(preguntar);
        palabras.add(generar);
        palabras.add(resumir);
        palabras.add(analizar);
        palabras.add(traducir);
        palabras.add(clasificar);
        palabras.add(extraer);
        palabras.add(cargar);
        palabras.add(sobre);
        palabras.add(desde);
        palabras.add(en);
        palabras.add(como);
        palabras.add(asignacion);
        
        caracteres = new ArrayList<>();
        caracteres.add(new PalabraReservada(String.valueOf(COMILLAS), TipoToken.COMILLAS));
        caracteres.add(new PalabraReservada("=", TipoToken.IGUAL));
        caracteres.add(new PalabraReservada("+", TipoToken.CONCATENACION));
        caracteres.add(new PalabraReservada("{", TipoToken.LLAVE_IZQUIERDA));
        caracteres.add(new PalabraReservada("}", TipoToken.LLAVE_DERECHA));
        caracteres.add(new PalabraReservada("(", TipoToken.PARENTESIS_IZQUIERDA));
        caracteres.add(new PalabraReservada(")", TipoToken.PARENTESIS_DERECHA));
        caracteres.add(new PalabraReservada(String.valueOf(ASTERISCO), TipoToken.ASTERISCO));
        caracteres.add(new PalabraReservada(String.valueOf(PUNTO_Y_COMA), TipoToken.DELIMITADOR));
        caracteres.add(new PalabraReservada(String.valueOf(COMA), TipoToken.DELIMITADOR));
        caracteres.add(new PalabraReservada(String.valueOf(DOS_PUNTOS), TipoToken.DELIMITADOR));
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
    
    public List<String> getNumeros() {
        return numeros;
    }

    public String getMODELO() {
        return modelo.getLexema();
    }
    
    public String getROL() {
        return rol.getLexema();
    }

    public String getFORMATO() {
        return formato.getLexema();
    }

    public String getAGENTE() {
        return agente.getLexema();
    }

    public String getCONTEXTO() {
        return contexto.getLexema();
    }

    public String getVARIABLE() {
        return variable.getLexema();
    }

    public String getEJECUTAR() {
        return ejecutar.getLexema();
    }

    public String getEXPORTAR() {
        return exportar.getLexema();
    }

    public String getPREGUNTAR() {
        return preguntar.getLexema();
    }

    public String getGENERAR() {
        return generar.getLexema();
    }

    public String getRESUMIR() {
        return resumir.getLexema();
    }

    public String getANALIZAR() {
        return analizar.getLexema();
    }

    public String getTRADUCIR() {
        return traducir.getLexema();
    }

    public String getCLASIFICAR() {
        return clasificar.getLexema();
    }

    public String getEXTRAER() {
        return extraer.getLexema();
    }

    public String getCARGAR() {
        return cargar.getLexema();
    }

    public String getSOBRE() {
        return sobre.getLexema();
    }

    public String getDESDE() {
        return desde.getLexema();
    }

    public String getEN() {
        return en.getLexema();
    }

    public String getCOMO() {
        return como.getLexema();
    }

    public String getASIGNACION() {
        return asignacion.getLexema();
    }
    
    public List<PalabraReservada> getCaracteres() {
        return caracteres;
    }
    
//    public List<String> getNumeros() {
//        return numeros;
//    }

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
