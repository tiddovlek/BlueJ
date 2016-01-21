

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BestellingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BestellingTest
{
    private Bestelling bestelling;
    private Catalogus catalogu1;
    private Artikel artikel1;
    private Artikel artikel2;
    private Artikel artikel3;
    private Artikel artikel4;

    /**
     * Default constructor for test class BestellingTest
     */
    public BestellingTest()
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
        bestelling = new Bestelling();
        catalogu1 = new Catalogus();
        artikel1 = catalogu1.zoek(1);
        artikel2 = catalogu1.zoek(22);
        artikel3 = catalogu1.zoek(333);
        artikel4 = catalogu1.zoek(4444);
        bestelling.voegtoe(artikel1);
        bestelling.voegtoe(artikel2);
        bestelling.voegtoe(artikel3);
        bestelling.voegtoe(artikel4);
        
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
