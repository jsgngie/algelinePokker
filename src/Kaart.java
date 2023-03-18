public class Kaart implements Comparable<Kaart> {
    private String mast;
    private int tugevus;

    public Kaart(String mast, int tugevus) {
        this.mast = mast;
        this.tugevus = tugevus;
    }

    public String getMast() {
        return mast;
    }

    public int getTugevus() {
        return tugevus;
    }

    @Override
    public int compareTo(Kaart o) {
        return Integer.compare(tugevus, o.tugevus);
    }
}
