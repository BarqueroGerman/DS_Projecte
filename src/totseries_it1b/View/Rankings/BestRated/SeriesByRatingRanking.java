/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.BestRated;

import java.util.Observable;
import totseries_it1b.Controller.TSController;
import totseries_it1b.View.Rankings.AbstractRankingPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeriesByRatingRanking extends AbstractRankingPanel {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(284, 487));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    protected void load() {
        for (String[] serie : TSController.getInstance().getBestRatedSeries()) {
            addElementToRanking(serie);
        }
    }

    private void addElementToRanking(String[] serie) {
        SerieRatingPanel panel = new SerieRatingPanel(serie[0], serie[1], Double.parseDouble(serie[3]));
        addPanelToRanking(panel);
    }

    @Override
    protected void linkToObservable() {
        TSController.getInstance().linkBestRatedSeriesRanking(this);
    }
}