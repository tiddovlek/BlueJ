

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BankTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BankTest
{
    private Bank bank;

    /**
     * Default constructor for test class BankTest
     */
    public BankTest()
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
        bank = new Bank("ABN");
        bank.addRekening(new Bankrekening(396729439, "Piet Verkerk", 310.20));
        bank.addRekening(new Bankrekening(963013948, "Kees de Lange", 647.37));
        bank.addRekening(new Bankrekening(295783758, "Lisa Fleur", 12.26));
        bank.addRekening(new Bankrekening(494727219, "Jaap van der Pet", 108.04));
        bank.addRekening(new Bankrekening(582753923, "Rosalinde Spinnewiel", 2303.38));
        bank.printOverzicht();
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
