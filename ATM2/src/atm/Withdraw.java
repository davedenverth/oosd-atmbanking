/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import edu.sit.cs.db.CSDbDelegate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Oriopun Ai
 */
public class Withdraw extends PopUp {
    
    public FormatDateTime format;
    
    /**
     * Creates new form Withdraw
     */
    public Withdraw() {
        format = new DateATM();
        initComponents();
    }
    //public static int no; 
    public static String user; 
    
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

        OKbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OKbtn.setText("OK");
        OKbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKbtnMouseClicked(evt);
            }
        });
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed(evt);
            }
        });

        withdrawField.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        withdrawField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawFieldActionPerformed(evt);
            }
        });

        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        BG_withdraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/withdraw.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(withdrawField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(Cancelbtn))
            .addComponent(BG_withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(withdrawField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(BG_withdraw)
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKbtnMouseClicked
        try {
            // TODO add your handling code here:
            performFunction();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OKbtnMouseClicked

    private void withdrawFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_withdrawFieldActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        dispose();
        // go back to transaction page
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OKbtnActionPerformed
    //private void jButton3Backbutton(java.awt.event.ActionEvent)
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
        //CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
    }
    
    public void setFormat(FormatDateTime ft){
        format = ft;
    }
    
    public void performFunction() throws FileNotFoundException{
        ConnectDB db = new ConnectDB();
        CSDbDelegate get = db.getConnect();
        
        get.connect();
        //no = Login.getPass();
        user = Login.getUser(); //fix db

        String balance1 = "SELECT Balance FROM ATMuser WHERE Username = '"+user+"'";
        
        HashMap b = get.queryRow(balance1);

        double balance = Double.parseDouble(b.get("Balance")+"");
        double amount=0;
        try{
         amount = Double.parseDouble(withdrawField.getText());
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Please input only number!!");
                   
        }
        if(amount > balance){
            JOptionPane.showMessageDialog(null, "Insufficient Fund!", "Invalid Transaction", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //before withdraw
        System.out.println("Balance = "+balance);
        balance = balance - amount;
        
        //after withdraw
        System.out.println("Balance after withdraw = "+balance);
        String sql_update = "UPDATE `ATMuser` SET `Balance`="+"'"+balance+"'" +"WHERE Username = '"+user+"'"; 
        get.executeQuery(sql_update);
       
        String date = format.getFormat();
        setFormat(new TimeATM());
        String time = format.getFormat();
      
        String ac1 = "SELECT ACno FROM ATMuser WHERE Username = '"+user+"'";
        HashMap a = get.queryRow(ac1);
        int  ac = Integer.parseInt(a.get("ACno")+"");
        
        String insert = "INSERT INTO ATMtransaction(DATE, TIME, ACno, TRANSACTION, AMOUNT, BALANCE)"; 
        String value = "VALUES ('"+date+"','"+time+"','"+ac+"','"+"Withdraw"+"','"+amount+"'"
                + ",'"+balance+"')";
        String sql_add = insert + value;
        boolean insertComplete = get.executeQuery(sql_add);
        
        if(insertComplete) JOptionPane.showMessageDialog(null , "Process Successfully!");
        else
            JOptionPane.showMessageDialog(this, "Error!" , "Execute Problem", JOptionPane.ERROR_MESSAGE);
       // db.executeQuery(sql_create);
        
        //popup receipt
        int yesno = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, "DATE: "+date+"\t\t"+"TIME: "+time+"\n"+
                "My Account No.: "+ac+"\n"+"TRANSACTION: "+"Withdraw"+"\n"+"AMOUNT: "+
                amount+"\n"+"BALANCE: "+balance+"\n\nDo you want to print the receipt?", "ATM RECEIPT", yesno);
        
            //choose to print receipt
            if(yesno == 0){
                //print receipt
                System.out.println("Print receipt already");
                File file = new File("reciep_file_acno."+ac+".txt");
    
                PrintWriter write = new PrintWriter(file); //for write in file
                write.println("Receipt of Account no."+ac);
                write.println("Date : "+ date);
                write.println("Time : "+ time);
                write.println("My account no. : "+ ac);
                write.println("Transaction : Withdraw");
                write.println("Amount : "+amount);
                write.println("My Balance : " + balance);
                write.close();
            } 
        
        setVisible(false);
        get.disconnect();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_withdraw;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JButton OKbtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField withdrawField;
    // End of variables declaration//GEN-END:variables
}
