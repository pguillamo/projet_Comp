// Grammaire du langage PROJET
// COMP L3  
// Anne Grazon, Véronique Masson
// il convient d'y insérer les appels à {PtGen.pt(k);}
// relancer Antlr après chaque modification et raffraichir le projet Eclipse le cas échéant

// attention l'analyse est poursuivie après erreur si l'on supprime la clause rulecatch

grammar projet;

options {
  language=Java; k=1;
}

@header {           
  import java.io.IOException;
  import java.io.DataInputStream;
  import java.io.FileInputStream;
} 


// partie syntaxique :  description de la grammaire //
// les non-terminaux doivent commencer par une minuscule


@members {


  // variables globales et méthodes utiles à placer ici

}
// la directive rulecatch permet d'interrompre l'analyse à la première erreur de syntaxe
@rulecatch {
  catch (RecognitionException e) {reportError (e) ; throw e ; }}

unite:
    unitprog {PtGen.pt(255);} EOF
  | unitmodule  EOF
;

unitprog:
    'programme' ident ':'
        declarations
        corps
        { PtGen.pt(254); System.out.println("succès, arret de la compilation "); }
;

unitmodule:
    'module' ident ':'
        declarations
;

declarations:
    partiedef?
    partieref?
    consts?
    vars?
    decprocs? 
;

partiedef:
    'def' ident  (',' ident )* ptvg
;

partieref:
    'ref'  specif (',' specif)* ptvg
;

specif:
    ident ( 'fixe' '(' type  ( ',' type  )* ')' )?
          ( 'mod'  '(' type  ( ',' type  )* ')' )? 
;

consts:
    'const' ( ident {PtGen.pt(1);} '=' valeur {PtGen.pt(10);}  ptvg  )+ 
;

vars:
    'var' ( type ident {PtGen.pt(1);} {PtGen.pt(11);}
          ( ','  ident {PtGen.pt(1);} {PtGen.pt(11);} )* ptvg )+
          {PtGen.pt(42);}
;

type:
    'ent'  {PtGen.pt(8);}
  | 'bool' {PtGen.pt(9);}
;

decprocs:
    {PtGen.pt(100);} (decproc ptvg)+ {PtGen.pt(101);}
;

decproc:
    'proc' ident {PtGen.pt(102);} parfixe? parmod?
        consts?
        vars?
        corps {PtGen.pt(105);}
;

ptvg:
    ';'
  | 
;

corps:
    'debut' instructions 'fin'
;

parfixe:
    'fixe' '(' pf ( ';' pf)* ')'
;

pf:
    type ident {PtGen.pt(103);} ( ',' ident {PtGen.pt(103);} )*
;

parmod:
    'mod' '(' pm ( ';' pm)* ')'
;

pm:
    type ident {PtGen.pt(103);} ( ',' ident {PtGen.pt(103);} )*
;

instructions:
    instruction ( ';' instruction )*
;

instruction:
    inssi
  | inscond
  | boucle
  | lecture
  | ecriture
  | affouappel
  |
;

inssi:
    'si' expression {PtGen.pt(50);} 
        'alors'  instructions
        ( {PtGen.pt(51);} 'sinon' instructions)?
        'fsi' {PtGen.pt(52);}

;

inscond:
    'cond' {PtGen.pt(55);}   expression {PtGen.pt(50);} ':' instructions 
        ({PtGen.pt(56);} ',' expression {PtGen.pt(50);} ':' instructions)* 
        ({PtGen.pt(57);} 'aut' instructions )?
        'fcond' {PtGen.pt(58);} 
;

boucle:
    'ttq' {PtGen.pt(53);} expression {PtGen.pt(50);} 'faire' instructions 'fait' {PtGen.pt(54);}

;

lecture:
    'lire' '(' ident {PtGen.pt(44);}
         ( ',' ident {PtGen.pt(44);}  )* ')' 
;

