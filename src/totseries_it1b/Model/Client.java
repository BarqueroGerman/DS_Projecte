/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class Client extends User {
    private static int id = 0;
    private String nationality;
    private Date birthdate;
    private String creditCard;
    private String address;
    
    private ArrayList<View> views;
    
    public Client(String id, String user, String pass, String name, String nationality, Date birthdate){
        super(id, name, user, pass);
        this.nationality = nationality;
        this.birthdate = birthdate;
        views = new ArrayList<View>();
    }
    
    public Client(String user, String pass, String name, String nationality, Date birthdate){
        super(Integer.toString(id), name, user, pass);
        this.nationality = nationality;
        this.birthdate = birthdate;
        views = new ArrayList<View>();
        id += 1;
    }
    
    public void addView(View v){
        views.add(v);
        v.setClient(this);
    }
}
