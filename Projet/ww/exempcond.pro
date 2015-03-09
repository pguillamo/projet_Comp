programme exempcond:
  var bool b1, b2, b3, b4, b5, b6;
debut
  b1 := faux; b2 := vrai; b3 := faux; b4 := faux; b5 := faux; b6 := vrai;
  cond
  b1: ecrire(1),
  b2: cond
      b3: ecrire(2),
      b4: ecrire(3),
      b5: ecrire(4)
      aut ecrire(5) fcond,
  b6: ecrire(6)
  fcond;
fin
