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
    private UsersList userslist;
    
    public TotSeries(){
        this.catalog = new Catalog(this);
        userslist = new UsersList();
    }
    
    public boolean isUsernameAvailable(String username){
        return userslist.getByUsername(username) == null;
    }
    
    public boolean addUser(User u){
        if(isUsernameAvailable(u.getUsername())){
            this.userslist.add(u);
            return true;
        }
        return false;
    }
    
    public Catalog getCatalog(){
        return this.catalog;
    }
}
