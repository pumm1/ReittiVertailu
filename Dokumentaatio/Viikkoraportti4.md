# Viikkoraportti4

## Mit� olen tehnyt t�ll� viikolla?
Olen jatkanut Dijkstran toteuttamista ja BFS-algoritmin hiomista. Lis�sin my�s ohjelmalle Syvyyssuuntaisen l�pik�ynnin algoritmin (DFS).
Olen my�s yritt�nyt saada muutettua ohjelman rakennetta siten, ett� se hy�dynt�isi Vieruslistaa matriisien sijaan.

## Miten ohjelma on edistynt?
Dijkstraa en ole saanut toimimaan viel�k��n kunnolla. Algoritmi l�yt�� reitin, kun viher� ruutu on punaisesta vasemmalla ja ylh��ll� tai
kokonaan sen yl�puolella.  T�ll�inkin tulee v�lill� ongelmia, jos reitin edess� on esteit� liikaa.

BFS- ja DFS- algoritmit toimivat moitteetta. Ohjelma hy�dynt�� nyt itse toteuttamaani vieruslistaa luokan Array avulla. (Joskin ohjelman
koodi on viel� sekavaa, kun seassa on koodinp�tki� mill� testasin erilaisia tapoja toteuttaa asioita)

## Mit� opin t�ll� viikolla?
Opin vieruslistojen t�rkeyden verkkojen esitt�misess�.

## Miik� j�i ep�selv�ksi tai on tuottanut vaikeuksia?
Dijkstra tuottaa edelleen vaikeuksia ja verkon esitt�minen t�ysin vieruslistojen avulla taitaa ohjelmassani olla v�h�n hankalaa tai jopa mahdotonta,
koska ruudukko esitet��n matriisina. Nyt koodissani on ainakin luokka Edge, mik� on t�ysin hy�dyt�n, vaikka esitt��kin verkon kaaria, mutta ohelman
rakenne on sellainen, etten keksi miten niit� voisi fiksusti hy�dynt��.

Aloin ep�ill�, ett� ehk� en ole muuttanut koodin rakennetta tarpeeksi ohjaajan neuvojen mukaan. 

## Mit� teen seuraavaksi
Koitan viel� saada Dijkstraa toimimaan ja testien toteuttamista pit�� lis�t� nyt, kun olen saanut asioita paremmin toimimaan. En ole varma, annanko
seuraavaksi viel� k�ytt�j�lle mahdollisuutta vaihtaa algoritmia lennossa, mutta se ominaisuus tulee kuitenkin l�hiaikoina. Samalla ohjelmalle t�ytyy
toteuttaa jokin teksti-ikkuna, mist� n�kee algoritmin k�ytt�m�n ajan reitin etsimiseen.

Viikon ty�tunnit: 6,5h

