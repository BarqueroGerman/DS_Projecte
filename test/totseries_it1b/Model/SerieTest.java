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
public class SerieTest {
    
    public SerieTest() {
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
     * Test of getSeasonByNumber method, of class Serie.
     */
    @Test
    public void testGetSeasonByNumber() {
        System.out.println("getSeasonByNumber");
        int id = 0;
        Serie instance = null;
        Season expResult = null;
        Season result = instance.getSeasonByNumber(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkId method, of class Serie.
     */
    @Test
    public void testCheckId() {
        System.out.println("checkId");
        int id = 0;
        Serie instance = null;
        boolean expResult = false;
        boolean result = instance.checkId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Serie.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Serie instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
