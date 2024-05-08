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
texto = \"[^\"\\]+\"

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
              + yyline );return symbol(sym.SI, yytext()); }

"entonces" { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline );return symbol(sym.ENTONCES, yytext()); }

"fin_si"  { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline );return symbol(sym.FIN_SI, yytext()); }

"sino"    { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline );return symbol(sym.SINO, yytext()); }


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

"funcion"  { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.FUNCTION, yytext()); }

"retorna" { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.RETURN, yytext()); }

"retorno" { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.RETORNO, yytext()); }

","     { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.COMA, yytext()); }



"fin_funcion" { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.FIN_FUNCION, yytext()); }



"imprimir"  { System.out.println("Lexema imp: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.IMPRMIR, yytext()); }

"cadena"  { System.out.println("Lexema: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.CADENA, yytext()); }

{texto}     { System.out.println("Lexema texto: "
              + yytext()
              + " columna: "
              + yychar
              + " fila: "
              + yyline ); return symbol(sym.TEXTO, yytext());}


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