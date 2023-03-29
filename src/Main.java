import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    /* kui tulevikus edasi teha

    //Kuninglik mastirida (Royal Straight Flush)
    //Mastirida (Straight Flush)
    //Maja (Full House)
    //Kõrge kaart
    Üks paar (One Pair) -ile kicker
    Kaks paari (Two Pair) -ile kicker
    ja teised täpsustavad asjad võiduolukordadeöe

    panustamine
    */

    /*
    (done)    Programm käsitleb mingit (inimlikku) tegevust, näiteks mängimist
    (done)    Programm peab kasutajalt midagi küsima (võib-olla ka korduvalt)
    (done)    Programm peaks olema kasutatav ilma, et programmi kohta oleks erilisi eelteadmisi
    (done)    Programm peab sisaldama juhusliku suuruse kasutamist (soovitavalt klassi Random abil)
    (done)    Programm peab koosnema mitmest klassist (sh. peaklass)
    (yes)     Programm peab olema rühmaliikmete endi kirjutatud
        Programm peab olema mõistlikult kommenteeritud.
    (kinda)    Programm ei tohiks olla liiga keeruline
    (done)    Kasutajaga suhtlemine peaks olema väga elementaarselt kujundatud. Vältida (veel) graafilist kasutajaliidest.
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

        String tühik = "----------------\n";

        //mängimise osa
        Scanner scan = new Scanner(System.in);

        System.out.println("Lihtne Pokker\n" + tühik);
        mäng:
        while (true){
            String valik = "Valiku tegemiseks sisestage number: ";

            System.out.println("1. Mängu reeglid\n2. Alusta mängimist\n3. Lahku\n" + tühik);
            System.out.println(valik);

            int vastus = scan.nextInt();
            System.out.println(tühik);
            switch (vastus) {
                case 1:
                    System.out.println("Mängu reeglid");
                    System.out.println("");
                    /*
                    * mängu võitmine
                    * mängu võidab see kellel on kõige tugevam käsi käes
                    * käte tugevused on tegevaimast nõrgemani on järgmised
                    * https://et.wikipedia.org/wiki/Pokkerik%C3%A4te_tugevusj%C3%A4rjestus
                    * //Kuninglik mastirida (Royal Straight Flush)  vaja lisada
                    * //Mastirida (Straight Flush) vaja lisada
                    * //Maja (Full House) vaja lisada
                    *   Üks paar (One Pair)
                    * // Kõrge kaart vaja lisada
                    * panustamine // lisab hiljem
                    */
                    System.out.println("1. mängu võitmine");
                    //System.out.println("2. panustamine");
                    System.out.println("3. tagasi\n" + tühik);
                    System.out.println(valik);
                    int reegel = scan.nextInt();
                    System.out.println(tühik);
                    switch (reegel) {
                        case 1:
                            selgitused:
                            while (true){
                                System.out.println("võidu selgitused\n");
                                System.out.println("1. Nelik\n2. Mast\n3. Rida\n4. Kolmik\n5. Kaks paari\n6. Üks paar\n7. tagasi\n" + tühik);
                                System.out.println(valik);
                                int selgitus = scan.nextInt();
                                System.out.println(tühik);
                                switch (selgitus) {
                                    //Nelik (Four Of A Kind)
                                    case 1:
                                        System.out.println("Nelik\n");
                                        System.out.println("Neli samase tugevusega kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv = scan.nextInt();
                                        break;
                                    //Mast (Flush)
                                    case 2:
                                        System.out.println("Mast\n");
                                        System.out.println("Viis ühest mastist kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv2 = scan.nextInt();
                                        break;
                                    //Rida (Straight)
                                    case 3:
                                        System.out.println("Rida\n");
                                        System.out.println("Viis järjestikust kaarti. Näiteks kolm, neli, viis, kuus ja seitse");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv3 = scan.nextInt();
                                        break;
                                    //Kolmik (Three Of A Kind)
                                    case 4:
                                        System.out.println("Kolmik\n");
                                        System.out.println("Kolm samase tugevusega kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv4 = scan.nextInt();
                                        break;
                                    //Kaks paari (Two Pair)
                                    case 5:
                                        System.out.println("Kaks paari\n");
                                        System.out.println("Tugevaimad kaks võimalikku paari oleksid äss, äss ja kuningas, kuningas");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv5 = scan.nextInt();
                                        break;
                                    case 6:
                                        System.out.println("Üks paar\n");
                                        System.out.println("Kaks samase tugevusega kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv6 = scan.nextInt();
                                        break;
                                    case 7:
                                        break selgitused;
                                    }
                                }
                        case 2:
                            break;
                        }

                    break;
                case 2:
                    //lisada mängu osa

                    diiler.resetAll();
                    diiler.alustaRaundi(4);
                    diiler.käed();
                    diiler.lisaLauale(5);
                    System.out.println(diiler.flush());
                    break;
                case 3:
                    System.out.println("Aitäh, Mängige jälle!");
                    break mäng;

                    }



            }
        }
}