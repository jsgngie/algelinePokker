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

    public void lisaLauale(int mitu){
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
            System.out.println(i+1 + ". mängija käes on " + Arrays.toString(kätes.get(i)));
        }
    }
}