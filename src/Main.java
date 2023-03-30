import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    /* kui tulevikus edasi teha

    Üks paar (One Pair) -ile kicker
    Kaks paari (Two Pair) -ile kicker
    ja teised täpsustavad asjad võiduolukordadele

    panustamine
    */

    /* reeglid
     * mängu võitmine
     * mängu võidab see kellel on kõige tugevam käsi käes
     * käte tugevused on tegevaimast nõrgemani on järgmised
     * https://et.wikipedia.org/wiki/Pokkerik%C3%A4te_tugevusj%C3%A4rjestus
     * panustamine // lisab hiljem
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

    public static void väljastaVõitja(List<Boolean> võitjad) {
        System.out.println(võitjad);
        int võitjateArv = 0;
        List<Integer> võitjateIndex = new ArrayList<>();
        for (int i = 0; i < võitjad.size(); i++) {
            if (võitjad.get(i)) {
                võitjateIndex.add(i);
                võitjateArv++;
            }
        }

        if (võitjateArv > 1) {
            System.out.println("Mäng jäi viiki mängijate poolt: ");
            for (int i = 0; i < võitjateArv; i++) {
                System.out.println((võitjateIndex.get(i)+1) + ". mängija.");
            }
            System.out.println("viigi põhjus: ");
        } else {
            System.out.println("Mängu võitis: " + (võitjateIndex.get(0)+1) + ". mängija.");
            System.out.println("Võidu põhjus: ");
        }
    }

    public static void main(String[] args) {
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
                    System.out.println("1. mängu võitmine");
                    //System.out.println("2. panustamine");
                    System.out.println("3. tagasi\n" + tühik);
                    System.out.println(valik);
                    int reegel = scan.nextInt();
                    System.out.println(tühik);
                    switch (reegel) {
                        case 1:
                            selgitused:
                            while (true) {
                                System.out.println("mängu võitmine\n\n" +
                                        "mängu võidab see kellel on kõige tugevam käsi käes\n" +
                                        "käte tugevused on tegevaimast nõrgemani on järgmised");
                                System.out.println("Käte selgitused\n");
                                System.out.println(
                                        "1. Kuninglik mastirida\n" +
                                        "2. Mastirida\n" +
                                        "3. Nelik\n" +
                                        "4. Maja\n" +
                                        "5. Mast\n" +
                                        "6. Rida\n" +
                                        "7. Kolmik\n" +
                                        "8. Kaks paari\n" +
                                        "9. Üks paar\n" +
                                        "10. Kõrge kaart\n" +
                                        "11. tagasi\n" +
                                        tühik);
                                System.out.println(valik);
                                int selgitus = scan.nextInt();
                                System.out.println(tühik);
                                switch (selgitus) {

                                    //Kuninglik mastirida (Royal Straight Flush)
                                    case 1:
                                        System.out.println("Kuninglik mastirida\n");
                                        System.out.println("Ühest mastist äss, kuningas, emand, poiss ja kümme");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv = scan.nextInt();
                                        break;

                                    //Mastirida (Straight Flush)
                                    case 2:
                                        System.out.println("Mastirida\n");
                                        System.out.println("Mastirea moodustavad viis järjestikust ühest mastist kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv10 = scan.nextInt();
                                        break;

                                    //Nelik (Four Of A Kind)
                                    case 3:
                                        System.out.println("Nelik\n");
                                        System.out.println("Neli samase tugevusega kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv11 = scan.nextInt();
                                        break;

                                    //Maja (Full House)
                                    case 4:
                                        System.out.println("Maja\n");
                                        System.out.println("Maja koosneb kolmikust ja paarist");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv13 = scan.nextInt();
                                        break;

                                    //Mast (Flush)
                                    case 5:
                                        System.out.println("Mast\n");
                                        System.out.println("Viis ühest mastist kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv2 = scan.nextInt();
                                        break;
                                    //Rida (Straight)
                                    case 6:
                                        System.out.println("Rida\n");
                                        System.out.println("Viis järjestikust kaarti. Näiteks kolm, neli, viis, kuus ja seitse");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv3 = scan.nextInt();
                                        break;
                                    //Kolmik (Three Of A Kind)
                                    case 7:
                                        System.out.println("Kolmik\n");
                                        System.out.println("Kolm samase tugevusega kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv4 = scan.nextInt();
                                        break;
                                    //Kaks paari (Two Pair)
                                    case 8:
                                        System.out.println("Kaks paari\n");
                                        System.out.println("Tugevaimad kaks võimalikku paari oleksid äss, äss ja kuningas, kuningas");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv5 = scan.nextInt();
                                        break;
                                    //Üks paar (One Pair)
                                    case 9:
                                        System.out.println("Üks paar\n");
                                        System.out.println("Kaks samase tugevusega kaarti");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv6 = scan.nextInt();
                                        break;

                                    //Kõrge kaart (High card)
                                    case 10:
                                        System.out.println("Kõrge kaart\n");
                                        System.out.println("Kõrgeim käesolev kaart");
                                        System.out.println(tühik);
                                        System.out.println("tagasiminekuks sisestage suvaline number: ");
                                        int arv17 = scan.nextInt();
                                        break;

                                    case 11:
                                        break selgitused;
                                }
                            }
                        case 2:
                            break;
                    }

                    break;

                //MÄNGU CASE

                case 2:
                    //lisada mängu osa
                    Kaardipakk kaardipakk = new Kaardipakk();
                    kaardipakk.genereeriTavaPakk();
                    Diiler diiler = new Diiler(kaardipakk);
                    diiler.alustaRaundi(4);
                    diiler.käed();
                    diiler.lisaLauale(5);

                    /* test tsükkel ära eemalda pls
                    //oke
                    while (!diiler.royalStraightFlush().contains(true)) {
                        diiler.käed();
                        diiler.resetAll();
                        diiler.alustaRaundi(4);
                        diiler.lisaLauale(5);
                        for (int i = 0; i < 4; i++) {
                            System.out.println(diiler.käedLauaga(i));
                        }
                        System.out.println(diiler.royalStraightFlush());
                    } */
                    if (diiler.royalStraightFlush().contains(true)) {
                        List<Boolean> võitjad = diiler.royalStraightFlush();
                        väljastaVõitja(võitjad);
                        System.out.println("Kuninglik mastirida");

                    } else if (diiler.straightFlush().contains(true)) {
                        List<Boolean> võitjad = diiler.straightFlush();
                        väljastaVõitja(võitjad);
                        System.out.println("Mastirida");

                    } else if (diiler.fourOfAKind().contains(true)) {
                        List<Boolean> võitjad = diiler.fourOfAKind();
                        väljastaVõitja(võitjad);
                        System.out.println("Nelik");

                    } else if (diiler.fullHouse().contains(true)) {
                        List<Boolean> võitjad = diiler.fullHouse();
                        väljastaVõitja(võitjad);
                        System.out.println("Maja");

                    } else if (diiler.flush().contains(true)) {
                        List<Boolean> võitjad = diiler.flush();
                        väljastaVõitja(võitjad);
                        System.out.println("Mast");

                    } else if (diiler.straight().contains(true)) {
                        List<Boolean> võitjad = diiler.straight();
                        väljastaVõitja(võitjad);
                        System.out.println("Rida");

                    } else if (diiler.threeOfAKind().contains(true)) {
                        List<Boolean> võitjad = diiler.threeOfAKind();
                        väljastaVõitja(võitjad);
                        System.out.println("Kolmik");

                    } else if (diiler.twoPair().contains(true)) {
                        List<Boolean> võitjad = diiler.twoPair();
                        väljastaVõitja(võitjad);
                        System.out.println("Kaks paar");

                    } else if (diiler.pair().contains(true)) {
                        List<Boolean> võitjad = diiler.pair();
                        väljastaVõitja(võitjad);
                        System.out.println("üks paar");

                    } /*else if (diiler.highCard().contains(true)) {
                        List<Boolean> võitjad = diiler.highCard();
                        väljastaVõitja(võitjad);
                        System.out.println("Kõrge kaart");
                    } */

                    System.out.println(tühik);
                    break;
                case 3:
                    System.out.println("Aitäh, Mängige jälle!");
                    break mäng;

                    }
            }
        }
}