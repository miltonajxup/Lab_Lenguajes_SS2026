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
public class Alfabeto {
    
    private final List<Character> letras;
    private final List<Character> numeros;
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
    private final char PUNTO = '.';

    public Alfabeto() {
        letras = new ArrayList<>();
        letras.add(ARROBA);
        letras.add(A_MIN);
        letras.add(B_MIN);
        letras.add(C_MIN);
        letras.add(D_MIN);
        letras.add(E_MIN);
        letras.add(F_MIN);
        letras.add(G_MIN);
        letras.add(H_MIN);
        letras.add(I_MIN);
        letras.add(J_MIN);
        letras.add(K_MIN);
        letras.add(L_MIN);
        letras.add(M_MIN);
        letras.add(N_MIN);
        letras.add(O_MIN);
        letras.add(P_MIN);
        letras.add(Q_MIN);
        letras.add(R_MIN);
        letras.add(S_MIN);
        letras.add(T_MIN);
        letras.add(U_MIN);
        letras.add(V_MIN);
        letras.add(W_MIN);
        letras.add(X_MIN);
        letras.add(Y_MIN);
        letras.add(Z_MIN);

        letras.add(A);
        letras.add(B);
        letras.add(C);
        letras.add(D);
        letras.add(E);
        letras.add(F);
        letras.add(G);
        letras.add(H);
        letras.add(I);
        letras.add(J);
        letras.add(K);
        letras.add(L);
        letras.add(M);
        letras.add(N);
        letras.add(O);
        letras.add(P);
        letras.add(Q);
        letras.add(R);
        letras.add(S);
        letras.add(T);
        letras.add(U);
        letras.add(V);
        letras.add(W);
        letras.add(X);
        letras.add(Y);
        letras.add(Z);
        
        numeros = new ArrayList<>();
        numeros.add('0');
        numeros.add('1');
        numeros.add('2');
        numeros.add('3');
        numeros.add('4');
        numeros.add('5');
        numeros.add('6');
        numeros.add('7');
        numeros.add('8');
        numeros.add('9');
        numeros.add(PUNTO);
    }
    
    public List<Character> getLetras() {
        return letras;
    }
    
    public List<Character> getNumeros() {
        return numeros;
    }
    
    public char getPUNTO() {
        return PUNTO;
    }
    
}
