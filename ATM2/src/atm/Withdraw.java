/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
 *
 * @author Oriopun Ai
 */
public class Withdraw extends PopUp implements FunctionATM{
    
    public static String user;

    /**
     * Creates new form Withdraw
     */
    public Withdraw() {
        super();
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        OKbtn = new javax.swing.JButton();
        withdrawField = new javax.swing.JTextField();
        Cancelbtn = new javax.swing.JButton();
        BG_withdraw = new javax.swing.JLabel();

        jButton2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jButton2.setText("Ok");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OKbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OKbtn.setText("OK");
        OKbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKbtnMouseClicked(evt);
            }
        });
        getContentPane().add(OKbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 80, 30));

        withdrawField.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        getContentPane().add(withdrawField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, 40));

        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, 30));

        BG_withdraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/withdraw.png"))); // NOI18N
        getContentPane().add(BG_withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKbtnMouseClicked
        performFunction();
        properDispose();
    }//GEN-LAST:event_OKbtnMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        properDispose(); // go back to transaction page
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
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Withdraw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdraw().setVisible(true);
            }
        });
    }

    public void performFunction() {
        System.out.println(get.connect());
        
        if (!connectionIsOn()) {
            JOptionPane.showMessageDialog(null, "Bad Connection", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = Login.getUser(); //fix db

        String balance1 = "SELECT Balance FROM ATMuser WHERE Username = '" + user + "'";

        HashMap b = get.queryRow(balance1);

        double balance = Double.parseDouble(b.get("Balance") + "");
        double amount;

        try {
            amount = Double.parseDouble(withdrawField.getText());
            if (amount < 1) {
                JOptionPane.showMessageDialog(null, "Please deposite more than 0 bath", "Error!", JOptionPane.ERROR_MESSAGE);
            } else if (amount < 2000000000 && amount > 0) {//fix double size bug
                if (amount > balance) {
                    JOptionPane.showMessageDialog(null, "Insufficient Fund!", "Invalid Transaction", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //before withdraw
                System.out.println("Balance = " + String.format("%.2f", balance));
                balance = balance - amount;

                //after withdraw
                System.out.println("Balance after withdraw = " + String.format("%.2f", balance));
                String sql_update = "UPDATE `ATMuser` SET `Balance`=" + "'" + balance + "'" + "WHERE Username = '" + user + "'";
                get.executeQuery(sql_update);

                String date = format.getFormat();
                setFormat(new TimeATM());
                String time = format.getFormat();

                String ac1 = "SELECT ACno FROM ATMuser WHERE Username = '" + user + "'";
                HashMap a = get.queryRow(ac1);
                int ac = Integer.parseInt(a.get("ACno") + "");

                String insert = "INSERT INTO ATMtransaction(DATE, TIME, ACno, TRANSACTION, AMOUNT, BALANCE)";
                String value = "VALUES ('" + date + "','" + time + "','" + ac + "','" + "Withdraw" + "','" + amount + "'"
                        + ",'" + balance + "')";
                String sql_add = insert + value;
                boolean insertComplete = get.executeQuery(sql_add);

                if (insertComplete) {
                    JOptionPane.showMessageDialog(null, "Process Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error!", "Execute Problem", JOptionPane.ERROR_MESSAGE);
                }
                
                //popup receipt
                int yesno = JOptionPane.showConfirmDialog(null, "DATE: " + date + "\t\t" + "TIME: " + time + "\n"
                        + "My Account No.: " + ac + "\n" + "TRANSACTION: " + "Withdraw" + "\n" + "AMOUNT: "
                        + String.format("%.2f", amount) + "\n" + "BALANCE: " + String.format("%.2f", balance) + "\n\nDo you want to print the receipt?", "ATM RECEIPT", JOptionPane.YES_NO_OPTION);

                //choose to print receipt
                if (yesno == 0) {
                    //print receipt
                    System.out.println("Print receipt already");
                    File file = new File("receipt/receipt_file_acno." + ac + ".txt");

                    PrintWriter write = new PrintWriter(file); //for write in file
                    write.println("Receipt of Account no." + ac);
                    write.println("Date : " + date);
                    write.println("Time : " + time);
                    write.println("My account no. : " + ac);
                    write.println("Transaction : Withdraw");
                    write.println("Amount : " + String.format("%.2f", amount));
                    write.println("My Balance : " + String.format("%.2f", balance));
                    write.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please withdraw less than 2,000,000,000", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter only number", "Error!", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException e){
            
        }
        System.out.println(get.disconnect());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_withdraw;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JButton OKbtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField withdrawField;
    // End of variables declaration//GEN-END:variables
}
