package controller.potvrdiOdustani;

import java.awt.event.*;
import javax.swing.*;
import util.Util;
import view.*;

public class BtnNeListener implements MouseListener {
private AppView view;
	
	public BtnNeListener(AppView view) {
		this.view = view;

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getActionCommand()) {
			case "Student":
				{
					view.getDeleteStudentDialog().setVisible(false);
					break;
				}
			case "Profesor":
				{
					view.getDeleteProfesorDialog().setVisible(false);
					break;
				}
			case "Predmet":
				{
					view.getDeletePredmetDialog().setVisible(false);
					break;
				}
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
		btn.setBackground(Util.buttonEnteredColor);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(null);
		btn.setEnabled(true);
	}
}
