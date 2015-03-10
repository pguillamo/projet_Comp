programme exempcond:
  var bool b1, b2, b3, b4, b5, b6;    #   réserver 6
debut
  b1 := faux;                         #   empiler 0
                                      #   affecterg 0
  b2 := vrai;                         #   empiler 1
                                      #   affecterg 1
  b3 := faux;                         #   empiler 0
                                      #   affecterg 2
  b4 := faux;                         #   empiler 0
                                      #   affecterg 3
  b5 := faux;                         #   empiler 0
                                      #   affecterg 4
  b6 := vrai;                         #   empiler 1
                                      #   affecterg 5
  cond
  b1:                                 #   contenug 0
                                      #   bsifaux @cond_1_b2
    ecrire(1),                        #   empiler 1
                                      #   ecrent
                                      #   bincond @fcond_1
   b2:                                # cond_1_b2:
                                      #   contenug 1
                                      #   bsifaux @cond_1_b6
    cond
    b3:                               #   congenug 2
                                      #   bsifaux @cond_2_b4
      ecrire(2),                      #   empiler 2
                                      #   ecrent
                                      #   bincond @fcond_2
    b4:                               # cond_2_b4:
                                      #   contenug 3
                                      #   bsifaux @cond_2_b5
      ecrire(3),                      #   empiler 3
                                      #   ecrent
                                      #   bincond @fcond_2
    b5:                               # cond_2_b5:
                                      #   contenug 4
                                      #   bsifaux @cond_2_aut
      ecrire(4)                       #   empiler 4
                                      #   ecrent
    aut                               #   bincond @fcond_2
                                      # cond_2_aut:
      ecrire(5)                       #   empiler 5
                                      #   ecrent
    fcond,                            # fcond_2:
  b6:                                 # cond_1_b6:
                                      #   contenug 5
                                      #   bsifaux @fcond_1
    ecrire(6)                         #   empiler 6
                                      #   ecrent
  fcond;                              # fcond_1:
fin                                   #   arrêt
