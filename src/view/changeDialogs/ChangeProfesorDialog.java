package view.changeDialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Adresa;
import model.Profesor;
import util.Util;
import view.AppFrame;

public class ChangeProfesorDialog extends ChangeDialog {

	private static final long serialVersionUID = -2979043114439733749L;

	public ChangeProfesorDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		panelInformacije.getCentralPanel().setLayout(new GridLayout(10, 2, 0, 20));
		
		panelInformacije.addPairLabelTextField("Ime*");
		panelInformacije.addPairLabelTextField("Prezime*");
		panelInformacije.addPairLabelTextField("Datum rođenja*");
		panelInformacije.addPairLabelTextField("Adresa stanovanja*");
		panelInformacije.addPairLabelTextField("Broj telefona*");
		panelInformacije.addPairLabelTextField("E-mail adresa*");
		panelInformacije.addPairLabelTextField("Adresa kancelarije*");
		panelInformacije.addPairLabelTextField("Broj licne karte*");
		panelInformacije.addPairLabelTextField("Zvanje*");
		panelInformacije.addPairLabelTextField("Broj godina staza*");
		
		panelInformacije.getCentralPanel().setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		this.add(panelInformacije.getCentralPanel(), BorderLayout.CENTER);
		
		panelInformacije.getBtnPotvrdi().setActionCommand("Profesor");
		panelInformacije.getBtnOdustani().setActionCommand("Profesor");
		
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
		
		ArrayList<JTextField> textFields = panelInformacije.getTextFields();
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
