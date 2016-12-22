/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Factories;

import totseries_it1b.Model.Season;
import totseries_it1b.Model.Serie;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeasonFactory extends AbstractFactory {

    public Season create(Serie serie, int num) {
        return new Season(serie, num);
    }
}
