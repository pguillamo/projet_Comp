Projet de Compilation
=====================

Projet de compilation en L3 Info (Université de Rennes 1)

L'objectif de ce projet est de créer un compilateur à l'aide d'ANTLR pour
compiler des fichiers .pro (langage "Projet") en .obj (Langage Mapile).

Utilisation
-----------

Les dossiers antlr et bin sont fournis, l'intégralité du projet se trouve dans
le dossier Projet. Le fichier Makefile permet de :

1. Construire le lexer et le parser (`make projet`)
2. Compiler les fichiers .pro en .gen et .obj (`make build`)
3. Tester les fichiers .gen générés avec des fichiers .test.gen "compilés" à la main (`make test`)

Exemples d'utilisation
----------------------

### Construction du lexer et du parser

    ➜  Projet git:(master) ✗ make projet
    java -cp libclass/:../antlr/antlr-3.5.jar org.antlr.Tool projet.g
    javac -cp libclass/:../antlr/antlr-3.5.jar -d libclass/ *.java

### Compilation

    ➜  Projet git:(master) ✗ make build
    echo -ne "ww/simple\n\n" | java -cp libclass/:../antlr/antlr-3.5.jar projet
    PROJET DE COMPILATION version : Matthieu Leportier, Antoine Pinsard, Pierre-Yves Guillamo
    ----------------------------------------
    
    Donnez le nom du fichier que vous souhaitez compiler, sans suffixe :  (RC si terminé) 
    succ�s, arret de la compilation 
           code           categorie      type    info
          |--------------|--------------|-------|----
    bc=  1 @moinscinq     CONSTANTE      ENT     -5
         2 @i             VARGLOBALE     ENT     0
         3 @n             VARGLOBALE     ENT     1
         4 @x             VARGLOBALE     ENT     2
         5 @s             VARGLOBALE     ENT     3
    it=  6 @b             VARGLOBALE     BOOL    4

### Génération des fichiers de test à partir du .pro

test_builder.py se base sur le code mapile compilé à la main en commentaires de fin de ligne.
Voir les fichiers Projet/ww/simple.pro et Projet/ww/exempcond.pro pour exemples. Pour les
branchements, il est possible d'utiliser des labels `label:` mémorise l'adresse courante,
`@label` est remplacé par l'adresse mémorisée par `label:`. Le remplacement est fait après
l'analyse du fichier, il est donc possible de renseigner des `@label` avant le `label:`
correspondant.

    ➜  Projet git:(master) ✗ make ww/simple.test.gen
    python3 test_builder.py ww/simple.pro

### Lancement des tests

    ➜  Projet git:(master) ✗ make test
    iconv -o ww/simple.utf8.gen -f ISO-8859-1 -t UTF-8 ww/simple.gen
    diff ww/simple.test.gen ww/simple.utf8.gen > /dev/null && echo "OK" || echo "FAIL"
    FAIL
    python3 test_builder.py ww/exempcond.pro
    iconv -o ww/exempcond.utf8.gen -f ISO-8859-1 -t UTF-8 ww/exempcond.gen
    diff ww/exempcond.test.gen ww/exempcond.utf8.gen > /dev/null && echo "OK" || echo "FAIL"
    FAIL
    rm ww/exempcond.test.gen ww/exempcond.utf8.gen ww/simple.utf8.gen
    
Lorsque les tests échouent, il est possible de voir les différences entre le .gen généré et
le .test.gen attendu en lançant la commande `make simple.diff`. Cela ouvrir les fichiers
ww/simple.utf8.gen (version utf8 du fichier ww/simple.gen qui est en latin1) et ww/simple.test.gen
avec l'outil `vimdiff`.

Auteurs
-------

* Antoine Pinsard
* Pierre-Yves Guillamo
* Matthieu Leportier
