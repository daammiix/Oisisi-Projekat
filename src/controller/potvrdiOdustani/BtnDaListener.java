package controller.potvrdiOdustani;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import model.AppData;
import model.Student;
import util.Util;
import view.*;
import view.addDialogs.AddProfesorDialog;
import view.deleteDialogs.*;


public class BtnDaListener implements MouseListener {
	
	private AppView view;
	
	public BtnDaListener(AppView view) {
		this.view = view;

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getActionCommand()) {
			case "Student":
				{
					deleteStudent();
					break;
				}
			case "Profesor":
				{
					deleteProfesor();
					break;
				}
			case "Predmet":
				{
					deletePredmet();
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
	
	private void deleteStudent() {
		JDialog dialog = view.getDeleteStudentDialogOrNotSelected();
		int index = AppCentralPanel.getInstance().getIndexStudent();
		AppCentralPanel.getInstance().deleteStudent(index);
		dialog.setVisible(false);
	}
	
	private void deleteProfesor() {
		DeleteProfesorDialog dialog = view.getDeleteProfesorDialog();
		int index = AppCentralPanel.getInstance().getIndexProfesori();
		AppCentralPanel.getInstance().deleteProfesor(index);
		dialog.setVisible(false);
	}
	
	private void deletePredmet() {
		DeletePredmetDialog dialog = view.getDeletePredmetDialog();
		int index = AppCentralPanel.getInstance().getIndexPredmeti();
		AppCentralPanel.getInstance().deletePredmet(index);
		dialog.setVisible(false);
	}

}
