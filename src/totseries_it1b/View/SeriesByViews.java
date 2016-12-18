/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.util.Observable;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SeriesByViews extends RankingPanel {

    public SeriesByViews() {
        super(new Observable());
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO
        addElementToRanking();
    }

        
                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
