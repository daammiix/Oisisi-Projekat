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
import view.deleteDialogs.DeletePredmetDialog;
import view.deleteDialogs.DeleteProfesorDialog;
import view.panelInformacije.PanelInformacijeWithComboBoxes;

public class BtnPotvrdiChangeDialog implements MouseListener, ActionListener{
	private AppView view;
	private AppData data;
	private String messageStudent;
	private String messageProfesor;
	private String messagePredmet;
	private AppCentralPanel centralPanel;
	
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
				textFields = view.getChangePredmetDialog().getPanelInformacije().getTextFields();
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
					changeStudent();
					break;
				}
			case "Profesor":
				{
					changeProfesor();
					break;
				}
			case "Predmet":
				{
					changePredmet();
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
		   !view.isTextFieldValid(textFields.get(6), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(7), Util.numberPattern) || 
		   !data.isIndexStudentaUnique(textFields.get(6).getText()))
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
		   !view.isTextFieldValid(textFields.get(7), Util.numberPattern) ||
		   !view.isTextFieldValid(textFields.get(8), Util.stringPattern) || 
		   !view.isTextFieldValid(textFields.get(9), Util.numberPattern))
			return false;
		else
			return true;
	}
	
	private boolean checkPredmetTextFields(ArrayList<JTextField> textFields) {
		if(!view.isTextFieldValid(textFields.get(0), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(1), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(2), Util.numberPattern) ||
		   !data.isSifraPredmetaUnique(textFields.get(0).getText()) ||
		   !data.isNazivPredmetaUnique(textFields.get(1).getText()))
			return false;
		else
			return true;
	}
	
	private void changeStudent() {
		ChangeStudentDialog dialog = view.getChangeStudentDialog();
		PanelInformacijeWithComboBoxes panel = view.getChangeStudentDialog().getPanelInformacije();
		String ime = data.unpackStringTextField(panel.getTextFields().get(0));
		String prezime = data.unpackStringTextField(panel.getTextFields().get(1));
		Date datumRodjenja = data.unpackDateTextField(panel.getTextFields().get(2));
		Adresa adresa = data.unpackAdressTextField(panel.getTextFields().get(3));
		String kontaktTelefon = data.unpackStringTextField(panel.getTextFields().get(4));
		String email = data.unpackStringTextField(panel.getTextFields().get(5));
		String brIndeksa = data.unpackStringTextField(panel.getTextFields().get(6));
		int godUpisa = data.unpackIntTextField(panel.getTextFields().get(7));
		int trenutnaGodStud = data.unpackComboBoxGodStud(panel.getComboBoxes().get(0));
		String statusStr = (String)panel.getComboBoxes().get(1).getSelectedItem();
		Student.Status status = Student.Status.B;
		if(statusStr == "Samofinansiranje")
			status = Student.Status.S;
		Student student = new Student(ime, prezime, datumRodjenja, adresa, kontaktTelefon, email, brIndeksa, godUpisa, trenutnaGodStud, status);
		deleteStudent();
		AppCentralPanel.getInstance().addStudent(student);
		panel.clearTextFields();
		panel.refreshComboBoxes();
		dialog.setVisible(false);
	}
	
	private void changeProfesor() {
		ChangeProfesorDialog dialog = view.getChangeProfesorDialog();
		PanelInformacijeWithComboBoxes panel = view.getChangeProfesorDialog().getPanelInformacije();
		String ime = data.unpackStringTextField(panel.getTextFields().get(0));
		String prezime = data.unpackStringTextField(panel.getTextFields().get(1));
		Date datumRodjenja = data.unpackDateTextField(panel.getTextFields().get(2));
		Adresa adresa = data.unpackAdressTextField(panel.getTextFields().get(3));
		String kontaktTelefon = data.unpackStringTextField(panel.getTextFields().get(4));
		String email = data.unpackStringTextField(panel.getTextFields().get(5));
		Adresa adresaKancelarije = data.unpackAdressTextField(panel.getTextFields().get(6));
		String brLicneKarte = data.unpackStringTextField(panel.getTextFields().get(7));
		String zvanje = data.unpackStringTextField(panel.getTextFields().get(8));
		int brGodinaStaza = data.unpackIntTextField(panel.getTextFields().get(9));
		Profesor profesor = new Profesor(ime, prezime, datumRodjenja, adresa, kontaktTelefon, email, adresaKancelarije, brLicneKarte,
				zvanje, brGodinaStaza);
		deleteProfesor();
		AppCentralPanel.getInstance().addProfesor(profesor);
		panel.clearTextFields();
		dialog.setVisible(false);
	}
	
	private void changePredmet() {
		ChangePredmetDialog dialog = view.getChangePredmetDialog();
		PanelInformacijeWithComboBoxes panel = view.getChangePredmetDialog().getPanelInformacije();
		String sifra = data.unpackStringTextField(panel.getTextFields().get(0));
		String naziv = data.unpackStringTextField(panel.getTextFields().get(1));
		String semestar = (String)panel.getComboBoxes().get(0).getSelectedItem();
		int godina = data.unpackComboBoxGodStud(panel.getComboBoxes().get(1));
		int espb = data.unpackIntTextField(panel.getTextFields().get(2));
		Predmet predmet = new Predmet(sifra, naziv, espb, godina, semestar);
		deletePredmet();
		AppCentralPanel.getInstance().addPredmet(predmet);
		panel.clearTextFields();	
		panel.refreshComboBoxes();
		dialog.setVisible(false);
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
