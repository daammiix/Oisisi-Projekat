package view.katedraDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Katedra;
import model.Predmet;
import model.Profesor;
import view.AppFrame;

public class TrenutniSefKatedre extends JDialog {

	private static final long serialVersionUID = 4618477342134113442L;
	
	private JPanel mainPanel;
	private JPanel btnPanel;
	private JTextField textField;
	private JButton btnOdustani;
	private JButton btnPlus;
	private JButton btnMinus;
	
	public TrenutniSefKatedre(AppFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		this.setSize(parent.getWidth() / 2, parent.getHeight() / 3);
		this.setResizable(false);
		
		textField = new JTextField();
		//textField.setEnabled(false);
		textField.setPreferredSize(new Dimension(100, 25));
		textField.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
		mainPanel = new JPanel();
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
		btnOdustani = new JButton("Zavrsi");
		btnOdustani.setActionCommand("TrenutniSefKatedre");
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		
		JLabel lProfesor = new JLabel("Profesor");
		lProfesor.setPreferredSize(new Dimension(100, 25));
		
		Box box1 = createBox(lProfesor, textField);
		box1.add(Box.createHorizontalStrut(15));
		box1.add(btnPlus);
		box1.add(Box.createHorizontalStrut(15));
		box1.add(btnMinus);
		
		mainPanel.add(box1);
		
		btnPanel.add(btnOdustani);
		btnPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		this.add(BorderLayout.CENTER, mainPanel);
		this.add(BorderLayout.SOUTH, btnPanel);
	}
	
	public JButton getBtnOdustani() {
		return btnOdustani;
	}

	public void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}

	public JButton getBtnPlus() {
		return btnPlus;
	}

	public void setBtnPlus(JButton btnPlus) {
		this.btnPlus = btnPlus;
	}

	public JButton getBtnMinus() {
		return btnMinus;
	}

	public void setBtnMinus(JButton btnMinus) {
		this.btnMinus = btnMinus;
	}

	public void addOdustaniProfesorBtnListener(MouseListener ml) {
		btnOdustani.addMouseListener(ml);
	}
	
	public void addPlusSefBtnListener(MouseListener ml) {
		btnPlus.addMouseListener(ml);
	}
	
	public void addMinusSefBtnListener(MouseListener ml) {
		btnMinus.addMouseListener(ml);
	}
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextFields(JTextField textField) {
		this.textField = textField;
	}
	
	private Box createBox(JLabel label, JTextField tf) {
		Box box2 = Box.createHorizontalBox();
		box2.add(label);
		box2.add(Box.createHorizontalStrut(15));
		box2.add(tf);
		return box2;
	}
	
	public void fillInSefKatedre(Katedra katedra) {
		Profesor profesor = katedra.getSefKatedre();
		if(profesor == null) {
			textField.setText("");
		} else {
			textField.setText(profesor.getIme() + " " + profesor.getPrezime());
		}
	}
	

}
