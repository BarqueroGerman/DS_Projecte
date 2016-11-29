/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.Calendar;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class VIPClient extends Client {
    
    public VIPClient(String id, String user, String pass, String name){
        super(id, user, pass, name);
    }
    
    public VIPClient(String user, String pass, String name, String nationality, Calendar birthdate){
        super(user, pass, name, nationality, birthdate);
    }
    
}
