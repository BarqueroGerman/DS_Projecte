/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Enric Calvo & German Barquero
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({totseries_it1b.Model.ModelSuite.class, totseries_it1b.TotSeries_It1bTest.class, totseries_it1b.Controller.ControllerSuite.class, totseries_it1b.View.ViewSuite.class})
public class Totseries_it1bSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
