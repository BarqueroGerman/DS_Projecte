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

    public EpisodeRatingPanel(String serieid, int num, String title, String desc, int numSeason, double rating) {
        super(serieid, num, title, desc, true, numSeason);
    }
}