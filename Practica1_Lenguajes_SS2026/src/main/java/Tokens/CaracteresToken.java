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
public class CaracteresToken {
    
    /*
    Son caracteres validos para ser comprobados si son tokens
    */
    private final List<Character> caracteres;
    private final List<Character> numeros;
    private final List<Character> caracteresEspeciales;
    private final char ARROBA = '@';
    private final char A_MIN = 'a';
    private final char B_MIN = 'b';
    private final char C_MIN = 'c';
    private final char D_MIN = 'd';
    private final char E_MIN = 'e';
    private final char F_MIN = 'f';
    private final char G_MIN = 'g';
    private final char H_MIN = 'h';
    private final char I_MIN = 'i';
    private final char J_MIN = 'j';
    private final char K_MIN = 'k';
    private final char L_MIN = 'l';
    private final char M_MIN = 'm';
    private final char N_MIN = 'n';
    private final char O_MIN = 'o';
    private final char P_MIN = 'p';
    private final char Q_MIN = 'q';
    private final char R_MIN = 'r';
    private final char S_MIN = 's';
    private final char T_MIN = 't';
    private final char U_MIN = 'u';
    private final char V_MIN = 'v';
    private final char W_MIN = 'w';
    private final char X_MIN = 'x';
    private final char Y_MIN = 'y';
    private final char Z_MIN = 'z';
    private final char A = 'A';
    private final char B = 'B';
    private final char C = 'C';
    private final char D = 'D';
    private final char E = 'E';
    private final char F = 'F';
    private final char G = 'G';
    private final char H = 'H';
    private final char I = 'I';
    private final char J = 'J';
    private final char K = 'K';
    private final char L = 'L';
    private final char M = 'M';
    private final char N = 'N';
    private final char O = 'O';
    private final char P = 'P';
    private final char Q = 'Q';
    private final char R = 'R';
    private final char S = 'S';
    private final char T = 'T';
    private final char U = 'U';
    private final char V = 'V';
    private final char W = 'W';
    private final char X = 'X';
    private final char Y = 'Y';
    private final char Z = 'Z';
    private final char CERO = '0';
    private final char UNO = '1';
    private final char DOS = '2';
    private final char TRES = '3';
    private final char CUATRO = '4';
    private final char CINCO = '5';
    private final char SEIS = '6';
    private final char SIETE = '7';
    private final char OCHO = '8';
    private final char NUEVE = '9';
    private final char PUNTO = '.';
    private final char GUION_BAJO = '_';
    private final char IGUAL = '=';
    private final char CONCATENACION = '+';
    private final char LLAVE_IZQUIERDA = '{';
    private final char LLAVE_DERECHA = '}';
    private final char PARENTESIS_IZQUIERDA = '(';
    private final char PARENTESIS_DERECHA = ')';
    private final char COMILLAS = '"';
    private final char SLASH = '/';
    private final char ASTERISCO = '*';

    public CaracteresToken() {
        caracteres = new ArrayList<>();
        caracteres.add(ARROBA);
        caracteres.add(A_MIN);
        caracteres.add(B_MIN);
        caracteres.add(C_MIN);
        caracteres.add(D_MIN);
        caracteres.add(E_MIN);
        caracteres.add(F_MIN);
        caracteres.add(G_MIN);
        caracteres.add(H_MIN);
        caracteres.add(I_MIN);
        caracteres.add(J_MIN);
        caracteres.add(K_MIN);
        caracteres.add(L_MIN);
        caracteres.add(M_MIN);
        caracteres.add(N_MIN);
        caracteres.add(O_MIN);
        caracteres.add(P_MIN);
        caracteres.add(Q_MIN);
        caracteres.add(R_MIN);
        caracteres.add(S_MIN);
        caracteres.add(T_MIN);
        caracteres.add(U_MIN);
        caracteres.add(V_MIN);
        caracteres.add(W_MIN);
        caracteres.add(X_MIN);
        caracteres.add(Y_MIN);
        caracteres.add(Z_MIN);

        caracteres.add(A);
        caracteres.add(B);
        caracteres.add(C);
        caracteres.add(D);
        caracteres.add(E);
        caracteres.add(F);
        caracteres.add(G);
        caracteres.add(H);
        caracteres.add(I);
        caracteres.add(J);
        caracteres.add(K);
        caracteres.add(L);
        caracteres.add(M);
        caracteres.add(N);
        caracteres.add(O);
        caracteres.add(P);
        caracteres.add(Q);
        caracteres.add(R);
        caracteres.add(S);
        caracteres.add(T);
        caracteres.add(U);
        caracteres.add(V);
        caracteres.add(W);
        caracteres.add(X);
        caracteres.add(Y);
        caracteres.add(Z);
        
        numeros = new ArrayList<>();
        numeros.add(CERO);
        numeros.add(UNO);
        numeros.add(DOS);
        numeros.add(TRES);
        numeros.add(CUATRO);
        numeros.add(CINCO);
        numeros.add(SEIS);
        numeros.add(SIETE);
        numeros.add(OCHO);
        numeros.add(NUEVE);
        numeros.add(PUNTO);
        
        caracteresEspeciales = new ArrayList<>();
        caracteresEspeciales.add(IGUAL);
        caracteresEspeciales.add(CONCATENACION);
        caracteresEspeciales.add(LLAVE_IZQUIERDA);
        caracteresEspeciales.add(LLAVE_DERECHA);
        caracteresEspeciales.add(PARENTESIS_IZQUIERDA);
        caracteresEspeciales.add(PARENTESIS_DERECHA);
        caracteresEspeciales.add(COMILLAS);
        caracteresEspeciales.add(SLASH);
        caracteresEspeciales.add(ASTERISCO);
    }
    
    public List<Character> getCaracteres() {
        return caracteres;
    }

    public char getIGUAL() {
        return IGUAL;
    }

    public List<Character> getNumeros() {
        return numeros;
    }

    public List<Character> getCaracteresEspeciales() {
        return caracteresEspeciales;
    }

    public char getCONCATENACION() {
        return CONCATENACION;
    }

    public char getLLAVE_IZQUIERDA() {
        return LLAVE_IZQUIERDA;
    }

    public char getLLAVE_DERECHA() {
        return LLAVE_DERECHA;
    }

    public char getPARENTESIS_IZQUIERDA() {
        return PARENTESIS_IZQUIERDA;
    }

    public char getPARENTESIS_DERECHA() {
        return PARENTESIS_DERECHA;
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
    
}
