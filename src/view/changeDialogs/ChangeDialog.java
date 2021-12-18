package view.changeDialogs;

import javax.swing.BorderFactory;
import javax.swing.JDialog;

import view.AppFrame;
import view.panelInformacije.PanelInformacijeWithComboBoxes;
import java.awt.*;

public class ChangeDialog extends JDialog {

	private static final long serialVersionUID = 632357483747789917L;
	protected PanelInformacijeWithComboBoxes panelInformacije;
	
	public ChangeDialog(AppFrame parent, String title, boolean modal) {
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
	
	public PanelInformacijeWithComboBoxes getPanelInformacije() {
		return this.panelInformacije;
	}
}
