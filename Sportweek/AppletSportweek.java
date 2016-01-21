package Sportweek;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletSportweek extends Applet {
    
	private Leerling leerling1;
    private Leerling leerling2;
    private Leerling leerling3;
    private Leerling leerling4;
    private Team team1;
    private Team team2;
    private Wedstrijd wedstrijd;
    
    public void init() {
    	setSize(400, 600);
    	leerling1 = new Leerling("Hendrik de Bruijn", "MMVAOO5A", "m", 84631, new Datum(15, 4, 1948));
        leerling2 = new Leerling("Kees den Uijl", "MMVAOO5A", "m", 84669, new Datum(22, 8, 1951));
        team1 = new Team("De Boerenjongens", leerling1, leerling2);
        
        leerling3 = new Leerling("Melissa Barendse", "MMVAOO5B", "v", 84735, new Datum(1, 4, 1949));
        leerling4 = new Leerling("Stefan Verkerk", "MMVAOO5B", "m", 84767, new Datum(9, 10, 1952));
        team2 = new Team("De Pannenkoekjes", leerling3, leerling4);
        
        for (int i = 0; i < 14; i++) {team1.addScore();}
        for (int i = 0; i < 8; i++) {team2.addScore();}
        wedstrijd = new Wedstrijd(team1, team2, new Datum(18, 12, 1967));
    }
    
    public void paint(Graphics g) {
    	g.drawString("Datum wedstrijd: "+wedstrijd.getDatum(), 20, 20);
    	g.drawString("Spelers van "+team1+":", 20, 60);
    	g.drawString("- "+leerling1.getNaam(), 20, 80);
    	g.drawString("- "+leerling2.getNaam(), 20, 100);
    	g.drawString("Spelers van "+team2+":", 20, 140);
    	g.drawString("- "+leerling3.getNaam(), 20, 160);
    	g.drawString("- "+leerling4.getNaam(), 20, 180);
    	g.drawString("Uitslag: "+wedstrijd.getUitslag(), 20, 220);
    }
    
}