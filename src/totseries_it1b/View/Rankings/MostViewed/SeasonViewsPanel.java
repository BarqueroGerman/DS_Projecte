/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.MostViewed;

import javax.swing.JLabel;
import totseries_it1b.View.BasicPanels.SeasonPanel;
import totseries_it1b.View.BasicPanels.ViewsPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeasonViewsPanel extends SeasonPanel {

    private int views;

    public SeasonViewsPanel(String serieid, int num, int views) {
        super(serieid, num, true);
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
