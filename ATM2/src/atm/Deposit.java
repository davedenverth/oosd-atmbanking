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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Game
 */
public class Deposit extends PopUp implements FunctionATM {
    private double amount = 0;
    FormatDateTime format;
    public static String user; 
   // private int amount;
    //private int depositss;
    
    /**
     * Creates new form Deposit
     */
    
    public Deposit() {
        format = new DateATM();
        db = new ConnectDB();
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
        depositField = new javax.swing.JTextField();
        Cancelbtn = new javax.swing.JButton();
        BG_deposit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OKbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        OKbtn.setText("OK");
        OKbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKbtnMouseClicked(evt);
            }
        });
        getContentPane().add(OKbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 90, -1));

        depositField.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        depositField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositFieldActionPerformed(evt);
            }
        });
        getContentPane().add(depositField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, 40));

        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        BG_deposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/deposit.png"))); // NOI18N
        getContentPane().add(BG_deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depositFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositFieldActionPerformed

    private void OKbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKbtnMouseClicked
        try {
            performFunction();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OKbtnMouseClicked

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        dispose();
        // go back to transaction page
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
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposit().setVisible(true);
            }
        });
        //CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        //ConnectDB db = new ConnectDB();
        //CSDbDelegate get = db.getConnect();
    }
    
    public void setFormat(FormatDateTime ft){
         format = ft;
    }

    public void performFunction() throws FileNotFoundException{

        
        db.connect();
        if(db.getDbConnection() == null){
            return;
        }
        //no = Login.getPass();
        user = Login.getUser(); //fix db
        
        //getbalance from this user
        String balance1 = "SELECT Balance FROM ATMuser WHERE Username = '"+user+"'";
        
        HashMap b = db.queryRow(balance1);

        //before deposit
        double balance = Double.parseDouble(b.get("Balance")+"");
        try{
         amount = Double.parseDouble(depositField.getText());
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Please input only number!!");
                   
        }
        System.out.println("Balance = "+balance);
        
        //after deposit
        balance = balance + amount;
        System.out.println("Balance after deposit = "+balance);
        
        String sql_update = "UPDATE `ATMuser` SET `Balance`="+"'"+balance+"'" +"WHERE Username = '"+user+"'"; 
        db.executeQuery(sql_update);
       
        String date = format.getFormat();
        setFormat(new TimeATM());
        String time = format.getFormat();
        //this.time = time;
        
        //get ac co
        String ac1 = "SELECT ACno FROM ATMuser WHERE Username = '"+user+"'";
        HashMap a = db.queryRow(ac1);
        int  account = Integer.parseInt(a.get("ACno")+"");
        System.out.println("Account no = "+account);
         
        //receipt to transaction table
        String insert = "INSERT INTO ATMtransaction(DATE, TIME, ACno, TRANSACTION, AMOUNT, BALANCE)"; 
        String value = "VALUES ('"+date+"','"+time+"','"+account+"','"+"Deposit"+"','"+amount+"'"
                + ",'"+balance+"')";
        String sql_add = insert + value;
        
        boolean insertComplete = db.executeQuery(sql_add);
        if(insertComplete) JOptionPane.showMessageDialog(null , "Process Successfully!");
        else
            JOptionPane.showMessageDialog(this, "Error!" , "Execute Problem", JOptionPane.ERROR_MESSAGE);
        setVisible(false);
        
        //receipt
        int yesno = JOptionPane.showConfirmDialog(null, "DATE: "+date+"\t\t"+"TIME: "+time+"\n"+
                "My Account No.: "+account+"\n"+"TRANSACTION: "+"Deposite"+"\n"+"AMOUNT: "+
                amount+"\n"+"BALANCE: "+balance+"\n\nDo you want to print the receipt?", "ATM RECEIPT", JOptionPane.YES_NO_OPTION);
        
            //choose to print receipt
            if(yesno == JOptionPane.YES_OPTION){
                //print receipt
                System.out.println("Print receipt already");
                File file = new File("receipt/receipt_file_acno."+account+".txt");
    
                PrintWriter write = new PrintWriter(file); //for write in file
                write.println("Receipt of Account no."+account);
                write.println("Date : "+ date);
                write.println("Time : "+ time);
                write.println("My account no. : "+ account);
                write.println("Transaction : Deposite");
                write.println("Amount : "+amount);
                write.println("My Balance : " + balance);
                write.close();
            } 
        
        setVisible(false); 
        db.disconnect();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_deposit;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JButton OKbtn;
    private javax.swing.JTextField depositField;
    // End of variables declaration//GEN-END:variables

  
    }

