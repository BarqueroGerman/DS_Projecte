/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class Client extends User {

    protected static int id = 0;
    protected String nationality;
    protected Calendar birthdate;
    protected String creditCard;
    protected String address;

    private ArrayList<View> views;

    public Client(String id, String user, String pass, String name) {
        super(id, name, user, pass);
        views = new ArrayList<View>();
    }

    public Client(String user, String pass, String name, String nationality, Calendar birthdate) {
        super(Integer.toString(id), name, user, pass);
        this.nationality = nationality;
        this.birthdate = birthdate;
        views = new ArrayList<View>();
        id += 1;
    }

    public void addView(View v) {
        views.add(v);
        v.setClient(this);
    }
}
