package controller.changeSubject;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import util.Util;
import view.*;


public class BtnMinusListener implements MouseListener{
private AppView view;
private String message;
	
	public BtnMinusListener(AppView view) {
		this.view = view;
		
		message = "Ne postoji profesor";
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if(!btn.isEnabled()) {
			JOptionPane.showMessageDialog(view.getChangeStudentDialog(), message, "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			view.getRemoveProfessorDialog().setLocationRelativeTo(view.getFrame());
			view.getRemoveProfessorDialog().setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		ArrayList<JTextField> textFields;
		textFields = view.getChangePredmetDialog().getTextFields();
		if(doesProfessorExists(textFields))
		{
			btn.setEnabled(true);
			btn.setBackground(Util.buttonEnteredColor);
		}
		else
			btn.setEnabled(false);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		ArrayList<JTextField> textFields;
		textFields = view.getChangePredmetDialog().getTextFields();
		if(doesProfessorExists(textFields))
		{
			btn.setBackground(null);
			btn.setEnabled(true);
		}
		else
			btn.setEnabled(false);

	}
	
	
	public boolean doesProfessorExists(ArrayList<JTextField> textFields) {
		String textF = textFields.get(3).getText();
		String text = textF.trim();
		if(text.equals("")) {
			return false;
		} else return true;
	}
}
