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
public class UsersList {
    private ArrayList<User> users;
    
    public UsersList(){
        users = new ArrayList<>();
    }
    
    public User getByUsername(String username){
        User user = null;
        Iterator it = users.iterator();
        boolean found = false;
        
        while(it.hasNext() && !found){
            user = ((User)it.next());
            found = username.equals(user.getUsername());
        }
        return user;
    }
    
    public int size(){
        return this.users.size();
    }
    
    public void add(User u){
        this.users.add(u);
    }
}
