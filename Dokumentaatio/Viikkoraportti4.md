# Viikkoraportti4

## Mitä olen tehnyt tällä viikolla?
Olen jatkanut Dijkstran toteuttamista ja BFS-algoritmin hiomista. Lisäsin myös ohjelmalle Syvyyssuuntaisen läpikäynnin algoritmin (DFS).
Olen myös yrittänyt saada muutettua ohjelman rakennetta siten, että se hyödyntäisi Vieruslistaa matriisien sijaan.

## Miten ohjelma on edistynt?
Dijkstraa en ole saanut toimimaan vieläkään kunnolla. Algoritmi löytää reitin, kun viherä ruutu on punaisesta vasemmalla ja ylhäällä tai
kokonaan sen yläpuolella.  Tällöinkin tulee välillä ongelmia, jos reitin edessä on esteitä liikaa.

BFS- ja DFS- algoritmit toimivat moitteetta. Ohjelma hyödyntää nyt itse toteuttamaani vieruslistaa luokan Array avulla. (Joskin ohjelman
koodi on vielä sekavaa, kun seassa on koodinpätkiä millä testasin erilaisia tapoja toteuttaa asioita)

## Mitä opin tällä viikolla?
Opin vieruslistojen tärkeyden verkkojen esittämisessä.

## Miikä jäi epäselväksi tai on tuottanut vaikeuksia?
Dijkstra tuottaa edelleen vaikeuksia ja verkon esittäminen täysin vieruslistojen avulla taitaa ohjelmassani olla vähän hankalaa tai jopa mahdotonta,
koska ruudukko esitetään matriisina. Nyt koodissani on ainakin luokka Edge, mikä on täysin hyödytön, vaikka esittääkin verkon kaaria, mutta ohelman
rakenne on sellainen, etten keksi miten niitä voisi fiksusti hyödyntää.

Aloin epäillä, että ehkä en ole muuttanut koodin rakennetta tarpeeksi ohjaajan neuvojen mukaan. 

## Mitä teen seuraavaksi
Koitan vielä saada Dijkstraa toimimaan ja testien toteuttamista pitää lisätä nyt, kun olen saanut asioita paremmin toimimaan. En ole varma, annanko
seuraavaksi vielä käyttäjälle mahdollisuutta vaihtaa algoritmia lennossa, mutta se ominaisuus tulee kuitenkin lähiaikoina. Samalla ohjelmalle täytyy
toteuttaa jokin teksti-ikkuna, mistä näkee algoritmin käyttämän ajan reitin etsimiseen.

Viikon työtunnit: 6,5h

