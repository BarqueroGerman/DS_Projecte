/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;


/**
 *
 * @author enric
 */
public class SeasonPanel extends ParentPanel {

    /**
     * Creates new form SeasonPanel
     */
    public SeasonPanel(String title, String id) {
        super(title, id);
    }
    
    public SeasonPanel(String title, String id, boolean read, int num) {
        super(title, id, read, num);
    }
    
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
            cat.showEpisodeCard(title,id, numSeason);
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