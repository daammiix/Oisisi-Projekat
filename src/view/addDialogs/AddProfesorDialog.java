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
		
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Ime") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Prezime") + "*");
		panelInformacije.addPairLabelTextField(AppFrame.getInstance().getResourceBundle().getString("Datun_rodjenja") + "*");
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
	}
	
}