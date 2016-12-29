/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.BasicPanels;

import totseries_it1b.View.Catalog.CatalogContainer;

/**
 *
 * @author ecalvove7.alumnes
 */
public class EpisodePanel extends ParentPanel {

    private String serieId;
    private int numSeason;
    private int numEpisode;
    private String titleEpisode;
    private String description;

    public EpisodePanel(String serieId, int num, String title, String description, boolean readOnly, int numSeason) {
        super("EPISODE " + num, readOnly);
        this.serieId = serieId;
        this.description = description;
        this.titleEpisode = title;
        this.infoEpisode.setText(titleEpisode);
        this.numEpisode = num;
        this.numSeason = numSeason;
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
        setPreferredSize(new java.awt.Dimension(157, 234));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void formMouseClicked(java.awt.event.MouseEvent evt) {
        CatalogContainer cat = (CatalogContainer) getParent().getParent().getParent().getParent();
        cat.showWatchCard(title, serieId, numEpisode, titleEpisode, description, numSeason);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
