/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.MostViewed;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout.Constraints;
import totseries_it1b.View.BasicPanels.SeriePanel;
import totseries_it1b.View.BasicPanels.ViewsPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SerieViewsPanel extends SeriePanel {

    private int views;

    /**
     * Creates new form SerieViewsPanel
     */
    public SerieViewsPanel(String id, String title, int views) {
        super(id, title, true);
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
