/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.util.Observable;
import javax.swing.DefaultListModel;
import totseries_it1b.Controller.TSController;
import totseries_it1b.Model.Ranking;
import totseries_it1b.Model.Serie;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeriesByViews extends RankingPanel {

    public SeriesByViews() {
        super(TSController.getInstance().getMostViewedSeriesRanking());
    }

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
    public void update(Observable o, Object arg) {
        clearRanking();
        load((Ranking) o);
    }

    @Override
    protected void load(Ranking ranking) {
        for (Object obj : ranking) {
            addElementToRanking(obj);
        }
    }

    @Override
    protected void addElementToRanking(Object obj) {
        model.addElement((Serie) obj);
    }
}
