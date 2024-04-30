package mi.primer.scanner;

import java_cup.runtime.*;
%%

//Opciones y definiciones regulares

%public
%class Scanner
%char
%line
%column
%cup

%{
    private Symbol symbol(int tipo, Object valor) {
        return new Symbol(tipo, yyline, yycolumn, valor);
    }
%}
//Definición regular
palabra = [a-zA-Z]+
identificador = [a-zA-Z][a-zA-Z0-9]*
digito = -?[0-9]+
espacios_blanco = [\r|\n|\r\n| |\t]
d_float  = -?[0-9]+(\.[0-9]+)?
%%

//Reglas léxicas

"*"        { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.MULTI, yytext()); }


"+"         { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.SUMA, yytext());  }

"-"        { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.RESTA, yytext()); }

"/"        { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.DIVIDIR, yytext()); }

"="        { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.ASIGNAR, yytext()); }

";"         { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.PUNTO_COMA, yytext());}

">"      { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.MAYOR, yytext()); }

"<"      { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.MENOR, yytext()); }

"=="      { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.IGUAL, yytext()); }

"!="      { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.DIFERENTE, yytext()); }


">="      { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.MAYOR_IGUAL, yytext()); }

"<="      { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.MENOR_IGUAL, yytext()); }



"("         { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.PARENTESIS_IZQ, yytext());}

")"         { System.out.println("Lexema: "
                + yytext()
                + " columna: "
                + yychar
                + " fila: "
                + yyline ); return symbol(sym.PARENTESIS_DER, yytext());}

"si"      { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline );}

"flotante"  { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline );return symbol(sym.FLOT, yytext()); }

"entero"   { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.ENT, yytext()); }

"imprimir"  { System.out.println("Lexema imp: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.IMPRMIR, yytext()); }


{identificador} { System.out.println("Lexema id: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.ID, yytext());}

{digito}     { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.NUM, new Integer(yytext()));}

{d_float}    { System.out.println("Lexema: "
                      + yytext()
                      + " columna: "
                      + yychar
                      + " fila: "
                      + yyline ); return symbol(sym.FLOTANTE, new Float(yytext()));}


{espacios_blanco}   { /*Ignorar estos símbolos*/ }