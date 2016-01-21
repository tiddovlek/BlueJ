import java.util.ArrayList;

/**
 * Write a description of class Bank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bank {
    
    private ArrayList<Bankrekening> lijst = new ArrayList<Bankrekening>();
    private String naam;
    
    public Bank(String naam) {
        this.naam = naam;
    }
    
    public void addRekening(Bankrekening item) {
        lijst.add(item);
    }
    
    public void printOverzicht() {
        System.out.printf("%n   %-15s   ||   %-30s   ||   %-10s%n", "Rekeningnummer", "Naam", "Saldo");
        System.out.println("-------------------------------------------------------------------------------");
        for (Bankrekening item : lijst) {
            System.out.printf("   %015d   ||   %-30s   ||   € %10.2f%n", item.getNummer(), item.getNaam(), item.getSaldo());
        }
        System.out.println();
    }
    
    public double berekenTotaleSaldo() {
        double totaal = 0;
        for (Bankrekening item : lijst) {
            totaal += item.getSaldo();
        }
        return totaal;
    }
    
}