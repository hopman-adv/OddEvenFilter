#Konzolová aplikace pro filtrování sudých/lichých čísel

##Popis
Konzolová aplikace přijímá jako vstup řadu kladných čísel oddělenou mezerami.
Vyřadí neplatné znaky (viz dále) a spočítá počet platných znaků.
Pokud je počet znaků sudý - vyfiltruje jen sudá čísla z řady.
Pokud je počet znaků lichý - vyfiltruje jen lichá čísla z řady.
Čisla jsou buďto zapsaná přímo do konsole nebo do souboru.

##Použití
- Otevřeme terminál ve složce s aplikací (oddEvenFilter.jar)
- Příkaz pro spuštění aplikace: java -jar oddEvenFilter.jar parametr1 parametr2
    - Parametr1 udává vstup - textový řetězec nebo soubor s textovým řetězcem.
    - Parametr2 udává výstup - cestu k souboru kam bude text vypsán(volitelný).


##Parametry
- Text parametrů by měl být v v závorkách. První parametr může být i bez závorek pokud se jedná o celé číslo.

###Parametr1:
- Parametr1 může být textový řetězec obsahující čísla, jedno samostatné číslo nebo cesta k souboru s čísly. 
###Parametr2:
- Parametr2 je volitelný. Jedná se o cestu k souboru kam bude výstup zapsán. Pokud chybí bude řada filtrovaných čísel vypsána do konsole.

##Omezení
Aplikace obsahuje validaci vstupů:
- Jiné znaky než celá kladná čísla a nula jsou z řady předem odstraněna.
  - Součet čísel v řadě (pro rozhodnutí o sudosti/lichosti) se dělá jen z platných znaků - ne z vyřazených.
    Řada [-1, 1, 2, 1] vrátí [1, 1] (-1 není započítaná a 1,2,3 jsou 3 čísla - liché).
- Maximální platné číslo je 2147483647.
- Nula je počítána jako sudé číslo. 
- Aplikace vypisuje informace o svém chodu (přeskočená čísla, nenalezení souboru) - tyto informace se nezapisují do souboru pro výstup.

##Příklady použití
java -jar oddEvenFilter.jar "1 2 3"
-> Vypíše do konzole: [1, 3]

java -jar oddEvenFilter.jar 5
-> Vypíše do konzole: [5]

java -jar oddEvenFilter.jar "1 2 3" "output.txt"
-> Vypíše do souboru "output.txt" [1, 3]

java -jar oddEvenFilter.jar "-10 0 2" "/Users/josef/output.txt"
-> Vypíše: [0, 2]  do souboru na cestě /Users/josef/output.txt

