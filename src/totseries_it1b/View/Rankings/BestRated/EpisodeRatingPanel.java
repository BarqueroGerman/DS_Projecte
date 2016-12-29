/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.BestRated;

import totseries_it1b.View.BasicPanels.EpisodePanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class EpisodeRatingPanel extends EpisodePanel {

    public EpisodeRatingPanel(String id, String title, int num, String info, String desc, int numSeason, double rating) {
        super(id, num, info, desc, true, numSeason);
    }
}
