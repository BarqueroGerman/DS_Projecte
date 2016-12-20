/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import javax.swing.JLabel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SerieRatingPanel extends SeriePanel {

    /**
     * Creates new form SerieRatingPanel
     */
    public SerieRatingPanel(String id, String title, double rating) {
        super(title, id);
        prova(Double.toString(rating));
    }
}
