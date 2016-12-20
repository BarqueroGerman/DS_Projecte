/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.util.Observable;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeriesByViews extends RankingPanel {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    protected void load() {
        for (String[] serie : TSController.getInstance().getMostViewedSeries()) {
            addElementToRanking(serie);
        }
    }

    private void addElementToRanking(String[] serie) {
        SerieViewsPanel panel = new SerieViewsPanel(serie[0], serie[1], Integer.parseInt(serie[2]));
        //SeriePanel panel = new SeriePanel(serie[0], serie[1]);
        addPanelToRanking(panel);
    }

    @Override
    protected void linkToObservable() {
        TSController.getInstance().linkMostViewedSeriesRanking(this);
    }
}
