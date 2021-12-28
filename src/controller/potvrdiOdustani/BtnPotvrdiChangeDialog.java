package controller.potvrdiOdustani;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import model.Adresa;
import model.AppData;
import model.Predmet;
import model.Profesor;
import model.Student;
import util.Util;
import view.*;
import view.changeDialogs.*;
import view.changeDialogs.Profesor.ChangeProfesorDialog;
import view.changeDialogs.Student.ChangeStudentDialog;
import view.deleteDialogs.DeletePredmetDialog;
import view.deleteDialogs.DeleteProfesorDialog;
import view.panelInformacije.PanelInformacijeWithComboBoxes;

public class BtnPotvrdiChangeDialog implements MouseListener, ActionListener{
	private AppView view;
	private AppData data;
	private String messageStudent;
	private String messageProfesor;
	private String messagePredmet;
	
	public BtnPotvrdiChangeDialog(AppView view, AppData data) {
		this.view = view;
		this.data = data;
		
		messageStudent = "Polja nisu validno popunjena!\n"
				+ "Ime: Tekst\n"
				+ "Prezime: Tekst\n"
				+ "Datum Rodjenja: Dan.Mesec.Godina.\n"
				+ "Adresa Stanovanja: Ulica, Broj, Grad, Drzava\n"
				+ "Broj Telefona: Od 9 do 25 cifara\n"
				+ "E-mail adresa: Mora da sadrzi @\n"
				+ "Broj indeksa: Broj indeksa(mora da bude jedinstven)\n"
				+ "Godina upisa: Broj";
		
		messageProfesor = "Polja nisu validno popunjena!\n"
				+ "Ime: Tekst\n"
				+ "Prezime: Tekst\n"
				+ "Datum Rodjenja: Dan.Mesec.Godina.\n"
				+ "Adresa Stanovanja: Ulica, Broj, Grad, Drzava\n"
				+ "Broj Telefona: Od 9 do 25 cifara\n"
				+ "E-mail adresa: Tekst koji mora da sadrzi @\n"
				+ "Adresa Kancelarije: Ulica, Broj, Grad, Drzava\n"
				+ "Broj Licne Karte: Mora sadrzati tacno 13 cifara\n"
				+ "Zvanje: Tekst\n"
				+ "Broj Godina Staza: Broj\n";
		
		messagePredmet = "Polja nisu validno popunjena!\n"
				+ "Sifra: Tekst(mora da bude jedinstvena)\n"
				+ "Naziv: Tekst(mora da bude jedinstven)\n"
				+ "Espb: Broj";
	}	

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getActionCommand()) {
			case "Student":
			{
				if(!btn.isEnabled()) {
					JOptionPane.showMessageDialog(view.getChangeStudentDialog(), messageStudent, "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			case "Profesor":
			{	
				if(!btn.isEnabled()) {
					JOptionPane.showMessageDialog(view.getChangeStudentDialog(), messageProfesor,"Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			case "Predmet":
			{
				if(!btn.isEnabled()) {
					JOptionPane.showMessageDialog(view.getChangeStudentDialog(), messagePredmet, "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Util.buttonEnteredColor);
		ArrayList<JTextField> textFields;
		switch(btn.getActionCommand()) {
			case "Student":
			{
				textFields = view.getChangeStudentDialog().getPanelInformacije().getTextFields();
				if(!checkStudentTextFields(textFields))
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
				break;
			}
			case "Profesor":
			{
				textFields = view.getChangeProfesorDialog().getPanelInformacije().getTextFields();
				if(!checkProfesorTextFields(textFields))
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
				break;
			}
			case "Predmet":
			{
				textFields = view.getChangePredmetDialog().getTextFields();
				if(!checkPredmetTextFields(textFields))
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
				break;
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(null);
		btn.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getActionCommand()) {
			case "Student":
				{
					int selectedStudent = view.getCentralPanel().gettStudenti().getSelectedRow();
					changeStudent(selectedStudent);
					break;
				}
			case "Profesor":
				{
					int selectedProfesor = view.getCentralPanel().gettProfesori().getSelectedRow();
					changeProfesor(selectedProfesor);
					break;
				}
			case "Predmet":
				{
					int selectedPredmet = view.getCentralPanel().gettPredmeti().getSelectedRow();
					changePredmet(selectedPredmet);
					break;
				}
		}
	}
	
	private boolean checkStudentTextFields(ArrayList<JTextField> textFields) {
		if(!view.isTextFieldValid(textFields.get(0), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(1), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(2), Util.datePattern) ||
		   !view.isTextFieldValid(textFields.get(3), Util.adressPattern) ||
		   !view.isTextFieldValid(textFields.get(4), Util.numTelPattern) ||
		   !view.isTextFieldValid(textFields.get(5), Util.emailPattern) ||
		   !view.isTextFieldValid(textFields.get(6), Util.brIndeksaPattern) ||
		   !view.isTextFieldValid(textFields.get(7), Util.godUpisaPattern) ||
		   !data.isIndexStudentaChanged(textFields.get(6).getText()))
			return false;
		else
			return true;
	}
	
	private boolean checkProfesorTextFields(ArrayList<JTextField> textFields) {
		if(!view.isTextFieldValid(textFields.get(0), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(1), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(2), Util.datePattern) ||
		   !view.isTextFieldValid(textFields.get(3), Util.adressPattern) ||
		   !view.isTextFieldValid(textFields.get(4), Util.numTelPattern) ||
		   !view.isTextFieldValid(textFields.get(5), Util.emailPattern) ||
		   !view.isTextFieldValid(textFields.get(6), Util.adressPattern) ||
		   !view.isTextFieldValid(textFields.get(7), Util.brLicKartePattern) ||
		   !view.isTextFieldValid(textFields.get(8), Util.stringPattern) || 
		   !view.isTextFieldValid(textFields.get(9), Util.brGodStazaPattern) ||
		   !data.isBrLicKarProfesoraChanged(textFields.get(7).getText()))
			return false;
		else
			return true;
	}
	
	private boolean checkPredmetTextFields(ArrayList<JTextField> textFields) {
		if(!view.isTextFieldValid(textFields.get(0), Util.textPattern) ||
		   !view.isTextFieldValid(textFields.get(1), Util.textPattern) ||
		   !view.isTextFieldValid(textFields.get(2), Util.numberPattern) ||
		   !data.isSifraPredmetaChanged(textFields.get(0).getText()) ||
		   !data.isNazivPredmetaChanged(textFields.get(1).getText()))
			return false;
		else
			return true;
	}
	
	private void changeStudent(int selectedStudent) {
		ChangeStudentDialog dialog = view.getChangeStudentDialog();
		PanelInformacijeWithComboBoxes panel = view.getChangeStudentDialog().getPanelInformacije();
		data.changeStudent(selectedStudent,panel.getTextFields(),panel.getComboBoxes());
		view.initTableStudenti();
		dialog.setVisible(false);
	}
	
	private void changeProfesor(int selectedProfesor) {
		ChangeProfesorDialog dialog = view.getChangeProfesorDialog();
		PanelInformacijeWithComboBoxes panel = view.getChangeProfesorDialog().getPanelInformacije();
		data.changeProfesor(selectedProfesor, panel.getTextFields());
		view.initTableProfesori();
		dialog.setVisible(false);
	}
	
	private void changePredmet(int selectedPredmet) {
		ChangePredmetDialog dialog = view.getChangePredmetDialog();
		data.changePredmet(selectedPredmet, dialog.getTextFields(), dialog.getCbGodina(), dialog.getCbSemestar());
		view.initTablePredmeti();
		dialog.setVisible(false);
	}

}
