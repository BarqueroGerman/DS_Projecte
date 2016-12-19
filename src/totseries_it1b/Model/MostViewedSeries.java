/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

/**
 * Classe que representa el TOP X de les series més vistes de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class MostViewedSeries extends Ranking {

    private TotSeries totSeries;

    public MostViewedSeries(TotSeries TS, int num) {
        super(num);
        totSeries = TS;
    }

    protected Serie getHigherElement(Object obj1, Object obj2) {
        Serie s1 = (Serie) obj1;
        Serie s2 = (Serie) obj2;
        if (s1.getTotalViews() > s2.getTotalViews()) {
            return s1;
        } else if (s1.getTotalViews() < s2.getTotalViews()) {
            return s2;
        }
        return null;
    }

}
