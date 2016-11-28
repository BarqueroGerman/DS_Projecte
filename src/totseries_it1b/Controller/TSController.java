/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import edu.ub.informatica.disseny.totseries.Consola;
import java.util.Calendar;
import totseries_it1b.Model.*;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TSController {
    private Consola console;
    /**
     * Database
     */
    private TotSeries totSeries;
    /**
     * Client in session.
     */
    private Client client;
    
    public TSController(){
        totSeries = new TotSeries();
        console = new Consola();
    }
    
    public TSController(TotSeries ts){
        this.totSeries = ts;
    }
    
    public boolean createClient(){
        String username, pass, name, nationality, dateString;
        Calendar birthdate = Calendar.getInstance();
        
        username = console.llegeixString();
        pass = console.llegeixString();
        name = console.llegeixString();
        nationality = console.llegeixString();
        dateString = console.llegeixString();
        
        // Crear birthdate
        //client = new Client(totSeries, username, pass, name, nationality, birthdate);
        return false;
    }
    
    public void consultCatalog(){
        
    }
    
    public void visualizeEpisode(){
        
    }
    
    public boolean login(){
        return false;
    }
    
    public void setClientVIP(Client v, boolean VIP){
        
    }
    
    public View createView(Client c, Episode e){
        return null;
    }
}
