import java.util.*;

/**
 * Write a description of class Bestelling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bestelling {
    
    private ArrayList<Artikel> lijst = new ArrayList<Artikel>();
    
    public Bestelling() {
        
    }
    
    public void voegtoe(Artikel item) {
        lijst.add(item);
    }
    
    public void printFactuur() {
        for( Artikel artikel : lijst ) {
            System.out.printf("%4d %-20s € %6.2f%n", artikel.getNummer(), artikel.getOmschrijving(), artikel.getPrijs() );
        }
        System.out.println("----------------------------------");
        System.out.printf("Totaal: %17s € %.2f%n", "", berekenTotaal());
    }
    
    public double berekenTotaal() {
        double totaal = 0;
        for( Artikel artikel : lijst ) {
            totaal += artikel.getPrijs();
        }
        return totaal;
    }
    
}