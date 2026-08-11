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
public class Tokens {
    
    private final List<String> tokens;
    private final String TOKEN_MODELO = "@modelo";
    private final String TOKEN_ROL = "@rol";
    private final String TOKEN_FORMATO = "@formato";
    private final String TOKEN_AGENTE = "AGENTE";
    private final String TOKEN_CONTEXTO = "contexto";
    private final String TOKEN_VARIABLE = "variable";
    private final String TOKEN_EJECUTAR = "EJECUTAR";
    private final String TOKEN_EXPORTAR = "EXPORTAR";
    private final String TOKEN_PREGUNTAR = "PREGUNTAR";
    private final String TOKEN_GENERAR = "GENERAR";
    private final String TOKEN_RESUMIR = "RESUMIR";
    private final String TOKEN_ANALIZAR = "ANALIZAR";
    private final String TOKEN_TRADUCIR = "TRADUCIR";
    private final String TOKEN_CLASIFICAR = "CLASIFICAR";
    private final String TOKEN_EXTRAER = "EXTRAER";
    private final String TOKEN_CARGAR = "CARGAR";
    private final String TOKEN_SOBRE = "SOBRE";
    private final String TOKEN_DESDE = "DESDE";
    private final String TOKEN_EN = "EN";
    private final String TOKEN_COMO = "COMO";
    private final String TOKEN_RESULTADO = "->";
    
    public Tokens() {
        tokens = new ArrayList<>();
        tokens.add(TOKEN_MODELO);
        tokens.add(TOKEN_ROL);
        tokens.add(TOKEN_FORMATO);
        tokens.add(TOKEN_AGENTE);
        tokens.add(TOKEN_CONTEXTO);
        tokens.add(TOKEN_VARIABLE);
        tokens.add(TOKEN_EJECUTAR);
        tokens.add(TOKEN_EXPORTAR);
        tokens.add(TOKEN_PREGUNTAR);
        tokens.add(TOKEN_GENERAR);
        tokens.add(TOKEN_RESUMIR);
        tokens.add(TOKEN_ANALIZAR);
        tokens.add(TOKEN_TRADUCIR);
        tokens.add(TOKEN_CLASIFICAR);
        tokens.add(TOKEN_EXTRAER);
        tokens.add(TOKEN_CARGAR);
        tokens.add(TOKEN_SOBRE);
        tokens.add(TOKEN_DESDE);
        tokens.add(TOKEN_EN);
        tokens.add(TOKEN_COMO);
        tokens.add(TOKEN_RESULTADO);
    }

    public List<String> getTokens() {
        return tokens;
    }

    public String getTOKEN_MODELO() {
        return TOKEN_MODELO;
    }

    public String getTOKEN_ROL() {
        return TOKEN_ROL;
    }

    public String getTOKEN_FORMATO() {
        return TOKEN_FORMATO;
    }

    public String getTOKEN_AGENTE() {
        return TOKEN_AGENTE;
    }

    public String getTOKEN_CONTEXTO() {
        return TOKEN_CONTEXTO;
    }

    public String getTOKEN_VARIABLE() {
        return TOKEN_VARIABLE;
    }

    public String getTOKEN_EJECUTAR() {
        return TOKEN_EJECUTAR;
    }

    public String getTOKEN_EXPORTAR() {
        return TOKEN_EXPORTAR;
    }

    public String getTOKEN_PREGUNTAR() {
        return TOKEN_PREGUNTAR;
    }

    public String getTOKEN_GENERAR() {
        return TOKEN_GENERAR;
    }

    public String getTOKEN_RESUMIR() {
        return TOKEN_RESUMIR;
    }

    public String getTOKEN_ANALIZAR() {
        return TOKEN_ANALIZAR;
    }

    public String getTOKEN_TRADUCIR() {
        return TOKEN_TRADUCIR;
    }

    public String getTOKEN_CLASIFICAR() {
        return TOKEN_CLASIFICAR;
    }

    public String getTOKEN_EXTRAER() {
        return TOKEN_EXTRAER;
    }

    public String getTOKEN_CARGAR() {
        return TOKEN_CARGAR;
    }

    public String getTOKEN_SOBRE() {
        return TOKEN_SOBRE;
    }

    public String getTOKEN_DESDE() {
        return TOKEN_DESDE;
    }

    public String getTOKEN_EN() {
        return TOKEN_EN;
    }

    public String getTOKEN_COMO() {
        return TOKEN_COMO;
    }

    public String getTOKEN_RESULTADO() {
        return TOKEN_RESULTADO;
    }
    
}
