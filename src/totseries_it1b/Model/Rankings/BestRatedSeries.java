/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Rankings;

import totseries_it1b.Model.Serie;

/**
 * Classe que representa el TOP X de les series millor valorades de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class BestRatedSeries extends Ranking {

    public BestRatedSeries(int num) {
        super(num);
    }

    protected Serie getHigherElement(Object obj1, Object obj2) {
        Serie s1 = (Serie) obj1;
        Serie s2 = (Serie) obj2;
        if (s1.getRatingAverage() > s2.getRatingAverage()) {
            return s1;
        } else if (s1.getRatingAverage() < s2.getRatingAverage()) {
            return s2;
        }
        return null;
    }

}