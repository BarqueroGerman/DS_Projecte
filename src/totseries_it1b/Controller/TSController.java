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
    
    public boolean createClient(String username, String pass, String name, String nationality, Calendar birthdate){
        boolean added = false;
        if(totSeries.isUsernameAvailable(username)){
            client = new Client(username, pass, name, nationality, birthdate);
            added = totSeries.addUser(client);
        }
        return added;
    }
    
    public void consultCatalog(){
        System.out.println("Heu consultat el ");
    }
    
    public void visualizeEpisode(){
        
    }
    
    public boolean usernameExists(String user){
        if(totSeries.correctUsername(user) == null){
            return false;
        } else {
            return true;
        }
    }
    
    public boolean correctPassword(String user, String password){
        String pass = totSeries.correctUsername(user).getPassword();
        if(pass.equals(password)){
            return true;
        } else {
            return false;
        }
    }
    public void setClientVIP(Client v, boolean VIP){
        
    }
    
    public View createView(Client c, Episode e){
        return null;
    }
    
    public boolean isLogged(){
        return client != null;
    }
}
