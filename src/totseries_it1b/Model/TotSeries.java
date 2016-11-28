/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class TotSeries {
    private Catalog catalog;
    private ArrayList<User> users;
    
    public TotSeries(){
        this.catalog = new Catalog(this);
        users = new ArrayList<User>();
    }
    
    public boolean addUser(User u){
        if(isUsernameAvailable(u.getUsername())){
            this.users.add(u);
            return true;
        }
        return false;
    }
    
    public boolean isUsernameAvailable(String username){
        Iterator it = users.iterator();
        boolean found = false;
        
        while(it.hasNext() && !found){
            found = username.equals(((User)it.next()).getUsername());
        }
        return !found;
    }
    
    public Catalog getCatalog(){
        return this.catalog;
    }
}
