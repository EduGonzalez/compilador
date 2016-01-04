package compilador;
import java_cup.runtime.Symbol; 

%% 

%eofval{
    { System.exit(0); }
%eofval} 
%cup 
%line
%column
%char

//################################## DECLARACIONES ###################################################

%{/*Crear un nuevo objeto java_cup.runtime.Symbol con informacion sobre el token actual sin valor*/


    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }
    /* Crear un nuevo objeto java_cup.runtime.Symbol con informacion sobre el token actual con valor*/
    private Symbol symbol(int type,Object value){
        return new Symbol(type,yyline,yycolumn,value);
    }
%}

//#####################################################################################
//condiciones
length = [1-9][0-9]* //no puede empezar en cero, comienza del 1 al nueve y le puede seguir cualquiera
ID = [a-z]+[0-9]* //tiene que empezar con a-z y seguido 0-9

%% 

"INICIO"        {   
                System.out.println(yytext() + " es una INICIO - Linea: " + yyline + " - Columna: " + yycolumn); 
                return new Symbol(sym.INICIO,yytext()); 
            }



"FIN"    {      System.out.println(yytext() + " es una FIN - Linea: " + yyline + " - Columna: " + yycolumn); 
                return new Symbol(sym.FINSTMTS,yytext()); 
            }

"END"    {      System.out.println(yytext() + " es una END - Linea: " + yyline + " - Columna: " + yycolumn); 
                return new Symbol(sym.END,yytext()); 
            }



{length}      { System.out.println(yytext() + " es un Terminal - Linea: " + yyline + " - Columna: " + yycolumn);       
                return symbol(sym.length,yytext()); }


{ID}        {

            System.out.println(yytext() + " es un No Terminal - Linea: " + yyline + " - Columna: " + yycolumn);    
            return symbol(sym.ID,yytext());
            }
 

"CREATE"    {  
                System.out.println(yytext() + " es una create - Linea: " + yyline + " - Columna: " + yycolumn);     
                return new Symbol(sym.CREATE,yytext()); 
            }

"TABLE" {
                 System.out.println(yytext() + " es una table - Linea: " + yyline + " - Columna: " + yycolumn); 
                 return new Symbol(sym.TABLE,yytext()); 
        }


"CHAR"  {     System.out.println(yytext() + " es un CHAR - Linea: " + yyline + " - Columna: " + yycolumn); 
              return new Symbol(sym.CHAR,yytext()); 
        }

"TIME"  {   
            System.out.println(yytext() + " es un TIME - Linea: " + yyline + " - Columna: " + yycolumn); 
            return new Symbol(sym.TIME,yytext()); 
        }


"DATE"  {   
            System.out.println(yytext() + " es un DATE - Linea: " + yyline + " - Columna: " + yycolumn); 
            return new Symbol(sym.DATE,yytext()); 
        }


"NOT_NULL" { System.out.println(yytext() + " es un NOT_NULL - Linea: " + yyline + " - Columna: " + yycolumn);
             return new Symbol(sym.NOT_NULL,yytext()); }

"PRIMARY_KEY" {             
                System.out.println(yytext() + " es un PRIMARY_KEY - Linea: " + yyline + " - Columna: " + yycolumn); 
                return new Symbol(sym.PRIMARY_KEY,yytext()); }


"AUTO_INCREMENT" { System.out.println(yytext() + " es un AUTO_INCREMENT - Linea: " + yyline + " - Columna: " + yycolumn);
                 return new Symbol(sym.AUTO_INCREMENT,yytext()); }


"VARCHAR" { 
            System.out.println(yytext() + " es un VARCHAR - Linea: " + yyline + " - Columna: " + yycolumn);
            return new Symbol(sym.VARCHAR,yytext()); }

"INT" { System.out.println(yytext() + " es un INT - Linea: " + yyline + " - Columna: " + yycolumn); 
        return new Symbol(sym.INT,yytext()); }


"Foreign" {System.out.println(yytext() + " es un Foreign - Linea: " + yyline + " - Columna: " + yycolumn); 
            return new Symbol(sym.Foreign,yytext()); }

"Key"   { 
        System.out.println(yytext() + " es un key - Linea: " + yyline + " - Columna: " + yycolumn);     
        return new Symbol(sym.Key,yytext()); 
        }

"References" {             
                System.out.println(yytext() + " es un References - Linea: " + yyline + " - Columna: " + yycolumn); 
                return new Symbol(sym.References,yytext()); 
            }


 "(" { System.out.println(yytext() + " es un Parentesis - Linea: " + yyline + " - Columna: " + yycolumn); 
        return new Symbol(sym.PARI,yytext()); }

")" { System.out.println(yytext() + " es un Parentesis - Linea: " + yyline + " - Columna: " + yycolumn); 
      return new Symbol(sym.PARD,yytext()); }


";" {    
        System.out.println(yytext() + " es un punto y coma - Linea: " + yyline + " - Columna: " + yycolumn);
        return new Symbol(sym.FIN,yytext());    
    }

 "," { System.out.println(yytext() + " es un coma - Linea: " + yyline + " - Columna: " + yycolumn); 
       return new Symbol(sym.COMA,yytext()); }
[ \t\r\n\f]     {  }
. {System.out.println( yytext() + " NO SE RECONOCE COMO CARACTER VALIDO - Linea: " + yyline + " - Columna: " + yycolumn);}