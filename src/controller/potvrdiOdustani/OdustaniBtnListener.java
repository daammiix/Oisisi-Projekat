package controller.potvrdiOdustani;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import util.Util;
import view.AppView;

public class OdustaniBtnListener implements MouseListener {
	private AppView view;
	
	public OdustaniBtnListener(AppView view) {
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
					view.getAddStudentDialog().setVisible(false);
					view.getAddStudentDialog().getPanelInformacije().clearTextFields();
					view.getAddStudentDialog().getPanelInformacije().refreshComboBoxes();
					break;
				}
			case "Profesor":
				{
					view.getAddProfesorDialog().setVisible(false);
					view.getAddProfesorDialog().getPanelInformacije().clearTextFields();
					break;
				}
			case "Predmet":
				{
					view.getAddPredmetDialog().setVisible(false);
					view.getAddPredmetDialog().getPanelInformacije().clearTextFields();
					view.getAddPredmetDialog().getPanelInformacije().refreshComboBoxes();
					break;
				}
			case "Polaganje":
				{
					view.getPolaganjeDialog().setVisible(false);
					break;
				}
			case "Odustani od dodavanja predmeta":
				{
					view.getDodavanjePredmetaProfesoruDialog().setVisible(false);
				}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Util.buttonEnteredColor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		btn.setBackground(null);
	}

}
