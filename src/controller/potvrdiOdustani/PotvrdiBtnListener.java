package controller.potvrdiOdustani;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.AppData;
import util.Util;
import view.*;
import view.addDialogs.*;
import view.panelInformacije.PanelInformacijeWithComboBoxes;

public class PotvrdiBtnListener implements MouseListener, ActionListener {
	private AppView view;
	private AppData data;
	private String messageStudent;
	private String messageProfesor;
	private String messagePredmet;
	private String messagePolaganje;
	
	public PotvrdiBtnListener(AppView view, AppData data) {
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
		
		messagePolaganje = "Datum: Dan.Mesec.Godina.";
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
					JOptionPane.showMessageDialog(view.getAddStudentDialog(), messageStudent, "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			case "Profesor":
			{	
				if(!btn.isEnabled()) {
					JOptionPane.showMessageDialog(view.getAddStudentDialog(), messageProfesor,"Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			case "Predmet":
			{
				if(!btn.isEnabled()) {
					JOptionPane.showMessageDialog(view.getAddStudentDialog(), messagePredmet, "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
			case "Polaganje":
			{
				if(!btn.isEnabled()) 
					JOptionPane.showMessageDialog(view.getPolaganjeDialog(), messagePolaganje, "Error",
							JOptionPane.ERROR_MESSAGE);
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
		ArrayList<JTextField> textFields = null;
		switch(btn.getActionCommand()) {
			case "Polaganje":
			{
				textFields = view.getPolaganjeDialog().getPanel().getTextFields();
				if(!view.isTextFieldValid(textFields.get(2), Util.datePattern))
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
		switch(btn.getActionCommand()) {
			case "Polaganje":
			{
				btn.setEnabled(true);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		switch(btn.getActionCommand()) {
			case "Student":
				{
					newStudent();
					break;
				}
			case "Profesor":
				{
					newProfesor();
					break;
				}
			case "Predmet":
				{
					newPredmet();
					break;
				}
			case "Polaganje":
			{
				int selectedPredmet = view.getChangeStudentDialog().getPanelNepolozeni().getTable()
						.getSelectedRow();
				int selectedStudent = view.getCentralPanel().gettStudenti().getSelectedRow();
				poloziPredmet(selectedPredmet, selectedStudent);
				break;
			}
		}
	}
	
	private void newStudent() {
		AddStudentDialog dialog = view.getAddStudentDialog();
		PanelInformacijeWithComboBoxes panel = view.getAddStudentDialog().getPanelInformacije();
		data.createStudentAndAddToStudents(panel.getTextFields(), panel.getComboBoxes());
		view.initTableStudenti();
		panel.clearTextFields();
		panel.refreshComboBoxes();
		dialog.setVisible(false);
	}
	
	private void newProfesor() {
		AddProfesorDialog dialog = view.getAddProfesorDialog();
		PanelInformacijeWithComboBoxes panel = view.getAddProfesorDialog().getPanelInformacije();
		data.createProfesorAndAddToProfesors(panel.getTextFields());
		view.initTableProfesori();
		panel.clearTextFields();
		dialog.setVisible(false);
	}
	
	private void newPredmet() {
		AddPredmetDialog dialog = view.getAddPredmetDialog();
		PanelInformacijeWithComboBoxes panel = view.getAddPredmetDialog().getPanelInformacije();
		data.createPredmetAndAddToPredmets(panel.getTextFields(), panel.getComboBoxes());
		view.initTablePredmeti();
		panel.clearTextFields();	
		dialog.setVisible(false);
	}
	
	private void poloziPredmet(int selectedPredmet, int selectedStudent) {
		data.poloziPredmet(selectedPredmet, selectedStudent, view.getPolaganjeDialog().getPanel().getTextFields()
				.get(2), view.getPolaganjeDialog().getPanel().getComboBoxes().get(0));
		view.getChangeStudentDialog().getPanelPolozeni().refreshInfo(data.getStudenti().get(selectedStudent));
		view.getChangeStudentDialog().getPanelNepolozeni().refreshInfo(data.getStudenti().get(selectedStudent));
		view.getPolaganjeDialog().setVisible(false);		
	}

}
