package controller.daNeOk;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import model.AppData;
import model.Predmet;
import model.Profesor;
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
		DeleteStudentDialog dialog = view.getDeleteStudentDialog();
		int index = AppCentralPanel.getInstance().getIndexStudent();
		Student student = AppData.getInstance().getStudenti().get(index);
		AppData.getInstance().deleteStudent(student);
		view.initTableStudenti();
		dialog.setVisible(false);
	}
	
	private void deleteProfesor() {
		DeleteProfesorDialog dialog = view.getDeleteProfesorDialog();
		int index = AppCentralPanel.getInstance().getIndexProfesori();
		Profesor profesor = AppData.getInstance().getProfesori().get(index);
		AppData.getInstance().deleteProfesor(profesor);
		view.initTableProfesori();
		dialog.setVisible(false);
	}
	
	private void deletePredmet() {
		DeletePredmetDialog dialog = view.getDeletePredmetDialog();
		int index = AppCentralPanel.getInstance().getIndexPredmeti();
		Predmet predmet = AppData.getInstance().getPredmeti().get(index);
		AppData.getInstance().deletePredmet(predmet);
		view.initTablePredmeti();
		dialog.setVisible(false);
	}

}
