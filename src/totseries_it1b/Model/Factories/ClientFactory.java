/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import java.util.Calendar;
import totseries_it1b.Model.Client;
import totseries_it1b.Model.VIPClient;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class ClientFactory extends AbstractFactory {

    public Client create(String id, String name, String user, String pass, boolean vip) {
        if (vip) {
            return new VIPClient(id, name, user, pass);
        } else {
            return new Client(id, name, user, pass);
        }
    }

    public Client create(String username, String pass, String name, String nationality, Calendar birthdate, boolean vip) {
        if (vip) {
            return new VIPClient(username, pass, name, nationality, birthdate);
        } else {
            return new Client(username, pass, name, nationality, birthdate);
        }
    }
}
