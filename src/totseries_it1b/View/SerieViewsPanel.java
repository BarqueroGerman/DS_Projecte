/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SerieViewsPanel extends SeriePanel {

    /**
     * Creates new form SerieViewsPanel
     */
    public SerieViewsPanel(String id, String title, int views) {
        super(title, id);
        prova(Integer.toString(views));
    }
}