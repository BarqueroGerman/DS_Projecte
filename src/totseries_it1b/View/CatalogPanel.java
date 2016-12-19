/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.util.ArrayList;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class CatalogPanel extends javax.swing.JPanel {
    TSController ctrl;
    ArrayList<SeriePanel> seriesPanels;
    /**
     * Creates new form CatalogPanel
     */
    public CatalogPanel() {
        initComponents();
        ctrl = TSController.getInstance();
        seriesPanels = new ArrayList<SeriePanel>();
        for(String[] serie:ctrl.getInfoSeries()){
            SeriePanel panel = new SeriePanel(serie[0],serie[1]);
            seriesPanels.add(panel);
        }updateSeries(0,9);
        
    }
    
    public void setTitleSerie(int i){
        seriesPanels.get(i);
    }
    
    public void updateSeries(int from, int to){
        boolean done = false;
        int iter = 0;
        int limit = to-from;
        while(!done && iter<5){
            if(limit==iter) done = true;
            series1_5Panel.add(seriesPanels.get(iter));
            iter++;
        }if(!done){
            while(!done && iter<10){
                if(limit==iter) done = true;
                series6_10Panel.add(seriesPanels.get(iter));
                iter++;
            }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        series1_5Panel = new javax.swing.JPanel();
        series6_10Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        series1_5Panel.setBackground(new java.awt.Color(255, 255, 255));
        series1_5Panel.setPreferredSize(new java.awt.Dimension(891, 290));

        series6_10Panel.setBackground(new java.awt.Color(255, 255, 255));
        series6_10Panel.setPreferredSize(new java.awt.Dimension(891, 260));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/ecalvove7.alumnes/Escriptori/arrowL.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/ecalvove7.alumnes/Escriptori/arrowR.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(series6_10Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                    .addComponent(series1_5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(series1_5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(series6_10Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel series1_5Panel;
    private javax.swing.JPanel series6_10Panel;
    // End of variables declaration//GEN-END:variables
}
