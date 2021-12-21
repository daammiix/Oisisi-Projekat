package view.addDialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;

import view.AppFrame;

public class AddPredmetDialog extends AddDialog {

	private static final long serialVersionUID = 4096610483633397937L;

	public AddPredmetDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		panelInformacije.getCentralPanel().setLayout(new GridLayout(5, 2, 0, 20));
		this.setSize(parent.getWidth() / 2, parent.getHeight() - 220);
		
		panelInformacije.addPairLabelTextField("Sifra*");
		panelInformacije.addPairLabelTextField("Naziv*");
		panelInformacije.addPairLabelTextField("Espb*");
		String[] semestar = {"Letnji", "Zimski"};
		panelInformacije.addPairLabelComboBox("Semestar*", semestar);
		String[] godina = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
		panelInformacije.addPairLabelComboBox("God*", godina);
		
		panelInformacije.getCentralPanel().setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));
		this.add(panelInformacije.getCentralPanel(), BorderLayout.CENTER);
		
		this.panelInformacije.getBtnPotvrdi().setActionCommand("Predmet");
		this.panelInformacije.getBtnOdustani().setActionCommand("Predmet");
	}
	
}