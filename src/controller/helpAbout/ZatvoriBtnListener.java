package controller.helpAbout;

import java.awt.event.*;
import javax.swing.*;
import util.Util;
import view.*;

public class ZatvoriBtnListener implements MouseListener{
private AppView view;
	
	public ZatvoriBtnListener(AppView view) {
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		switch(btn.getActionCommand()) {
			case "About":
				{
					view.getAboutDialog().setVisible(false);
					break;
				}
			case "Help":
				{
					view.getHelpDialog().setVisible(false);
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
