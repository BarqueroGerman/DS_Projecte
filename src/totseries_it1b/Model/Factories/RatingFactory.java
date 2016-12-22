/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Rating;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class RatingFactory extends AbstractFactory {

    public Rating create(int value) {
        return new Rating(value);
    }
}
