/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b;

import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;
import totseries_it1b.Controller.TSController;
import totseries_it1b.Model.TotSeries;
import totseries_it1b.View.TSMenu;

/**
 *
 * @author German
 */
public class TotSeries_It1b {
    private final static String xmlFilename = "data/TotSeries.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // We initialize our database
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades(xmlFilename);
        
        TSController ctrl = new TSController(dataManager.getTotSeries());
        // We show the main menu
        TSMenu menu = new TSMenu(ctrl);
        menu.init();
    }
    
}
