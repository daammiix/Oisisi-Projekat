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
			btn.setBackground(null);
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
		if(btn.isEnabled())
		{
			btn.setBackground(Util.buttonEnteredColor);
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn.isEnabled())
		{
			btn.setBackground(null);
		}
	}
}
