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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * A Swing program that demonstrates how to create a popup menu
 * for a JTable component.
 * @author www.codejava.net
 *
 */
public class AccountBalance extends JFrame implements ActionListener {

	private JTable table;
	private DefaultTableModel tableModel; 
	private JPopupMenu popupMenu;
	private JMenuItem menuItemAdd;
	private JMenuItem menuItemRemove;
	private JMenuItem menuItemRemoveAll;
	private static String[][] results;
	
	public AccountBalance(String[][] results) 
        {
		super("JTable Popup Menu Example");
		this.results=results;
		
		// sample table data
		String[] columnNames = new String[] {
                    "Date", "time", "No.", "Transaction", "Amount", "Balance"};
		// constructs the table with sample data
		tableModel = new DefaultTableModel(results, columnNames);
		
                table = new JTable(tableModel);
		
		// constructs the popup menu
		popupMenu = new JPopupMenu();
		menuItemAdd = new JMenuItem("Add New Row");
		menuItemRemove = new JMenuItem("Remove Current Row");
		menuItemRemoveAll = new JMenuItem("Remove All Rows");
		
		menuItemAdd.addActionListener(this);
		menuItemRemove.addActionListener(this);
		menuItemRemoveAll.addActionListener(this);
		
		popupMenu.add(menuItemAdd);
		popupMenu.add(menuItemRemove);
		popupMenu.add(menuItemRemoveAll);
		
		// sets the popup menu for the table
		//table.setComponentPopupMenu(popupMenu);
		
		//table.addMouseListener(new TableMouseListener(table));
		
		// adds the table to the frame
		add(new JScrollPane(table));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 150);
		setLocationRelativeTo(null);
		setTitle("Transaction of Account ");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AccountBalance(results).setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JMenuItem menu = (JMenuItem) event.getSource();
		if (menu == menuItemAdd) {
			addNewRow();
		} else if (menu == menuItemRemove) {
			removeCurrentRow();
		} else if (menu == menuItemRemoveAll) {
			removeAllRows();
		}
	}
	
	private void addNewRow() {
		tableModel.addRow(new String[0]);
	}
	
	private void removeCurrentRow() {
		int selectedRow = table.getSelectedRow();
		tableModel.removeRow(selectedRow);
	}
	
	private void removeAllRows() {
		int rowCount = tableModel.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			tableModel.removeRow(0);
		}
	}
}
