import java.util.*;

public class Diiler {
    private List<Kaart[]> kätes = new ArrayList<>();

    private Kaardipakk kaardipakk;
    private List<Kaart> laual = new ArrayList<>();

    Diiler(Kaardipakk kaardipakk) {
        this.kaardipakk = kaardipakk;
    }

    public List<Kaart[]> alustaRaundi(int mängijateArv) {
        List<Kaart> pakk = kaardipakk.getPakk();
        Random random = new Random();
        // List laud on kahemõõtmeline, kus iga alamjärjend tähistab ühte mängijat.
        // Iga mängija saab kaks kaarti.
        for (int i = 0; i < mängijateArv; i++) {
            Kaart[] mängija = new Kaart[2];
            for (int j = 0; j < 2; j++) {
                Kaart suvaline = pakk.get(random.nextInt(pakk.size()));
                while (this.laual.contains(suvaline)) {
                    suvaline = pakk.get(random.nextInt(pakk.size()));
                }
                mängija[j] = suvaline;
                this.laual.add(suvaline);
            }
            this.kätes.add(mängija);
        }
        //tagastab listi kõigi mängijatega.
        return kätes;
    }

    public void lisaLauale(int mitu) {
        //lisab lauale nii mitu kaarti palju vaja
        List<Kaart> pakk = kaardipakk.getPakk();
        Random random = new Random();
        Kaart suvaline = pakk.get(random.nextInt(pakk.size()));
        for (int i = 0; i < mitu; i++) {
            while (this.laual.contains(suvaline)) {
                suvaline = pakk.get(random.nextInt(pakk.size()));
            }
            this.laual.add(suvaline);
            System.out.println("Lauda tuli: " + suvaline);
        }
    }

    public List<Kaart> getLaual() {
        //tagastab laual olevad kaardid
        return laual;
    }

    public void käed() {
        //väljastab kõikide mängijate käed
        for (int i = 0; i < kätes.size(); i++) {
            System.out.println(i + 1 + ". mängija käes on " + Arrays.toString(kätes.get(i)));
        }
    }

    public List<Kaart> käedLauaga(int mängija) {
        //tagastab antud mängija käe koos laua kaartidega.
        List<Kaart> temp = new ArrayList<>();
        Kaart[] mängijaKäsi = this.kätes.get(mängija);
        for (int i = 0; i < 2; i++) {
            temp.add(mängijaKäsi[i]);
        }
        List<Kaart> laualeTulnudKaardid = (this.laual.subList(8, this.laual.size()));
        for (int i = 0; i < laualeTulnudKaardid.size(); i++) {
            Kaart tempKaart = laualeTulnudKaardid.get(i);
            temp.add(tempKaart);
        }
        Collections.sort(temp);
        return temp;
    }

    public List<Boolean> pair() {
        //käib kõik mängijad ükshaaval läbi
        //teen tühja väärtuste järjendi, kui ei ole paari on false
        // kui on siis true
        List<Boolean> väärtused = new ArrayList<>();

        for (int i = 0; i < this.kätes.size(); i++) {
            List<Kaart> temp = this.käedLauaga(i);
            Collections.sort(temp);
            //kontrollin kas on kaks ühesugust kaarti
            for (int j = 0; j < temp.size()-1; j++) {
                if (temp.get(j).getTugevus() == temp.get(j+1).getTugevus()) {
                    väärtused.add(true);
                    break;
                }
                if (j == temp.size()-2) {
                    väärtused.add(false);
                }
            }
        }
        return väärtused;
    }

    public List<Boolean> twoPair() {
        List<Boolean> väärtused = new ArrayList<>();
        //kontrolling kas on üks paar
        List<Boolean> kasOnÜks = this.pair();
        //kontrollin kas on kaks paari
        for (int i = 0; i < kasOnÜks.size(); i++) {
            if (!kasOnÜks.get(i)) {
                väärtused.add(false);
            } else {
                List<Kaart> temp = this.käedLauaga(i);
                Collections.sort(temp);
                //kui on üks paar kontrollin kas on teine paar
                //eemaldan esimese
                for (int j = 0; j < temp.size()-1; j++) {
                    if (temp.get(j).getTugevus() == temp.get(j+1).getTugevus()) {
                        temp.remove(j);
                        temp.remove(j);
                        break;
                    }
                }
                //kontrollin kas allesjäänudest on paari
                for (int j = 0; j < temp.size()-1; j++) {
                    if (temp.get(j).getTugevus() == temp.get(j+1).getTugevus()) {
                        väärtused.add(true);
                        break;
                    }
                    if (j == temp.size()-2) {
                        väärtused.add(false);
                    }
                }
            }
        }
        return väärtused;
    }
}