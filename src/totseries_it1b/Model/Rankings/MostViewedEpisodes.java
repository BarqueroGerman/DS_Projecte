/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Rankings;

import totseries_it1b.Model.Episode;

/**
 * Classe que representa el TOP X de les series més vistes de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class MostViewedEpisodes extends Ranking {

    public MostViewedEpisodes(int num) {
        super(num);
    }

    protected Episode getHigherElement(Object obj1, Object obj2) {
        Episode e1 = (Episode) obj1;
        Episode e2 = (Episode) obj2;
        if (e1.getViewsCount() > e2.getViewsCount()) {
            return e1;
        } else if (e1.getViewsCount() < e2.getViewsCount()) {
            return e2;
        }
        return null;
    }

}
