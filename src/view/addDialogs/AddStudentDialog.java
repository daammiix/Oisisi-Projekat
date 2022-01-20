package view.addDialogs;

import java.awt.*;
import javax.swing.*;
import view.AppFrame;

public class AddStudentDialog extends AddDialog{
	
	private static final long serialVersionUID = -8852044026022448578L;

	public AddStudentDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		panelInformacije.getCentralPanel().setLayout(new GridLayout(10, 2, 0, 20));
		
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Ime") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Prezime") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Datun_rodjenja") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Adresa") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Broj_telefona") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Email") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Indeks") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Godina_upisa") + "*");
		String[] godStud = {"I", "II", "III", "IV"};
		panelInformacije.addPairLabelComboBox(AppFrame.getInstance().getResourceBundle().getString("Trenutna_godina_studija"), godStud);
		String[] nacFin = {AppFrame.getInstance().getResourceBundle().getString("Budzet"), AppFrame.getInstance().getResourceBundle().getString("Samofinansiranje")};
		panelInformacije.addPairLabelComboBox(AppFrame.getInstance().getResourceBundle().getString("Nacin_finansiranja"), nacFin);
		
		panelInformacije.getCentralPanel().setBorder(BorderFactory.createEmptyBorder(20, 90, 15, 90));
		this.add(panelInformacije.getCentralPanel(), BorderLayout.CENTER);
		
		panelInformacije.getBtnPotvrdi().setActionCommand("Student");
		panelInformacije.getBtnOdustani().setActionCommand("Student");
	}
	
	public void initComponents() {
		this.panelInformacije.getBtnPotvrdi().setText(AppFrame.getInstance().getResourceBundle().getString("btnPotvrdi"));
		this.panelInformacije.getBtnOdustani().setText(AppFrame.getInstance().getResourceBundle().getString("btnOdustani"));
	}
	
}