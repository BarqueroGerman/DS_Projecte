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
        System.out.println("S'ha creat un usuari");
        return true;
    }
    
    public void consultCatalog(){
        System.out.println("Heu consultat el ");
    }
    
    public void visualizeEpisode(){
        
    }
    
    public boolean login(){
        System.out.println("Us heu registrat");
        return true;

    }
    
    public void setClientVIP(Client v, boolean VIP){
        
    }
    
    public View createView(Client c, Episode e){
        return null;
    }
}
