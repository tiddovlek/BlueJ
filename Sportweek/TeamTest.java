package Sportweek;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TeamTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TeamTest
{
    
    private Leerling leerling1;
    private Leerling leerling2;
    private Leerling leerling3;
    private Leerling leerling4;
    private Team team1;
    private Team team2;
    private Wedstrijd wedstrijd;
    
    /**
     * Default constructor for test class TeamTest
     */
    public TeamTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
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

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
}