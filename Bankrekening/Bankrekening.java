/**
 * Write a description of class Bankrekening here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bankrekening {
    
    private String naam;
    private int nummer;
    private double saldo;
    
    public Bankrekening(String naam, int nummer, double saldo) {
        this.naam = naam;
        this.nummer = nummer;
        this.saldo = saldo;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public double neemOp(double bedrag) {
        saldo -= bedrag;
        return bedrag;
    }
    
    public void stort(double bedrag) {
        saldo += bedrag;
    }
    
}