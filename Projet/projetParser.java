// $ANTLR 3.5 projet.g 2015-03-09 21:01:07
           
  import java.io.IOException;
  import java.io.DataInputStream;
  import java.io.FileInputStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "ML_COMMENT", 
		"WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int ML_COMMENT=7;
	public static final int WS=8;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "projet.g"; }




	  // variables globales et m�thodes utiles � placer ici




	// $ANTLR start "unite"
	// projet.g:36:1: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// projet.g:36:6: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==48) ) {
				alt1=1;
			}
			else if ( (LA1_0==44) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// projet.g:37:5: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite62);
					unitprog();
					state._fsp--;

					PtGen.pt(255);
					match(input,EOF,FOLLOW_EOF_in_unite66); 
					}
					break;
				case 2 :
					// projet.g:38:5: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite72);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite75); 
					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// projet.g:41:1: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// projet.g:41:9: ( 'programme' ident ':' declarations corps )
			// projet.g:42:5: 'programme' ident ':' declarations corps
			{
			match(input,48,FOLLOW_48_in_unitprog87); 
			pushFollow(FOLLOW_ident_in_unitprog89);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitprog91); 
			pushFollow(FOLLOW_declarations_in_unitprog101);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog111);
			corps();
			state._fsp--;

			 System.out.println("succ�s, arret de la compilation "); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// projet.g:48:1: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// projet.g:48:11: ( 'module' ident ':' declarations )
			// projet.g:49:5: 'module' ident ':' declarations
			{
			match(input,44,FOLLOW_44_in_unitmodule133); 
			pushFollow(FOLLOW_ident_in_unitmodule135);
			ident();
			state._fsp--;

			match(input,15,FOLLOW_15_in_unitmodule137); 
			pushFollow(FOLLOW_declarations_in_unitmodule147);
			declarations();
			state._fsp--;

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// projet.g:53:1: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// projet.g:53:13: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// projet.g:54:5: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// projet.g:54:5: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==30) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// projet.g:54:5: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations159);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// projet.g:55:5: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==49) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// projet.g:55:5: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations166);
					partieref();
					state._fsp--;

					}
					break;

			}

			// projet.g:56:5: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==28) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// projet.g:56:5: consts
					{
					pushFollow(FOLLOW_consts_in_declarations173);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:57:5: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==53) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// projet.g:57:5: vars
					{
					pushFollow(FOLLOW_vars_in_declarations180);
					vars();
					state._fsp--;

					}
					break;

			}

			// projet.g:58:5: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==47) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// projet.g:58:5: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations187);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// projet.g:61:1: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// projet.g:61:10: ( 'def' ident ( ',' ident )* ptvg )
			// projet.g:62:5: 'def' ident ( ',' ident )* ptvg
			{
			match(input,30,FOLLOW_30_in_partiedef201); 
			pushFollow(FOLLOW_ident_in_partiedef203);
			ident();
			state._fsp--;

			// projet.g:62:18: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==13) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// projet.g:62:19: ',' ident
					{
					match(input,13,FOLLOW_13_in_partiedef207); 
					pushFollow(FOLLOW_ident_in_partiedef209);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef214);
			ptvg();
			state._fsp--;

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// projet.g:65:1: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// projet.g:65:10: ( 'ref' specif ( ',' specif )* ptvg )
			// projet.g:66:5: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,49,FOLLOW_49_in_partieref226); 
			pushFollow(FOLLOW_specif_in_partieref229);
			specif();
			state._fsp--;

			// projet.g:66:19: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==13) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// projet.g:66:20: ',' specif
					{
					match(input,13,FOLLOW_13_in_partieref232); 
					pushFollow(FOLLOW_specif_in_partieref234);
					specif();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref238);
			ptvg();
			state._fsp--;

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// projet.g:69:1: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// projet.g:69:7: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// projet.g:70:5: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif250);
			ident();
			state._fsp--;

			// projet.g:70:11: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==40) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// projet.g:70:13: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,40,FOLLOW_40_in_specif254); 
					match(input,9,FOLLOW_9_in_specif256); 
					pushFollow(FOLLOW_type_in_specif258);
					type();
					state._fsp--;

					// projet.g:70:30: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==13) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// projet.g:70:32: ',' type
							{
							match(input,13,FOLLOW_13_in_specif263); 
							pushFollow(FOLLOW_type_in_specif265);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					match(input,10,FOLLOW_10_in_specif271); 
					}
					break;

			}

			// projet.g:71:11: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==43) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// projet.g:71:13: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,43,FOLLOW_43_in_specif288); 
					match(input,9,FOLLOW_9_in_specif291); 
					pushFollow(FOLLOW_type_in_specif293);
					type();
					state._fsp--;

					// projet.g:71:30: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==13) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// projet.g:71:32: ',' type
							{
							match(input,13,FOLLOW_13_in_specif298); 
							pushFollow(FOLLOW_type_in_specif300);
							type();
							state._fsp--;

							}
							break;

						default :
							break loop11;
						}
					}

					match(input,10,FOLLOW_10_in_specif306); 
					}
					break;

			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// projet.g:74:1: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// projet.g:74:7: ( 'const' ( ident '=' valeur ptvg )+ )
			// projet.g:75:5: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,28,FOLLOW_28_in_consts322); 
			// projet.g:75:13: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// projet.g:75:15: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts326);
					ident();
					state._fsp--;

					PtGen.pt(1);
					match(input,21,FOLLOW_21_in_consts330); 
					pushFollow(FOLLOW_valeur_in_consts332);
					valeur();
					state._fsp--;

					PtGen.pt(10);
					pushFollow(FOLLOW_ptvg_in_consts337);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// projet.g:78:1: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// projet.g:78:5: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// projet.g:79:5: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,53,FOLLOW_53_in_vars354); 
			// projet.g:79:11: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==26||LA15_0==33) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// projet.g:79:13: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars358);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars360);
					ident();
					state._fsp--;

					PtGen.pt(1);
					PtGen.pt(11);
					// projet.g:80:11: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==13) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// projet.g:80:13: ',' ident
							{
							match(input,13,FOLLOW_13_in_vars378); 
							pushFollow(FOLLOW_ident_in_vars381);
							ident();
							state._fsp--;

							PtGen.pt(1);
							PtGen.pt(11);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars390);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			PtGen.pt(42);
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// projet.g:84:1: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// projet.g:84:5: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==33) ) {
				alt16=1;
			}
			else if ( (LA16_0==26) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// projet.g:85:5: 'ent'
					{
					match(input,33,FOLLOW_33_in_type417); 
					PtGen.pt(8);
					}
					break;
				case 2 :
					// projet.g:86:5: 'bool'
					{
					match(input,26,FOLLOW_26_in_type426); 
					PtGen.pt(9);
					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// projet.g:89:1: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// projet.g:89:9: ( ( decproc ptvg )+ )
			// projet.g:90:5: ( decproc ptvg )+
			{
			// projet.g:90:5: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==47) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// projet.g:90:6: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs441);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs443);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// projet.g:93:1: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// projet.g:93:8: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// projet.g:94:5: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,47,FOLLOW_47_in_decproc457); 
			pushFollow(FOLLOW_ident_in_decproc460);
			ident();
			state._fsp--;

			// projet.g:94:20: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==40) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// projet.g:94:20: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc463);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// projet.g:94:29: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==43) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// projet.g:94:29: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc466);
					parmod();
					state._fsp--;

					}
					break;

			}

			// projet.g:95:9: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==28) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// projet.g:95:9: consts
					{
					pushFollow(FOLLOW_consts_in_decproc477);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:96:9: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==53) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// projet.g:96:9: vars
					{
					pushFollow(FOLLOW_vars_in_decproc488);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc499);
			corps();
			state._fsp--;

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// projet.g:100:1: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// projet.g:100:5: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==17) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==26||(LA22_0 >= 28 && LA22_0 <= 29)||LA22_0==33||LA22_0==47||LA22_0==49||LA22_0==53) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// projet.g:101:5: ';'
					{
					match(input,17,FOLLOW_17_in_ptvg512); 
					}
					break;
				case 2 :
					// projet.g:103:3: 
					{
					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// projet.g:105:1: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// projet.g:105:6: ( 'debut' instructions 'fin' )
			// projet.g:106:5: 'debut' instructions 'fin'
			{
			match(input,29,FOLLOW_29_in_corps529); 
			pushFollow(FOLLOW_instructions_in_corps531);
			instructions();
			state._fsp--;

			match(input,39,FOLLOW_39_in_corps533); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// projet.g:109:1: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// projet.g:109:8: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// projet.g:110:5: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,40,FOLLOW_40_in_parfixe545); 
			match(input,9,FOLLOW_9_in_parfixe547); 
			pushFollow(FOLLOW_pf_in_parfixe549);
			pf();
			state._fsp--;

			// projet.g:110:19: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==17) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// projet.g:110:21: ';' pf
					{
					match(input,17,FOLLOW_17_in_parfixe553); 
					pushFollow(FOLLOW_pf_in_parfixe555);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,10,FOLLOW_10_in_parfixe559); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// projet.g:113:1: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// projet.g:113:3: ( type ident ( ',' ident )* )
			// projet.g:114:5: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf571);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf573);
			ident();
			state._fsp--;

			// projet.g:114:16: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==13) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// projet.g:114:18: ',' ident
					{
					match(input,13,FOLLOW_13_in_pf577); 
					pushFollow(FOLLOW_ident_in_pf579);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// projet.g:117:1: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// projet.g:117:7: ( 'mod' '(' pm ( ';' pm )* ')' )
			// projet.g:118:5: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,43,FOLLOW_43_in_parmod596); 
			match(input,9,FOLLOW_9_in_parmod598); 
			pushFollow(FOLLOW_pm_in_parmod600);
			pm();
			state._fsp--;

			// projet.g:118:18: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==17) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// projet.g:118:20: ';' pm
					{
					match(input,17,FOLLOW_17_in_parmod604); 
					pushFollow(FOLLOW_pm_in_parmod606);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,10,FOLLOW_10_in_parmod610); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// projet.g:121:1: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// projet.g:121:3: ( type ident ( ',' ident )* )
			// projet.g:122:5: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm622);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm624);
			ident();
			state._fsp--;

			// projet.g:122:16: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==13) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// projet.g:122:18: ',' ident
					{
					match(input,13,FOLLOW_13_in_pm628); 
					pushFollow(FOLLOW_ident_in_pm630);
					ident();
					state._fsp--;

					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// projet.g:125:1: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// projet.g:125:13: ( instruction ( ';' instruction )* )
			// projet.g:126:5: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions645);
			instruction();
			state._fsp--;

			// projet.g:126:17: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==17) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// projet.g:126:19: ';' instruction
					{
					match(input,17,FOLLOW_17_in_instructions649); 
					pushFollow(FOLLOW_instruction_in_instructions651);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// projet.g:129:1: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// projet.g:129:12: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 50:
				{
				alt28=1;
				}
				break;
			case 27:
				{
				alt28=2;
				}
				break;
			case 52:
				{
				alt28=3;
				}
				break;
			case 42:
				{
				alt28=4;
				}
				break;
			case 32:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 13:
			case 17:
			case 25:
			case 36:
			case 38:
			case 39:
			case 41:
			case 51:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// projet.g:130:5: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction666);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:131:5: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction672);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:132:5: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction678);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:133:5: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction684);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:134:5: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction690);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:135:5: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction696);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// projet.g:137:3: 
					{
					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// projet.g:139:1: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// projet.g:139:6: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// projet.g:140:5: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,50,FOLLOW_50_in_inssi712); 
			pushFollow(FOLLOW_expression_in_inssi714);
			expression();
			state._fsp--;

			PtGen.pt(50);
			match(input,24,FOLLOW_24_in_inssi727); 
			pushFollow(FOLLOW_instructions_in_inssi730);
			instructions();
			state._fsp--;

			PtGen.pt(51);
			// projet.g:143:9: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==51) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// projet.g:143:10: 'sinon' instructions
					{
					match(input,51,FOLLOW_51_in_inssi751); 
					pushFollow(FOLLOW_instructions_in_inssi753);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,41,FOLLOW_41_in_inssi765); 
			PtGen.pt(52);
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// projet.g:148:1: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions )? 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// projet.g:148:8: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions )? 'fcond' )
			// projet.g:149:5: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions )? 'fcond'
			{
			match(input,27,FOLLOW_27_in_inscond780); 
			PtGen.pt(55);
			pushFollow(FOLLOW_expression_in_inscond784);
			expression();
			state._fsp--;

			PtGen.pt(50);
			match(input,15,FOLLOW_15_in_inscond788); 
			pushFollow(FOLLOW_instructions_in_inscond790);
			instructions();
			state._fsp--;

			PtGen.pt(56);
			// projet.g:150:9: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==13) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// projet.g:150:10: ',' expression ':' instructions
					{
					match(input,13,FOLLOW_13_in_inscond804); 
					pushFollow(FOLLOW_expression_in_inscond820);
					expression();
					state._fsp--;

					PtGen.pt(50);
					match(input,15,FOLLOW_15_in_inscond824); 
					pushFollow(FOLLOW_instructions_in_inscond826);
					instructions();
					state._fsp--;

					PtGen.pt(56);
					}
					break;

				default :
					break loop30;
				}
			}

			// projet.g:151:9: ( 'aut' instructions )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==25) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// projet.g:151:10: 'aut' instructions
					{
					match(input,25,FOLLOW_25_in_inscond843); 
					pushFollow(FOLLOW_instructions_in_inscond845);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,38,FOLLOW_38_in_inscond858); 
			PtGen.pt(57);
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// projet.g:155:1: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// projet.g:155:7: ( 'ttq' expression 'faire' instructions 'fait' )
			// projet.g:156:5: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,52,FOLLOW_52_in_boucle873); 
			PtGen.pt(53);
			pushFollow(FOLLOW_expression_in_boucle877);
			expression();
			state._fsp--;

			PtGen.pt(50);
			match(input,35,FOLLOW_35_in_boucle881); 
			pushFollow(FOLLOW_instructions_in_boucle883);
			instructions();
			state._fsp--;

			match(input,36,FOLLOW_36_in_boucle885); 
			PtGen.pt(54);
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// projet.g:160:1: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// projet.g:160:8: ( 'lire' '(' ident ( ',' ident )* ')' )
			// projet.g:161:5: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,42,FOLLOW_42_in_lecture900); 
			match(input,9,FOLLOW_9_in_lecture902); 
			pushFollow(FOLLOW_ident_in_lecture904);
			ident();
			state._fsp--;

			PtGen.pt(44);
			// projet.g:162:10: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==13) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// projet.g:162:12: ',' ident
					{
					match(input,13,FOLLOW_13_in_lecture919); 
					pushFollow(FOLLOW_ident_in_lecture921);
					ident();
					state._fsp--;

					PtGen.pt(44);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,10,FOLLOW_10_in_lecture929); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// projet.g:165:1: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// projet.g:165:9: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// projet.g:166:5: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,32,FOLLOW_32_in_ecriture942); 
			match(input,9,FOLLOW_9_in_ecriture945); 
			pushFollow(FOLLOW_expression_in_ecriture947);
			expression();
			state._fsp--;

			PtGen.pt(43);
			// projet.g:167:13: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==13) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// projet.g:167:15: ',' expression
					{
					match(input,13,FOLLOW_13_in_ecriture965); 
					pushFollow(FOLLOW_expression_in_ecriture967);
					expression();
					state._fsp--;

					PtGen.pt(43);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,10,FOLLOW_10_in_ecriture974); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// projet.g:170:1: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// projet.g:170:11: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// projet.g:171:5: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel986);
			ident();
			state._fsp--;

			PtGen.pt(40);
			// projet.g:172:5: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==16) ) {
				alt36=1;
			}
			else if ( (LA36_0==9||LA36_0==13||LA36_0==17||LA36_0==25||LA36_0==36||(LA36_0 >= 38 && LA36_0 <= 39)||LA36_0==41||LA36_0==51) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// projet.g:173:9: ':=' expression
					{
					match(input,16,FOLLOW_16_in_affouappel1004); 
					pushFollow(FOLLOW_expression_in_affouappel1006);
					expression();
					state._fsp--;

					PtGen.pt(41);
					}
					break;
				case 2 :
					// projet.g:174:9: ( effixes ( effmods )? )?
					{
					// projet.g:174:9: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==9) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// projet.g:174:10: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel1020);
							effixes();
							state._fsp--;

							// projet.g:174:18: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==9) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// projet.g:174:19: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel1023);
									effmods();
									state._fsp--;

									}
									break;

							}

							}
							break;

					}

					}
					break;

			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// projet.g:178:1: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// projet.g:178:8: ( '(' ( expression ( ',' expression )* )? ')' )
			// projet.g:179:5: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effixes1047); 
			// projet.g:179:9: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==9||LA38_0==12||LA38_0==14||LA38_0==37||LA38_0==45||LA38_0==54) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// projet.g:179:10: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes1050);
					expression();
					state._fsp--;

					// projet.g:179:22: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==13) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// projet.g:179:23: ',' expression
							{
							match(input,13,FOLLOW_13_in_effixes1054); 
							pushFollow(FOLLOW_expression_in_effixes1056);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effixes1064); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// projet.g:182:1: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// projet.g:182:8: ( '(' ( ident ( ',' ident )* )? ')' )
			// projet.g:183:5: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,9,FOLLOW_9_in_effmods1076); 
			// projet.g:183:9: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// projet.g:183:10: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods1079);
					ident();
					state._fsp--;

					// projet.g:183:17: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==13) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// projet.g:183:18: ',' ident
							{
							match(input,13,FOLLOW_13_in_effmods1083); 
							pushFollow(FOLLOW_ident_in_effmods1085);
							ident();
							state._fsp--;

							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,10,FOLLOW_10_in_effmods1093); 
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// projet.g:186:1: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// projet.g:186:11: ( ( exp1 ) ( 'ou' exp1 )* )
			// projet.g:187:5: ( exp1 ) ( 'ou' exp1 )*
			{
			// projet.g:187:5: ( exp1 )
			// projet.g:187:6: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1107);
			exp1();
			state._fsp--;

			}

			// projet.g:187:12: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==46) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// projet.g:187:13: 'ou' exp1
					{
					match(input,46,FOLLOW_46_in_expression1111); 
					PtGen.pt(20);
					pushFollow(FOLLOW_exp1_in_expression1115);
					exp1();
					state._fsp--;

					PtGen.pt(20);
					PtGen.pt(27);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// projet.g:190:1: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// projet.g:190:5: ( exp2 ( 'et' exp2 )* )
			// projet.g:191:5: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11134);
			exp2();
			state._fsp--;

			// projet.g:191:12: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==34) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// projet.g:191:13: 'et' exp2
					{
					match(input,34,FOLLOW_34_in_exp11139); 
					PtGen.pt(20);
					pushFollow(FOLLOW_exp2_in_exp11143);
					exp2();
					state._fsp--;

					PtGen.pt(20);
					PtGen.pt(21);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// projet.g:194:1: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// projet.g:194:5: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==45) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==9||LA43_0==12||LA43_0==14||LA43_0==37||LA43_0==54) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// projet.g:195:5: 'non' exp2
					{
					match(input,45,FOLLOW_45_in_exp21162); 
					pushFollow(FOLLOW_exp2_in_exp21164);
					exp2();
					state._fsp--;

					PtGen.pt(20);
					PtGen.pt(28);
					}
					break;
				case 2 :
					// projet.g:196:5: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21174);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// projet.g:199:1: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// projet.g:199:5: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// projet.g:200:5: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31188);
			exp4();
			state._fsp--;

			// projet.g:201:5: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 21:
					{
					alt44=1;
					}
					break;
				case 20:
					{
					alt44=2;
					}
					break;
				case 22:
					{
					alt44=3;
					}
					break;
				case 23:
					{
					alt44=4;
					}
					break;
				case 18:
					{
					alt44=5;
					}
					break;
				case 19:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// projet.g:202:9: '=' exp4
					{
					match(input,21,FOLLOW_21_in_exp31205); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp4_in_exp31210);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(23);
					}
					break;
				case 2 :
					// projet.g:203:9: '<>' exp4
					{
					match(input,20,FOLLOW_20_in_exp31224); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp4_in_exp31228);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(29);
					}
					break;
				case 3 :
					// projet.g:204:9: '>' exp4
					{
					match(input,22,FOLLOW_22_in_exp31242); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp4_in_exp31247);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(30);
					}
					break;
				case 4 :
					// projet.g:205:9: '>=' exp4
					{
					match(input,23,FOLLOW_23_in_exp31261); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp4_in_exp31265);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(31);
					}
					break;
				case 5 :
					// projet.g:206:9: '<' exp4
					{
					match(input,18,FOLLOW_18_in_exp31279); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp4_in_exp31284);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(32);
					}
					break;
				case 6 :
					// projet.g:207:9: '<=' exp4
					{
					match(input,19,FOLLOW_19_in_exp31298); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp4_in_exp31302);
					exp4();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(33);
					}
					break;

			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// projet.g:211:1: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// projet.g:211:5: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// projet.g:212:5: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41325);
			exp5();
			state._fsp--;

			// projet.g:213:5: ( '+' exp5 | '-' exp5 )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==12) ) {
					alt45=1;
				}
				else if ( (LA45_0==14) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// projet.g:214:9: '+' exp5
					{
					match(input,12,FOLLOW_12_in_exp41341); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp5_in_exp41345);
					exp5();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(24);
					}
					break;
				case 2 :
					// projet.g:215:9: '-' exp5
					{
					match(input,14,FOLLOW_14_in_exp41359); 
					PtGen.pt(22);
					pushFollow(FOLLOW_exp5_in_exp41363);
					exp5();
					state._fsp--;

					PtGen.pt(22);
					PtGen.pt(34);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// projet.g:219:1: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// projet.g:219:5: ( primaire ( '*' primaire | 'div' primaire )* )
			// projet.g:220:5: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51386);
			primaire();
			state._fsp--;

			// projet.g:221:5: ( '*' primaire | 'div' primaire )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==11) ) {
					alt46=1;
				}
				else if ( (LA46_0==31) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// projet.g:222:9: '*' primaire
					{
					match(input,11,FOLLOW_11_in_exp51403); 
					pushFollow(FOLLOW_primaire_in_exp51407);
					primaire();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:223:9: 'div' primaire
					{
					match(input,31,FOLLOW_31_in_exp51417); 
					pushFollow(FOLLOW_primaire_in_exp51419);
					primaire();
					state._fsp--;

					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// projet.g:227:1: primaire : ( valeur | ident | '(' expression ')' );
	public final void primaire() throws RecognitionException {
		try {
			// projet.g:227:9: ( valeur | ident | '(' expression ')' )
			int alt47=3;
			switch ( input.LA(1) ) {
			case INT:
			case 12:
			case 14:
			case 37:
			case 54:
				{
				alt47=1;
				}
				break;
			case ID:
				{
				alt47=2;
				}
				break;
			case 9:
				{
				alt47=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}
			switch (alt47) {
				case 1 :
					// projet.g:228:5: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1438);
					valeur();
					state._fsp--;

					PtGen.pt(26);
					}
					break;
				case 2 :
					// projet.g:229:5: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1446);
					ident();
					state._fsp--;

					PtGen.pt(25);
					}
					break;
				case 3 :
					// projet.g:230:5: '(' expression ')'
					{
					match(input,9,FOLLOW_9_in_primaire1456); 
					pushFollow(FOLLOW_expression_in_primaire1458);
					expression();
					state._fsp--;

					match(input,10,FOLLOW_10_in_primaire1460); 
					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// projet.g:233:1: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// projet.g:233:7: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 12:
				{
				alt48=2;
				}
				break;
			case 14:
				{
				alt48=3;
				}
				break;
			case 54:
				{
				alt48=4;
				}
				break;
			case 37:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// projet.g:234:5: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1472);
					nbentier();
					state._fsp--;

					PtGen.pt(2);
					}
					break;
				case 2 :
					// projet.g:235:5: '+' nbentier
					{
					match(input,12,FOLLOW_12_in_valeur1484); 
					pushFollow(FOLLOW_nbentier_in_valeur1486);
					nbentier();
					state._fsp--;

					PtGen.pt(2);
					}
					break;
				case 3 :
					// projet.g:236:5: '-' nbentier
					{
					match(input,14,FOLLOW_14_in_valeur1494); 
					pushFollow(FOLLOW_nbentier_in_valeur1496);
					nbentier();
					state._fsp--;

					PtGen.pt(3);
					}
					break;
				case 4 :
					// projet.g:237:5: 'vrai'
					{
					match(input,54,FOLLOW_54_in_valeur1504); 
					PtGen.pt(4);
					}
					break;
				case 5 :
					// projet.g:238:5: 'faux'
					{
					match(input,37,FOLLOW_37_in_valeur1518); 
					PtGen.pt(5);
					}
					break;

			}
		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// projet.g:248:1: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// projet.g:248:9: ( INT )
			// projet.g:249:5: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1545); 
			UtilLex.valNb = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// projet.g:252:1: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// projet.g:252:6: ( ID )
			// projet.g:253:5: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1560); 
			UtilLex.traiterId((ID2!=null?ID2.getText():null), (ID2!=null?ID2.getLine():0));
			}

		}

		  catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite62 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite72 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_unitprog87 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog89 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitprog91 = new BitSet(new long[]{0x0022800070000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog101 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_unitprog111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_unitmodule133 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule135 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_unitmodule137 = new BitSet(new long[]{0x0022800050000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations159 = new BitSet(new long[]{0x0022800010000002L});
	public static final BitSet FOLLOW_partieref_in_declarations166 = new BitSet(new long[]{0x0020800010000002L});
	public static final BitSet FOLLOW_consts_in_declarations173 = new BitSet(new long[]{0x0020800000000002L});
	public static final BitSet FOLLOW_vars_in_declarations180 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_partiedef201 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef203 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partiedef207 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef209 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_partieref226 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref229 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_13_in_partieref232 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref234 = new BitSet(new long[]{0x0000000000022000L});
	public static final BitSet FOLLOW_ptvg_in_partieref238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif250 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_40_in_specif254 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif256 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif258 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif263 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif265 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif271 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_43_in_specif288 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_specif291 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif293 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_specif298 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_specif300 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_specif306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_consts322 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts326 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_consts330 = new BitSet(new long[]{0x0040002000005040L});
	public static final BitSet FOLLOW_valeur_in_consts332 = new BitSet(new long[]{0x0000000000020020L});
	public static final BitSet FOLLOW_ptvg_in_consts337 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_53_in_vars354 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_type_in_vars358 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars360 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_13_in_vars378 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars381 = new BitSet(new long[]{0x0000000204022000L});
	public static final BitSet FOLLOW_ptvg_in_vars390 = new BitSet(new long[]{0x0000000204000002L});
	public static final BitSet FOLLOW_33_in_type417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs441 = new BitSet(new long[]{0x0000800000020000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs443 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_decproc457 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc460 = new BitSet(new long[]{0x0020090030000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc463 = new BitSet(new long[]{0x0020080030000000L});
	public static final BitSet FOLLOW_parmod_in_decproc466 = new BitSet(new long[]{0x0020000030000000L});
	public static final BitSet FOLLOW_consts_in_decproc477 = new BitSet(new long[]{0x0020000020000000L});
	public static final BitSet FOLLOW_vars_in_decproc488 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_corps_in_decproc499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_ptvg512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_corps529 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_corps531 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_corps533 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_parfixe545 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parfixe547 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe549 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parfixe553 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pf_in_parfixe555 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parfixe559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf571 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf573 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pf577 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf579 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_43_in_parmod596 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_parmod598 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod600 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_17_in_parmod604 = new BitSet(new long[]{0x0000000204000000L});
	public static final BitSet FOLLOW_pm_in_parmod606 = new BitSet(new long[]{0x0000000000020400L});
	public static final BitSet FOLLOW_10_in_parmod610 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm622 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm624 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_pm628 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm630 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_instruction_in_instructions645 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_instructions649 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instruction_in_instructions651 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_inssi_in_instruction666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_inssi712 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inssi714 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_inssi727 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi730 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_51_in_inssi751 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inssi753 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_inssi765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_inscond780 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond784 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond788 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond790 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_13_in_inscond804 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_inscond820 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_inscond824 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond826 = new BitSet(new long[]{0x0000004002002000L});
	public static final BitSet FOLLOW_25_in_inscond843 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_inscond845 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_inscond858 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_boucle873 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_boucle877 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_boucle881 = new BitSet(new long[]{0x0014040108020020L});
	public static final BitSet FOLLOW_instructions_in_boucle883 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_lecture900 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_lecture902 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture904 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_lecture919 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture921 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_lecture929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_ecriture942 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_ecriture945 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture947 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_ecriture965 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_ecriture967 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_ecriture974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel986 = new BitSet(new long[]{0x0000000000010202L});
	public static final BitSet FOLLOW_16_in_affouappel1004 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_affouappel1006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel1020 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_effmods_in_affouappel1023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effixes1047 = new BitSet(new long[]{0x0040202000005660L});
	public static final BitSet FOLLOW_expression_in_effixes1050 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effixes1054 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_effixes1056 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effixes1064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_effmods1076 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_ident_in_effmods1079 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effmods1083 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods1085 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_10_in_effmods1093 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1107 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_expression1111 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp1_in_expression1115 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11134 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_exp11139 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp11143 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_45_in_exp21162 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_exp2_in_exp21164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31188 = new BitSet(new long[]{0x0000000000FC0002L});
	public static final BitSet FOLLOW_21_in_exp31205 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31224 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_exp31242 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31261 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_exp31279 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31298 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp4_in_exp31302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41325 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_12_in_exp41341 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp41345 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_14_in_exp41359 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_exp5_in_exp41363 = new BitSet(new long[]{0x0000000000005002L});
	public static final BitSet FOLLOW_primaire_in_exp51386 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_11_in_exp51403 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp51407 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_31_in_exp51417 = new BitSet(new long[]{0x0040002000005260L});
	public static final BitSet FOLLOW_primaire_in_exp51419 = new BitSet(new long[]{0x0000000080000802L});
	public static final BitSet FOLLOW_valeur_in_primaire1438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_primaire1456 = new BitSet(new long[]{0x0040202000005260L});
	public static final BitSet FOLLOW_expression_in_primaire1458 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_primaire1460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_valeur1484 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_valeur1494 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_valeur1504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_valeur1518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1560 = new BitSet(new long[]{0x0000000000000002L});
}
