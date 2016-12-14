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
    private static MostViewedSeries instance;

    private MostViewedSeries(TotSeries TS, int num) {
        super(num);
        totSeries = TS;
    }

    public static MostViewedSeries getInstance(TotSeries TS, int num) {
        if (instance == null) {
            synchronized (BestRatedEpisodes.class) {
                if (instance == null) {
                    instance = new MostViewedSeries(TS, num);
                }
            }
        }
        return instance;
    }

    protected Episode getHigherElement(Object obj1, Object obj2) {
        Serie s1 = (Serie) obj1;
        Serie s2 = (Serie) obj2;
        /*if (s1.getRatingAverage() > s2.getRatingAverage()) {
         return s1;
         } else if (s1.getRatingAverage() < s2.getRatingAverage()) {
         return s2;
         }*/
        return null;
    }

}
