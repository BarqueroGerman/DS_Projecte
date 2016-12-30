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
public abstract class User {

    protected String id;
    protected String name;
    protected String username;
    protected String password;

    protected ArrayList<AbstractView> views;

    public User(String id, String name, String username, String pass) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = pass;

        views = new ArrayList<AbstractView>();
    }

    public boolean compareUsername(String u) {
        return u.equals(this.username);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public void addView(AbstractView v) {
        views.add(v);
        v.setUser(this);
    }

    public AbstractView findViewById(int viewId) {
        boolean found = false;
        Iterator it = views.iterator();
        AbstractView v = null;
        while (!found && it.hasNext()) {
            v = (AbstractView) it.next();
            if (v.checkId(viewId)) {
                found = true;
            }
        }
        return v;
    }
}
