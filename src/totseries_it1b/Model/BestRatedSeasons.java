/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class BestRatedSeasons extends Ranking {

    public BestRatedSeasons(int num) {
        super(num);
    }

    protected Season getHigherElement(Object obj1, Object obj2) {
        Season s1 = (Season) obj1;
        Season s2 = (Season) obj2;
        if (s1.getRatingAverage() > s2.getRatingAverage()) {
            return s1;
        } else if (s1.getRatingAverage() < s2.getRatingAverage()) {
            return s2;
        }
        return null;
    }

}
