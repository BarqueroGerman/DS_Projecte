/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.awt.CardLayout;
import totseries_it1b.Model.Serie;

/**
 *
 * @author ecalvove7.alumnes
 */
public class SeriePanel extends javax.swing.JPanel {
    String id;
    /**
     * Creates new form SeriePanel
     */
    public SeriePanel(String title,String id) {
        initComponents();
        titleSerie.setText(title);
        this.id = id;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serieContainer = new javax.swing.JPanel();
        titleSerie = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serieContainer.setBackground(new java.awt.Color(51, 51, 51));
        serieContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                serieContainerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                serieContainerMouseExited(evt);
            }
        });

        titleSerie.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        titleSerie.setForeground(new java.awt.Color(255, 255, 255));
        titleSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSerie.setText("jLabel1");

        javax.swing.GroupLayout serieContainerLayout = new javax.swing.GroupLayout(serieContainer);
        serieContainer.setLayout(serieContainerLayout);
        serieContainerLayout.setHorizontalGroup(
            serieContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );
        serieContainerLayout.setVerticalGroup(
            serieContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleSerie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        add(serieContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 204, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void serieContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serieContainerMouseEntered
    }//GEN-LAST:event_serieContainerMouseEntered

    private void serieContainerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serieContainerMouseExited

    }//GEN-LAST:event_serieContainerMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setSize(this.getWidth()-10,this.getHeight()-10);
        serieContainer.setLocation(serieContainer.getX()-5, serieContainer.getY()-10);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setSize(this.getWidth()+10,this.getHeight()+10);        
        serieContainer.setLocation(serieContainer.getX()+5, serieContainer.getY()+10);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        CardLayout card = (CardLayout)getParent().getParent().getParent().getLayout();
        card.show(getParent().getParent().getParent(), "seasons");
    }//GEN-LAST:event_formMouseClicked
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel serieContainer;
    private javax.swing.JLabel titleSerie;
    // End of variables declaration//GEN-END:variables
}
