/******************************************************************************************************
 *    projet.java    pour AntLR version 3                                                             *
 *    programme fourni aux �tudiants QUI NE DOIVENT PAS LE MODIFIER                                   *
 *    ce programme contient le main qui demande le nom du programme source que l'on souhaite compiler,*
 *    et lance sa compilation � partir de l'axiome "unite" de la grammaire projet.g                   *     
 *    on peut compiler plusieurs programmes source de suite (arr�t par un retour-chariot)             *
 *    ANTLR suspend compl�tement le traitement les programmes sources de syntaxe erron�e si l'on met  *  
 *    la clause @rulecatch dans la grammaire                                                          *
 *    NB : ce module utilise des classes externes comme Lecture, UtilLex, ANTLRxxx                    *
 *****************************************************************************************************/



import java.io.*;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;


class projet {
	public static String nomSourceComplet; // nom du source � compiler, avec son suffixe .pro 
	
	private static void UneCompilation (String nomDuSource ) {
		try {
			ANTLRFileStream input = new ANTLRFileStream(nomDuSource);
			projetLexer lexer = new projetLexer(input);
			CommonTokenStream token_stream = new CommonTokenStream(lexer); // production d'un flot d'unit�s lexicales
			projetParser parser = new projetParser(token_stream);   
			PtGen.pt(0); // point de g�n�ration des initialisations
			// Compile le texte source en entr�e, l'axiome "unite" est precis�
			parser.unite();

		 } catch (FileNotFoundException fnf) {
			System.out.println("exception: " + fnf); // cas o� le fichier source pr�cis� n'existe pas
		}
		catch (RecognitionException re) {
			System.err.println("Recognition exception: " + re); // erreur de nature syntaxique d�tect�e par le lexer ou le parser
			// System.err.println dirige ses impressions sur une autre sortie et les messages ont ici tendance � se m�langer
		}
		catch (IOException exc) {
			System.err.println("IO exception: " + exc);
		} 
		// try	
	
	} // UneCompilation
	
	
	public static void main(String [] args) {
		System.out.println("PROJET DE COMPILATION version : " + PtGen.trinome);
		System.out.println("----------------------------------------");
		System.out.println();
		
		do 
		 {
			// lecture du nom de fichier en entr�e, sans son suffixe
			System.out.println(); 
		    System.out.print("Donnez le nom du fichier que vous souhaitez compiler, sans suffixe :  (RC si termin�) ");
		    UtilLex.nomSource=Lecture.lireString();  // on fournit � UtilLex le nom sans suffixe
		    System.out.println();
		    
		    if (!UtilLex.nomSource.equals("")) {
		    	nomSourceComplet = UtilLex.nomSource+".pro";
		    	// traitement d'une compilation	 
		    	UneCompilation (nomSourceComplet);
		    } 
		    System.out.println();
		}
		while (!UtilLex.nomSource.equals("")); 	
		System.out.println("\n \n Merci pour votre patience, " + PtGen.trinome + ", et � bient�t !!!");	
	} // main
} // projet