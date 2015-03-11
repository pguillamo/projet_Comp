# res = 0
# op = 1
#------------------
# v = 0 FIX
# r = 1 MOD
# b = 2 MOD
# drap = 5 LOC
#------------------
# recurs_r = 0 MOD
# x = 3 LOC
# marq = 4 LOC
programme exo6:
  var ent res; bool op;               #   réserver 2
                                      #   bincond @main
  proc verifdrapeau                   # proc_verifdrapeau:
      fixe (ent v)
      mod (ent r; bool b)
    var bool drap;                    #   réserver 1
  debut
    drap:=faux;                       #   empiler faux
                                      #   affecterl %(drap)s
    cond
    v=0:                              #   contenul %(v)s
                                      #   empiler 0
                                      #   eg
                                      #   bsifaux @cond_1_v1
      drap:=vrai;                     #   empiler vrai
                                      #   affecterl %(drap)s
      r:=0;                           #   empiler 0
                                      #   affecterl %(r)s
      op:=vrai                        #   empiler vrai
                                      #   affecterg %(op)s
                                      #   bincond @fcond_1
    ,v=1:                             # cond_1_v1:
                                      #   contenul %(v)s
                                      #   empiler 1
                                      #   eg
                                      #   bsifaux @fcond_1
      drap:=vrai;                     #   empiler vrai
                                      #   affecterl %(drap)s
      r:=1;                           #   empiler 1
                                      #   affecterl %(r)s
      op:=faux                        #   empiler faux
                                      #   affecterg %(op)s
    fcond;                            # fcond_1:
    b:=drap;                          #   contenul %(drap)s
                                      #   affecterl %(b)s
  fin;                                #   retour 3
  proc recurs                         # proc_recurs:
      mod (ent r)
    var ent x; bool marq;             #   réserver 2
  debut
    lire(x);                          #   lirent
                                      #   affecterl %(x)s
    verifdrapeau(x)(r, marq);         #   contenul %(x)s
                                      #   empileradl %(recurs_r)s
                                      #   empileradl %(marq)s
                                      #   appel @proc_verifdrapeau 3
    si non marq alors                 #   contenul %(marq)s
                                      #   non
                                      #   bsifaux @fsi_2
      recurs()(r);                    #   empileradl %(recurs_r)s
                                      #   appel @proc_recurs 1
      si op alors                     #   contenug %(op)s
                                      #   bsifaux @sinon_3
        r:=x+r                        #   contenul %(x)s
                                      #   contenul %(recurs_r)s
                                      #   add
                                      #   affecterl %(recurs_r)s
                                      #   bincond @fsi_3
      sinon                           # sinon_3:
        r:=x*r                        #   contenul %(x)s
                                      #   contenul %(recurs_r)s
                                      #   mul
                                      #   affecterl %(recurs_r)s
      fsi                             # fsi_3:
    fsi                               # fsi_2:
  fin;                                #   retour 1
debut                                 # main:
  recurs()(res);                      #   empieradg %(res)s
                                      #   appel @proc_recurs 1
  ecrire(res);                        #   contenug %(res)s
                                      #   ecrent
fin                                   #   arrêt
