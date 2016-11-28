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
    private String nationality;
    private Date birthdate;
    private String creditCard;
    private String address;
    
    private ArrayList<View> views;
    
    public Client(TotSeries ts, String id, String user, String pass, String name, String nationality, String address, Date birthdate){
        super(ts, id, name, user, pass);
        this.nationality = nationality;
        this.address = address;
        this.birthdate = birthdate;
        views = new ArrayList<View>();
    }
    
    public void addView(View v){
        views.add(v);
        v.setClient(this);
    }
}
