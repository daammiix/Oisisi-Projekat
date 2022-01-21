package view.changeDialogs.Profesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Predmet;
import model.Profesor;
import util.Util;
import view.AppFrame;

public class Predmeti extends JPanel {
	private JButton btnDodaj;
	private JButton btnUkloni;
	private DefaultTableModel tmodel;
	private JTable table;
	
	private static final long serialVersionUID = 5257298610456900864L;
	
	public Predmeti() {
		super();
		this.init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout(0, 10));
		
		btnDodaj = new JButton("Dodaj predmet");
		
		btnUkloni = new JButton("Ukloni predmet");
		
		String[] columns = {"Šifra", "Naziv", "Godina studija", "Semestar"};
		tmodel = new DefaultTableModel(columns, 0);
		
		table = Util.createTable(tmodel);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.setTableColumnsWidth();
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		Box btnBox = Box.createHorizontalBox();
		btnBox.add(btnDodaj);
		btnBox.add(Box.createHorizontalStrut(40));
		btnBox.add(btnUkloni);
		
		this.add(btnBox, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 30, 15));
	}
	
	public void initComponents() {
		btnDodaj.setText(AppFrame.getInstance().getResourceBundle().getString("btnDodaj"));
		btnUkloni.setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
		String[] columns = {AppFrame.getInstance().getResourceBundle().getString("Sifra")
				, AppFrame.getInstance().getResourceBundle().getString("Naziv")
				, AppFrame.getInstance().getResourceBundle().getString("Godina_studija")
				, AppFrame.getInstance().getResourceBundle().getString("Semestar")};
		tmodel.setColumnIdentifiers(columns);
	}
	
	private void setTableColumnsWidth() {
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
	}
	
	public void refreshInfo(Profesor p) {
		tmodel.setRowCount(0);
		ArrayList<Predmet> predmeti = p.getPredmeti();
		System.out.println(predmeti.size());
		for(Predmet pr : predmeti) {
			Object[] data = {pr.getSifraPredmeta(), pr.getNazivPredmeta(), pr.getGodinaStudija(), 
					pr.getSemestar()};
			tmodel.addRow(data);
		}
	}
	
	public void addBtnDodajListener(ActionListener al) {
		btnDodaj.addActionListener(al);
	}
	
	public void addBtnUkloniListener(ActionListener al) {
		btnUkloni.addActionListener(al);
	}
	
	
	// setters and getters
	
	public JButton getDodaj() {
		return btnDodaj;
	}

	public void setDodaj(JButton dodaj) {
		this.btnDodaj = dodaj;
	}

	public JButton getUkloni() {
		return btnUkloni;
	}

	public void setUkloni(JButton ukloni) {
		this.btnUkloni = ukloni;
	}

	public DefaultTableModel getTmodel() {
		return tmodel;
	}

	public void setTmodel(DefaultTableModel tmodel) {
		this.tmodel = tmodel;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}	
