/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View.BasicPanels;

/**
 *
 * @author enric
 */
public class RatingStar extends javax.swing.JPanel {

    /**
     * Creates new form RatingStar
     */
    public RatingStar() {
        initComponents();
    }

    public void setOn() {
        starIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/onStar.jpg")));
    }

    public void setOff() {
        starIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/offStar.jpg")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        starIcon = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(50, 50));

        starIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/offStar.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(starIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(starIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel starIcon;
    // End of variables declaration//GEN-END:variables
}
