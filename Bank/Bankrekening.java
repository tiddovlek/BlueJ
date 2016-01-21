/**
 * Write a description of class Bankrekening here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bankrekening {
    
    private long nummer;
    private String naam;
    private double saldo;
    
    public Bankrekening(long nummer, String naam, double saldo) {
        this.nummer = nummer;
        this.naam = naam;
        this.saldo = saldo;
    }
    
    public long getNummer() {
        return nummer;
    }
    public String getNaam() {
        return naam;
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