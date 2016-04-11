/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import edu.sit.cs.db.CSDbDelegate;

/**
 *
 * @author Oriopun AI
 */
public class Transaction extends PopUp {

    /**
     * Creates new form Transaction
     */
    public Transaction() {
        initComponents();
        //CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        ConnectDB db = new ConnectDB();
        CSDbDelegate get = db.getConnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Accountbtn = new javax.swing.JButton();
        ChangePassbtn = new javax.swing.JButton();
        withdrawBtn = new javax.swing.JButton();
        depositBtn = new javax.swing.JButton();
        Exitbtn = new javax.swing.JButton();
        tranferBtn = new javax.swing.JButton();
        BG_transac = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Accountbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 317, 24, 24));

        ChangePassbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePassbtnMouseClicked(evt);
            }
        });
        getContentPane().add(ChangePassbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 285, 24, 24));

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

        Exitbtn.setBackground(java.awt.Color.black);
        Exitbtn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Exitbtn.setForeground(new java.awt.Color(255, 255, 255));
        Exitbtn.setText("EXIT");
        Exitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitbtnMouseClicked(evt);
            }
        });
        Exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 270, 30));

        tranferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tranferBtnActionPerformed(evt);
            }
        });
        getContentPane().add(tranferBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 30, 30));

        BG_transac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/transaction.png"))); // NOI18N
        getContentPane().add(BG_transac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitbtnMouseClicked
        // TODO add your handling code here:
        dispose();
        PopUp login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_ExitbtnMouseClicked

    private void ExitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitbtnActionPerformed

    private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositBtnActionPerformed

    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawBtnActionPerformed

    private void depositBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositBtnMouseClicked
        // TODO add your handling code here:
        PopUp d = new Deposit();
        d.setVisible(true);

    }//GEN-LAST:event_depositBtnMouseClicked

    private void withdrawBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawBtnMouseClicked
        // TODO add your handling code here:
        PopUp w = new Withdraw();
        w.setVisible(true);
    }//GEN-LAST:event_withdrawBtnMouseClicked

    private void ChangePassbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassbtnMouseClicked
        // TODO add your handling code here:
        PopUp c = new ChangePassword();
        c.setVisible(true);
    }//GEN-LAST:event_ChangePassbtnMouseClicked

    private void tranferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tranferBtnActionPerformed
        // TODO add your handling code here:
        Transfer t = new Transfer();
        t.setVisible(true);
    }//GEN-LAST:event_tranferBtnActionPerformed

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
    private javax.swing.JButton Accountbtn;
    private javax.swing.JLabel BG_transac;
    private javax.swing.JButton ChangePassbtn;
    private javax.swing.JButton Exitbtn;
    private javax.swing.JButton depositBtn;
    private javax.swing.JButton tranferBtn;
    private javax.swing.JButton withdrawBtn;
    // End of variables declaration//GEN-END:variables
}
