programme exo6:
  var ent res; bool op;               #   réserver 2
                                      #   bincond @main
  proc verifdrapeau                   # proc_verifdrapeau:
      fixe (ent v)
      mod (ent r; bool b)
    var bool drap;                    #   réserver 1
  debut
    drap:=faux;                       #   empiler 0
                                      #   affecterl 5 LOC
    cond
    v=0:                              #   contenul 0 FIX
                                      #   empiler 0
                                      #   eg
                                      #   bsifaux @cond_1_v1
      drap:=vrai;                     #   empiler 1
                                      #   affecterl 5 LOC
      r:=0;                           #   empiler 0
                                      #   affecterl 1 MOD
      op:=vrai                        #   empiler 1
                                      #   affecterg 1
                                      #   bincond @fcond_1
    ,v=1:                             # cond_1_v1:
                                      #   contenul 0 FIX
                                      #   empiler 1
                                      #   eg
                                      #   bsifaux @fcond_1
      drap:=vrai;                     #   empiler 1
                                      #   affecterl 5 LOC
      r:=1;                           #   empiler 1
                                      #   affecterl 1 MOD
      op:=faux                        #   empiler 0
                                      #   affecterg 1
    fcond;                            # fcond_1:
    b:=drap;                          #   contenul 5 LOC
                                      #   affecterl 2 MOD
  fin;                                #   retour 3
  proc recurs                         # proc_recurs:
      mod (ent r)
    var ent x; bool marq;             #   réserver 2
  debut
    lire(x);                          #   lirent
                                      #   affecterl 3 LOC
    verifdrapeau(x)(r, marq);         #   contenul 3 LOC
                                      #   empileradl 0 MOD
                                      #   empileradl 4 LOC
                                      #   appel @proc_verifdrapeau 3
    si non marq alors                 #   contenul 4 LOC
                                      #   non
                                      #   bsifaux @fsi_2
      recurs()(r);                    #   empileradl 0 MOD
                                      #   appel @proc_recurs 1
      si op alors                     #   contenug 1
                                      #   bsifaux @sinon_3
        r:=x+r                        #   contenul 3 LOC
                                      #   contenul 0 MOD
                                      #   add
                                      #   affecterl 0 MOD
                                      #   bincond @fsi_3
      sinon                           # sinon_3:
        r:=x*r                        #   contenul 3 LOC
                                      #   contenul 0 MOD
                                      #   mul
                                      #   affecterl 0 MOD
      fsi                             # fsi_3:
    fsi                               # fsi_2:
  fin;                                #   retour 1
debut                                 # main:
  recurs()(res);                      #   empieradg 0
                                      #   appel @proc_recurs 1
  ecrire(res);                        #   contenug 0
                                      #   ecrent
fin                                   #   arrêt
