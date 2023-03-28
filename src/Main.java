import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        diiler.lisaLauale(5);
        System.out.println(diiler.flush());

        //test loop
        while (!diiler.flush().contains(true)) {
            diiler.käed();
            diiler.resetAll();
            diiler.alustaRaundi(4);
            diiler.lisaLauale(5);
            for (int i = 0; i < 4; i++) {
                System.out.println(diiler.käedLauaga(i) + "\n");
            }
            System.out.println(diiler.flush());
        }

        String tühik = "\n----------------\n";

        //mängimise osa
        Scanner scan = new Scanner(System.in);

        System.out.println("Lihtne Pokker" + tühik);
        mäng:
        while (true){
            System.out.println("1. Mängu reeglid\n2. Alusta mängimist" + tühik);
            System.out.println("Valiku tegemiseks sisestage number: ");

            int vastus = scan.nextInt();
            System.out.println(tühik);
            switch (vastus) {
                case 1:
                    System.out.println("Mängu reeglid");
                    break;
                case 2:
                    diiler.resetAll();
                    diiler.alustaRaundi(4);
                    diiler.käed();
                    diiler.lisaLauale(5);
                    System.out.println(diiler.flush());
                    break;
                case 3:
                    break mäng;
            }
        }

    }
}