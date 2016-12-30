/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings.BestRated;

import totseries_it1b.Controller.TSController;
import totseries_it1b.View.Rankings.AbstractRankingPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeasonsByRatingRanking extends AbstractRankingPanel {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
    }// </editor-fold>

    // Variables declaration - do not modify
    // End of variables declaration
    @Override
    protected void load() {
        for (String[] seas : TSController.getInstance().getBestRatedSeasons()) {
            addElementToRanking(seas);
        }
    }

    private void addElementToRanking(String[] seas) {
        SeasonRatingPanel panel = new SeasonRatingPanel(seas[0], seas[1], Integer.parseInt(seas[2]), Double.parseDouble(seas[4]));
        addPanelToRanking(panel);
    }

    @Override
    protected void linkToObservable() {
        TSController.getInstance().linkBestRatedSeasonsRanking(this);
    }
}
