# n = 0
# min = 1
# max = 2
# ajout2_y = 0 FIX
module m2ess1:
  def init2, ajout2, ecr2;
  var ent n, min, max;
  proc init2
  debut
    n := 0                            #   empiler 0
                                      #   affecterg %(n)s
  fin                                 #   retour 0
  proc ajout2 fixe(ent y)
  debut
    si n = 0 alors                    #   contenug %(n)s
                                      #   empiler 0
                                      #   eg
                                      #   bsifaux @sinon_1
      min := y;                       #   contenul %(ajout2_y)s
                                      #   affecterg %(min)s
      max := y                        #   contenul %(ajout2_y)s 
                                      #   affecterg %(max)s
                                      #   bincond @fsi_1
    sinon                             # sinon_1:
      si y < min alors                #   contenul %(ajout2_y)s
                                      #   contenug %(min)s
                                      #   inf
                                      #   bsifaux @sinon_2
        min := y                      #   contenul %(ajout2_y)s
                                      #   affecterg %(min)s
                                      #   bincond @fsi_2
      sinon                           # sinon_2:
        si y > max alors              #   contenul %(ajout2_y)s
                                      #   contenug %(max)s
                                      #   sup
                                      #   bsifaux @fsi_3
          max := y                    #   contenul %(ajout2_y)s
                                      #   affecterg %(max)s
        fsi                           # fsi_1:
      fsi                             # fsi_2:
    fsi;                              # fsi_3:
    n := n + 1;                       #   contenug %(n)s
                                      #   empiler 1
                                      #   add
                                      #   affecterg %(n)s
  fin                                 #   retour 1
  proc ecr2
  debut
    si n <> 0 alors                   #   contenug %(n)s
                                      #   empiler 0
                                      #   diff
                                      #   bsifaux @sinon_4
      ecrire (n, min, max)            #   contenug %(n)s
                                      #   ecrent
                                      #   contenug %(min)s
                                      #   ecrent
                                      #   contenug %(max)s
                                      #   ecrent
                                      #   bincond @fsi_4
    sinon                             # sinon_4:
      ecrire(0)                       #   empiler 0
                                      #   ecrent
    fsi;                              # fsi_4:
  fin;                                # retour 0
