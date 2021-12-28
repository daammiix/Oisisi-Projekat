package view.polaganjeDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import model.Ocena;
import view.changeDialogs.Student.ChangeStudentDialog;
import view.panelInformacije.PanelInformacijeWithComboBoxes;

public class PolaganjeDialog extends JDialog {
	
	private static final long serialVersionUID = 1967174485548048968L;
	
	PanelInformacijeWithComboBoxes panel;
	
	public PolaganjeDialog(ChangeStudentDialog parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth()/2, parent.getHeight()/2);
		init();
	}
	
	private void init() {
		panel = new PanelInformacijeWithComboBoxes();
		
		panel.getCentralPanel().setLayout(new GridLayout(4, 2, 0, 10));
		panel.getBtnPanel().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 35));
		
		panel.addPairLabelTextField("Šifra*");
		panel.addPairLabelTextField("Naziv*");
		
		String[] ocene = {"6", "7", "8", "9", "10"};
		panel.addPairLabelComboBox("Ocena*", ocene);
		panel.addPairLabelTextField("Datum*");
		
		panel.getBtnPanel().add(panel.getBtnPotvrdi());
		panel.getBtnPanel().add(panel.getBtnOdustani());
		
		panel.add(panel.getCentralPanel(), BorderLayout.CENTER);
		panel.add(panel.getBtnPanel(), BorderLayout.SOUTH);
		panel.setBorder(BorderFactory.createEmptyBorder(25, 20, 0, 20));
		
		panel.getTextFields().get(0).setEditable(false);
		panel.getTextFields().get(0).setBackground(Color.LIGHT_GRAY);
		
		panel.getTextFields().get(1).setEditable(false);
		panel.getTextFields().get(1).setBackground(Color.LIGHT_GRAY);
		
		panel.getBtnOdustani().setActionCommand("Polaganje");
		panel.getBtnPotvrdi().setActionCommand("Polaganje");
		
		this.add(panel);
	}
	
	public void fillInfo(Ocena o) {
		panel.getTextFields().get(0).setText(o.getPredmet().getSifraPredmeta());
		panel.getTextFields().get(1).setText(o.getPredmet().getNazivPredmeta());	
		panel.getComboBoxes().get(0).setSelectedIndex(0);
		panel.getTextFields().get(2).setText("");
	}
	
	public PanelInformacijeWithComboBoxes getPanel() {
		return this.panel;
	}
}
