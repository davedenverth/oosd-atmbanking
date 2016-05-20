/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Oriopun AI
 */
public class Login extends PopUp {

    public static int pass;
    public static String user;
    public static Transaction transaction;

    /**
     * Creates new form Receipt
     */
    public Login() {
        super();
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        user = "";
        pass = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Loginbtn = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        UserField = new javax.swing.JTextField();
        Cancelbtn = new javax.swing.JButton();
        BG_login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Loginbtn.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Loginbtn.setText("Login");
        Loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginbtnMouseClicked(evt);
            }
        });
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 70, -1));

        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 160, 30));

        UserField.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        getContentPane().add(UserField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 160, 30));

        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        BG_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/login.png"))); // NOI18N
        getContentPane().add(BG_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, -1, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_buttomActionPerformed

    }//GEN-LAST:event_Exit_buttomActionPerformed

    private void Login_buttomActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void LoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbtnActionPerformed
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_buttomActionPerformed(evt);
            }
        });        // TODO add your handling code here:

    }//GEN-LAST:event_LoginbtnActionPerformed

    private void Exit_buttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_buttomActionPerformed(evt);
            }
        });        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LoginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginbtnMouseClicked
        // TODO add your handling code here:
        System.out.println(get.connect());
        if (!connectionIsOn()) {
            JOptionPane.showMessageDialog(null, "Bad Connection", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        checkPassword();
        System.out.println(get.disconnect());


    }//GEN-LAST:event_LoginbtnMouseClicked

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        // TODO add your handling code here:
        if (connectionIsOn()) {
            System.out.println(get.disconnect());
        }
        System.exit(0); //close java frame loei
    }//GEN-LAST:event_CancelbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public void checkPassword() {
        String sql = "SELECT Username, Password FROM ATMuser";
        String tempUser = UserField.getText();
        ArrayList<HashMap> list = get.queryRows(sql);
        boolean hasAccount = false;

        for (HashMap a : list) { 
            if (a.get("Username").equals(tempUser)) { //login
                hasAccount = true;
                user = tempUser;
                try {
                    pass = Integer.parseInt(PasswordField.getText());
                    
                    if (Integer.toString(pass).length() != 4) {
                        JOptionPane.showMessageDialog(null, "Please enter 4 digit numbers!", "Please enter 4 digit numbers!", JOptionPane.ERROR_MESSAGE);
                    } else if (a.get("Password").equals("" + pass)) { // password colu
                        Login.pass = Integer.parseInt(String.valueOf(a.get("Password")));
                        JOptionPane.showMessageDialog(null, "Login Successfully!");
                        transaction = new Transaction();

                        dispose();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Password!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter only number", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (!hasAccount) {
            JOptionPane.showMessageDialog(null, "Please Register", "No Account", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int getPass() {
        return Login.pass;
    }

    public static String getUser() {
        return Login.user;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_login;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JButton Loginbtn;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField UserField;
    // End of variables declaration//GEN-END:variables
}
