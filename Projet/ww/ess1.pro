# x = 0
# minx = 0
# maxx = 20
# moyx = 10
# init1 = 1 0
# init2 = 2 0
# ajout1 = 3 1
# ajout2 = 4 1
# ecr1 = 5 0
# ecr2 = 6 0
programme ess1:
ref init, init2, ajout1 fixe(ent),
  ajout2 fixe(ent), ecr1, ecr2;
const minx = 0;
const maxx = 20;
const moyx = 10;
var ent x;                            #   réserver 1
debut
  init1;                              #   appel %(init1)s
  init2;                              #   appel $(init2)s
  lire(x);                            #   lirent
                                      #   affecterg %(x)s
  ttq x <> -1 faire                   # ttq_1:
                                      #   contenug %(x)s
                                      #   empiler -1
                                      #   diff
                                      #   bsifaux @fait_1
    si x >= minx et x <= maxx alors   #   contenug %(x)s
                                      #   empiler %(minx)s
                                      #   supeg
                                      #   contenug %(x)s
                                      #   empiler %(maxx)s
                                      #   infeg
                                      #   et
                                      #   bsifaux @fsi_1
      si x < moyx alors               #   contenug %(x)s
                                      #   empiler %(moyx)s
                                      #   inf
                                      #   bsifaux @ sinon_2
        ajout1(x)                     #   contenug %(x)s
                                      #   appel %(ajout1)s
                                      #   bincond @fsi_2
      sinon                           # sinon_2:
        ajout2(x)                     #   contenug %(x)s
                                      #   appel %(ajout2)s
      fsi;                            # fsi_2:
    fsi;                              # fsi_1:
    lire(x);                          #   lirent
                                      #   affecterg %(x)s
  fait;                               #   bincond %(ttq_1)s
                                      # fait_1:
  ecr1;                               #   appel %(ecr1)s
  ecr2;                               #   appel %(ecr2)s
fin                                   #   arrêt
