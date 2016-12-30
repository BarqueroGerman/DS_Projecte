/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Rankings;

import totseries_it1b.Model.Season;

/**
 * Classe que representa el TOP X de les series més vistes de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class MostViewedSeasons extends Ranking {

    public MostViewedSeasons(int num) {
        super(num);
    }

    protected Season getHigherElement(Object obj1, Object obj2) {
        Season s1 = (Season) obj1;
        Season s2 = (Season) obj2;
        if (s1.getTotalViews() > s2.getTotalViews()) {
            return s1;
        } else if (s1.getTotalViews() < s2.getTotalViews()) {
            return s2;
        }
        return null;
    }

}
