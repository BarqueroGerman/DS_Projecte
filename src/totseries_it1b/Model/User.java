/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public abstract class User {
    protected String id;
    private String name;
    protected String username;
    protected String password;
    
    public User(String id, String name, String username, String pass){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = pass;
    }
    
    public boolean compareUsername(String u){
        return u.equals(this.username);
    }
    
    public String getUsername(){
        return this.username;
    }
}
