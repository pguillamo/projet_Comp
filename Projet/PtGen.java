/*********************************************************************************
 *       VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex.java               *
 *       compl�ment � l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compil�, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valNb = valeur du dernier nombre entier lu (item nbentier)    *
 *     int UtilLex.numId = code du dernier identificateur lu (item ident)        *
 *                                                                               *
 *                                                                               *
 *   m�thodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arr�t compilation       *
 *     String UtilLex.repId(int nId) d�livre l'ident de codage nId               *
 *     
 *********************************************************************************     
 *     METHODES FOURNIES PAR LA CLASSE PtGen.java                                *
 *     constGen() et constObj()  fournissent les deux fichiers objets            *  
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/

// NB: Merci de renseigner la variable (String) trinome, d�finie plus loin

import java.io.*;

public class PtGen {

  // constantes manipul�es par le compilateur
  // ----------------------------------------

  private static final int

    MAXSYMB = 300,
            MAXOBJ = 1000,

            // codes MAPILE :
            RESERVER = 1, EMPILER = 2, CONTENUG = 3, AFFECTERG = 4, OU = 5,
            ET = 6, NON = 7, INF = 8, INFEG = 9, SUP = 10, SUPEG = 11, EG = 12,
            DIFF = 13, ADD = 14, SOUS = 15, MUL = 16, DIV = 17, BSIFAUX = 18,
            BINCOND = 19, LIRENT = 20, LIREBOOL = 21, ECRENT = 22,
            ECRBOOL = 23, ARRET = 24, EMPILERADG = 25, EMPILERADL = 26,
            CONTENUL = 27, AFFECTERL = 28, APPEL = 29, RETOUR = 30,

            // types permis :
            ENT = 1, BOOL = 2, NEUTRE = 3,

            // cat�gories possibles :
            CONSTANTE = 1, VARGLOBALE = 2, VARLOCALE = 3, PARAMFIXE = 4,
            PARAMMOD = 5, PROC = 6, DEF = 7, REF = 8, PRIVEE = 9;

  // table des symboles
  // ------------------

  private static class EltTabSymb {
    public int code, categorie, type, info;

    public EltTabSymb() {
    }

    public EltTabSymb(int code, int categorie, int type, int info) {
      this.code = code;
      this.categorie = categorie;
      this.type = type;
      this.info = info;
    }

    public String toString() {
      final String[] chcat = { "", "CONSTANTE      ", "VARGLOBALE     ",
        "VARLOCALE      ", "PARAMFIXE      ", "PARAMMOD       ",
        "PROC           ", "DEF            ", "REF            ",
        "PRIVEE         " };
      final String[] chtype = { "", "ENT     ", "BOOL    ", "NEUTRE  " };
      String ch = "";
      if (code == -1)
        ch += "-1";
      else
        ch += "@" + UtilLex.repId(code);
      while (ch.length() < 15)
        ch += ' ';
      return ch + chcat[categorie] + chtype[type] + info;
    } // toString
  } // EltTabSymb

  private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];
  private static int it, bc;

  private static int presentIdent(int binf) {
    int i = it;
    while (i >= binf && tabSymb[i].code != UtilLex.numId)
      i--;
    if (i >= binf)
      return i;
    else
      return 0;
  }

  private static void placeIdent(int c, int cat, int t, int v) {
    if (it == MAXSYMB)
      UtilLex.messErr("d�bordement de la table des symboles");
    it = it + 1;
    tabSymb[it] = new EltTabSymb(c, cat, t, v);
  }

  private static void afftabSymb() { // affiche la table des symboles
    System.out.println("       code           categorie      type    info");
    System.out.println("      |--------------|--------------|-------|----");
    for (int i = 1; i <= it; i++) {
      if (i == bc) {
        System.out.print("bc=");
        Ecriture.ecrireInt(i, 3);
      } else if (i == it) {
        System.out.print("it=");
        Ecriture.ecrireInt(i, 3);
      } else
        Ecriture.ecrireInt(i, 6);
      if (tabSymb[i] == null)
        System.out.println(" r�f�rence NULL");
      else
        System.out.println(" " + tabSymb[i]);
    }
    System.out.println();
  }

  // contr�le de type
  // ----------------

  private static void verifEnt() {
    if (tCour != ENT)
      UtilLex.messErr("expression enti�re attendue");
  }

  private static void verifBool() {
    if (tCour != BOOL)
      UtilLex.messErr("expression bool�enne attendue");
  }

  // pile pour g�rer les cha�nes de reprise et les branchements en avant
  // -------------------------------------------------------------------

  private static class TpileRep { // chaines de reprise it�rations,
    // conditionnelles
    private final int MAXPILEREP = 50;
    private int ip;
    private int[] T = new int[MAXPILEREP + 1];

    public void empiler(int x) {
      if (ip == MAXPILEREP)
        UtilLex.messErr("d�bordement de la pile de gestion des reprises");
      ip = ip + 1;
      T[ip] = x;
    }

    public int depiler() {
      if (ip == 0)
        UtilLex.messErr("compilateur en croix sur chaine de reprise ");
      ip = ip - 1;
      return T[ip + 1];
    }

    public TpileRep() {
      ip = 0;
    }
  } // TpileRep

  private static TpileRep pileRep = new TpileRep();; // chaines de reprise
  // it�rations,
  // conditionnelles

  // production du code objet en m�moire, dans le tableau po
  // -------------------------------------------------------

  private static int[] po = new int[MAXOBJ + 1];
  private static int ipo;

  private static void produire(int codeouarg) {
    if (ipo == MAXOBJ)
      UtilLex.messErr("d�bordement : programme objet trop long");
    ipo = ipo + 1;
    po[ipo] = codeouarg;
  }

  // construction du fichier objet sous forme mn�monique
  // ---------------------------------------------------
  private static void constGen() {
    Mnemo.creerFichier(ipo, po, UtilLex.nomSource + ".gen"); // recopie de
    // po sous
    // forme
    // mn�monique
  }

  // construction du fichier objet pour MAPILE
  // -----------------------------------------
  private static void constObj() {
    OutputStream f = Ecriture.ouvrir(UtilLex.nomSource + ".obj");
    if (f == null) {
      System.out.println("impossible de cr�er " + UtilLex.nomSource
          + ".obj");
      System.exit(1);
    }
    for (int i = 1; i <= ipo; i++)
      if (vTrans[i] != -1)
        Ecriture.ecrireStringln(f, i + "   " + vTrans[i]);
    for (int i = 1; i <= ipo; i++)
      Ecriture.ecrireStringln(f, "" + po[i]);
    Ecriture.fermer(f);
  }

  // autres variables et proc�dures fournies
  // ---------------------------------------
  public static String trinome = "Matthieu Leportier, Antoine Pinsard, Pierre-Yves Guillamo";

  private static int tCour; // type de l'expression compil�e
  private static int vCour; // valeur de l'expression compil�e le cas echeant


  // compilation s�par�e : vecteur de translation et descripteur
  // -----------------------------------------------------------

  private static int[] vTrans = new int[MAXOBJ + 1];

  private static void initvTrans() {
    for (int i = 1; i <= MAXOBJ; i++)
      vTrans[i] = -1;
  }

  private static Descripteur desc;

  private static void vecteurTrans(int x) { // ajout d'un doublet au vecteur
    // de translation
    if (x == Descripteur.REFEXT || desc.unite.equals("module")) {
      vTrans[ipo] = x;
      desc.nbTransExt++;
    }
  } // descripteur

  // initialisations � compl�ter
  // -----------------------------

  private static void initialisations() { // � compl�ter si n�cessaire mais NE
    // RIEN SUPPRIMER
    initvTrans();
    desc = new Descripteur(); // initialisation du descripteur pour
    // compilation s�par�e
    it = 0;
    bc = 1;
    ipo = 0;
    tCour = NEUTRE;
    nbVarGlobales = 0;
  } // initialisations

  // autres variables et proc�dures introduites par le trinome

  private static int idCour; // Stocke le dernier identifiant rencontr�
  private static int catCour; // categorie de l'expression compil�e
  private static int nbVarGlobales;
  private static EltTabSymb symbCour;

  // code des points de g�n�ration � compl�ter
  // -----------------------------------------
  public static void pt(int numGen) {
    int cat, i;
    switch (numGen) {
      case 255:
        afftabSymb(); constGen(); constObj();
        break;
      case 0:
        initialisations();
        break;

      // Traitement des d�clarations
      case 1:
        if (presentIdent(1) != 0) {
          UtilLex.messErr("Identifiant d�j� d�fini : \""+ UtilLex.repId(UtilLex.numId) +"\"");
        }
        break;
      case 2:
        tCour = ENT;
        vCour = UtilLex.valNb;
        break;
      case 3:
        tCour = ENT;
        vCour = -UtilLex.valNb;
        break;
      case 4:
        tCour = BOOL;
        vCour = 1;
        break;
      case 5:
        tCour = BOOL;
        vCour = 0;
        break;
      case 8:
        tCour = ENT;
        break;
      case 9:
        tCour = BOOL;
        break;
      case 10:
        placeIdent(UtilLex.numId, CONSTANTE, tCour, vCour);
        break;
      case 11:
        placeIdent(UtilLex.numId, VARGLOBALE, tCour, nbVarGlobales);
        nbVarGlobales++;
        break;

      // Traitement des expressions
      case 20:
        verifBool();
        break;
      case 22:
        verifEnt();
        break;
      case 21:
        produire(ET);
        break;
      case 27:
        produire(OU);
        break;
      case 28:
        produire(NON);
        break;
      case 23:
        tCour = BOOL;
        produire(EG);
        break;
      case 29:
        tCour = BOOL;
        produire(DIFF);
        break;
      case 30:
        tCour = BOOL;
        produire(SUP);
        break;
      case 31:
        tCour = BOOL;
        produire(SUPEG);
        break;
      case 32:
        tCour = BOOL;
        produire(INF);
        break;
      case 33:
        tCour = BOOL;
        produire(INFEG);
        break;
      case 24:
        produire(ADD);
        break;
      case 34:
        produire(SOUS);
        break;
      case 25:
        i = presentIdent(1);
        if (i == 0)
          UtilLex.messErr("identificateur \""+ UtilLex.repId(UtilLex.numId) +"\" non d�clar�");
        tCour = tabSymb[i].type;
        switch (tabSymb[i].categorie) {
          case CONSTANTE:
            produire(EMPILER);
            produire(tabSymb[i].info);
            break;
          case VARGLOBALE:
            produire(CONTENUG);
            produire(tabSymb[i].info);
            break;
        }
        break;
      case 26:
        produire(EMPILER);
        produire(vCour);
        break;

      case 40:
        i = presentIdent(1);
        if (i == 0)
          UtilLex.messErr("identificateur \""+ UtilLex.repId(UtilLex.numId) +"\" non d�clar�");
        symbCour = tabSymb[i];
        break;
      case 41:
        switch (symbCour.type) {
          case BOOL:
            verifBool();
            break;
          case ENT:
            verifEnt();
            break;
        }
        break;
      case 42:
        produire(RESERVER);
        produire(nbVarGlobales);
        break;
      case 43:
        switch (tCour) {
          case BOOL:
            produire(ECRBOOL);
            break;
          case ENT:
            produire(ECRENT);
            break;
        }
        break;
      case 44:
        switch (tCour) {
          case BOOL:
            produire(LIREBOOL);
            break;
          case ENT:
            produire(LIRENT);
            break;
        }
        break;

      // Traitement du si ==> corrig� avec la prof
      case 50:		
        verifBool();
        produire(BSIFAUX);
        produire(0);
        pileRep.empiler(ipo);
        break;
        
      case 51:
        produire(BINCOND);
        produire(0);
        po[pileRep.depiler()] = ipo+1;
        pileRep.empiler(ipo);
        break;
      case 52:
        po[pileRep.depiler()] = ipo+1;
        break;

      // Traitement du ttq
    	  
      case 53:
        int addr_bsifaux = pileRep.depiler();
    	int addr_debut = pileRep.depiler();
    	produire(BINCOND);
    	produire(addr_debut);
    	po[addr_bsifaux] = ipo+1;
    	break;
    	
      // Traitement du cond

      // etc

      default:
        System.out.println("Point de g�n�ration non pr�vu dans votre liste");
        break;

    }
  }
}
