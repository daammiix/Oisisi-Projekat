package view.changeDialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.AppFrame;

public class ChangeStudentDialog extends ChangeDialog {

	private static final long serialVersionUID = 6484156735480732897L;

	public ChangeStudentDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		panelInformacije.getCentralPanel().setLayout(new GridLayout(10, 2, 0, 40));
		
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
		
		JTabbedPane centralPanel = new JTabbedPane();
		
		centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
	
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();


		panel1.add(panelInformacije.getCentralPanel());
		centralPanel.add("Informacije", panel1);
		centralPanel.add("Polozeni", panel2);
		centralPanel.add("Nepolozeni", panel3);
		
		this.add(centralPanel, BorderLayout.CENTER);
	}
}
