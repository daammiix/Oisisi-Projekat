package controller.changeSubject;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import util.Util;
import view.*;

public class BtnPlusListener implements MouseListener{
	private AppView view;
	private String message;
		
	public BtnPlusListener(AppView view) {
		this.view = view;
		
		message = "Profesor vec postoji";
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if(!btn.isEnabled()) {
			JOptionPane.showMessageDialog(view.getChangeStudentDialog(), message, "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			view.getChooseProfessorDialog().setLocationRelativeTo(view.getFrame());
			view.getChooseProfessorDialog().setVisible(true);
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
		if(btn.isEnabled())
		{
			btn.setBackground(Util.buttonEnteredColor);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		ArrayList<JTextField> textFields;
		textFields = view.getChangePredmetDialog().getTextFields();
		if(btn.isEnabled())
		{
			btn.setBackground(null);
		}
	}
	
	
	public boolean doesProfessorExists(ArrayList<JTextField> textFields) {
		String textF = textFields.get(3).getText();
		String text = textF.trim();
		if(text.equals("")) {
			return false;
		} else return true;
	}
}
