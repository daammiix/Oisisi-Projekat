package view.changeDialogs.Student;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import util.Util;

public class Nepolozeni extends JPanel {
	private static final long serialVersionUID = 3236291496585565620L;
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPolaganje;
	private JTable table;
	private DefaultTableModel tableModel;
	
	public Nepolozeni() {
		super();
		this.setLayout(new BorderLayout(0, 15));
		init();
	}
	
	private void init() {
		String[] cols = {"Šifra predmeta", "Naziv predmeta", "ESPB", "Godina studija", "Semestar"};
		tableModel = new DefaultTableModel(cols, 0);
		table = Util.createTable(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnDodaj = new JButton("Dodaj");
		modifyButton(btnDodaj);
		
		btnObrisi = new JButton("Obriši");
		modifyButton(btnObrisi);
		
		btnPolaganje = new JButton("Polaganje");
		modifyButton(btnPolaganje);
		
		Box btnBox = Box.createHorizontalBox();
		btnBox.add(btnDodaj);
		btnBox.add(Box.createHorizontalStrut(15));
		btnBox.add(btnObrisi);
		btnBox.add(Box.createHorizontalStrut(15));
		btnBox.add(btnPolaganje);
		
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		this.add(btnBox, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(25, 40, 60, 40));
	}
	
	private void modifyButton(JButton btn) {
		btn.setBackground(Util.buttonBackgroundColor);
		btn.setForeground(Util.buttonForegroundColor);
		btn.setMargin(new Insets(1, 4, 1, 4));
	}
	
	public void refreshInfo(Student s) {
		clearTable();
		for(Ocena o : s.getNepolozeniIspiti()) {
			Predmet p = o.getPredmet();
			Object[] data = {p.getSifraPredmeta(), p.getNazivPredmeta(), p.getEspb(), p.getGodinaStudija(),
					p.getSemestar()};
			tableModel.addRow(data);
		}
		
	}
	
	public void clearTable() {
		tableModel.setRowCount(0);
	}
	
	public void addBtnObrisiActionListener(ActionListener al) {
		btnObrisi.addActionListener(al);
	}
	
	public void addBtnPolaganjeActionListener(ActionListener al) {
		btnPolaganje.addActionListener(al);
	}
	
	public JTable getTable() {
		return this.table;
	}
}
