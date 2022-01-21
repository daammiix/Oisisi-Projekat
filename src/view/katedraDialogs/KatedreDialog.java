package view.katedraDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.AppData;
import model.Katedra;
import util.Util;
import view.AppFrame;


public class KatedreDialog extends JDialog {

	private static final long serialVersionUID = 4617687518810044464L;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnSefKatedre;
	private JButton btnZavrsi;
	private JPanel panel;
	
	public KatedreDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() / 2, parent.getHeight() / 2);
		this.setResizable(false);
		init();
	}
	
	private void init() {
		String[] cols = {"Ponudjene katedre"};
		tableModel = new DefaultTableModel(cols,0);
		table = Util.createTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnSefKatedre = new JButton("Izmeni");
		setButton(btnSefKatedre);
		btnSefKatedre.setActionCommand("Katedre");
		btnSefKatedre.setPreferredSize(new Dimension(25, 25));
		btnZavrsi = new JButton("Zavrsi");
		btnZavrsi.setActionCommand("Katedre");
		setButton(btnZavrsi);
		btnZavrsi.setPreferredSize(new Dimension(25, 25));
		
		panel = new JPanel();
		panel.add(btnSefKatedre);
		panel.add(btnZavrsi);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		panel.setLayout(new GridLayout(1, 2, 15, 0));
		
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		this.add(panel, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
	}
	
	public void initComponents() {
		btnSefKatedre.setText(AppFrame.getInstance().getResourceBundle().getString("btnIzmeni"));
		btnZavrsi.setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
	}
	
	private void setButton(JButton button) {
		button.setMargin(new Insets(1, 4, 1, 4));
	}
	
	public void addBtnIzmeniKatedruListener(MouseListener ml, ActionListener al) {
		btnSefKatedre.addMouseListener(ml);
		btnSefKatedre.addActionListener(al);
	}
	
	public void addOdustaniProfesorBtnListener(MouseListener ml) {
		btnZavrsi.addMouseListener(ml);
	}
	
	public void initTable() {
		clearTable();
		ArrayList<Katedra> katedre = AppData.getInstance().getKatedra();
		for(Katedra k : katedre) {
			Object[] data = {k.getNazivKatedre()};
			tableModel.addRow(data);
		}

	}
	
	public void clearTable() {
		tableModel.setRowCount(0);
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	public DefaultTableModel getTableModel() {
		return this.tableModel;
	}
}
