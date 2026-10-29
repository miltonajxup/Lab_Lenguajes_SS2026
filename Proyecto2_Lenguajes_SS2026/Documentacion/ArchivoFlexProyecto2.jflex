package com.milton.proyecto2_lenguajes.compilador;

import com.milton.proyecto2_lenguajes.compilador.reglas.TipoToken;
import com.milton.proyecto2_lenguajes.compilador.reglas.Token;

%%

%class AnalizadorLexico
%type Token
%line
%column 

DIGITO = [0-9]
ENTERO = {DIGITO}+

LETRA = [a-zA-Z]
IDENTIFICADOR = {LETRA}({LETRA}|{DIGITO})*
CADENA = \"[^\r\n\"]*\"

ESPACIO = [ \t\n\r]+

%%

"@modelo" { return new Token(TipoToken.MODELO, yytext(), yyline + 1, yycolumn + 1); }
"@rol" { return new Token(TipoToken.ROL, yytext(), yyline + 1, yycolumn + 1); }
"@formato" { return new Token(TipoToken.FORMATO, yytext(), yyline + 1, yycolumn + 1); }

"AGENTE" { return new Token(TipoToken.AGENTE, yytext(), yyline + 1, yycolumn + 1); }
"contexto" { return new Token(TipoToken.CONTEXTO, yytext(), yyline + 1, yycolumn + 1); }
"variable" { return new Token(TipoToken.VARIABLE, yytext(), yyline + 1, yycolumn + 1); }
"EJECUTAR" { return new Token(TipoToken.EJECUTAR, yytext(), yyline + 1, yycolumn + 1); }
"EXPORTAR" { return new Token(TipoToken.EXPORTAR, yytext(), yyline + 1, yycolumn + 1); }

"PREGUNTAR" { return new Token(TipoToken.PREGUNTAR, yytext(), yyline + 1, yycolumn + 1); }
"GENERAR" { return new Token(TipoToken.GENERAR, yytext(), yyline + 1, yycolumn + 1); }
"RESUMIR" { return new Token(TipoToken.RESUMIR, yytext(), yyline + 1, yycolumn + 1); }
"ANALIZAR" { return new Token(TipoToken.ANALIZAR, yytext(), yyline + 1, yycolumn + 1); }
"TRADUCIR" { return new Token(TipoToken.TRADUCIR, yytext(), yyline + 1, yycolumn + 1); }
"CLASIFICAR" { return new Token(TipoToken.CLASIFICAR, yytext(), yyline + 1, yycolumn + 1); }
"EXTRAER" { return new Token(TipoToken.EXTRAER, yytext(), yyline + 1, yycolumn + 1); }

"CARGAR" { return new Token(TipoToken.CARGAR, yytext(), yyline + 1, yycolumn + 1); }

"SOBRE" { return new Token(TipoToken.SOBRE, yytext(), yyline + 1, yycolumn + 1); }
"DESDE" { return new Token(TipoToken.DESDE, yytext(), yyline + 1, yycolumn + 1); }
"EN" { return new Token(TipoToken.EN, yytext(), yyline + 1, yycolumn + 1); }
"COMO" { return new Token(TipoToken.COMO, yytext(), yyline + 1, yycolumn + 1); }

"->" { return new Token(TipoToken.ASIGNAR, yytext(), yyline + 1, yycolumn + 1); }

"=" { return new Token(TipoToken.ASIGNACION, yytext(), yyline + 1, yycolumn + 1); }
"+" { return new Token(TipoToken.CONCATENACION, yytext(), yyline + 1, yycolumn + 1); }

"{" { return new Token(TipoToken.LLAVE_IZQ, yytext(), yyline + 1, yycolumn + 1); }
"}" { return new Token(TipoToken.LLAVE_DER, yytext(), yyline + 1, yycolumn + 1); }
"(" { return new Token(TipoToken.PARENTESIS_IZQ, yytext(), yyline + 1, yycolumn + 1); }
")" { return new Token(TipoToken.PARENTESIS_DER, yytext(), yyline + 1, yycolumn + 1); }
"," { return new Token(TipoToken.COMA, yytext(), yyline + 1, yycolumn + 1); }
";" { return new Token(TipoToken.PUNTO_Y_COMA, yytext(), yyline + 1, yycolumn + 1); }


"//" [^\r\n]* { /* Ignorar */ }
"/*" [^*]* "*" ([^/][^*]* "*")* "/" { /* Ignorar */ }


{CADENA} { return new Token(TipoToken.CADENA, yytext(), yyline + 1, yycolumn + 1); }

{ENTERO} { return new Token(TipoToken.ENTERO, yytext(), yyline + 1, yycolumn + 1); }
{IDENTIFICADOR} { return new Token(TipoToken.IDENTIFICADOR, yytext(), yyline + 1, yycolumn + 1); }
{ESPACIO} { /* Ignorar espacios en blanco */ }

. {
    return new Token(
        TipoToken.ERROR,
        yytext(),
        yyline + 1,
        yycolumn + 1,
        "No se pudo reconocer el caracter: " + yytext()
        + ". Encontrado en la linea " + (yyline + 1)
        + " y columna " + (yycolumn + 1)
    );
}
