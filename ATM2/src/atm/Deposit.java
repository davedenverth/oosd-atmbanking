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
 * @author Oriopun Ai
 */
public class Deposit extends PopUp {
    FormatDateTime format;
    /**
     * Creates new form Deposit
     */
    
    public Deposit() {
        format = new DateATM();
        initComponents();
    }
    
    public static String user; 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        deposit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jButton1.setText("OK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        deposit.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });
        getContentPane().add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 110, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel4.setText("Please enter amount");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel3.setText("Deposit");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/Transparent.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 410, 260));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/25488042-men-hand-businessman-puts-credit-card-into-atm.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        //CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        ConnectDB db = new ConnectDB();
        CSDbDelegate get = db.getConnect();
        
        get.connect();
        //no = Login.getPass();
        user = Login.getUser(); //fix db
        
        String balance1 = "SELECT Balance FROM ATMuser WHERE Username = '"+user+"'";
        
        HashMap b = get.queryRow(balance1);

        //before deposit
        double balance = Double.parseDouble(b.get("Balance")+"");
        double amount = Double.parseDouble(deposit.getText());
        System.out.println("Balance = "+balance);
        
        //after deposit
        balance = balance + amount;
        System.out.println("Balance after deposit = "+balance);
        
        String sql_update = "UPDATE `ATMuser` SET `Balance`="+"'"+balance+"'" +"WHERE Username = '"+user+"'"; 
        get.executeQuery(sql_update);
       
        String date = format.getFormat();
        setFormat(new TimeATM());
        String time = format.getFormat();
        //this.time = time;
        
        String ac1 = "SELECT ACno FROM ATMuser WHERE Username = '"+user+"'";
        HashMap a = get.queryRow(ac1);
        int  account = Integer.parseInt(a.get("ACno")+"");
        System.out.println("Account no = "+account);
         
        String insert = "INSERT INTO ATMtransaction(DATE, TIME, ACno, TRANSACTION, AMOUNT, BALANCE)"; 
        String value = "VALUES ('"+date+"','"+time+"','"+account+"','"+"Deposit"+"','"+amount+"'"
                + ",'"+balance+"')";
        String sql_add = insert + value;
        
        boolean insertComplete = get.executeQuery(sql_add);
        if(insertComplete) JOptionPane.showMessageDialog(null , "Process Successfully!");
        else
            JOptionPane.showMessageDialog(this, "Error!" , "Execute Problem", JOptionPane.ERROR_MESSAGE);
        setVisible(false);
        
        
        JOptionPane.showMessageDialog(null,"\tATM RECEIPT\n\n"+"DATE: "+date+"\n"+"TIME: "+time+"\n"+"A/C No.: "+account+"\n"
                                            +"TRANSACTION: "+"Deposit"+"\n"+"AMOUNT: "+amount+"\n"+"BALANCE: "+balance+"\n");
        
        // db.executeQuery(sql_create);
        get.disconnect();
    }//GEN-LAST:event_jButton1MouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField deposit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
