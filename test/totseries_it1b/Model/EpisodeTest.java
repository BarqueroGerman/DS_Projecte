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
public class EpisodeTest {
    
    public EpisodeTest() {
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
     * Test of addView method, of class Episode.
     */
    @Test
    public void testAddView() {
        System.out.println("addView");
        View v = null;
        Episode instance = null;
        instance.addView(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRating method, of class Episode.
     */
    @Test
    public void testUpdateRating() {
        System.out.println("updateRating");
        Rating r = null;
        Episode instance = null;
        instance.updateRating(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNumber method, of class Episode.
     */
    @Test
    public void testCheckNumber() {
        System.out.println("checkNumber");
        int n = 0;
        Episode instance = null;
        boolean expResult = false;
        boolean result = instance.checkNumber(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Episode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Episode instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
