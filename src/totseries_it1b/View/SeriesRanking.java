/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import javax.swing.JPanel;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeriesRanking extends JPanel {

    /**
     * Creates new form SeriesRankings
     */
    public SeriesRanking() {
        initComponents();

        byViews = new SeriesByViews();
        byRating = new SeriesByRating();
        this.add(byViews);
        this.add(byRating);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private SeriesByViews byViews;
    private SeriesByRating byRating;
}
