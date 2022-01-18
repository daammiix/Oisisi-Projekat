package controller.katedra;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import util.Util;
import view.*;

public class BtnMinusSefListener implements MouseListener{
	private AppView view;
	private String message;
		
		public BtnMinusSefListener(AppView view) {
			this.view = view;
			
			message = "Ne postoji sef katedre";
		}

		
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton btn = (JButton) e.getSource();
			if(!btn.isEnabled()) {
				JOptionPane.showMessageDialog(view.getChangeStudentDialog(), message, "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				view.getRemoveSefKatedreDialog().setLocationRelativeTo(view.getFrame());
				view.getRemoveSefKatedreDialog().setVisible(true);
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
			JTextField textField;
			textField = view.getTrenutniSefKatedre().getTextField();
			if(btn.isEnabled())
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
			JTextField textField;
			textField = view.getTrenutniSefKatedre().getTextField();
			if(btn.isEnabled())
			{
				btn.setBackground(null);
				btn.setEnabled(true);
			}
			else
				btn.setEnabled(false);

		}
		
		public boolean doesSefExists(JTextField textField) {
			String textF = textField.getText();
			String text = textF.trim();
			if(text.equals("")) {
				return false;
			} else return true;
		}
}
