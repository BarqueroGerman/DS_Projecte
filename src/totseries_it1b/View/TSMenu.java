/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import edu.ub.informatica.disseny.totseries.Consola;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TSMenu {
    private TSController ctrl;
    private Consola console;
    
    public TSMenu(){
        ctrl = new TSController();
    }
    
    public TSMenu(TSController ctrl){
        this.ctrl = ctrl;
    }
    
    public void show(){
        console.escriu("Welcome to TotSeries. Select an option, please:"
                + "\n(1)Login"
                + "\n(2)Register"
                + "\n(3)Consult catalog");
    }
}
