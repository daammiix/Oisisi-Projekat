package view.changeDialogs.Student;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Adresa;
import model.Student;
import util.Util;
import view.AppFrame;
import view.changeDialogs.ChangeDialog;

public class ChangeStudentDialog extends ChangeDialog {
	
	private JTabbedPane tabbedPane;
	private Polozeni polozeni;
	private Nepolozeni nepolozeni;

	private static final long serialVersionUID = 6484156735480732897L;

	public ChangeStudentDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		panelInformacije.getCentralPanel().setLayout(new GridLayout(10, 2, 0, 20));
		
		panelInformacije.addPairLabelTextField("Ime*");
		panelInformacije.addPairLabelTextField("Prezime*");
		panelInformacije.addPairLabelTextField("Datum rođenja*");
		panelInformacije.addPairLabelTextField("Adresa stanovanja*");
		panelInformacije.addPairLabelTextField("Broj telefona*");
		panelInformacije.addPairLabelTextField("E-mail adresa*");
		panelInformacije.addPairLabelTextField("Broj indeksa*");
		panelInformacije.addPairLabelTextField("Godina upisa*");
		String[] godStud = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		panelInformacije.addPairLabelComboBox("Trenutna godina studija*", godStud);
		String[] nacFin = {"Budžet", "Samofinansiranje"};
		panelInformacije.addPairLabelComboBox("Način finansiranja*", nacFin);
		
		panelInformacije.getCentralPanel().setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		panelInformacije.getBtnPotvrdi().setActionCommand("Student");
		panelInformacije.getBtnOdustani().setActionCommand("Student");
		
		tabbedPane = new JTabbedPane();
	
		polozeni = new Polozeni();
		nepolozeni = new Nepolozeni();

		tabbedPane.add("Informacije", panelInformacije.getCentralPanel());
		tabbedPane.add("Polozeni", polozeni);
		tabbedPane.add("Nepolozeni", nepolozeni);
		
		tabbedPane.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
		this.add(tabbedPane);
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
		
		
		ArrayList<JTextField> textFields = panelInformacije.getTextFields();
		ArrayList<JComboBox<String>> comboBoxes = panelInformacije.getComboBoxes();
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

	public JTabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	
	public Polozeni getPanelPolozeni() {
		return this.polozeni;
	}
	
	public Nepolozeni getPanelNepolozeni() {
		return this.nepolozeni;
	}
}
