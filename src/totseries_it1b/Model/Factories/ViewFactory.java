/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.AbstractView;
import totseries_it1b.Model.Client;
import totseries_it1b.Model.Episode;
import totseries_it1b.Model.PhantomView;
import totseries_it1b.Model.User;
import totseries_it1b.Model.View;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class ViewFactory extends AbstractFactory {

    public AbstractView create(Episode e, User c) {
        AbstractView v;
        v = new View();
        e.addView(v);
        c.addView(v);
        return v;
    }

    public AbstractView create(Episode e, User c, boolean fake) {
        AbstractView v;
        if (fake) {
            v = new PhantomView();
        } else {
            v = new View();
        }
        e.addView(v);
        c.addView(v);
        return v;
    }
}
