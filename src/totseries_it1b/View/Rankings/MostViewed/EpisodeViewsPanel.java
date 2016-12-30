/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.MostViewed;

import totseries_it1b.View.Rankings.BestRated.*;
import totseries_it1b.View.BasicPanels.EpisodePanel;
import totseries_it1b.View.BasicPanels.ViewsPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class EpisodeViewsPanel extends EpisodePanel {

    private int views;

    public EpisodeViewsPanel(String serieid, String serieTitle, int num, String title, String desc, int numSeason, int views) {
        super(serieid, serieTitle, num, title, desc, true, numSeason);
        addViewsToPanel(views);
        this.views = views;
    }

    private void addViewsToPanel(int views) {
        ViewsPanel panel = new ViewsPanel(views);
        panel.setBounds(0, 0, 155, 30);
        infoPanelContainer.add(panel, new Integer(1));
        panel.setVisible(true);
    }
}
