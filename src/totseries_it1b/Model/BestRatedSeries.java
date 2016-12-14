/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

/**
 * Classe que representa el TOP X de les series millor valorades de TotSeries.
 *
 * @author Enric Calvo & German Barquero
 */
public class BestRatedSeries extends Ranking {

    private TotSeries totSeries;
    private static BestRatedSeries instance;

    private BestRatedSeries(TotSeries TS, int num) {
        super(num);
        totSeries = TS;
    }

    public static BestRatedSeries getInstance(TotSeries TS, int num) {
        if (instance == null) {
            synchronized (BestRatedEpisodes.class) {
                if (instance == null) {
                    instance = new BestRatedSeries(TS, num);
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
