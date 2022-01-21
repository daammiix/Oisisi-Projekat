package view.addDialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import view.AppFrame;

public class AddPredmetDialog extends AddDialog {

	private static final long serialVersionUID = 4096610483633397937L;

	public AddPredmetDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		panelInformacije.getCentralPanel().setLayout(new GridLayout(5, 2, 0, 20));
		this.setSize(parent.getWidth() / 2, parent.getHeight() - 220);
		
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Sifra") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Naziv") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Broj_espb") + "*");
		String[] semestar = {AppFrame.getInstance().getResourceBundle().getString("Letnji"), AppFrame.getInstance().getResourceBundle().getString("Zimski")};
		panelInformacije.addPairLabelComboBox(AppFrame.getInstance().getResourceBundle().getString("Semestar") + "*", semestar);
		String[] godina = {"I", "II", "III", "IV"};
		panelInformacije.addPairLabelComboBox(AppFrame.getInstance().getResourceBundle().getString("Godina_studija") + "*", godina);
		
		panelInformacije.getCentralPanel().setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));
		this.add(panelInformacije.getCentralPanel(), BorderLayout.CENTER);
		
		this.panelInformacije.getBtnPotvrdi().setActionCommand("Predmet");
		this.panelInformacije.getBtnOdustani().setActionCommand("Predmet");
	}
	
	public void initComponents() {
		this.panelInformacije.getBtnPotvrdi().setText(AppFrame.getInstance().getResourceBundle().getString("btnPotvrdi"));
		this.panelInformacije.getBtnOdustani().setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
		ArrayList<JLabel> labels = panelInformacije.getLabels();
		labels.get(0).setText(AppFrame.getInstance().getResourceBundle().getString("Sifra") + "*");
		labels.get(1).setText(AppFrame.getInstance().getResourceBundle().getString("Naziv") + "*");
		labels.get(2).setText(AppFrame.getInstance().getResourceBundle().getString("Broj_espb") + "*");
		String[] semestar = {AppFrame.getInstance().getResourceBundle().getString("Letnji"), AppFrame.getInstance().getResourceBundle().getString("Zimski")};
		labels.get(3).setText(AppFrame.getInstance().getResourceBundle().getString("Semestar") + "*");
		String[] godStud = {"I", "II", "III", "IV"};
		labels.get(4).setText(AppFrame.getInstance().getResourceBundle().getString("Godina_studija") + "*");
	}
	
}
