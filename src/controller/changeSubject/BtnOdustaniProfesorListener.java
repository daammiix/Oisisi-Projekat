package controller.changeSubject;

import java.awt.event.*;
import javax.swing.*;
import util.Util;
import view.*;

public class BtnOdustaniProfesorListener implements MouseListener{
private AppView view;
	
	public BtnOdustaniProfesorListener(AppView view) {
		this.view = view;

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		switch(btn.getActionCommand()) {
			case "Remove":
				{
					view.getRemoveProfessorDialog().setVisible(false);
					break;
				}
			case "Choose":
				{
					view.getChooseProfessorDialog().setVisible(false);
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
