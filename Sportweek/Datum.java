package Sportweek;

/**
 * Write a description of class Datum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Datum {
    
    //attributes
    private int dag;
    private int maand;
    private int jaar;
    
    //Constructor
    public Datum(int dag, int maand, int jaar) {
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }
    
    //******************** methods ********************//
    public String toString() {
        return String.format("%02d-%02d-%04d", dag, maand, jaar);
    }
    
    public int getDag() {
        return dag;
    }
    public int getMaand() {
        return maand;
    }
    public int getJaar() {
        return jaar;
    }
    
    public void setDag(int dag) {
        this.dag = dag;
    }
    public void setMaand(int maand) {
        this.maand = maand;
    }
    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
    //*************************************************//
    
}