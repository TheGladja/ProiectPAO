Proiect tipic de backend despre gestionarea cartilor si autorilor acestora.
Se va citi de la tastatura initial un numar de autori.
Apoi se va citi un numar de carti care la randul lor au o lista de cititori.
Fiecare carte va avea cate un autor ales random din lista de autori.
Autorii vor avea un stil de scriere prevazut de clasa de tip enum TipCarte, iar cititorii vor avea o preferinta prevazuta de aceeasi clasa.
In functie de varsta introdusa autorilor si cititorilor le vor fi atribuite stadiile de viata in care se afla, stadii prevazute de clasa de tip enum TipPersoana.
Clasa Persoana este abstracta si este mostenita de autori si cititori care ii implementeaza metodele.
Interfata ICarte prevede toate metodele aplicabile pe listele de autori si carti citite in main, iar clasa Actiuni implementeaza metodele.
In main se pot folosi diferite interogari in functie de numarul introdus de la tastatura (meniu interactiv), interogari precum stergeri, adaugari, sortari parametrizate,
si afisari. 
[!!!GRESEALA: In clasa Main la optinunea 1 se afiseaza numarul de cititori ce au preferinta introdusa de la tastatura, nu numarul de cititori dupa genul cartii (cu toate ca ar fi fost bine sa introduc si optiunea aceasta)]
