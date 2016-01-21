package Sportweek;

/**
 * Write a description of class Leerling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leerling {
    
    //attributes
    private String naam;
    private String klas;
    private String geslacht;
    private int nummer;
    private Datum geboortedatum;
    
    //Constructor
    public Leerling(String naam, String klas, String geslacht, int nummer, Datum geboortedatum) {
        this.naam = naam;
        this.klas = klas;
        this.geslacht = geslacht;
        this.nummer = nummer;
        this.geboortedatum = geboortedatum;
    }
    
    //******************** methods ********************//
    public String toString() {
        return naam+", "+klas+", "+geslacht+", "+nummer+", "+geboortedatum;
    }
    
    public String getNaam() {
        return naam;
    }
    public String getKlas() {
        return klas;
    }
    public String getGeslacht() {
        return geslacht;
    }
    public int getNummer() {
        return nummer;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public void setKlas(String klas) {
        this.klas = klas;
    }
    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
    //*************************************************//
    
}
