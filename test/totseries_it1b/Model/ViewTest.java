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
public class ViewTest {
    
    public ViewTest() {
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
     * Test of setRate method, of class View.
     */
    @Test
    public void testSetRate_int() {
        System.out.println("setRate");
        int rate = 0;
        View instance = new View();
        instance.setRate(rate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class View.
     */
    @Test
    public void testSetRate_Rating() {
        System.out.println("setRate");
        Rating rating = null;
        View instance = new View();
        instance.setRate(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClient method, of class View.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        Client c = null;
        View instance = new View();
        instance.setClient(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEpisode method, of class View.
     */
    @Test
    public void testSetEpisode() {
        System.out.println("setEpisode");
        Episode e = null;
        View instance = new View();
        instance.setEpisode(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
