import java.util.*;

public class Yahtzee_4 {
    
    private Dobbelsteen dobbelsteen;  
    private ArrayList<Integer> worp;
    private ArrayList<Integer> telling;
    
    public Yahtzee_4() {
        dobbelsteen = new Dobbelsteen();
        worp = new ArrayList<Integer>();
        telling = new ArrayList<Integer>();
    }
    
    public void gooi5() {
        worp.clear();
        for(int i = 0; i < 5; i++) {
            worp.add(dobbelsteen.gooi());
        }
        print();
    }
    
    public void print() {
        for(int item : worp) {
            System.out.printf("%3d", item);
        }
        System.out.println();
    }
    
    public void tel() {
        telling.clear();
        for(int ogen = 1; ogen <= 6; ogen++) {
            telling.add(getAantal(ogen, worp));
        }
        for(int item : telling) {
            System.out.printf("%3d", item);
        }
        System.out.println();
    }
    
    public void analyseer() {
        if (getAantal(5, telling) == 1) {
            System.out.println("Yahtzee");
        }
        else if (getAantal(4, telling) == 1) {
            System.out.println("Carré");
        }
        else if (getAantal(3, telling) == 1) {
            if (getAantal(2, telling) == 1) {
                System.out.println("Full House");
            }
            else {System.out.println("Three of a Kind");}
        }
        else if (getAantal(1, telling) == 5) {
            if (getAantal(1, worp) == 0
            || getAantal(6, worp) == 0) {
                System.out.println("Large Strait");
            }
            else if (getAantal(2, worp) == 0
            || getAantal(5, worp) == 0) {
                System.out.println("Small Strait");
            }
            else {System.out.println("Nothing");}
        }
        else if (getAantal(1, telling) == 3) {
            if ((getAantal(5, worp) == 0
            && getAantal(6, worp) == 0)
            || (getAantal(1, worp) == 0
            && getAantal(6, worp) == 0)
            || (getAantal(1, worp) == 0
            && getAantal(2, worp) == 0)) {
                System.out.println("Small Strait");
            }
            else {System.out.println("Nothing");}
        }
        else {System.out.println("Nothing");}
    }
    
    public void gooiEnResultaat(int aantalKeer) {
        for (int i = 0; i < aantalKeer; i++) {
            gooi5();
            System.out.println();
            tel();
            analyseer();
            System.out.println("------------------");
            System.out.println();
        }
    }
    
    private int getAantal(int getal, ArrayList<Integer> lijst) {
        int aantal = 0;
        for (int item : lijst) {
            if (item == getal) {
                aantal++;
            }
        }
        return aantal;
    }
    
}