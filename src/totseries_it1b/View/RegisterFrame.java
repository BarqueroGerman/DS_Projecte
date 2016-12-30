/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.View;

import java.awt.Color;
import java.util.Calendar;
import totseries_it1b.Controller.TSController;

/**
 *
 * @author enric
 */
public class RegisterFrame extends javax.swing.JFrame {

    TSController controller;

    /**
     * Creates new form RegisterFrame
     */
    public RegisterFrame(TSController ctrl, String user, char[] password) {
        initComponents();
        controller = ctrl;
        usernameTextField.setText(user);
        String pass = "";
        for (char c : password) {
            pass = pass + c;
        }
        passwordTextField.setText(pass);
        checkUsernameAvailability();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerBackGround = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nationalityTextField = new javax.swing.JTextField();
        nationalityLabel = new javax.swing.JLabel();
        availabilityLabel = new javax.swing.JLabel();
        birthdateLabel = new javax.swing.JLabel();
        dayTextField = new javax.swing.JTextField();
        monthTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        monthLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        birthdateFormatLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        registerBackGround.setBackground(new java.awt.Color(255, 255, 255));

        registerLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setText("Register");

        usernameLabel.setText("Username");

        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        usernameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameTextFieldKeyReleased(evt);
            }
        });

        passwordLabel.setText("Password");

        nameLabel.setText("Name");

        nationalityTextField.setText("Spain");

        nationalityLabel.setText("Nationality");

        availabilityLabel.setForeground(new java.awt.Color(255, 0, 0));
        availabilityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availabilityLabel.setText("This username is not available ");

        birthdateLabel.setText("Birthdate");

        dayTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        monthTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        yearTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        monthLabel.setText("Month");

        dayLabel.setText("Day");

        yearLabel.setText("Year");

        registerButton.setBackground(new java.awt.Color(0, 153, 153));
        registerButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        birthdateFormatLabel.setForeground(new java.awt.Color(255, 0, 0));
        birthdateFormatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        birthdateFormatLabel.setText("Incorrect birthdate format");

        javax.swing.GroupLayout registerBackGroundLayout = new javax.swing.GroupLayout(registerBackGround);
        registerBackGround.setLayout(registerBackGroundLayout);
        registerBackGroundLayout.setHorizontalGroup(
            registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(registerBackGroundLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(nationalityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(availabilityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(birthdateFormatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameTextField)
                        .addComponent(passwordTextField)
                        .addComponent(nationalityTextField)
                        .addGroup(registerBackGroundLayout.createSequentialGroup()
                            .addComponent(monthLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(registerBackGroundLayout.createSequentialGroup()
                                    .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dayLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(yearLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(usernameTextField)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        registerBackGroundLayout.setVerticalGroup(
            registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerBackGroundLayout.createSequentialGroup()
                .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availabilityLabel)
                .addGap(26, 26, 26)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(18, 18, 18)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationalityLabel))
                .addGap(18, 18, 18)
                .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthdateLabel)
                    .addGroup(registerBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthLabel)
                        .addComponent(dayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dayLabel)
                        .addComponent(yearLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(birthdateFormatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addGap(48, 48, 48))
        );

        birthdateFormatLabel.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed

    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void usernameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextFieldKeyReleased
        checkUsernameAvailability();
    }//GEN-LAST:event_usernameTextFieldKeyReleased

    private void checkUsernameAvailability() {
        if (controller.usernameExists(usernameTextField.getText())) {
            availabilityLabel.setForeground(Color.RED);
            availabilityLabel.setText("This username is not available");
        } else {
            availabilityLabel.setForeground(new java.awt.Color(0, 153, 51));
            availabilityLabel.setText("This username is available");
        }
    }

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        String username = usernameTextField.getText();
        String password = "";
        for (char c : passwordTextField.getPassword()) {
            password = password + c;
        }
        String name = nameTextField.getText();
        String nationality = nationalityTextField.getText();
        Calendar date = Calendar.getInstance();
        try {
            date.set(Integer.parseInt(yearTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(dayTextField.getText()));
            birthdateFormatLabel.setVisible(false);
            if (controller.createClient(username, password, name, nationality, date)) {
                this.dispose();
            }
        } catch (Exception ex) {
            birthdateFormatLabel.setVisible(true);
        }
        if (controller.createClient(username, password, name, nationality, date)) {
            this.dispose();
        }

    }//GEN-LAST:event_registerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availabilityLabel;
    private javax.swing.JLabel birthdateFormatLabel;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTextField dayTextField;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JTextField monthTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JTextField nationalityTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JPanel registerBackGround;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
