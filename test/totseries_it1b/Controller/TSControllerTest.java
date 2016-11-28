/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import totseries_it1b.Model.Client;
import totseries_it1b.Model.Episode;
import totseries_it1b.Model.View;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TSControllerTest {
    
    public TSControllerTest() {
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
     * Test of createClient method, of class TSController.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        TSController instance = new TSController();
        boolean expResult = false;
        boolean result = instance.createClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultCatalog method, of class TSController.
     */
    @Test
    public void testConsultCatalog() {
        System.out.println("consultCatalog");
        TSController instance = new TSController();
        instance.consultCatalog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizeEpisode method, of class TSController.
     */
    @Test
    public void testVisualizeEpisode() {
        System.out.println("visualizeEpisode");
        TSController instance = new TSController();
        instance.visualizeEpisode();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class TSController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        TSController instance = new TSController();
        boolean expResult = false;
        boolean result = instance.login();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientVIP method, of class TSController.
     */
    @Test
    public void testSetClientVIP() {
        System.out.println("setClientVIP");
        Client v = null;
        boolean VIP = false;
        TSController instance = new TSController();
        instance.setClientVIP(v, VIP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createView method, of class TSController.
     */
    @Test
    public void testCreateView() {
        System.out.println("createView");
        Client c = null;
        Episode e = null;
        TSController instance = new TSController();
        View expResult = null;
        View result = instance.createView(c, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
