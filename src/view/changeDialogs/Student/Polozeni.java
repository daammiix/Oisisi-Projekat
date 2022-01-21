package view.changeDialogs.Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Ocena;
import model.Student;
import util.Util;
import view.AppFrame;

public class Polozeni extends JPanel {
	private static final long serialVersionUID = 2705682130776803296L;
	private JPanel topPanel;
	private DefaultTableModel tableModel;
	private JTable tableIspiti;
	private JPanel botPanel;
	private JButton btnPonisti;
	private JLabel prosecnaOcena;
	private JLabel uEspb;
	
	public Polozeni() {
		super();
		this.setLayout(new BorderLayout(0, 20));
		init();
	}
	
	public void init() {
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		btnPonisti = new JButton("Poništi ocenu");
		btnPonisti.setBackground(Util.buttonBackgroundColor);
		btnPonisti.setForeground(Util.buttonForegroundColor);
		btnPonisti.setMargin(new Insets(1, 4, 1, 4));
		topPanel.add(btnPonisti);
		
		String[] columns = {"Šifra predmeta", "Naziv predmeta", "ESPB", "Ocena", "Datum"};
		tableModel = new DefaultTableModel(columns, 0);
		tableIspiti = Util.createTable(tableModel);
		tableIspiti.getColumnModel().getColumn(0).setPreferredWidth(180);
		tableIspiti.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableIspiti.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableIspiti.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableIspiti.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		JScrollPane sp = new JScrollPane(tableIspiti, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		botPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 5));
		prosecnaOcena = new JLabel();
		uEspb = new JLabel();
		Box box = Box.createVerticalBox();
		box.add(prosecnaOcena);
		box.add(Box.createVerticalStrut(10));
		box.add(uEspb);
		botPanel.add(box);
		
		this.add(topPanel, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(botPanel, BorderLayout.SOUTH);
		this.setBorder(BorderFactory.createEmptyBorder(20, 35, 40, 35));
	}
	
	public void initComponents() {
		btnPonisti.setText(AppFrame.getInstance().getResourceBundle().getString("btnPonisti"));
		String[] columns = {AppFrame.getInstance().getResourceBundle().getString("Sifra")
				, AppFrame.getInstance().getResourceBundle().getString("Naziv")
				, AppFrame.getInstance().getResourceBundle().getString("Broj_espb")
				, AppFrame.getInstance().getResourceBundle().getString("Ocena")
				, AppFrame.getInstance().getResourceBundle().getString("Datum")};
		tableModel.setColumnIdentifiers(columns);
	}
	
	public void setProsecnaOcena(Double po, Student s) {
		prosecnaOcena.setText(AppFrame.getInstance().getResourceBundle().getString("Prosecna_ocena")+ ": " + String.format("%.2f", po));
		s.setProsecnaOcena(po);
	}
	
	public void setUkupnoEspb(String espb) {
		uEspb.setText(AppFrame.getInstance().getResourceBundle().getString("Ukupno_espb")+ ": " + espb);
	}
	
	public void refreshInfo(Student s) {
		clearTable();
		double sum = 0;
		int uEspb = 0;
		for(Ocena o : s.getPolozeniIspiti()) {
			String sifra = o.getPredmet().getSifraPredmeta();
			String naziv = o.getPredmet().getNazivPredmeta();
			int espb = o.getPredmet().getEspb();
			int ocena = o.getOcena();
			String datum = Util.formatter.format(o.getDatum());
			
			Object[] data = {sifra, naziv, espb, ocena, datum};
			tableModel.addRow(data);
			uEspb += espb;
			sum += ocena;
		}
		if(sum == 0) {
			setProsecnaOcena(0.0, s);
			setUkupnoEspb("0");
			return;
		}
		double ocena = sum / s.getPolozeniIspiti().size();
		s.setProsecnaOcena(ocena);
		
		setProsecnaOcena( ocena, s);
		setUkupnoEspb(String.format("%d", uEspb));
	}
	
	public void clearTable() {
		tableModel.setRowCount(0);
	}
	
	public void addBtnPonistiActionListener(ActionListener al) {
		btnPonisti.addActionListener(al);
	}
	
	public JTable getTableIspit() {
		return this.tableIspiti;
	}
	
}
