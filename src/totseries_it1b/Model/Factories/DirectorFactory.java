/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Director;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class DirectorFactory extends AbstractFactory {

    public Director create(int id, String name, String nationality) {
        return new Director(id, name, nationality);
    }
}
