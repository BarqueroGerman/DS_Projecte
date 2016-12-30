/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.Catalog;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import totseries_it1b.Controller.TSController;
import totseries_it1b.View.BasicPanels.EpisodePanel;
import totseries_it1b.View.BasicPanels.SeasonPanel;
import totseries_it1b.View.BasicPanels.SeriePanel;

/**
 *
 * @author enric
 */
public class SeasonsAndEpisodes extends javax.swing.JPanel {

    /**
     * Creates new form seasonEpisodes
     */
    ArrayList<EpisodePanel> episodesPanels;
    ArrayList<SeasonPanel> seasonsPanels;
    TSController ctrl;
    int activeCard = 0;
    int numSeason;
    String title;
    String id;

    public SeasonsAndEpisodes() {
        initComponents();
        ctrl = TSController.getInstance();
    }

    public void updateSerie(String title, String id) {
        this.title = title;
        this.id = id;
        CardLayout card = (CardLayout) seasonsAndEpisodesContainer.getLayout();
        card.show(seasonsAndEpisodesContainer, "seasons");
        activeCard = 0;
        serieDescription.setText(ctrl.getDescriptionSerie(id));
        numberSeasonLabel.setText(title);
        directorNameLabel.setText(ctrl.getDirector(id));
        producerNameLabel.setText(ctrl.getProducer(id));
        mainSeriePanel.removeAll();
        mainSeriePanel.add(new SeriePanel(id, title, true));
        seasonsPanels = new ArrayList<SeasonPanel>();
        for (String[] season : ctrl.getInfoSeasonsBySerieId(id)) {            
            SeasonPanel panel = new SeasonPanel(season[0], title, Integer.parseInt(season[2]), false);
            seasonsPanels.add(panel);
        }
        updateSeason();
    }

    public void updateEpisode(String title, String id, int numEp, String inforEpisode, String description, int numSeason) {
        this.title = title;
        this.id = id;
        CardLayout card = (CardLayout) seasonsAndEpisodesContainer.getLayout();
        card.show(seasonsAndEpisodesContainer, "watch");
        activeCard = 1;
        serieDescription.setText(ctrl.getDescriptionSerie(id));
        numberSeasonLabel.setText(title);
        directorNameLabel.setText(ctrl.getDirector(id));
        producerNameLabel.setText(ctrl.getProducer(id));
        mainSeriePanel.removeAll();
        mainSeriePanel.add(new SeasonPanel(id, title, numSeason, false, true));
        watchEpisode1.updateEpisode(id, title, numSeason, numEp, inforEpisode, description);
        this.numSeason = numSeason;
    }

    public void updateSeason() {
        seasonsPanel1.removeAll();        
        for (SeasonPanel panel : seasonsPanels){            
            seasonsPanel1.add(panel);
        }
    }

    public void updateSeason(String title, String id, int num) {
        this.title = title;
        this.id = id;
        CardLayout card = (CardLayout) seasonsAndEpisodesContainer.getLayout();
        card.show(seasonsAndEpisodesContainer, "episodes");
        activeCard = 2;
        serieDescription.setText(ctrl.getDescriptionSerie(id));
        numberSeasonLabel.setText("SEASON " + Integer.toString(num));
        directorNameLabel.setText(ctrl.getDirector(id));
        producerNameLabel.setText(ctrl.getProducer(id));
        mainSeriePanel.removeAll();
        mainSeriePanel.add(new SeriePanel(id, title, false));
        episodesPanels = new ArrayList<EpisodePanel>();
        for (String[] episode : ctrl.getInfoEpisodesBySeasonId(id, num)) {
            EpisodePanel panel = new EpisodePanel(episode[0], title, Integer.parseInt(episode[4]), episode[3], episode[5], false, num);
            episodesPanels.add(panel);
        }
        updateEpisode(episodesPanels);
    }

    public void updateEpisode(ArrayList<EpisodePanel> episodesPanels) {
        episodesPanel1.removeAll();
        for (EpisodePanel panel : episodesPanels) {
            episodesPanel1.add(panel);
        }
    }

    public JPanel getSeasonsAndEoisodesContainer() {
        return seasonsAndEpisodesContainer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainSeriePanel = new javax.swing.JPanel();
        seasonsAndEpisodesContainer = new javax.swing.JPanel();
        seasonsPanel1 = new totseries_it1b.View.Catalog.SeasonsPanel();
        watchEpisode1 = new totseries_it1b.View.Catalog.WatchEpisode();
        episodesPanel1 = new totseries_it1b.View.Catalog.EpisodesPanel();
        numberSeasonLabel = new javax.swing.JLabel();
        serieDescription = new javax.swing.JTextPane();
        directorLabel = new javax.swing.JLabel();
        directorNameLabel = new javax.swing.JLabel();
        producerLabel = new javax.swing.JLabel();
        producerNameLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 637));

        mainSeriePanel.setBackground(new java.awt.Color(255, 255, 255));
        mainSeriePanel.setPreferredSize(new java.awt.Dimension(160, 240));

        seasonsAndEpisodesContainer.setBackground(new java.awt.Color(255, 255, 255));
        seasonsAndEpisodesContainer.setLayout(new java.awt.CardLayout());
        seasonsAndEpisodesContainer.add(seasonsPanel1, "seasons");
        seasonsAndEpisodesContainer.add(watchEpisode1, "watch");
        seasonsAndEpisodesContainer.add(episodesPanel1, "episodes");

        numberSeasonLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        numberSeasonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberSeasonLabel.setText("SEASON NUMBER");

        serieDescription.setEditable(false);
        serieDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        serieDescription.setOpaque(false);

        directorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        directorLabel.setText("Director:");

        directorNameLabel.setText("jLabel2");

        producerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        producerLabel.setText("Producer:");

        producerNameLabel.setText("jLabel2");

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(seasonsAndEpisodesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainSeriePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(serieDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(producerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(directorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(directorNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(producerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(numberSeasonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addGap(8, 8, 8)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(mainSeriePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(numberSeasonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(backButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serieDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(directorLabel)
                            .addComponent(directorNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(producerLabel)
                            .addComponent(producerNameLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(seasonsAndEpisodesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CatalogContainer cat = (CatalogContainer)getParent();
        switch(activeCard){
            case 0:
                cat.showCatalogCard();
                break;
            case 1:
                cat.showEpisodeCard(title, id, numSeason);
                break;
            case 2:
                cat.showSeasonCard(title, id);
                break;
        }
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel directorLabel;
    private javax.swing.JLabel directorNameLabel;
    private totseries_it1b.View.Catalog.EpisodesPanel episodesPanel1;
    private javax.swing.JPanel mainSeriePanel;
    private javax.swing.JLabel numberSeasonLabel;
    private javax.swing.JLabel producerLabel;
    private javax.swing.JLabel producerNameLabel;
    private javax.swing.JPanel seasonsAndEpisodesContainer;
    private totseries_it1b.View.Catalog.SeasonsPanel seasonsPanel1;
    private javax.swing.JTextPane serieDescription;
    private totseries_it1b.View.Catalog.WatchEpisode watchEpisode1;
    // End of variables declaration//GEN-END:variables
}
