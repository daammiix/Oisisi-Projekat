package controller.katedra;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import util.Util;
import view.*;

public class BtnPlusSefListener implements MouseListener{
	private AppView view;
	private String message;
		
	public BtnPlusSefListener(AppView view) {
		this.view = view;
		
		message = "Sef katedre vec postoji";
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if(!btn.isEnabled()) {
			JOptionPane.showMessageDialog(view.getChangeStudentDialog(), message, "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			view.getSefKatedreDialog().setLocationRelativeTo(view.getFrame());
			view.getSefKatedreDialog().setVisible(true);
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
