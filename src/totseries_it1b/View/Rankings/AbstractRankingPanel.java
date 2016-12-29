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

        setPreferredSize(new java.awt.Dimension(965, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bottomContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(topContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bottomContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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
        model.clear();
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