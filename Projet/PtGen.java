/*********************************************************************************
 *       VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex.java               *
 *       complément à l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compilé, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valNb = valeur du dernier nombre entier lu (item nbentier)    *
 *     int UtilLex.numId = code du dernier identificateur lu (item ident)        *
 *                                                                               *
 *                                                                               *
 *   méthodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arrêt compilation       *
 *     String UtilLex.repId(int nId) délivre l'ident de codage nId               *
 *     
 *********************************************************************************     
 *     METHODES FOURNIES PAR LA CLASSE PtGen.java                                *
 *     constGen() et constObj()  fournissent les deux fichiers objets            *  
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/

// NB: Merci de renseigner la variable (String) trinome, définie plus loin

import java.io.*;

public class PtGen {

  // constantes manipulées par le compilateur
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

            // catégories possibles :
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
      UtilLex.messErr("débordement de la table des symboles");
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
        System.out.println(" référence NULL");
      else
        System.out.println(" " + tabSymb[i]);
    }
    System.out.println();
  }

  // contrôle de type
  // ----------------

  private static void verifEnt() {
    if (tCour != ENT)
      UtilLex.messErr("expression entière attendue");
  }

  private static void verifBool() {
    if (tCour != BOOL)
      UtilLex.messErr("expression booléenne attendue");
  }

  // pile pour gérer les chaînes de reprise et les branchements en avant
  // -------------------------------------------------------------------

  private static class TpileRep { // chaines de reprise itérations,
    // conditionnelles
    private final int MAXPILEREP = 50;
    private int ip;
    private int[] T = new int[MAXPILEREP + 1];

    public void empiler(int x) {
      if (ip == MAXPILEREP)
        UtilLex.messErr("débordement de la pile de gestion des reprises");
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

    public String toString() {
      String res = "{";
      for (int i=1; i<ip; i++) {
        res += i+", ";
      }
      res += "}";
      return res;
    }
  } // TpileRep

  private static TpileRep pileRep = new TpileRep();; // chaines de reprise
  // itérations,
  // conditionnelles

  // production du code objet en mémoire, dans le tableau po
  // -------------------------------------------------------

  private static int[] po = new int[MAXOBJ + 1];
  private static int ipo;

  private static void produire(int codeouarg) {
    if (ipo == MAXOBJ)
      UtilLex.messErr("débordement : programme objet trop long");
    ipo = ipo + 1;
    po[ipo] = codeouarg;
  }

  // construction du fichier objet sous forme mnémonique
  // ---------------------------------------------------
  private static void constGen() {
    Mnemo.creerFichier(ipo, po, UtilLex.nomSource + ".gen"); // recopie de
    // po sous
    // forme
    // mnémonique
  }

  // construction du fichier objet pour MAPILE
  // -----------------------------------------
  private static void constObj() {
    OutputStream f = Ecriture.ouvrir(UtilLex.nomSource + ".obj");
    if (f == null) {
      System.out.println("impossible de créer " + UtilLex.nomSource
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

  // autres variables et procédures fournies
  // ---------------------------------------
  public static String trinome = "Matthieu Leportier Antoine Pinsard Pierre-Yves Guillamo";

  private static int tCour; // type de l'expression compilée
  private static int vCour; // valeur de l'expression compilée le cas echeant


  // compilation séparée : vecteur de translation et descripteur
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

  // initialisations à compléter
  // -----------------------------

  private static void initialisations() { // à compléter si nécessaire mais NE
    // RIEN SUPPRIMER
    initvTrans();
    desc = new Descripteur(); // initialisation du descripteur pour
    // compilation séparée
    it = 0;
    bc = 1;
    ipo = 0;
    tCour = NEUTRE;
    varCounter = 0;
    desc.tailleGlobaux = 0;
  } // initialisations

  // autres variables et procédures introduites par le trinome

  private static int idCour; // Stocke le dernier identifiant rencontré
  private static int catCour; // categorie de l'expression compilée
  private static int varCounter;
  private static int identCour;

  private static int addr_bsifaux;
  private static int addr_bincond;
  private static int addr_debut;
  private static int tmpAddr;

  private static int labelMain;
  private static String nomFichier;

  private static int superParamCounter;

  private static void affvTrans() {
    System.out.print("Vecteurs de translation :\n\t");
    for (int i=1; i <= ipo; i++) {
      if (vTrans[i] != -1) {
        System.out.print("("+ i +","+ vTrans[i] +")");
      }
    }
    System.out.print("\n");
  }

  // code des points de génération à compléter
  // -----------------------------------------
  public static void pt(int numGen) {
    int cat, i;
    switch (numGen) {
      case 255:
        afftabSymb(); constGen(); constObj();
        desc.tailleCode = ipo;
        System.out.println("Pile de reprise : "+ pileRep);
        System.out.println("\nDescripteur :\n");
        System.out.println(desc.toString());
        affvTrans();
        break;
      case 254:
        desc.ecrireDesc("ww/" + nomFichier);
        produire(ARRET);
        break;
      case 253:
        desc.unite = "programme";
        nomFichier = UtilLex.repId(UtilLex.numId);
        break;
      case 252:
        desc.unite = "module";
        break;
      case 251:
        for (int j = 1; j <= desc.nbDef; j++) {
          for (int k = bc; k <= it; k++) {
            if (tabSymb[k].categorie != PROC)
              continue;
            if (desc.tabDef[j].nomProc.equals(UtilLex.repId(tabSymb[k].code))) {
              desc.tabDef[j].adPo = tabSymb[k].info;
              desc.tabDef[j].nbParam = tabSymb[k+1].info;
              break;
            }
          }
          if (desc.tabDef[j].adPo == -1) {
            UtilLex.messErr("Undefined procedure "+ desc.tabDef[j].nomProc);
          }
        }
        break;
      case 0:
        initialisations();
        break;

      // Traitement des déclarations
      case 1:
        if (presentIdent(bc) != 0) {
          UtilLex.messErr("Identifiant déjà défini : \""+ UtilLex.repId(UtilLex.numId) +"\"");
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
        if (bc == 1) {
            placeIdent(UtilLex.numId, VARGLOBALE, tCour, varCounter);
            desc.tailleGlobaux++;
        }
        else
            placeIdent(UtilLex.numId, VARLOCALE, tCour, varCounter);
        varCounter++;
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
      case 35:
        produire(MUL);
        break;
      case 36:
        produire(DIV);
        break;
      case 25:
        i = presentIdent(bc);
        if (i == 0 && bc != 1)
          i = presentIdent(1);
        if (i == 0)
          UtilLex.messErr("identificateur \""+ UtilLex.repId(UtilLex.numId) +"\" non déclaré");
        tCour = tabSymb[i].type;
        switch (tabSymb[i].categorie) {
          case CONSTANTE:
            produire(EMPILER);
            produire(tabSymb[i].info);
            break;
          case VARGLOBALE:
            produire(CONTENUG);
            produire(tabSymb[i].info);
            vecteurTrans(Descripteur.TRANSDON);
            break;
          case VARLOCALE:
          case PARAMFIXE:
            produire(CONTENUL);
            produire(tabSymb[i].info);
            produire(0);
            break;
          case PARAMMOD:
            produire(CONTENUL);
            produire(tabSymb[i].info);
            produire(1);
            break;
          default:
            UtilLex.messErr("Catégorie \""+ tabSymb[i].categorie + "\" invalide");
        }
        break;
      case 26:
        produire(EMPILER);
        produire(vCour);
        break;

      case 40:
        i = presentIdent(bc);
        if (i == 0 && bc != 1)
          i = presentIdent(1);
        if (i == 0)
          UtilLex.messErr("identificateur \""+ UtilLex.repId(UtilLex.numId) +"\" non déclaré");
        identCour = i;
        if (tabSymb[identCour].categorie == CONSTANTE)
          UtilLex.messErr("Contexte inaproprié à une valeur constante");
        break;
      case 41:
        switch (tabSymb[identCour].type) {
          case BOOL:
            verifBool();
            break;
          case ENT:
            verifEnt();
            break;
        }
        switch (tabSymb[identCour].categorie) {
          case VARGLOBALE:
            produire(AFFECTERG);
            produire(tabSymb[identCour].info);
            vecteurTrans(Descripteur.TRANSDON);
            break;
          case PARAMMOD:
            produire(AFFECTERL);
            produire(tabSymb[identCour].info);
            produire(1);
            break;
          case VARLOCALE:
            produire(AFFECTERL);
            produire(tabSymb[identCour].info);
            produire(0);
            break;
          default:
            UtilLex.messErr("Catégorie \""+ tabSymb[identCour].categorie + "\" invalide pour affectation");
        }
        break;
      case 42:
        if (desc.unite.equals("programme")) {
          produire(RESERVER);
          if (bc != 1) {
            varCounter -= tabSymb[bc-1].info + 2;
          }
          produire(varCounter);
        }
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
        i = presentIdent(bc);
        if (i == 0 && bc != 1)
          i = presentIdent(1);
        if (i == 0)
          UtilLex.messErr("identificateur \""+ UtilLex.repId(UtilLex.numId) +"\" non déclaré");
        switch (tabSymb[i].type) {
          case BOOL:
            produire(LIREBOOL);
            break;
          case ENT:
            produire(LIRENT);
            break;
        }
        switch (tabSymb[i].categorie) {
          case VARGLOBALE:
            produire(AFFECTERG);
            produire(tabSymb[i].info);
            break;
          case PARAMMOD:
            produire(AFFECTERL);
            produire(tabSymb[i].info);
            produire(1);
            break;
          case VARLOCALE:
            produire(AFFECTERL);
            produire(tabSymb[i].info);
            produire(0);
            break;
          default:
            UtilLex.messErr("Catégorie \""+ tabSymb[i].categorie + "\" invalide pour affectation");
        }
        break;

      // Traitement si/ttq/cond
      case 50:
        verifBool();
        produire(BSIFAUX);
        produire(0);
        vecteurTrans(Descripteur.TRANSCODE);
        pileRep.empiler(ipo);
        break;

      // Traitement du si
      case 51:
        produire(BINCOND);
        produire(0);
        vecteurTrans(Descripteur.TRANSCODE);
        po[pileRep.depiler()] = ipo+1;
        pileRep.empiler(ipo);
        break;
      case 52:
        po[pileRep.depiler()] = ipo+1;
        break;

      // Traitement du ttq
      case 53:
        pileRep.empiler(ipo+1);
        break;
      case 54:
        addr_bsifaux = pileRep.depiler();
        addr_debut = pileRep.depiler();
        produire(BINCOND);
        produire(addr_debut);
        vecteurTrans(Descripteur.TRANSCODE);
        po[addr_bsifaux] = ipo+1;
        break;

      // Traitement du cond
      case 55:
        pileRep.empiler(0);
        break;
      case 56:
        addr_bsifaux = pileRep.depiler();
        addr_bincond = pileRep.depiler();
        produire(BINCOND);
        produire(addr_bincond);
        vecteurTrans(Descripteur.TRANSCODE);
        pileRep.empiler(ipo);
        po[addr_bsifaux] = ipo+1;
        break;
      case 57:
        addr_bsifaux = pileRep.depiler();
        produire(BINCOND);
        produire(0);
        vecteurTrans(Descripteur.TRANSCODE);
        pileRep.empiler(ipo);
        po[addr_bsifaux] = ipo+1;
        break;
      case 58:
        po[pileRep.depiler()] = ipo+1;
        addr_bincond = pileRep.depiler();
        while (addr_bincond != 0) {
          tmpAddr = po[addr_bincond];
          po[addr_bincond] = ipo+1;
          addr_bincond = tmpAddr;
        }
        break;

      // Traitement des procédures

      case 100:
        if (desc.unite.equals("programme")) {
          produire(BINCOND);
          produire(0);
          labelMain = ipo;
        }
        break;
      case 101:
        if (desc.unite.equals("programme")) {
          po[labelMain] = ipo+1;
        }
        break;
      case 102:
        if (presentIdent(bc) != 0) {
          UtilLex.messErr("Identifiant déjà défini : \""+ UtilLex.repId(UtilLex.numId) +"\"");
        }
        placeIdent(UtilLex.numId, PROC, NEUTRE, ipo+1);
        placeIdent(-1, PRIVEE, NEUTRE, 0);
        bc = it+1;
        break;
      case 103:
        if (presentIdent(bc) != 0) {
          UtilLex.messErr("Identifiant déjà défini : \""+ UtilLex.repId(UtilLex.numId) +"\"");
        }
        placeIdent(UtilLex.numId, PARAMFIXE, tCour, tabSymb[bc-1].info);
        tabSymb[bc-1].info++;
        break;
      case 104:
        if (presentIdent(bc) != 0) {
          UtilLex.messErr("Identifiant déjà défini : \""+ UtilLex.repId(UtilLex.numId) +"\"");
        }
        placeIdent(UtilLex.numId, PARAMMOD, tCour, tabSymb[bc-1].info);
        tabSymb[bc-1].info++;
        break;
      case 105:
        produire(RETOUR);
        produire(tabSymb[bc-1].info);
        for (i = 0; i < tabSymb[bc-1].info; i++) {
          tabSymb[bc+i].code = -1;
        }
        it = bc+i-1;
        bc = 1;
        break;
      case 106:
        varCounter = tabSymb[bc-1].info + 2;
        break;
      case 107:
        if (tabSymb[identCour].categorie != PROC &&
            tabSymb[identCour].categorie != REF)
        {
          afftabSymb();
          System.out.println(identCour);
          UtilLex.messErr("Procédure attendue");
        }
        produire(APPEL);
        produire(tabSymb[identCour].info);
        if (tabSymb[identCour].categorie == REF) {
          vecteurTrans(Descripteur.REFEXT);
          produire(desc.tabRef[tabSymb[identCour].info].nbParam);
        }
        else {
          produire(tabSymb[identCour+1].info);
        }
        break;
      case 108:
        i = presentIdent(bc);
        if (i == 0 && bc != 1)
          i = presentIdent(1);
        if (i == 0)
          UtilLex.messErr("identificateur \""+ UtilLex.repId(UtilLex.numId) +"\" non déclaré");
        switch (tabSymb[identCour+superParamCounter+2].type) {
          case ENT:
            verifEnt();
            break;
          case BOOL:
            verifBool();
            break;
          default:
            UtilLex.messErr("Type invalide");
        }
        if (tabSymb[identCour+superParamCounter+2].categorie != PARAMMOD) {
          UtilLex.messErr("Catégorie incorrect");
        }
        switch (tabSymb[i].categorie) {
          case VARGLOBALE:
            produire(EMPILERADG);
            produire(tabSymb[i].info);
            break;
          case VARLOCALE:
            produire(EMPILERADL);
            produire(tabSymb[i].info);
            produire(0);
            break;
          case PARAMMOD:
            produire(EMPILERADL);
            produire(tabSymb[i].info);
            produire(1);
            break;
          default:
            UtilLex.messErr("Catégorie invalide : "+tabSymb[i].categorie);
        }
        superParamCounter++;
        break;

      // Compilation séparée
      case 120:
        if (presentIdent(bc) != 0) {
          UtilLex.messErr("Identifiant déjà défini : \""+ UtilLex.repId(UtilLex.numId) +"\"");
        }
        desc.nbRef++;
        desc.tabRef[desc.nbRef] = new EltRef(UtilLex.repId(UtilLex.numId), 0);
        placeIdent(UtilLex.numId, REF, NEUTRE, desc.nbRef);
        placeIdent(-1, PRIVEE, NEUTRE, 0);
        break;
      case 121:
        placeIdent(-1, PARAMFIXE, tCour, desc.tabRef[desc.nbRef].nbParam);
        tabSymb[it-desc.tabRef[desc.nbRef].nbParam-1].info++;
        desc.tabRef[desc.nbRef].nbParam++;
        break;
      case 122:
        placeIdent(-1, PARAMMOD, tCour, desc.tabRef[desc.nbRef].nbParam);
        tabSymb[it-desc.tabRef[desc.nbRef].nbParam-1].info++;
        desc.tabRef[desc.nbRef].nbParam++;
        break;
      case 130:
        // Vérification si l'identificateur n'est pas déjà définit
        for (i = 1; i < desc.nbDef+1; i++) {
          if (desc.tabDef[i].nomProc.equals(UtilLex.repId(UtilLex.numId))) {
            UtilLex.messErr("Identificateur déjà définit");
          }
        }
        desc.nbDef++;
        desc.tabDef[desc.nbDef] = new EltDef(UtilLex.repId(UtilLex.numId), 0, 0);
        break;
      case 139:
        superParamCounter = 0;
        break;
      case 140:
        switch (tabSymb[identCour+superParamCounter+2].type) {
          case ENT:
            verifEnt();
            break;
          case BOOL:
            verifBool();
            break;
          default:
            UtilLex.messErr("Type invalide");
        }
        if (tabSymb[identCour+superParamCounter+2].categorie != PARAMFIXE) {
          UtilLex.messErr("Catégorie incorrect");
        }
        superParamCounter++;
        break;
      default:
        System.out.println("Point de génération non prévu dans votre liste");
        break;

    }
  }
}
