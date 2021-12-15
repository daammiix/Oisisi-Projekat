package view.panelInformacije;

import javax.swing.*;
import java.util.ArrayList;

public class PanelInformacijeWithComboBoxes extends PanelInformacije {
	private static final long serialVersionUID = -167517918124303838L;
	protected ArrayList<JComboBox<String>> comboBoxes;
	
	public PanelInformacijeWithComboBoxes() {
		comboBoxes = new ArrayList<JComboBox<String>>();
	}
	
	public void addPairLabelComboBox(String labelName, String[] comboItemsNames) {
		JLabel label = new JLabel(labelName);
		JComboBox<String> comboBox = new JComboBox<String>(comboItemsNames);
		comboBox.setName(labelName.substring(0, labelName.length()-1));
		centralPanel.add(label);
		centralPanel.add(comboBox);
		labels.add(label);
		comboBoxes.add(comboBox);
	}
	
	public void refreshComboBoxes() {
		for(JComboBox<String> cb : comboBoxes)
			cb.setSelectedIndex(0);
	}
	
	// getters and setters

	public ArrayList<JComboBox<String>> getComboBoxes() {
		return comboBoxes;
	}

	public void setComboBoxes(ArrayList<JComboBox<String>> comboBoxes) {
		this.comboBoxes = comboBoxes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
