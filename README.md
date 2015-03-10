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



Auteurs
-------

* Antoine Pinsard
* Pierre-Yves Guillamo
* Matthieu Leportier
