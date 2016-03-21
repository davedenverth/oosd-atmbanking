/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import edu.sit.cs.db.CSDbDelegate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Oriopun AI
 */
public class Transaction extends javax.swing.JFrame {

   
    /**
     * Creates new form Transaction
     */
    public Transaction() {
        initComponents();
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transaction = new javax.swing.JLabel();
        deposit = new javax.swing.JLabel();
        withdraw = new javax.swing.JLabel();
        changePassword = new javax.swing.JLabel();
        accountBook = new javax.swing.JLabel();
        accountBookBtn = new javax.swing.JButton();
        changePasswordBtn = new javax.swing.JButton();
        withdrawBtn = new javax.swing.JButton();
        depositBtn = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transaction.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        transaction.setText("Transaction");
        getContentPane().add(transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        deposit.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        deposit.setText("Deposit");
        getContentPane().add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        withdraw.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        withdraw.setText("Withdraw");
        getContentPane().add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        changePassword.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        changePassword.setText("Change Password");
        getContentPane().add(changePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        accountBook.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        accountBook.setText("Account Book");
        getContentPane().add(accountBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));
        getContentPane().add(accountBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 317, 24, 24));

        changePasswordBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePasswordBtnMouseClicked(evt);
            }
        });
        getContentPane().add(changePasswordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 285, 24, 24));

        withdrawBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withdrawBtnMouseClicked(evt);
            }
        });
        withdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBtnActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 255, 24, 24));

        depositBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositBtnMouseClicked(evt);
            }
        });
        depositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBtnActionPerformed(evt);
            }
        });
        getContentPane().add(depositBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 225, 24, 24));

        ok.setBackground(java.awt.Color.black);
        ok.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        ok.setForeground(new java.awt.Color(255, 255, 255));
        ok.setText("EXIT");
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
        });
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 270, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/ATM-Machine.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseClicked
       
       System.exit(0);
        
        
       

       // TODO add your handling code here:

    }//GEN-LAST:event_okMouseClicked

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okActionPerformed

    private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBtnActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_depositBtnActionPerformed

    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawBtnActionPerformed

    private void depositBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositBtnMouseClicked
                                // TODO add your handling code here:
        Deposit d = new Deposit();
        d.setVisible(true);
        //clickButton();

    }//GEN-LAST:event_depositBtnMouseClicked

    private void withdrawBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawBtnMouseClicked
        // TODO add your handling code here:
        
        Withdraw w = new Withdraw();
        w.setVisible(true);
        //clickButton();
    }//GEN-LAST:event_withdrawBtnMouseClicked

    private void changePasswordBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordBtnMouseClicked
        // TODO add your handling code here:
        ChangePassword c = new ChangePassword();
        c.setVisible(true);
        
       // clickButton();
        
    }//GEN-LAST:event_changePasswordBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // Resizable(false);
                new Transaction().setVisible(true);
                
                
            }
        });
        
        
        
    }
    
    /*public static int no;
    public static double amount;
    public static int transac;

    public double transaction(int transac, int amount) {
        CSDbDelegate db = new CSDbDelegate("cs14sitkmutt.me", "3306", "CSC105_G3", "CSC105_G3", "cstermproj");
        this.amount= amount;
        this.transac = transac;
        
        String balance1 = "SELECT Balance FROM ATMtransaction WHERE A/C No.= " + no;
        HashMap b = db.queryRow(balance1);
        double balance = Double.parseDouble(balance1); 
        System.out.println(b.get("Balance")); 

        //double balance = (double)Balance;   
        if (transac == 1) {
            deposit(amount,balance);
            
        } else {
            withdraw(amount,balance);
        }
    return balance;
    }

    public void deposit(int amount, double balance) {
        balance = balance + amount;

    }

    public void withdraw(int amount, double balance) {
        balance = balance - amount;
    }*/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountBook;
    private javax.swing.JButton accountBookBtn;
    private javax.swing.JLabel background;
    private javax.swing.JLabel changePassword;
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JLabel deposit;
    private javax.swing.JButton depositBtn;
    private javax.swing.JButton ok;
    private javax.swing.JLabel transaction;
    private javax.swing.JLabel withdraw;
    private javax.swing.JButton withdrawBtn;
    // End of variables declaration//GEN-END:variables
}
