/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Rankings;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public abstract class AbstractRankingPanel extends javax.swing.JPanel implements Observer {

    private int count = 0;

    /**
     * Creates new form RankingPanel
     */
    public AbstractRankingPanel() {
        initComponents();
        model = new DefaultListModel();
        linkToObservable();
        load();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topContainer = new javax.swing.JPanel();
        bottomContainer = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(965, 800));

        topContainer.setBackground(new java.awt.Color(255, 255, 255));

        bottomContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
            .addComponent(bottomContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomContainer;
    private javax.swing.JPanel topContainer;
    // End of variables declaration//GEN-END:variables
    protected DefaultListModel model;

    protected abstract void linkToObservable();

    protected abstract void load();

    @Override
    public void update(Observable o, Object arg) {
        clearRanking();
        load();
    }

    protected void clearRanking() {
        count = 0;
        bottomContainer.removeAll();
        topContainer.removeAll();
    }

    protected void addPanelToRanking(JPanel panel) {
        if (count < 5) {
            topContainer.add(panel);
            count++;
        } else if (count < 10) {
            bottomContainer.add(panel);
            count++;
        }
    }
}
