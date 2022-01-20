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
import model.Profesor;
import util.Util;
import view.AppFrame;

public class SefKatedreDialog extends JDialog {

	private static final long serialVersionUID = 7102449982660612509L;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnIzmeni;
	private JButton btnOdustani;
	private JPanel panel;
	private ArrayList<Profesor> dozvoljeniProfesori;
	
	public SefKatedreDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() / 2, parent.getHeight() / 2);
		this.setResizable(false);
		init();
	}
	
	private void init() {
		String[] cols = {"Ponudjeni profesori"};
		tableModel = new DefaultTableModel(cols,0);
		table = Util.createTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnIzmeni = new JButton("Potvrdi");
		setButton(btnIzmeni);
		btnIzmeni.setActionCommand("ChooseSefKatedre");
		btnIzmeni.setPreferredSize(new Dimension(25, 25));
		btnOdustani = new JButton("Odustani");
		btnOdustani.setActionCommand("SefKatedre");
		setButton(btnOdustani);
		btnOdustani.setPreferredSize(new Dimension(25, 25));
		
		panel = new JPanel();
		panel.add(btnIzmeni);
		panel.add(btnOdustani);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		panel.setLayout(new GridLayout(1, 2, 15, 0));
		
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		this.add(panel, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.CENTER);
	}
	
	public void initComponents() {
		btnIzmeni.setText(AppFrame.getInstance().getResourceBundle().getString("btnIzmeni"));
		btnOdustani.setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	private void setButton(JButton button) {
		button.setMargin(new Insets(1, 4, 1, 4));
	}
	
	public void addBtnPotvrdiProfesoraListener(MouseListener ml, ActionListener al) {
		btnIzmeni.addMouseListener(ml);
		btnIzmeni.addActionListener(al);
	}
	

	public void addOdustaniProfesorBtnListener(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}
	
	public void initTable() {
		ArrayList<Profesor> profesori = AppData.getInstance().getProfesori();
		dozvoljeniProfesori = new ArrayList<Profesor>();
		for(Profesor p : profesori) {
			if(p.getZvanje().equalsIgnoreCase("redovni_profesor") || p.getZvanje().equalsIgnoreCase("vanredni_profesor") && p.getGodineStaza()>=5) {
				Object[] data = {p.getIme() + " " + p.getPrezime()};
				tableModel.addRow(data);
				dozvoljeniProfesori.add(p);
			}
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
	
	public ArrayList<Profesor> getDozvoljeniProfesori() {
		return dozvoljeniProfesori;
	}

	public void setDozvoljeniProfesori(ArrayList<Profesor> dozvoljeniProfesori) {
		this.dozvoljeniProfesori = dozvoljeniProfesori;
	}
}
