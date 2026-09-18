/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milton
 */
public class Diccionario {
    
    private final List<Transicion> transiciones;
    private final List<Transicion> estadosDeAceptacion;
    private final String INICIO = "q0";
    private final String Q_ARROBA = "q1";
    private final String Q_aM = "q2";
    private final String Q_aMO = "q3";
    private final String Q_aMOD = "q4";
    private final String Q_aMODE = "q5";
    private final String Q_aMODEL = "q6";
    private final String Q_aMODELO = "q7";
    private final String Q_aR = "q8";
    private final String Q_aRO = "q9";
    private final String Q_aROL = "q10";
    private final String Q_aF = "q11";
    private final String Q_aFO = "q12";
    private final String Q_aFOR = "q13";
    private final String Q_aFORM = "q14";
    private final String Q_aFORMA = "q15";
    private final String Q_aFORMAT = "q16";
    private final String Q_aFORMATO = "q17";
    private final String Q_A = "q18";
    private final String Q_AG = "q19";
    private final String Q_AGE = "q20";
    private final String Q_AGEN = "q21";
    private final String Q_AGENT = "q22";
    private final String Q_AGENTE = "q23";
    private final String Q_AN = "q24";
    private final String Q_ANA = "q25";
    private final String Q_ANAL = "q26";
    private final String Q_ANALI = "q27";
    private final String Q_ANALIZ = "q28";
    private final String Q_ANALIZA = "q29";
    private final String Q_ANALIZAR = "q30";
    private final String Q_MIN_C = "q31";
    private final String Q_MIN_CO = "q32";
    private final String Q_MIN_CON = "q33";
    private final String Q_MIN_CONT = "q34";
    private final String Q_MIN_CONTE = "q35";
    private final String Q_MIN_CONTEX = "q36";
    private final String Q_MIN_CONTEXT = "q37";
    private final String Q_MIN_CONTEXTO = "q38";
    private final String Q_V = "q39";
    private final String Q_VA = "q40";
    private final String Q_VAR = "q41";
    private final String Q_VARI = "q42";
    private final String Q_VARIA = "q43";
    private final String Q_VARIAB = "q44";
    private final String Q_VARIABL = "q45";
    private final String Q_VARIABLE = "q46";
    private final String Q_E = "q47";
    private final String Q_EJ = "q48";
    private final String Q_EJE = "q49";
    private final String Q_EJEC = "q50";
    private final String Q_EJECU = "q51";
    private final String Q_EJECUT = "q52";
    private final String Q_EJECUTA = "q53";
    private final String Q_EJECUTAR = "q54";
    private final String Q_EX = "q55";
    private final String Q_EXP = "q56";
    private final String Q_EXPO = "q57";
    private final String Q_EXPOR = "q58";
    private final String Q_EXPORT = "q59";
    private final String Q_EXPORTA = "q60";
    private final String Q_EXPORTAR = "q61";
    private final String Q_EXT = "q62";
    private final String Q_EXTR = "q63";
    private final String Q_EXTRA = "q64";
    private final String Q_EXTRAE = "q65";
    private final String Q_EXTRAER = "q66";
    private final String Q_EN = "q67";
    private final String Q_P = "q68";
    private final String Q_PR = "q69";
    private final String Q_PRE = "q70";
    private final String Q_PREG = "q71";
    private final String Q_PREGU = "q72";
    private final String Q_PREGUN = "q73";
    private final String Q_PREGUNT = "q74";
    private final String Q_PREGUNTA = "q75";
    private final String Q_PREGUNTAR = "q76";
    private final String Q_G = "q77";
    private final String Q_GE = "q78";
    private final String Q_GEN = "q79";
    private final String Q_GENE = "q80";
    private final String Q_GENER = "q81";
    private final String Q_GENERA = "q82";
    private final String Q_GENERAR = "q83";
    private final String Q_R = "q84";
    private final String Q_RE = "q85";
    private final String Q_RES = "q86";
    private final String Q_RESU = "q87";
    private final String Q_RESUM = "q88";
    private final String Q_RESUMI = "q89";
    private final String Q_RESUMIR = "q90";
    private final String Q_T = "q91";
    private final String Q_TR = "q92";
    private final String Q_TRA = "q93";
    private final String Q_TRAD = "q94";
    private final String Q_TRADU = "q95";
    private final String Q_TRADUC = "q96";
    private final String Q_TRADUCI = "q97";
    private final String Q_TRADUCIR = "q98";
    private final String Q_C = "q99";
    private final String Q_CL = "q100";
    private final String Q_CLA = "q101";
    private final String Q_CLAS = "q102";
    private final String Q_CLASI = "q103";
    private final String Q_CLASIF = "q104";
    private final String Q_CLASIFI = "q105";
    private final String Q_CLASIFIC = "q106";
    private final String Q_CLASIFICA = "q107";
    private final String Q_CLASIFICAR = "q108";
    private final String Q_CA = "q109";
    private final String Q_CAR = "q110";
    private final String Q_CARG = "q111";
    private final String Q_CARGA = "q112";
    private final String Q_CARGAR = "q113";
    private final String Q_CO = "q114";
    private final String Q_COM = "q115";
    private final String Q_COMO = "q116";
    private final String Q_S = "q117";
    private final String Q_SO = "q118";
    private final String Q_SOB = "q119";
    private final String Q_SOBR = "q120";
    private final String Q_SOBRE = "q121";
    private final String Q_D = "q122";
    private final String Q_DE = "q123";
    private final String Q_DES = "q124";
    private final String Q_DESD = "q125";
    private final String Q_DESDE = "q126";
    private final String Q_ASIG1 = "q127";
    private final String Q_ASIG2 = "q128";
    private final String Q_COMILLA = "q129";
    private final String Q_LETRA = "q130";

