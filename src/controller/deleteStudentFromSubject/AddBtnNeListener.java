package controller.deleteStudentFromSubject;

import java.awt.event.*;
import javax.swing.*;
import util.Util;
import view.*;

public class AddBtnNeListener implements MouseListener{

	private AppView view;
	public AddBtnNeListener(AppView view) {
		this.view = view;

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		view.getDeleteStudentFromSubject().setVisible(false);
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
