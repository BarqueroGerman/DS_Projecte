/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TotSeriesTest {
    
    public TotSeriesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addClient method, of class TotSeries.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        Client c = null;
        TotSeries instance = new TotSeries();
        boolean expResult = false;
        boolean result = instance.addClient(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUsernameAvailable method, of class TotSeries.
     */
    @Test
    public void testIsUsernameAvailable() {
        System.out.println("isUsernameAvailable");
        String username = "";
        TotSeries instance = new TotSeries();
        boolean expResult = false;
        boolean result = instance.isUsernameAvailable(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCatalog method, of class TotSeries.
     */
    @Test
    public void testGetCatalog() {
        System.out.println("getCatalog");
        TotSeries instance = new TotSeries();
        Catalog expResult = null;
        Catalog result = instance.getCatalog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
