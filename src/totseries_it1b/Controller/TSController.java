/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Controller;

import totseries_it1b.Model.*;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TSController {
    private TotSeries totSeries;
    
    public TSController(){
        totSeries = new TotSeries();
    }
    
    public TSController(TotSeries ts){
        this.totSeries = ts;
    }
    
    public boolean createClient(){
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
