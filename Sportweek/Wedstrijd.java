package Sportweek;

/**
 * Write a description of class Wedstrijd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wedstrijd {
    
    //attributes
    private Team team1;
    private Team team2;
    private Datum datum;
    
    //Constructor
    public Wedstrijd(Team team1, Team team2, Datum datum) {
        this.team1 = team1;
        this.team2 = team2;
        this.datum = datum;
    }
    
    //******************** methods ********************//
    public void print() {
        System.out.println("Wedstrijd van "+datum+":");
        System.out.println(team1+" "+getUitslag()+" "+team2);
        System.out.println("--------------------------------------------");
    }
    
    public String getTeams() {
        return team1+" - "+team2;
    }
    public String getDatum() {
        return datum.toString();
    }
    public String getUitslag() {
        return String.format("%02d - %02d", team1.getScore(), team2.getScore());
    }
    
    public void setDatum(Datum datum) {
        this.datum = datum;
    }
    public void setUitslag(int score1, int score2) {
    	team1.setScore(score1);
    	team2.setScore(score2);
        getUitslag();
    }
    //*************************************************//
    
}