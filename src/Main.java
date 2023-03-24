import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    (done)    Programm käsitleb mingit (inimlikku) tegevust, näiteks mängimist
        Programm peab kasutajalt midagi küsima (võib-olla ka korduvalt)
        Programm peaks olema kasutatav ilma, et programmi kohta oleks erilisi eelteadmisi
    (done)    Programm peab sisaldama juhusliku suuruse kasutamist (soovitavalt klassi Random abil)
    (done)    Programm peab koosnema mitmest klassist (sh. peaklass)
    (yes)     Programm peab olema rühmaliikmete endi kirjutatud
        Programm peab olema mõistlikult kommenteeritud.
        Programm ei tohiks olla liiga keeruline
        Kasutajaga suhtlemine peaks olema väga elementaarselt kujundatud. Vältida (veel) graafilist kasutajaliidest.
            Ekraanile kuvatav info (ka näiteks mänguseis) võib olla tekstiridadena (System.out.println).
     */
    public static void main(String[] args) {
        Kaardipakk kaardipakk = new Kaardipakk();
        kaardipakk.genereeriTavaPakk();
        Diiler diiler = new Diiler(kaardipakk);
        diiler.alustaRaundi(4);
        diiler.käed();
        diiler.lisaLauale(3);
        //kontrollin kas on kaks paari
        System.out.println(diiler.twoPair());
    }
}