package view.addDialogs;

import javax.swing.*;

import view.AppFrame;
import view.panelInformacije.PanelInformacijeWithComboBoxes;
import java.awt.*;


public class AddDialog extends JDialog {
	protected PanelInformacijeWithComboBoxes panelInformacije;

	private static final long serialVersionUID = 6074145523826069140L;
	
	public AddDialog(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		panelInformacije = new PanelInformacijeWithComboBoxes();
		
		this.setSize(parent.getWidth() / 2, parent.getHeight() - 20);
		
		panelInformacije.getBtnPanel().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		panelInformacije.getBtnPanel().add(panelInformacije.getBtnPotvrdi());
		panelInformacije.getBtnPanel().add(panelInformacije.getBtnOdustani());
		panelInformacije.getBtnPanel().setBorder(BorderFactory.createEmptyBorder(15, 0, 25, 0));
		this.add(panelInformacije.getBtnPanel(), BorderLayout.SOUTH);
		this.setResizable(false);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public PanelInformacijeWithComboBoxes getPanelInformacije() {
		return this.panelInformacije;
	}
	
}
