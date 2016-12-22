/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Admin;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class AdminFactory extends AbstractFactory {

    public Admin create(String id, String name, String user, String pass) {
        return new Admin(id, name, user, pass);
    }

}
