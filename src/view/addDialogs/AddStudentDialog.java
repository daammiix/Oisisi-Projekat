package view.addDialogs;

import java.awt.*;
import javax.swing.*;
import view.AppFrame;

public class AddStudentDialog extends AddDialog{
	
	private static final long serialVersionUID = -8852044026022448578L;

	public AddStudentDialog(AppFrame parent, String title, boolean modal) {
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
		this.add(panelInformacije.getCentralPanel(), BorderLayout.CENTER);
		
		panelInformacije.getBtnPotvrdi().setActionCommand("Student");
		panelInformacije.getBtnOdustani().setActionCommand("Student");
	}
	
}