    public Diccionario() {
        transiciones = new ArrayList<>();
        
        transiciones.add(new Transicion(INICIO, '@', Q_ARROBA));
        Transicion estadoArroba = new Transicion(Q_ARROBA);
        estadoArroba.agregarSiguiente('m', Q_aM);
        estadoArroba.agregarSiguiente('r', Q_aR);
        estadoArroba.agregarSiguiente('f', Q_aF);
        transiciones.add(estadoArroba);
        transiciones.add(new Transicion(Q_aM, 'o', Q_aMO));
        transiciones.add(new Transicion(Q_aMO, 'd', Q_aMOD));
        transiciones.add(new Transicion(Q_aMOD, 'e', Q_aMODE));
        transiciones.add(new Transicion(Q_aMODE, 'l', Q_aMODEL));
        Transicion modelo = new Transicion(Q_aMODEL, 'o', Q_aMODELO);
        transiciones.add(modelo);
        
        transiciones.add(new Transicion(Q_aR, 'o', Q_aRO));
        Transicion rol = new Transicion(Q_aRO, 'l', Q_aROL);
        transiciones.add(rol);
        
        transiciones.add(new Transicion(Q_aF, 'o', Q_aFO));
        transiciones.add(new Transicion(Q_aFO, 'r', Q_aFOR));
        transiciones.add(new Transicion(Q_aFOR, 'm', Q_aFORM));
        transiciones.add(new Transicion(Q_aFORM, 'a', Q_aFORMA));
        transiciones.add(new Transicion(Q_aFORMA, 't', Q_aFORMAT));
        Transicion formato = new Transicion(Q_aFORMAT, 'o', Q_aFORMATO);
        transiciones.add(formato);
        
        transiciones.add(new Transicion(INICIO, 'A', Q_A));
        Transicion estadoA = new Transicion(Q_A);
        estadoA.agregarSiguiente('G', Q_AG);
        estadoA.agregarSiguiente('N', Q_AN);
        transiciones.add(estadoA);
        transiciones.add(new Transicion(Q_AG, 'E', Q_AGE));
        transiciones.add(new Transicion(Q_AGE, 'N', Q_AGEN));
        transiciones.add(new Transicion(Q_AGEN, 'T', Q_AGENT));
        Transicion agente = new Transicion(Q_AGENT, 'E', Q_AGENTE);
        transiciones.add(agente);
        
        transiciones.add(new Transicion(Q_AN, 'A', Q_ANA));
        transiciones.add(new Transicion(Q_ANA, 'L', Q_ANAL));
        transiciones.add(new Transicion(Q_ANAL, 'I', Q_ANALI));
        transiciones.add(new Transicion(Q_ANALI, 'Z', Q_ANALIZ));
        transiciones.add(new Transicion(Q_ANALIZ, 'A', Q_ANALIZA));
        Transicion analiza = new Transicion(Q_ANALIZA, 'R', Q_ANALIZAR);
        transiciones.add(analiza);
        
        transiciones.add(new Transicion(INICIO, 'c', Q_MIN_C));
        transiciones.add(new Transicion(Q_MIN_C, 'o', Q_MIN_CO));
        transiciones.add(new Transicion(Q_MIN_CO, 'n', Q_MIN_CON));
        transiciones.add(new Transicion(Q_MIN_CON, 't', Q_MIN_CONT));
        transiciones.add(new Transicion(Q_MIN_CONT, 'e', Q_MIN_CONTE));
        transiciones.add(new Transicion(Q_MIN_CONTE, 'x', Q_MIN_CONTEX));
        transiciones.add(new Transicion(Q_MIN_CONTEX, 't', Q_MIN_CONTEXT));
        Transicion contexto = new Transicion(Q_MIN_CONTEXT, 'o', Q_MIN_CONTEXTO);
        transiciones.add(contexto);
        
        transiciones.add(new Transicion(INICIO, 'v', Q_V));
        transiciones.add(new Transicion(Q_V, 'a', Q_VA));
        transiciones.add(new Transicion(Q_VA, 'r', Q_VAR));
        transiciones.add(new Transicion(Q_VAR, 'i', Q_VARI));
        transiciones.add(new Transicion(Q_VARI, 'a', Q_VARIA));
        transiciones.add(new Transicion(Q_VARIA, 'b', Q_VARIAB));
        transiciones.add(new Transicion(Q_VARIAB, 'l', Q_VARIABL));
        Transicion variable = new Transicion(Q_VARIABL, 'e', Q_VARIABLE);
        transiciones.add(variable);
        
        transiciones.add(new Transicion(INICIO, 'E', Q_E));
        Transicion estadoE = new Transicion(Q_E);
        estadoE.agregarSiguiente('J', Q_EJ);
        estadoE.agregarSiguiente('X', Q_EX);
        
        Transicion en = new Transicion(estadoE.getEstadoActual(), 'N', Q_EN);
        estadoE.agregarSiguiente(en);
        
        transiciones.add(estadoE);
        transiciones.add(new Transicion(Q_EJ, 'E', Q_EJE));
        transiciones.add(new Transicion(Q_EJE, 'C', Q_EJEC));
        transiciones.add(new Transicion(Q_EJEC, 'U', Q_EJECU));
        transiciones.add(new Transicion(Q_EJECU, 'T', Q_EJECUT));
        transiciones.add(new Transicion(Q_EJECUT, 'A', Q_EJECUTA));
        Transicion ejecutar = new Transicion(Q_EJECUTA, 'R', Q_EJECUTAR);
        transiciones.add(ejecutar);
        
        Transicion estadoEX = new Transicion(Q_EX);
        estadoEX.agregarSiguiente('P', Q_EXP);
        estadoEX.agregarSiguiente('T', Q_EXT);
        transiciones.add(estadoEX);
        transiciones.add(new Transicion(Q_EXP, 'O', Q_EXPO));
        transiciones.add(new Transicion(Q_EXPO, 'R', Q_EXPOR));
        transiciones.add(new Transicion(Q_EXPOR, 'T', Q_EXPORT));
        transiciones.add(new Transicion(Q_EXPORT, 'A', Q_EXPORTA));
        Transicion exportar = new Transicion(Q_EXPORTA, 'R', Q_EXPORTAR);
        transiciones.add(exportar);
        
        transiciones.add(new Transicion(Q_EXT, 'R', Q_EXTR));
        transiciones.add(new Transicion(Q_EXTR, 'A', Q_EXTRA));
        transiciones.add(new Transicion(Q_EXTRA, 'E', Q_EXTRAE));
        Transicion extraer = new Transicion(Q_EXTRAE, 'R', Q_EXTRAER);
        transiciones.add(extraer);
        
        transiciones.add(new Transicion(INICIO, 'P', Q_P));
        transiciones.add(new Transicion(Q_P, 'R', Q_PR));
        transiciones.add(new Transicion(Q_PR, 'E', Q_PRE));
        transiciones.add(new Transicion(Q_PRE, 'G', Q_PREG));
        transiciones.add(new Transicion(Q_PREG, 'U', Q_PREGU));
        transiciones.add(new Transicion(Q_PREGU, 'N', Q_PREGUN));
        transiciones.add(new Transicion(Q_PREGUN, 'T', Q_PREGUNT));
        transiciones.add(new Transicion(Q_PREGUNT, 'A', Q_PREGUNTA));
        Transicion preguntar = new Transicion(Q_PREGUNTA, 'R', Q_PREGUNTAR);
        transiciones.add(preguntar);
        
        transiciones.add(new Transicion(INICIO, 'G', Q_G));
        transiciones.add(new Transicion(Q_G, 'E', Q_GE));
        transiciones.add(new Transicion(Q_GE, 'N', Q_GEN));
        transiciones.add(new Transicion(Q_GEN, 'E', Q_GENE));
        transiciones.add(new Transicion(Q_GENE, 'R', Q_GENER));
        transiciones.add(new Transicion(Q_GENER, 'A', Q_GENERA));
        Transicion generar = new Transicion(Q_GENERA, 'R', Q_GENERAR);
        transiciones.add(generar);
        
        transiciones.add(new Transicion(INICIO, 'R', Q_R));
        transiciones.add(new Transicion(Q_R, 'E', Q_RE));
        transiciones.add(new Transicion(Q_RE, 'S', Q_RES));
        transiciones.add(new Transicion(Q_RES, 'U', Q_RESU));
        transiciones.add(new Transicion(Q_RESU, 'M', Q_RESUM));
        transiciones.add(new Transicion(Q_RESUM, 'I', Q_RESUMI));
        Transicion resumir = new Transicion(Q_RESUMI, 'R', Q_RESUMIR);
        transiciones.add(resumir);
        
        transiciones.add(new Transicion(INICIO, 'T', Q_T));
        transiciones.add(new Transicion(Q_T, 'R', Q_TR));
        transiciones.add(new Transicion(Q_TR, 'A', Q_TRA));
        transiciones.add(new Transicion(Q_TRA, 'D', Q_TRAD));
        transiciones.add(new Transicion(Q_TRAD, 'U', Q_TRADU));
        transiciones.add(new Transicion(Q_TRADU, 'C', Q_TRADUC));
        transiciones.add(new Transicion(Q_TRADUC, 'I', Q_TRADUCI));
        Transicion traducir = new Transicion(Q_TRADUCI, 'R', Q_TRADUCIR);
        transiciones.add(traducir);
        
        transiciones.add(new Transicion(INICIO, 'C', Q_C));
        Transicion estadoC = new Transicion(Q_C);
        estadoC.agregarSiguiente('L', Q_CL);
        estadoC.agregarSiguiente('A', Q_CA);
        estadoC.agregarSiguiente('O', Q_CO);
        transiciones.add(estadoC);
        transiciones.add(new Transicion(Q_CL, 'A', Q_CLA));
        transiciones.add(new Transicion(Q_CLA, 'S', Q_CLAS));
        transiciones.add(new Transicion(Q_CLAS, 'I', Q_CLASI));
        transiciones.add(new Transicion(Q_CLASI, 'F', Q_CLASIF));
        transiciones.add(new Transicion(Q_CLASIF, 'I', Q_CLASIFI));
        transiciones.add(new Transicion(Q_CLASIFI, 'C', Q_CLASIFIC));
        transiciones.add(new Transicion(Q_CLASIFIC, 'A', Q_CLASIFICA));
        Transicion clasificar = new Transicion(Q_CLASIFICA, 'R', Q_CLASIFICAR);
        transiciones.add(clasificar);
        
        transiciones.add(new Transicion(Q_CA, 'R', Q_CAR));
        transiciones.add(new Transicion(Q_CAR, 'G', Q_CARG));
        transiciones.add(new Transicion(Q_CARG, 'A', Q_CARGA));
        Transicion cargar = new Transicion(Q_CARGA, 'R', Q_CARGAR);
        transiciones.add(cargar);
        
        transiciones.add(new Transicion(Q_CO, 'M', Q_COM));
        Transicion como = new Transicion(Q_COM, 'O', Q_COMO);
        transiciones.add(como);
        
        transiciones.add(new Transicion(INICIO, 'S', Q_S));
        transiciones.add(new Transicion(Q_S, 'O', Q_SO));
        transiciones.add(new Transicion(Q_SO, 'B', Q_SOB));
        transiciones.add(new Transicion(Q_SOB, 'R', Q_SOBR));
        Transicion sobre = new Transicion(Q_SOBR, 'E', Q_SOBRE);
        transiciones.add(sobre);
        
        transiciones.add(new Transicion(INICIO, 'D', Q_D));
        transiciones.add(new Transicion(Q_D, 'E', Q_DE));
        transiciones.add(new Transicion(Q_DE, 'S', Q_DES));
        transiciones.add(new Transicion(Q_DES, 'D', Q_DESD));
        Transicion desde = new Transicion(Q_DESD, 'E', Q_DESDE);
        transiciones.add(desde);
        
        transiciones.add(new Transicion(INICIO, '-', Q_ASIG1));
        Transicion asignacion = new Transicion(Q_ASIG1, '>', Q_ASIG2);
        transiciones.add(asignacion);
        
        transiciones.add(new Transicion(INICIO, '"', Q_COMILLA));
        Transicion finCadena = new Transicion(Q_LETRA, '"', Q_COMILLA);
        //Transicion finCadenaVacia = new Transicion(Q_COMILLA, '"', Q_COMILLA);
        transiciones.add(finCadena);
        //transiciones.add(finCadenaVacia);
        
        estadosDeAceptacion = new ArrayList<>();
        estadosDeAceptacion.add(modelo);
        estadosDeAceptacion.add(rol);
        estadosDeAceptacion.add(formato);
        estadosDeAceptacion.add(agente);
        estadosDeAceptacion.add(analiza);
        estadosDeAceptacion.add(contexto);
        estadosDeAceptacion.add(variable);
        estadosDeAceptacion.add(en);
        estadosDeAceptacion.add(ejecutar);
        estadosDeAceptacion.add(exportar);
        estadosDeAceptacion.add(extraer);
        estadosDeAceptacion.add(preguntar);
        estadosDeAceptacion.add(generar);
        estadosDeAceptacion.add(resumir);
        estadosDeAceptacion.add(traducir);
        estadosDeAceptacion.add(clasificar);
        estadosDeAceptacion.add(cargar);
        estadosDeAceptacion.add(como);
        estadosDeAceptacion.add(sobre);
        estadosDeAceptacion.add(desde);
        estadosDeAceptacion.add(finCadena);
        estadosDeAceptacion.add(asignacion);
        //estadosDeAceptacion.add(finCadenaVacia);
    }
    
    public List<Transicion> getTransiciones() {
        return transiciones;
    }
    
    public List<Transicion> getEstadosDeAceptacion() {
        return estadosDeAceptacion;
    }
    
    public String getINICIO() {
        return INICIO;
    }
    
    public String getQ_COMILLA() {
        return Q_COMILLA;
    }
    
    public String getQ_LETRA() {
        return Q_LETRA;
    }
    
}
