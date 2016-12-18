/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.util.Observable;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeriesByViews extends RankingPanel {

    public SeriesByViews(Observable ranking) {
        super(ranking);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO
        addElementToRanking();
    }

}
