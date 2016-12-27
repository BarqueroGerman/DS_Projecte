/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author ecalvove7.alumnes
 */
public class SeriePanel extends ParentPanel {

    public SeriePanel(String title, String id, boolean read) {
        super(title,id,read);
    }

   /* public void prova(String toAdd) {
        JLabel label = new JLabel(toAdd);
        prova.add(label);
        label.setVisible(true);
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(157, 234));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

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
    protected void formMouseEntered(java.awt.event.MouseEvent evt) {                                  
        if (!readOnly) {
            this.setSize(this.getWidth() - 10, this.getHeight() - 10);
            this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            titlePanel.setLocation(titlePanel.getX() - 5, titlePanel.getY() - 10);
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
    }
    protected void formMouseExited(java.awt.event.MouseEvent evt) {                                 
        if (!readOnly) {
            this.setSize(this.getWidth() + 10, this.getHeight() + 10);
            titlePanel.setLocation(titlePanel.getX() + 5, titlePanel.getY() + 10);
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }    
    protected void formMouseClicked(java.awt.event.MouseEvent evt) {                                  
        if (!readOnly) {
            CatalogContainer cat = (CatalogContainer) getParent().getParent().getParent();
            cat.showSeasonCard(title,id);
        }
    }   /*
    
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if (!readOnly) {
            this.setSize(this.getWidth() - 10, this.getHeight() - 10);
            titlePanel.setLocation(titlePanel.getX() - 5, titlePanel.getY() - 10);
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (!readOnly) {
            this.setSize(this.getWidth() + 10, this.getHeight() + 10);
            titlePanel.setLocation(titlePanel.getX() + 5, titlePanel.getY() + 10);
            this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (!readOnly) {
            CardLayout card = (CardLayout) getParent().getParent().getParent().getLayout();
            card.show(getParent().getParent().getParent(), "seasons");
            ((CatalogContainer) (this.getParent().getParent().getParent())).getSeasons().updateSerie(ctrl.getCatalog().getSerieById(id).getTitle(), id);
        }
    }//GEN-LAST:event_formMouseClicked
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
