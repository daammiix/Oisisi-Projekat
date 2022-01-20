package view.panelInformacije;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentListener;

import view.AppCentralPanel;
import view.AppFrame;

public class PanelInformacije extends JPanel{
	private static final long serialVersionUID = -4852175226460687460L;
	private static PanelInformacije instance = null;
	protected ArrayList<JTextField> textFields;
	protected ArrayList<JLabel> labels;
	protected JButton btnPotvrdi;
	protected JButton btnOdustani;
	protected JPanel centralPanel;
	protected JPanel btnPanel;
	
	public static PanelInformacije getInstance() {
		if(instance == null)
			instance = new PanelInformacije();
		return instance;
	}

	

	public PanelInformacije() {
		super();
		this.setLayout(new BorderLayout(0, 20));
		textFields = new ArrayList<JTextField>();
		labels = new ArrayList<JLabel>();
		btnPotvrdi = new JButton("Potvrdi");
		btnOdustani = new JButton("Odustani");
		centralPanel = new JPanel();
		btnPanel = new JPanel();
	}
	
	public void addPairLabelTextField(String labelName) {
		JLabel label = new JLabel(labelName);
		JTextField textField = new JTextField(20);
		textField.setName(labelName.substring(0, labelName.length()-1));
		centralPanel.add(label);
		centralPanel.add(textField);
		labels.add(label);
		textFields.add(textField);
	}
	
	public void addBtnPotvrdiListener(MouseListener ml, ActionListener al) {
		btnPotvrdi.addMouseListener(ml);
		btnPotvrdi.addActionListener(al);
	}
	
	public void addBtnOdustaniListener(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}
	
	public void clearTextFields() {
		for(JTextField tf : textFields)
			tf.setText("");
	}
	
	public void connectDocumentListener(DocumentListener dl) {
		for(JTextField tf : textFields)
			tf.getDocument().addDocumentListener(dl);
	}
	
	// getters and setters

	public ArrayList<JTextField> getTextFields() {
		return textFields;
	}

	public void setTextFields(ArrayList<JTextField> textFields) {
		this.textFields = textFields;
	}

	public ArrayList<JLabel> getLabels() {
		return labels;
	}

	public void setLabels(ArrayList<JLabel> labels) {
		this.labels = labels;
	}

	public JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}

	public void setBtnPotvrdi(JButton btnPotvrdi) {
		this.btnPotvrdi = btnPotvrdi;
	}

	public JButton getBtnOdustani() {
		return btnOdustani;
	}

	public void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}

	public JPanel getCentralPanel() {
		return centralPanel;
	}

	public void setCentralPanel(JPanel centralPanel) {
		this.centralPanel = centralPanel;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
