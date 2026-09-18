/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lenguaje;

import Archivos.Reporte.Estilos;
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
    private final PalabraReservada cadena;
    private final PalabraReservada slash;
    private final PalabraReservada identificador;
    private final PalabraReservada entero;
    private final PalabraReservada decimal;
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
        Estilos estilos = new Estilos();
        modelo = new PalabraReservada("@modelo", TipoToken.MODELO, estilos.getCOLOR_DIRECTIVA());
        rol = new PalabraReservada("@rol", TipoToken.ROL, estilos.getCOLOR_DIRECTIVA());
        formato = new PalabraReservada("@formato", TipoToken.FORMATO, estilos.getCOLOR_DIRECTIVA());
        agente = new PalabraReservada("AGENTE", TipoToken.AGENTE, estilos.getCOLOR_PALABRA_RESERVADA());
        contexto = new PalabraReservada("contexto", TipoToken.CONTEXTO, estilos.getCOLOR_PALABRA_RESERVADA());
        variable = new PalabraReservada("variable", TipoToken.VARIABLE, estilos.getCOLOR_PALABRA_RESERVADA());
        ejecutar = new PalabraReservada("EJECUTAR", TipoToken.EJECUTAR, estilos.getCOLOR_COMANDO());
        exportar = new PalabraReservada("EXPORTAR", TipoToken.EXPORTAR, estilos.getCOLOR_COMANDO());
        preguntar = new PalabraReservada("PREGUNTAR", TipoToken.PREGUNTAR, estilos.getCOLOR_COMANDO());
        generar = new PalabraReservada("GENERAR", TipoToken.GENERAR, estilos.getCOLOR_COMANDO());
        resumir = new PalabraReservada("RESUMIR", TipoToken.RESUMIR, estilos.getCOLOR_COMANDO());
        analizar = new PalabraReservada("ANALIZAR", TipoToken.ANALIZAR, estilos.getCOLOR_COMANDO());
        traducir = new PalabraReservada("TRADUCIR", TipoToken.TRADUCIR, estilos.getCOLOR_COMANDO());
        clasificar = new PalabraReservada("CLASIFICAR", TipoToken.CLASIFICAR, estilos.getCOLOR_COMANDO());
        extraer = new PalabraReservada("EXTRAER", TipoToken.EXTRAER, estilos.getCOLOR_COMANDO());
        cargar = new PalabraReservada("CARGAR", TipoToken.CARGAR, estilos.getCOLOR_CARGAR());
        sobre = new PalabraReservada("SOBRE", TipoToken.SOBRE, estilos.getCOLOR_CONECTOR()); 
        desde = new PalabraReservada("DESDE", TipoToken.DESDE, estilos.getCOLOR_CONECTOR());
        en = new PalabraReservada("EN", TipoToken.EN, estilos.getCOLOR_CONECTOR());
        como = new PalabraReservada("COMO", TipoToken.COMO, estilos.getCOLOR_CONECTOR());
        asignacion = new PalabraReservada("->", TipoToken.ASIGNACION, estilos.getCOLOR_CONECTOR());
        cadena = new PalabraReservada("cadena", TipoToken.STRING, estilos.getCOLOR_CADENA());
        identificador = new PalabraReservada("identificador", TipoToken.IDENTIFICADOR, estilos.getCOLOR_IDENTIFICADOR());
        entero = new PalabraReservada("entero", TipoToken.ENTERO, estilos.getCOLOR_NUMERO());
        decimal = new PalabraReservada("decimal", TipoToken.DECIMAL, estilos.getCOLOR_NUMERO());
        
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
        caracteres.add(new PalabraReservada(String.valueOf(COMILLAS), TipoToken.COMILLAS, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada("=", TipoToken.IGUAL, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada("+", TipoToken.CONCATENACION, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada("{", TipoToken.LLAVE_IZQUIERDA, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada("}", TipoToken.LLAVE_DERECHA, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada("(", TipoToken.PARENTESIS_IZQUIERDA, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(")", TipoToken.PARENTESIS_DERECHA, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(String.valueOf(ASTERISCO), TipoToken.ASTERISCO, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(String.valueOf(PUNTO_Y_COMA), TipoToken.DELIMITADOR, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(String.valueOf(COMA), TipoToken.DELIMITADOR, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(String.valueOf(DOS_PUNTOS), TipoToken.DELIMITADOR, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(COMENTARIO_LINEA, TipoToken.COMENTARIO_LINEA, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(COMENT_BLOQUE_INICIO, TipoToken.COMENTARIO_BLOQUE, estilos.getCOLOR_SIMBOLO()));
        caracteres.add(new PalabraReservada(COMENT_BLOQUE_FIN, TipoToken.COMENTARIO_BLOQUE, estilos.getCOLOR_SIMBOLO()));
        slash = new PalabraReservada(String.valueOf(SLASH), TipoToken.SLASH, estilos.getCOLOR_SIMBOLO());
        caracteres.add(slash);
        
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
    
    public PalabraReservada getCadena() {
        return cadena;
    }
    
    public PalabraReservada getSlash() {
        return slash;
    }
    
    public PalabraReservada getIdentificador() {
        return identificador;
    }

    public PalabraReservada getEntero() {
        return entero;
    }

    public PalabraReservada getDecimal() {
        return decimal;
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
