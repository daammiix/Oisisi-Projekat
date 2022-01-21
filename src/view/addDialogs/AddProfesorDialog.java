package view.addDialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import view.AppFrame;

public class AddProfesorDialog extends AddDialog{

	private static final long serialVersionUID = 4215258431334576524L;

	public AddProfesorDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		panelInformacije.getCentralPanel().setLayout(new GridLayout(10, 2, 0, 20));
		
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Ime") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Prezime") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Datum_rodjenja") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Adresa") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Broj_telefona") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Email") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Adresa_kancelarije") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Licna") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Zvanje") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Staz") + "*");
		
		panelInformacije.getCentralPanel().setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		this.add(panelInformacije.getCentralPanel(), BorderLayout.CENTER);
		
		panelInformacije.getBtnPotvrdi().setActionCommand("Profesor");
		panelInformacije.getBtnOdustani().setActionCommand("Profesor");
	}
	
	public void initComponents() {
		this.panelInformacije.getBtnPotvrdi().setText(AppFrame.getInstance().getResourceBundle().getString("btnPotvrdi"));
		this.panelInformacije.getBtnOdustani().setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
		ArrayList<JLabel> labels = panelInformacije.getLabels();
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
	
}