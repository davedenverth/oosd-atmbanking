package atm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author halo
 */

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * A Swing program that demonstrates how to create a popup menu for a JTable
 * component.
 *
 * @author www.codejava.net
 *
 */
public class AccountBalance extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private static String[][] results;

    public AccountBalance(String[][] results) {
        this.results = results;

        // table data
        String[] columnNames = new String[]{
            "Date", "Time", "Account No.", "Transaction", "Amount", "Balance"};
        tableModel = new DefaultTableModel(results, columnNames);
        table = new JTable(tableModel);

        // adds the table to the frame
        add(new JScrollPane(table));
        setSize(640, 150);
        setLocationRelativeTo(null);
        setTitle("My last 5 Transaction");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountBalance(results).setVisible(true);
            }
        });
    }
}
