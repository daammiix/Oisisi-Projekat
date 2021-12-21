package view.addDialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import view.AppFrame;

public class AddProfesorDialog extends AddDialog{

	private static final long serialVersionUID = 4215258431334576524L;

	public AddProfesorDialog(AppFrame parent, String title, boolean modal) {
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
	
}