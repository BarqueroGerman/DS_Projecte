/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Rankings;

import totseries_it1b.Model.Episode;

/**
 * Classe que representa el TOP X dels episodis millor valorats de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class BestRatedEpisodes extends Ranking {

    public BestRatedEpisodes(int num) {
        super(num);
    }

    protected Object getHigherElement(Object obj1, Object obj2) {
        Episode ep1 = (Episode) obj1;
        Episode ep2 = (Episode) obj2;
        if (ep1.getRatingAverage() > ep2.getRatingAverage()) {
            return ep1;
        } else if (ep1.getRatingAverage() < ep2.getRatingAverage()) {
            return ep2;
        }
        return null;
    }

}
