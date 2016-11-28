/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.Date;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class VIPClient extends Client {
    
    public VIPClient(TotSeries ts, String id, String user, String pass, String name, String nationality, Date birthdate){
        super(ts, id, user, pass, name, nationality, birthdate);
    }
    
    public VIPClient(TotSeries ts, String user, String pass, String name, String nationality, Date birthdate){
        super(ts, user, pass, name, nationality, birthdate);
    }
    
}
