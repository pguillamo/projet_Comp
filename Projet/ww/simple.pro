# moinscinq = -5
# i = 0
# n = 1
# x = 2
# s = 3
# b = 4
programme simple:
  const moinscinq = -5;
  var ent i, n, x, s; bool b;         #   réserver 5
debut
  lire(n);                            #   lirent
                                      #   affecterg %(n)s
  i := n;                             #   contenug %(n)s
                                      #   affecterg %(i)s
  s := 0;                             #   empiler 0
                                      #   affecterg %(s)s
  b := faux;                          #   empiler 0
                                      #   affecterg %(b)s
  ttq i > 0 faire                     # ttq_1:
                                      #   contenug %(i)s
                                      #   empiler 0
                                      #   sup
                                      #   bsifaux @fait_1
    lire(x);                          #   lirent
                                      #   affecterg %(x)s
    s := s+x;                         #   contenug %(s)s
                                      #   contenug %(x)s
                                      #   add
                                      #   affecterg %(s)s
    si x = moinscinq alors            #   contenug %(x)s
                                      #   empiler %(moinscinq)s
                                      #   eg
                                      #   bsifaux @fsi_2
      b := vrai                       #   empiler 1
                                      #   affecterg %(b)s
    fsi;                              # fsi_2:
    i := i-1;                         #   contenug %(i)s
                                      #   empiler 1
                                      #   sous
                                      #   affecterg %(i)s
  fait;                               #   bincond @ttq_1
                                      # fait_1:
  ecrire(s, b);                       #   contenug %(s)s
                                      #   ecrent
                                      #   contenug %(b)s
                                      #   ecrbool
fin                                   #   arrêt
