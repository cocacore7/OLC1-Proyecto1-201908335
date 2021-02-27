package Analizadores;
import java_cup.runtime.Symbol; 

%% 
%class lexico
%public 
%line 
%char 
%cup 
%unicode

%init{ 
	yyline = 1; 
	yychar = 1; 
%init} 

BLANCOS=[ \r\t]+
D=[0-9]+
PALABRA=[a-zA-Z]+
IDEN=[a-zA-Z] ([a-zA-Z]|[0-9])* 
DD = [0-9]+ "." [0-9]+

%%

"CONJ" {return new Symbol(sym.conjunto,yyline,yychar, yytext());}
" " {return new Symbol(sym.espacio,yyline,yychar, yytext());}
"!" {return new Symbol(sym.admiracion,yyline,yychar, yytext());} 
"#" {return new Symbol(sym.numeral,yyline,yychar, yytext());} 
"$" {return new Symbol(sym.dolar,yyline,yychar, yytext());} 
"%" {return new Symbol(sym.porcentaje,yyline,yychar, yytext());} 
"&" {return new Symbol(sym.ampersand,yyline,yychar, yytext());} 
"'" {return new Symbol(sym.comillasimple,yyline,yychar, yytext());} 
"(" {return new Symbol(sym.parentesisabre,yyline,yychar, yytext());} 
")" {return new Symbol(sym.parentesiscierra,yyline,yychar, yytext());} 
"*" {return new Symbol(sym.asterisco,yyline,yychar, yytext());} 
"+" {return new Symbol(sym.suma,yyline,yychar, yytext());} 
"," {return new Symbol(sym.coma,yyline,yychar, yytext());} 
"-" {return new Symbol(sym.menos,yyline,yychar, yytext());} 
"." {return new Symbol(sym.punto,yyline,yychar, yytext());} 
"/" {return new Symbol(sym.barrainclinada,yyline,yychar, yytext());} 
":" {return new Symbol(sym.dospuntos,yyline,yychar, yytext());} 
";" {return new Symbol(sym.puntocoma,yyline,yychar, yytext());} 
"<" {return new Symbol(sym.menor,yyline,yychar, yytext());} 
"=" {return new Symbol(sym.igual,yyline,yychar, yytext());} 
">" {return new Symbol(sym.mayor,yyline,yychar, yytext());} 
"?" {return new Symbol(sym.interrogacion,yyline,yychar, yytext());} 
"@" {return new Symbol(sym.arroba,yyline,yychar, yytext());} 
"[" {return new Symbol(sym.corchetesabre,yyline,yychar, yytext());}
"]" {return new Symbol(sym.corchetescierra,yyline,yychar, yytext());} 
"^" {return new Symbol(sym.elevado,yyline,yychar, yytext());} 
"_" {return new Symbol(sym.guionbajo,yyline,yychar, yytext());} 
"`" {return new Symbol(sym.acentograve,yyline,yychar, yytext());} 
"{" {return new Symbol(sym.llavesabre,yyline,yychar, yytext());}
"|" {return new Symbol(sym.barravertical,yyline,yychar, yytext());}
"}" {return new Symbol(sym.llavescierra,yyline,yychar, yytext());}
"~" {return new Symbol(sym.tilde,yyline,yychar, yytext());}

\n {yychar=1;}

{BLANCOS} {} 
{D} {return new Symbol(sym.entero,yyline,yychar, yytext());} 
{PALABRA} {return new Symbol(sym.palabra,yyline,yychar, yytext());}
{IDEN} {return new Symbol(sym.identificador,yyline,yychar, yytext());}
{DD}   {return new Symbol(sym.decimal, yycolumn, yyline, yytext());}

.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn));
    }