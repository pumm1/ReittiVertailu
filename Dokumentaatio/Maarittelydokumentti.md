##Toteutettavat algoritmit ja tietorakenteet 
Verkko toteutetaan solmujen taulukkona ja verkon läpikäyntiin käytetään syvyys- ja leveyssuuntainen verkonläpikäynti, Dijkstran algoritmi.
Solmut lajitellaan taulukkoon kekona Dijkstran algoritmissa. Muitakin algoritmeja saatetaan lisätä mukaan, jos aika kurssilla riittää
siihen.

##Mitä ongelmaa ratkotaan
Ongelmana on löytää verkossa reitti solmusta toiseen. Samalla käyttäjälle annetaan myös vaihtoehtoja algoritmien valintaan, jolloin
verkon esittämienn tulisi toteuttaa niin, että jokainen algoritmi voisi hyödyntää samat verkon tiedot omiin tarpeisiinsa, eikä 
verkkoa tarvitsisi toteuttaa useammalla eri tavalla eri algoritmia varten. (Toisaalta, verkon pystyisi toteuttamaan tarvittaessa
jokaiselle algoritmile omalla tavallaan, mutta pyrkimyksenä on ainakin se, että jokainen reittialgoritmi voisi käyttää samaa
verkon toteutusta.)

Valitsin syvyys- ja leveyssuuntaisen-, sekä Dijkstran algoritmin siksi, että ne ovat perinteisiä reittialgoritmeja tietorakenteiden ja
algoritmien keskuudessa. Samalla jokainen niistä soveltuu erilaisiin tilanteisiin eri tavalla ja niiden aika- ja tilavaativuuksissa on
eroja.

##Syöytteet ja ohjelman käyttö
Käyttäjä näkee ruudukon, missä jokainen ruutu on oma nappinsa ja esittää samalla omaa solmuaan verkossa. Käyttäjä voi klikata ruutua 
kerran, jolloin se muuttuu verkossa esteeksi, tyhjäksi solmuksi, aloitus- tai lopetussolmuksi. Klikkaamalla uudestaan, vaihdetaan solmun
tyyppiä ja merkiksi tästä väri myös vaihtuu. Musta ruutu esittää estettä, valkoinen tyhjää solmua, vihreä aloitussolmua ja punainen 
esittää lopetussolmua.
Kun käyttäjä on asettanut ruudukkoon aloitus- ja lopetussolmut, sekä mahdolliset esteet, voi käyttäjä painaa nappia, joka vaihtaa
käytettävää algoritmia, samalla näyttäen, mikä algoritmi on kullakin hetkellä käytössä. Lopuksi käyttäjän valittua haluamansa algoritmi
niistä algoritmeista, mitä tarjolla on, käyttäjä voi painaa aloitus-nappia, jolloin ohjelma etsii verkossa lyhyimmän reitin ja värittää
sen ruudukkoon esille.

##Tavoitteena olevat aika- ja tilavaativuudet
Syvyyssuuntainen algoritmi: Aikavaativuuden tavoite on O(|V|+ |E|) ja tilavaativuuden tavoite on O(|V|). (1)
Leveyssuuntainen algoritmi: Aikavaativuuden tavoite on O(|V|+ |E|) ja tilavaativuuden tavoite on O(|V|). (2)
Dijkstran algoritmi: Aikavaativuuden tavoite on O((|E| + |V|)log|V|) ja tilavaativuuden tavoite on O(|V|). (3)

##Lähteet:
(1)Introduction to Algorithms, third edition - Thomas H.Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein  s.606
ja tietorakenteiden- ja algoritmien luentokalvot, Kevät 2016 - Jyrki Kivinen (kalvo viikko 9, s.479)
(2)Introduction to Algorithms, third edition - Thomas H.Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stei   s.597
ja tietorakenteiden- ja algoritmien luentokalvot, Kevät 2016 - Jyrki Kivinen (kalvo viikko 9, s.457)
(3)Tietorakenteiden- ja algoritmien luentokalvot, Kevät 2016 - Jyrki Kivinen (Viikko 10, s. 533)
