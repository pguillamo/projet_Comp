programme simple:
  const moinscinq = -5;
  var ent i, n, x, s; bool b;         #   réserver 5
debut
  lire(n);                            #   lirent
                                      #   affecterg 1
  i := n;                             #   contenug 1
                                      #   affecterg 0
  s := 0;                             #   empiler 0
                                      #   affecterg 3
  b := faux;                          #   empiler 0
                                      #   affecterg 4
  ttq i > 0 faire                     # ttq_1:
                                      #   contenug 0
                                      #   empiler 0
                                      #   sup
                                      #   bsifaux @fait_1
    lire(x);                          #   lirent
                                      #   affecterg 2
    s := s+x;                         #   contenug 3
                                      #   contenug 2
                                      #   add
                                      #   affecterg 3
    si x = moinscinq alors            #   contenug 2
                                      #   empiler -5
                                      #   eg
                                      #   bsifaux @fsi_2
      b := vrai                       #   empiler 1
                                      #   affecterg 4
    fsi;                              # fsi_2:
    i := i-1;                         #   contenug 0
                                      #   empiler 1
                                      #   sous
                                      #   affecterg 0
  fait;                               #   bincond @ttq_1
                                      # fait_1:
  ecrire(s, b);                       #   contenug 3
                                      #   ecrent
                                      #   contenug 4
                                      #   ecrbool
fin                                   #   arrêt
