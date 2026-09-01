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
    private final String Q_ARROBA = "q_a";
    private final String Q_aM = "q_am";
    private final String Q_aMO = "q_amo";
    private final String Q_aMOD = "q_amod";
    private final String Q_aMODE = "q_amode";
    private final String Q_aMODEL = "q_amodel";
    private final String Q_aMODELO = "q_amodelo";
    private final String Q_aR = "q_ar";
    private final String Q_aRO = "q_aro";
    private final String Q_aROL = "q_arol";
    private final String Q_aF = "q_af";
    private final String Q_aFO = "q_afo";
    private final String Q_aFOR = "q_afor";
    private final String Q_aFORM = "q_afomr";
    private final String Q_aFORMA = "q_aforma";
    private final String Q_aFORMAT = "q_aformat";
    private final String Q_aFORMATO = "q_aformato";
    private final String Q_A = "q_A";
    private final String Q_AG = "q_AG";
    private final String Q_AGE = "q_AGE";
    private final String Q_AGEN = "q_AGEN";
    private final String Q_AGENT = "q_AGENT";
    private final String Q_AGENTE = "q_AGENTE";
    private final String Q_AN = "q_AN";
    private final String Q_ANA = "q_ANA";
    private final String Q_ANAL = "q_ANAL";
    private final String Q_ANALI = "q_ANALI";
    private final String Q_ANALIZ = "q_ANALIZ";
    private final String Q_ANALIZA = "q_ANALIZA";
    private final String Q_ANALIZAR = "q_ANALIZAR";
    private final String Q_MIN_C = "q_c";
    private final String Q_MIN_CO = "q_co";
    private final String Q_MIN_CON = "q_con";
    private final String Q_MIN_CONT = "q_cont";
    private final String Q_MIN_CONTE = "q_conte";
    private final String Q_MIN_CONTEX = "q_contex";
    private final String Q_MIN_CONTEXT = "q_context";
    private final String Q_MIN_CONTEXTO = "q_contexto";
    private final String Q_V = "q_v";
    private final String Q_VA = "q_va";
    private final String Q_VAR = "q_var";
    private final String Q_VARI = "q_vari";
    private final String Q_VARIA = "q_varia";
    private final String Q_VARIAB = "q_variab";
    private final String Q_VARIABL = "q_variabl";
    private final String Q_VARIABLE = "q_variable";
    private final String Q_E = "q_E";
    private final String Q_EJ = "q_EJ";
    private final String Q_EJE = "q_EJE";
    private final String Q_EJEC = "q_EJEC";
    private final String Q_EJECU = "q_EJECU";
    private final String Q_EJECUT = "q_EJECUT";
    private final String Q_EJECUTA = "q_EJECUTA";
    private final String Q_EJECUTAR = "q_EJECUTAR";
    private final String Q_EX = "q_EX";
    private final String Q_EXP = "q_EXP";
    private final String Q_EXPO = "q_EXPO";
    private final String Q_EXPOR = "q_EXPOR";
    private final String Q_EXPORT = "q_EXPORT";
    private final String Q_EXPORTA = "q_EXPORTA";
    private final String Q_EXPORTAR = "q_EXPORTAR";
    private final String Q_EXT = "q_EXT";
    private final String Q_EXTR = "q_EXTR";
    private final String Q_EXTRA = "q_EXTRA";
    private final String Q_EXTRAE = "q_EXTRAE";
    private final String Q_EXTRAER = "q_EXTRAER";
    private final String Q_EN = "q_EN";
    private final String Q_P = "q_P";
    private final String Q_PR = "q_PR";
    private final String Q_PRE = "q_PRE";
    private final String Q_PREG = "q_PREG";
    private final String Q_PREGU = "q_PREGU";
    private final String Q_PREGUN = "q_PREGUN";
    private final String Q_PREGUNT = "q_PREGUNT";
    private final String Q_PREGUNTA = "q_PREGUNTA";
    private final String Q_PREGUNTAR = "q_PREGUNTAR";
    private final String Q_G = "q_G";
    private final String Q_GE = "q_GE";
    private final String Q_GEN = "q_GEN";
    private final String Q_GENE = "q_GENE";
    private final String Q_GENER = "q_GENER";
    private final String Q_GENERA = "q_GENERA";
    private final String Q_GENERAR = "q_GENERAR";
    private final String Q_R = "q_R";
    private final String Q_RE = "q_RE";
    private final String Q_RES = "q_RES";
    private final String Q_RESU = "q_RESU";
    private final String Q_RESUM = "q_RESUM";
    private final String Q_RESUMI = "q_RESUMI";
    private final String Q_RESUMIR = "q_RESUMIR";
    private final String Q_T = "q_T";
    private final String Q_TR = "q_TR";
    private final String Q_TRA = "q_TRA";
    private final String Q_TRAD = "q_TRAD";
    private final String Q_TRADU = "q_TRADU";
    private final String Q_TRADUC = "q_TRADUC";
    private final String Q_TRADUCI = "q_TRADUCI";
    private final String Q_TRADUCIR = "q_TRADUCIR";
    private final String Q_C = "q_C";
    private final String Q_CL = "q_CL";
    private final String Q_CLA = "q_CLA";
    private final String Q_CLAS = "q_CLAS";
    private final String Q_CLASI = "q_CLASI";
    private final String Q_CLASIF = "q_CLASIF";
    private final String Q_CLASIFI = "q_CLASIFI";
    private final String Q_CLASIFIC = "q_CLASIFIC";
    private final String Q_CLASIFICA = "q_CLASIFICA";
    private final String Q_CLASIFICAR = "q_CLASIFICAR";
    private final String Q_CA = "q_CA";
    private final String Q_CAR = "q_CAR";
    private final String Q_CARG = "q_CARG";
    private final String Q_CARGA = "q_CARGA";
    private final String Q_CARGAR = "q_CARGAR";
    private final String Q_CO = "q_CO";
    private final String Q_COM = "q_COM";
    private final String Q_COMO = "q_COMO";
    private final String Q_S = "q_S";
    private final String Q_SO = "q_SO";
    private final String Q_SOB = "q_SOB";
    private final String Q_SOBR = "q_SOBR";
    private final String Q_SOBRE = "q_SOBRE";
    private final String Q_D = "q_D";
    private final String Q_DE = "q_DE";
    private final String Q_DES = "q_DES";
    private final String Q_DESD = "q_DESD";
    private final String Q_DESDE = "q_DESDE";

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
    
}
