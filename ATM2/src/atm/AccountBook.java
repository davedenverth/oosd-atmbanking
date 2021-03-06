/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wanmoon
 */
public class AccountBook extends PopUp implements FunctionATM {

    public static String user;
    private String[][] resultss = new String[10][6];

    /**
     * Creates new form AccountBook
     */
    public AccountBook() {
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

        AccountField = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        BG_accountBook = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(AccountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, 40));

        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });
        getContentPane().add(okBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        BG_accountBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/accountBook.png"))); // NOI18N
        getContentPane().add(BG_accountBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        properDispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        performFunction();
        properDispose();
    }//GEN-LAST:event_okBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AccountBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountBook().setVisible(true);
            }
        });
    }

    public void performFunction() {
        System.out.println(get.connect());

        if (!connectionIsOn()) {
            JOptionPane.showMessageDialog(null, "Bad Connection", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = Login.getUser(); //get user who use this atm

        //get data from textfield
        if (isNumeric(AccountField.getText())) {
            int acc_no = Integer.parseInt(AccountField.getText());
            System.out.println("Account no. = " + acc_no);

            //get ac no.of user
            String ac1 = "SELECT ACno FROM ATMuser WHERE Username = '" + user + "'";
            HashMap a = get.queryRow(ac1);
            int account = Integer.parseInt(a.get("ACno") + "");
            System.out.println("My Account no = " + account);

            //check accno.
            if (acc_no == account) {
                //get data of this acc no.
                String sql_ac = "SELECT * FROM ATMtransaction WHERE ACno = '" + acc_no + "' ORDER BY DATE DESC,TIME DESC LIMIT 10";

                ArrayList<HashMap> list = get.queryRows(sql_ac);
                int i = 0;
                for (HashMap data : list) { //show last 10 transaction of this account 
                    resultss[i][0] = (String) data.get("DATE");
                    resultss[i][1] = (String) data.get("TIME");
                    resultss[i][2] = (String) data.get("ACno");
                    resultss[i][3] = (String) data.get("TRANSACTION");
                    resultss[i][4] = (String) data.get("AMOUNT");
                    resultss[i][5] = (String) data.get("BALANCE");
                    i++;
                }
                popupBalance(resultss);
            } else {
                System.out.println("Not your account no.");
                JOptionPane.showMessageDialog(null, "Not Your Account no.!",
                        "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter only number", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(get.disconnect());
    }
    
    public void popupBalance(String[][] results){
        resultss = results;
        
        // table data
        String[] columnNames = new String[]{
            "Date", "Time", "Account No.", "Transaction", "Amount", "Net Balance"};
        
        // create and adds the table to the frame
        JFrame frame = new JFrame("Your last 10 Transaction");
        DefaultTableModel tableModel = new DefaultTableModel(resultss, columnNames);
        JTable table = new JTable(tableModel);
        frame.add(new JScrollPane(table));
        frame.setSize(640, 210);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountField;
    private javax.swing.JLabel BG_accountBook;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
