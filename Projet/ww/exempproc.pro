programme exempproc:
  var ent n;                          #   réserver 1
                                      #   bincond @main
  proc p                              # proc_p:
      fixe (ent x)
      mod (ent y)
    var ent j;                        #   réserver 1
  debut
    j := 0;                           #   empiler 0
                                      #   affecterl 4 0
    y := x                            #   contenul 0 0
                                      #   affecterl 1 1
  fin                                 #   retour 2
  proc q                              # proc_q:
      mod (ent z)
    var ent i;                        #   réserver 1
  debut
    p(2)(i);                          #   empiler 2
                                      #   empileradl 3 0
                                      #   appel @proc_p 2
    p(i)(z);                          #   contenul 3 0
                                      #   empileradl 0 1
                                      #   appel @proc_p 2
    p(z)(i);                          #   contenul 0 1
                                      #   empileradl 3 0
                                      #   appel @proc_p 2
  fin                                 #   retour 1
debut                                 # main:
  q()(n);                             #   empileradg 0
                                      #   appel @proc_q 1
  ecrire(n);                          #   contenug 0
                                      #   ecrent
fin                                   #   arrêt
