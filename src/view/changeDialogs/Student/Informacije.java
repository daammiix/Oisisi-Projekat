package view.changeDialogs.Student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;

import model.Adresa;
import model.Student;
import util.Util;
import view.AppFrame;
import view.panelInformacije.PanelInformacijeWithComboBoxes;

public class Informacije extends PanelInformacijeWithComboBoxes {

	private static final long serialVersionUID = -4943585476185596272L;
	
	public Informacije() {
		super();
		this.changeStudentInformacije();
	}
	
	private void changeStudentInformacije() {
		centralPanel.setLayout(new GridLayout(10, 2, 0, 20));
		
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Ime") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Prezime") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Datun_rodjenja") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Adresa") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Broj_telefona") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Email") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Indeks") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Godina_upisa") + "*");
		String[] godStud = {"I", "II", "III", "IV"};
		addPairLabelComboBox(AppFrame.getInstance().getResourceBundle().getString("Trenutna_godina_studija"), godStud);
		String[] nacFin = {AppFrame.getInstance().getResourceBundle().getString("Budzet"), AppFrame.getInstance().getResourceBundle().getString("Samofinansiranje")};
		addPairLabelComboBox(AppFrame.getInstance().getResourceBundle().getString("Nacin_finansiranja"), nacFin);
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		this.btnPotvrdi.setActionCommand("Student");
		this.btnOdustani.setActionCommand("Student");
		btnPanel.add(btnPotvrdi);
		btnPanel.add(btnOdustani);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
		this.add(centralPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
	
	public void initComponents() {
		btnPotvrdi.setText(AppFrame.getInstance().getResourceBundle().getString("btnPotvrdi"));
		btnOdustani.setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
	}
	
	public void fillInStudent(Student s) {
		String ime = s.getIme();
		String prezime = s.getPrezime();
		Date datumRodjenja = s.getDatumRodjenja();
		Adresa adresa = s.getAdresaStanovanja();
		String brTelefona = s.getKontaktTelefon();
		String email = s.getEmail();
		String brIndeksa = s.getBrojIndeksa();
		int godinaUpisa = s.getGodinaUpisa();
		int trenutnaGod = s.getTrenutnaGodinaStudija();
		Student.Status status = s.getStatus();
		
		textFields.get(0).setText(ime);
		textFields.get(1).setText(prezime);
		String datumRodjenjaStr = Util.formatter.format(datumRodjenja);
		textFields.get(2).setText(datumRodjenjaStr);
		textFields.get(3).setText(adresa.getUlica() + ", " + adresa.getBroj() + ", " + adresa.getGrad() + ", " + 								adresa.getDrzava());
		textFields.get(4).setText(brTelefona);
		textFields.get(5).setText(email);
		textFields.get(6).setText(brIndeksa);
		textFields.get(7).setText(Integer.toString(godinaUpisa));
		switch(trenutnaGod) {
		case 1: comboBoxes.get(0).setSelectedIndex(0); break;
		case 2: comboBoxes.get(0).setSelectedIndex(1); break;
		case 3: comboBoxes.get(0).setSelectedIndex(2); break;
		case 4: comboBoxes.get(0).setSelectedIndex(3); break;
		}
		switch(status) {
		case B: comboBoxes.get(1).setSelectedIndex(0); break;
		case S: comboBoxes.get(1).setSelectedIndex(1); break;
		}
	}
	
}
