/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Admin;
import totseries_it1b.Model.User;

/**
 *
 * @author gbarquga9.alumnes
 */
public class UserFactory extends AbstractFactory {

    public User getAdmin() {
        return new Admin("id", "German", "Gershel", "a1a2a3a4");
    }
}
