/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import edu.sit.cs.db.CSDbDelegate;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Wanmoon
 */
public class Transfer extends PopUp {
    
    FormatDateTime format;
    public static String user; 
    
    /**
     * Creates new form Transfer
     */
    public Transfer() {
        format = new DateATM();
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

        OKbtn = new javax.swing.JButton();
        Cancelbtn = new javax.swing.JButton();
        TransfertoIDField = new javax.swing.JTextField();
        TransferMoneyField = new javax.swing.JTextField();
        BG_transfer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OKbtn.setText("OK");
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed(evt);
            }
        });

        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        TransfertoIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertoIDFieldActionPerformed(evt);
            }
        });

        BG_transfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/transfer.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(TransfertoIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(TransferMoneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OKbtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(Cancelbtn))))
            .addComponent(BG_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(TransfertoIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(TransferMoneyField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OKbtn)
                    .addComponent(Cancelbtn)))
            .addComponent(BG_transfer)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        // TODO add your handling code here:
        dispose();
        // go back to transaction page
        Transaction main = new Transaction();
        main.setVisible(true);
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        // TODO add your handling code here:
        ConnectDB db = new ConnectDB();
        CSDbDelegate get = db.getConnect();
        
        get.connect();
        user = Login.getUser(); //get user who use this atm
        
        //get balance of this user
        String balance1 = "SELECT Balance FROM ATMuser WHERE Username = '"+user+"'"; 
        
        HashMap b = get.queryRow(balance1);
        
        //get data from textfield
        String transfer_ID = TransfertoIDField.getText();
        double amount = Double.parseDouble(TransferMoneyField.getText());
        System.out.println("Transfer to account no. = "+transfer_ID);
        
        //get ac no.of user
        String ac1 = "SELECT ACno FROM ATMuser WHERE Username = '"+user+"'";
        HashMap a = get.queryRow(ac1);
        int  account = Integer.parseInt(a.get("ACno")+"");
        System.out.println("My Account no = "+account);
       
        //before deposit
        double balance = Double.parseDouble(b.get("Balance")+"");
        System.out.println("Balance = "+balance);
        
        //deleted money from user account
        balance = balance - amount;
        System.out.println("Balance after transfer = "+ balance);
        
        //update db user
        String sql_update = "UPDATE `ATMuser` SET `Balance`="+"'"+balance+"'" +"WHERE Username = '"+user+"'"; 
        get.executeQuery(sql_update);
        
        //add money to other account
        String sql_balance2 = "SELECT Balance FROM ATMuser WHERE ACno = '"+transfer_ID+"'";
        HashMap b2 = get.queryRow(sql_balance2);
        double balance2 = Double.parseDouble(b2.get("Balance")+"");
        System.out.println("Old balance before transfer = "+balance2); //ลบด้วย
        balance2 = balance2 + amount;
        System.out.println("Balance after transfer = "+balance2);

        //update db user2
        String sql_update2 = "UPDATE `ATMuser` SET `Balance`="+"'"+balance2+"'" +"WHERE ACno = '"+transfer_ID+"'"; 
        get.executeQuery(sql_update2);
        
        String date = format.getFormat();
        setFormat(new TimeATM());
        String time = format.getFormat();
        
        //reciept to transaction table
        String insert = "INSERT INTO ATMtransaction(DATE, TIME, ACno, TRANSACTION, AMOUNT, BALANCE)"; 
        String value = "VALUES ('"+date+"','"+time+"','"+account+"','"+"Transfer to Account no. "+transfer_ID+"','"+amount+"'"
                + ",'"+balance+"')";
        String sql_add = insert + value;
        
        boolean insertComplete = get.executeQuery(sql_add);
        if(insertComplete) JOptionPane.showMessageDialog(null , "Process Successfully!");
        else
            JOptionPane.showMessageDialog(this, "Error!" , "Execute Problem", JOptionPane.ERROR_MESSAGE);
        setVisible(false);
        
        
        JOptionPane.showMessageDialog(null,"\tATM RECEIPT\n\n"+"DATE: "+date+"\n"+"TIME: "+time+"\n"+
                "A/C No.: "+account+"\n"+"TRANSACTION: "+"Transfer to Account no. "+transfer_ID+"\n"+"AMOUNT: "+
                amount+"\n"+"BALANCE: "+balance+"\n");
        
        get.disconnect();
    }//GEN-LAST:event_OKbtnActionPerformed

    private void TransfertoIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertoIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TransfertoIDFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }
    
    public void setFormat(FormatDateTime ft){
         format = ft;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_transfer;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JButton OKbtn;
    private javax.swing.JTextField TransferMoneyField;
    private javax.swing.JTextField TransfertoIDField;
    // End of variables declaration//GEN-END:variables
}
