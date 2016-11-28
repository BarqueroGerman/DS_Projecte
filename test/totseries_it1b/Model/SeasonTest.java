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
public class SeasonTest {
    
    public SeasonTest() {
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
     * Test of getEpisodeByNumber method, of class Season.
     */
    @Test
    public void testGetEpisodeByNumber() {
        System.out.println("getEpisodeByNumber");
        int n = 0;
        Season instance = null;
        Episode expResult = null;
        Episode result = instance.getEpisodeByNumber(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNumber method, of class Season.
     */
    @Test
    public void testCheckNumber() {
        System.out.println("checkNumber");
        int n = 0;
        Season instance = null;
        boolean expResult = false;
        boolean result = instance.checkNumber(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Season.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Season instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
