/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.BestRated;

import totseries_it1b.View.BasicPanels.RatingPanel;
import totseries_it1b.View.BasicPanels.SeriePanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SerieRatingPanel extends SeriePanel {

    private double rating;

    /**
     * Creates new form SerieRatingPanel
     */
    public SerieRatingPanel(String id, String title, double rating) {
        super(id, title, true);
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
