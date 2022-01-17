package controller.potvrdiOdustani;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import util.Util;
import view.AppView;

public class BtnOdustaniChangeDialog implements MouseListener{
private AppView view;
	
	public BtnOdustaniChangeDialog(AppView view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		switch(btn.getActionCommand()) {
			case "Student":
				{
					view.getChangeStudentDialog().setVisible(false);
					break;
				}
			case "Profesor":
				{
					view.getChangeProfesorDialog().setVisible(false);
					break;
				}
			case "Predmet":
				{
					view.getChangePredmetDialog().setVisible(false);
					break;
				}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
