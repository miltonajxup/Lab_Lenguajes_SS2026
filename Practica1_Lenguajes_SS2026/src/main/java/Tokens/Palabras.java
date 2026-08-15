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
    
    public String buscarPalabra(TipoToken tipo) {
        for (PalabraReservada palabra : palabras) {
            if (palabra.getTipo() == tipo) {
                return palabra.getLexema();
            }
        }
        return null;
    }
    
}
