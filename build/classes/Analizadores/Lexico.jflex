package Analizadores;
import java_cup.runtime.*;

%% 

%class lexico
%cup
%public
%unicode
%line
%char
%ignorecase

%init{ 
	yyline = 1; 
	yychar = 1; 
%init} 

BLANCOS=[ \t\r]+
CADENACOMILLASDOBLES= [\"]([^\"\n]|(\\\"))*[\"]
IDEN=[a-zA-Z]+["_"|0-9|a-z|A-Z]* 
COMLIN=("//".*\r\n)|("//".*\n)|("//".*\r)
COMMLIN="<!""!"*([^!>]|[^!]">"|"!"[^>])*"!"*"!>"
D=[0-9]+
LETRA=[a-zA-Z]
ESPECIAL=("\\""n"|"\\""\'"|"\\""\"")
LETRAEXPREG=\"[A-Z]|[a-z]|[0-9]\"
CA=[0-9]"~"[0-9]
CB=[a-z]"~"[a-z]
CC=[A-Z]"~"[A-Z]

%%

{COMLIN}                {}
{COMMLIN}               {}
{LETRA}                 {return new Symbol(sym.letra,yycolumn, yyline, yytext());}
{D}                     {return new Symbol(sym.entero,yycolumn, yyline, yytext());} 
{ESPECIAL}              {return new Symbol(sym.especial,yyline,yychar, yytext());}
{LETRAEXPREG}           {return new Symbol(sym.letraexp,yyline,yychar, (yytext()).substring(1,yytext().length()-1));}
{CADENACOMILLASDOBLES}  {return new Symbol(sym.cadena,yyline,yychar, (yytext()).substring(1,yytext().length()-1));}

"CONJ" {return new Symbol(sym.conj,yyline,yychar, yytext());}
"," {return new Symbol(sym.coma,yyline,yychar, yytext());}
"\"" {return new Symbol(sym.comilladoble,yyline,yychar, yytext());} 
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
"~" {return new Symbol(sym.pestan,yyline,yychar, yytext());}

\n {yychar=1;}

{BLANCOS}   {} 
{IDEN}      {return new Symbol(sym.identificador,yycolumn, yyline, yytext());}
{CA}        {return new Symbol(sym.casa, yycolumn, yyline, yytext());}
{CB}        {return new Symbol(sym.casb, yycolumn, yyline, yytext());}
{CC}        {return new Symbol(sym.casc, yycolumn, yyline, yytext());}


.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yychar));
    }