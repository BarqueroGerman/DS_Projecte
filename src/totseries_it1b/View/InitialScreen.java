/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import totseries_it1b.Controller.TSController;
import totseries_it1b.Model.Client;
import totseries_it1b.Model.Episode;
import totseries_it1b.Model.Serie;
import totseries_it1b.Model.View;

/**
 *
 * @author ecalvove7.alumnes
 */
public class InitialScreen extends javax.swing.JFrame {

    private static TSController ctrl;
    private final static String xmlFilename = "data/TotSeries.xml";

    /**
     * Creates new form MainMenu
     */
    public InitialScreen(TSController ctrl) {
        this.ctrl = ctrl;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTitle = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        registerLabel1 = new javax.swing.JLabel();
        usernameTextFieldLogin = new javax.swing.JTextField();
        passwordLoginLabel = new javax.swing.JLabel();
        usernameLoginLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordTextFieldLogin = new javax.swing.JPasswordField();
        incorrectLoginLabel = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();
        usernameRegisterLabel = new javax.swing.JLabel();
        passwordRegisterLabel = new javax.swing.JLabel();
        usernameTextFieldRegister = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        passwordTextFieldRegister = new javax.swing.JPasswordField();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainTitle.setFont(new java.awt.Font("Cooper Black", 3, 80)); // NOI18N
        mainTitle.setForeground(new java.awt.Color(255, 255, 255));
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("TotSeries.com");
        getContentPane().add(mainTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1370, 110));

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));

        registerLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel1.setText("Log in");

        passwordLoginLabel.setText("Password");

        usernameLoginLabel.setText("Username");

        loginButton.setBackground(new java.awt.Color(0, 153, 153));
        loginButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Log in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        incorrectLoginLabel.setForeground(new java.awt.Color(204, 0, 0));
        incorrectLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLoginLabel)
                            .addComponent(usernameLoginLabel))
                        .addGap(45, 45, 45)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameTextFieldLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(passwordTextFieldLogin))
                        .addGap(46, 46, 46))
                    .addComponent(incorrectLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLoginLabel)
                    .addComponent(usernameTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLoginLabel)
                    .addComponent(passwordTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incorrectLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addContainerGap())
        );

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 390, 190));

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));

        registerLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setText("Register");

        usernameRegisterLabel.setText("Username");

        passwordRegisterLabel.setText("Password");

        registerButton.setBackground(new java.awt.Color(0, 153, 153));
        registerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordRegisterLabel)
                    .addComponent(usernameRegisterLabel))
                .addGap(45, 45, 45)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTextFieldRegister)
                    .addComponent(passwordTextFieldRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameRegisterLabel)
                    .addComponent(usernameTextFieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordRegisterLabel)
                    .addComponent(passwordTextFieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addContainerGap())
        );

        getContentPane().add(registerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 390, 190));

        backGround.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fonsMainMenu.png"))); // NOI18N
        getContentPane().add(backGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterFrame registerFrame = new RegisterFrame(ctrl, usernameTextFieldRegister.getText(), passwordTextFieldRegister.getPassword());
        registerFrame.setVisible(true);
        registerFrame.setLocation(275, 200);
        JFrame pointer = this;
        registerFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (ctrl.isLogged()) {
                    MainScreen totSeries = new MainScreen();
                    totSeries.setVisible(true);
                    pointer.setVisible(false);
                }
            }

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String password = "";
        for (char c : passwordTextFieldLogin.getPassword()) {
            password = password + c;
        }
        if (ctrl.login(usernameTextFieldLogin.getText(), password)) {
            incorrectLoginLabel.setText("");
            this.setVisible(false);
            MainScreen totSeries = new MainScreen();
            totSeries.setVisible(true);
        } else {
            incorrectLoginLabel.setText("Incorrect username or password");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        // We initialize our database
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades(xmlFilename);

        ctrl = TSController.getInstance(dataManager.getTotSeries());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InitialScreen initial = new InitialScreen(ctrl);
                //initial.setVisible(true);

                if (ctrl.login("atormenta", "atormenta")) {
                    initial.setVisible(false);
                    MainScreen totSeries = new MainScreen();
                    runRatingTest();
                    totSeries.setVisible(true);
                }
            }
        });
    }

    /**
     * Afegeix valoracions a 9 episodes de breaking bad a mode de test.
     */
    private static void runRatingTest() {
        ArrayList<Episode> episodes = new ArrayList<>();
        Client c1 = (Client) ctrl.getUserByUsername("atormenta");
        Client c2 = (Client) ctrl.getUserByUsername("dtomacal");
        Serie serie = ctrl.getCatalog().getSerieById("bbad");
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(1));
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(2));
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(3));
        episodes.add(serie.getSeasonByNumber(1).getEpisodeByNumber(4));
        episodes.add(serie.getSeasonByNumber(2).getEpisodeByNumber(1));
        episodes.add(serie.getSeasonByNumber(2).getEpisodeByNumber(2));
        episodes.add(serie.getSeasonByNumber(2).getEpisodeByNumber(3));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(1));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(2));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(3));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(4));
        episodes.add(serie.getSeasonByNumber(3).getEpisodeByNumber(5));
        View v;
        for (Episode e : episodes) {
            ctrl.login(c1.getUsername(), c1.getPassword());
            v = ctrl.visualizeEpisode(e);
            ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(0, 6));

            ctrl.login(c2.getUsername(), c2.getPassword());
            v = ctrl.visualizeEpisode(e);
            ctrl.rateEpisode(v, ThreadLocalRandom.current().nextInt(1, 6));
        }
        ctrl.logout();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel incorrectLoginLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JLabel passwordLoginLabel;
    private javax.swing.JLabel passwordRegisterLabel;
    private javax.swing.JPasswordField passwordTextFieldLogin;
    private javax.swing.JPasswordField passwordTextFieldRegister;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel registerLabel1;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JLabel usernameLoginLabel;
    private javax.swing.JLabel usernameRegisterLabel;
    private javax.swing.JTextField usernameTextFieldLogin;
    private javax.swing.JTextField usernameTextFieldRegister;
    // End of variables declaration//GEN-END:variables
}
