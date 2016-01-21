import java.util.ArrayList;

public class Dobbelsteen {
    
    private int aantalKanten;
    private int worp;
    private ArrayList<Integer> lijst = new ArrayList<Integer>();
    
    public Dobbelsteen(int aantalKanten) {
        this.aantalKanten = aantalKanten;
        worp = 0;
    }
    
    public int getWorp() {
        return worp;
    }
    
    public int gooi() {
        worp = (int) ( aantalKanten * Math.random() + 1 );
        return worp;
    }
    
    public void gooi(int aantalWorpen) {
        lijst.clear();
        for (int i = 1; i <= aantalWorpen; i++) {
            lijst.add(gooi());
        }
    }
    
    public int telResultaten(int getal) {
        int aantal = 0;
        for (int worp : lijst) {
            if (worp == getal) {aantal++;}
        }
        return aantal;
    }
    
    public void verdeling(int aantalWorpen) {
        gooi(aantalWorpen);
        for (int i = 1; i <= aantalKanten; i++) {
            System.out.printf("%7d   || ", i);
        }
        System.out.printf("%n");
        for (int i = 1; i <= aantalKanten; i++) {
            System.out.printf("%7d   || ", telResultaten(i));
        }
        System.out.printf("%n%n");
    }
    
}