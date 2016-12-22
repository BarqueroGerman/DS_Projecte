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

    public Client(String id, String name, String user, String pass) {
        super(id, name, user, pass);
    }

    public Client(String user, String pass, String name, String nationality, Calendar birthdate) {
        super(Integer.toString(id), name, user, pass);
        this.nationality = nationality;
        this.birthdate = birthdate;
        id += 1;
    }

    public void addView(AbstractView v) {
        views.add(v);
        v.setUser(this);
    }
}
