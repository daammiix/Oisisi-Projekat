package view.changeDialogs;

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
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;
import util.Util;
import view.AppFrame;

public class ChooseProfessorDialog extends JDialog {

	private static final long serialVersionUID = -5963238327765330825L;
	

	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JPanel panel;
	
	public ChooseProfessorDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() *2 / 5, parent.getHeight() *2 / 5);
		this.setResizable(false);
		init();
	}
	
	private void init() {
		String[] cols = {"Ponudjeni profesori"};
		tableModel = new DefaultTableModel(cols,0);
		table = Util.createTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setActionCommand("Choose");
		setButton(btnPotvrdi);
		btnPotvrdi.setPreferredSize(new Dimension(25, 25));
		btnOdustani = new JButton("Odustani");
		btnOdustani.setActionCommand("Choose");
		setButton(btnOdustani);
		btnOdustani.setPreferredSize(new Dimension(25, 25));
		
		panel = new JPanel();
		panel.add(btnPotvrdi);
		panel.add(btnOdustani);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		panel.setLayout(new GridLayout(1, 2, 15, 0));
		
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		this.add(panel, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
	}
	
	private void setButton(JButton button) {
		button.setMargin(new Insets(1, 4, 1, 4));
	}
	
	public void addBtnPotvrdiProfesoraListener(MouseListener ml, ActionListener al) {
		btnPotvrdi.addMouseListener(ml);
		btnPotvrdi.addActionListener(al);
	}
	
	public void addOdustaniProfesorBtnListener(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}
	
	public void initTable() {
		ArrayList<Profesor> profesori = new ArrayList<Profesor>();
		for(Profesor p : AppData.getInstance().getProfesori()) {
			profesori.add(p);
		}
		for(Profesor p : profesori) {
			Object[] data = {p.getIme() + " " + p.getPrezime()};
			tableModel.addRow(data);
		}
	}
	
	public JTable getTable() {
		return this.table;
	}
}
