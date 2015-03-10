programme sittq:
  const marqueur = -1;
  var ent nblu, min, max;             #   réserver 3
debut
  lire(min);                          #   lirent
                                      #   affecterg 1
  max := min;                         #   contenug 1
                                      #   affecterg 2
  lire(nblu);                         #   lirent
                                      #   affecterg 0
  ttq nblu <> marqueur faire          # ttq_1:
                                      #   contenug 0
                                      #   empiler -1
                                      #   diff
                                      #   bsifaux @fait_1
    si nblu > max alors               #   contenug 0
                                      #   contenug 2
                                      #   sup
                                      #   bsifaux @sinon_2
      max := nblu                     #   contenug 0
                                      #   affecterg 2
    sinon                             #   bincond @fsi_2
                                      # sinon_2:
      si nblu < min alors             #   contenug 0
                                      #   contenug 1
                                      #   inf
                                      #   bsifaux @fsi_3
        min := nblu                   #   contenug 0
                                      #   affecterg 1
      fsi                             # fsi_3:
    fsi;                              # fsi_2:
    lire(nblu);                       #   lirent
                                      #   affecterg 0
  fait;                               #   bincond @ttq_1
                                      # fait_1:
  ecrire(min, max);                   #   contenug 1
                                      #   ecrent
                                      #   contenug 2
                                      #   ecrent
fin                                   #   arrêt
