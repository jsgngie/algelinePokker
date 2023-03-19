public class Main {
    /*
    (done)    Programm käsitleb mingit (inimlikku) tegevust, näiteks mängimist
        Programm peab kasutajalt midagi küsima (võib-olla ka korduvalt)
        Programm peaks olema kasutatav ilma, et programmi kohta oleks erilisi eelteadmisi
        Programm peab sisaldama juhusliku suuruse kasutamist (soovitavalt klassi Random abil)
    (done)    Programm peab koosnema mitmest klassist (sh. peaklass)
        Programm peab olema rühmaliikmete endi kirjutatud
        Programm peab olema mõistlikult kommenteeritud.
        Programm ei tohiks olla liiga keeruline
        Kasutajaga suhtlemine peaks olema väga elementaarselt kujundatud. Vältida (veel) graafilist kasutajaliidest.
            Ekraanile kuvatav info (ka näiteks mänguseis) võib olla tekstiridadena (System.out.println).
     */
    public static void main(String[] args) {
        Kaardipakk kaardipakk = new Kaardipakk();
        kaardipakk.genereeriTavaPakk();

        System.out.println(kaardipakk.indexOf(new Kaart("ärtu", 4)));

    }
}