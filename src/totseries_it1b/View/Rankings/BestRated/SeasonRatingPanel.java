/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.BestRated;

import totseries_it1b.View.BasicPanels.EpisodePanel;
import totseries_it1b.View.BasicPanels.RatingPanel;
import totseries_it1b.View.BasicPanels.SeasonPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeasonRatingPanel extends SeasonPanel {

    private double rating;

    public SeasonRatingPanel(String serieid, int num, double rating) {
        super(serieid, num, true);
        addRatingToPanel(rating);
        this.rating = rating;
    }

    private void addRatingToPanel(double rating) {
        RatingPanel panel = new RatingPanel(rating);
        panel.setBounds(0, 0, 155, 30);
        infoPanelContainer.add(panel, new Integer(1));
        panel.setVisible(true);
    }
}
