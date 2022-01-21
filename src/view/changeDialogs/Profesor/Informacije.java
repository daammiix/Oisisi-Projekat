package view.changeDialogs.Profesor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Adresa;
import model.Predmet;
import model.Profesor;
import util.Util;
import view.AppFrame;
import view.panelInformacije.PanelInformacijeWithComboBoxes;

public class Informacije extends PanelInformacijeWithComboBoxes{

	private static final long serialVersionUID = -5108782296187534548L;
	public Informacije() {
		super();
		this.changeProfesorInformacije();
	}
	
	private void changeProfesorInformacije() {
		centralPanel.setLayout(new GridLayout(10, 2, 0, 20));
		
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Ime") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Prezime") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Datum_rodjenja") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Adresa") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Broj_telefona") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Email") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Adresa_kancelarije") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Licna") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Zvanje") + "*");
		addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Staz") + "*");
		
		
		this.setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		this.btnPotvrdi.setActionCommand("Profesor");
		this.btnOdustani.setActionCommand("Profesor");
		btnPanel.add(btnPotvrdi);
		btnPanel.add(btnOdustani);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
		this.add(centralPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
	
	public void initComponents() {
		btnPotvrdi.setText(AppFrame.getInstance().getResourceBundle().getString("btnPotvrdi"));
		btnOdustani.setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
		ArrayList<JLabel> labels = getLabels();
		labels.get(0).setText(AppFrame.getInstance().getResourceBundle().getString("Ime") + "*");
		labels.get(1).setText(AppFrame.getInstance().getResourceBundle().getString("Prezime") + "*");
		labels.get(2).setText(AppFrame.getInstance().getResourceBundle().getString("Datum_rodjenja") + "*");
		labels.get(3).setText(AppFrame.getInstance().getResourceBundle().getString("Adresa") + "*");
		labels.get(4).setText(AppFrame.getInstance().getResourceBundle().getString("Broj_telefona") + "*");
		labels.get(5).setText(AppFrame.getInstance().getResourceBundle().getString("Email") + "*");
		labels.get(6).setText(AppFrame.getInstance().getResourceBundle().getString("Adresa_kancelarije") + "*");
		labels.get(7).setText(AppFrame.getInstance().getResourceBundle().getString("Licna") + "*");
		labels.get(8).setText(AppFrame.getInstance().getResourceBundle().getString("Zvanje") + "*");
		labels.get(9).setText(AppFrame.getInstance().getResourceBundle().getString("Staz") + "*");
	}
	
	public void fillInProfesor(Profesor profesor) {
		String ime = profesor.getIme();
		String prezime = profesor.getPrezime();
		Date datumRodjenja = profesor.getDatumRodjenja();
		Adresa adresa = profesor.getAdresaStanovanja();
		String brTel = profesor.getKontaktTelefon();
		String email = profesor.getEmail();
		Adresa adresaK = profesor.getAdresaKancelarije();
		String brLicKar = profesor.getBrojLicneKarte();
		String zvanje = profesor.getZvanje();
		int brGodStaza = profesor.getGodineStaza();
		
		textFields.get(0).setText(ime);
		textFields.get(1).setText(prezime);
		String datumRodjenjaStr = Util.formatter.format(datumRodjenja);
		textFields.get(2).setText(datumRodjenjaStr);
		String adr1 = adresa.getUlica() + ", " + adresa.getBroj() + ", " + adresa.getGrad() + ", " + adresa.getDrzava();
		textFields.get(3).setText(adr1);
		textFields.get(4).setText(brTel);
		textFields.get(5).setText(email);
		String adr2 = adresaK.getUlica() + ", " + adresaK.getBroj() + ", " + adresaK.getGrad() + ", " + adresaK.getDrzava();
		textFields.get(6).setText(adr2);
		textFields.get(7).setText(brLicKar);
		textFields.get(8).setText(zvanje);
		textFields.get(9).setText(Integer.toString(brGodStaza));
		
	}
}