ecriture:
    'ecrire'  '(' expression {PtGen.pt(43);}
            ( ',' expression {PtGen.pt(43);} )* ')'
;

affouappel:
    ident {PtGen.pt(40);}
    (
        ':=' expression {PtGen.pt(41);} 
      | (effixes (effmods)?)?  
    )
;

effixes:
    '(' (expression  (',' expression  )*)? ')'
;

effmods:
    '(' (ident  (',' ident  )*)? ')'
; 

expression:
    (exp1) ('ou' {PtGen.pt(20);} exp1 {PtGen.pt(20);} {PtGen.pt(27);} )*
;

exp1:
    exp2   ('et' {PtGen.pt(20);} exp2 {PtGen.pt(20);} {PtGen.pt(21);} )*
;

exp2:
    'non' exp2 {PtGen.pt(20);} {PtGen.pt(28);}
  | exp3  
;

exp3:
    exp4 
    (
        '='  {PtGen.pt(22);} exp4 {PtGen.pt(22);} {PtGen.pt(23);}
      | '<>' {PtGen.pt(22);} exp4 {PtGen.pt(22);} {PtGen.pt(29);}
      | '>'  {PtGen.pt(22);} exp4 {PtGen.pt(22);} {PtGen.pt(30);}
      | '>=' {PtGen.pt(22);} exp4 {PtGen.pt(22);} {PtGen.pt(31);}
      | '<'  {PtGen.pt(22);} exp4 {PtGen.pt(22);} {PtGen.pt(32);}
      | '<=' {PtGen.pt(22);} exp4 {PtGen.pt(22);} {PtGen.pt(33);}
    )?
;

exp4:
    exp5
    (
        '+' {PtGen.pt(22);} exp5 {PtGen.pt(22);} {PtGen.pt(24);}
      | '-' {PtGen.pt(22);} exp5 {PtGen.pt(22);} {PtGen.pt(34);}
    )*
;

exp5:
    primaire 
    (
        '*' {PtGen.pt(22);} primaire {PtGen.pt(22);} {PtGen.pt(35);}
      | 'div' {PtGen.pt(22);} primaire {PtGen.pt(22);} {PtGen.pt(36);}
    )*
;

primaire:
    valeur {PtGen.pt(26);}
  | ident  {PtGen.pt(25);} 
  | '(' expression ')'
;

valeur:
    nbentier     {PtGen.pt(2);}
  | '+' nbentier {PtGen.pt(2);}
  | '-' nbentier {PtGen.pt(3);}
  | 'vrai'       {PtGen.pt(4);}
  | 'faux'       {PtGen.pt(5);}
;

// partie lexicale  : cette partie ne doit pas être modifiée  //
// les unités lexicales de ANTLR doivent commencer par une majuscule
// attention : ANTLR n'autorise pas certains traitements sur les unités lexicales, 
// il est alors nécessaire de passer par un non-terminal intermédiaire 
// exemple : pour l'unité lexicale INT, le non-terminal nbentier a dû être introduit


nbentier:
    INT {UtilLex.valNb = Integer.parseInt($INT.text);} // mise à jour de valNb
;

ident:
    ID {UtilLex.traiterId($ID.text, $ID.line);} // mise à jour de numId
;

// tous les identificateurs seront placés dans la table des identificateurs, y compris le nom du programme ou module
// la table des symboles n'est pas gérée au niveau lexical


ID: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; 

// zone purement lexicale //

INT: '0'..'9'+ ;
WS: (' '|'\t' | '\n' |'\r')+ {skip();} ; // définition des "espaces"


COMMENT:
    '\{' (.)* '\}' {skip();}   // toute suite de caractères entourée d'accolades est un commentaire
  |  '#' ~( '\r' | '\n' )* {skip();}  // tout ce qui suit un caractère dièse sur une ligne est un commentaire
;

// commentaires sur plusieurs lignes
ML_COMMENT:
    '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
;

