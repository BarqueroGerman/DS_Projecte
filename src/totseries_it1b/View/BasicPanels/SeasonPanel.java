/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.BasicPanels;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import totseries_it1b.Controller.TSController;
import totseries_it1b.View.Catalog.CatalogContainer;

/**
 *
 * @author enric
 */
public class SeasonPanel extends ParentPanel {

    private String serieId;
    private int numSeason;
    private boolean head = false;

    public SeasonPanel(String serieId, String serieTitle, int num, boolean readOnly) {
        super(serieTitle, readOnly);
        this.serieId = serieId;
        numSeason = num;
        initCustomComponents();
    }

    public SeasonPanel(String serieId, String serieTitle, int num, boolean readOnly, boolean head) {
        super(serieTitle, readOnly);
        this.serieId = serieId;
        numSeason = num;
        this.head = head;
        initCustomComponents();
    }

    private void initCustomComponents() {
        String imagePath = TSController.getInstance().getImageBySerieId(serieId);
        if (imagePath != null && !imagePath.equals("")) {
            setBackgroundPanel(new javax.swing.ImageIcon(getClass().getResource(imagePath)));
        }

        // SEASON TITLE
        JPanel seasInfoPanel = new JPanel();
        seasInfoPanel.setBounds(0, 100, 155, 30);
        JLabel label1 = new JLabel("SEASON " + numSeason);
        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        seasInfoPanel.add(label1);
        seasInfoPanel.setBackground(new Color(0, 0, 0, 170));
        infoPanelContainer.add(seasInfoPanel, new Integer(1));
    }

    protected void formMouseClicked(java.awt.event.MouseEvent evt) {
        if (!head) {
            CatalogContainer cat = (CatalogContainer) getParent().getParent().getParent().getParent();
            cat.showEpisodeCard(title, serieId, numSeason);
        } else {
            CatalogContainer cat = (CatalogContainer) getParent().getParent().getParent();
            cat.showEpisodeCard(title, serieId, numSeason);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(157, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
