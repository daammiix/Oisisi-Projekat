package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.addStudentOnSubjectListeners.BtnDodajListener;
import controller.addStudentOnSubjectListeners.BtnOdustaniListener;
import controller.addStudentOnSubjectListeners.DodajBtnListener;
//import controller.addStudentOnSubjectListeners.ObrisiPredmetaBtnListener;
import controller.daNeOk.BtnDaListener;
import controller.daNeOk.BtnNeListener;
import controller.daNeOk.BtnOkListener;
import controller.deleteStudentFromSubject.AddBtnDaListener;
import controller.deleteStudentFromSubject.AddBtnNeListener;
import controller.deleteStudentFromSubject.AddBtnObrisiListener;
import controller.documentsListeners.DocumentListenerPredmet;
import controller.documentsListeners.DocumentListenerProfesor;
import controller.documentsListeners.DocumentListenerStudent;
import controller.dodavanjePredmetaProfesoru.DodajPredmetBtnListener;
import controller.polaganjePredmeta.PolaganjePredmetaBtnListener;
import controller.ponistavanjeOcene.*;
import controller.potvrdiOdustani.*;
import controller.uklanjanjePredmetaProfesoru.DaNeBtnListenerUkloniPredmet;
import controller.uklanjanjePredmetaProfesoru.UkloniPredmetBtnListener;
import model.AppData;
import model.Profesor;
import model.Student;
import view.AppCentralPanel;
import view.AppView;
import view.changeDialogs.ChangePredmetDialog;
import view.changeDialogs.Profesor.ChangeProfesorDialog;
import view.changeDialogs.Student.ChangeStudentDialog;
import view.deleteDialogs.DeleteStudentDialog;
import view.deleteDialogs.NotSelectedDialog;


public class AppController {
	private static AppController instance = null;
	
	private static AppView appView = AppView.getInstance();
	private static AppData appData = AppData.getInstance();
	
	public static AppController getInstance() {
		if(instance == null)
			instance = new AppController();
		return instance;
	}
	
	private AppController() {
		
		this.addEntityListener();
		this.addOdustaniBtnListener();
		this.addPotvrdiBtnListener();
		this.tabChangedListener();
		this.addBtnDaListener();
		this.addBtnNeListener();
		this.addBtnOkListener();
		this.addBtnPotvrdiChangeListener();
		this.addBtnOdustaniChangeDialog();
		this.addDocumentListeners();
		this.addPonistavanjeOceneDialogListeners();
		this.addPolaganjePredmetaBtnListeners();
		this.addIzmenaProfesoraPredmetiBtnListeners();
		this.addDodajBtnListener();
		this.addBtnDodajListener();
		this.addBtnOdustaniListener();
		this.addBtnObrisiActionListener();
		this.addDeleteBtnNeListener();
		this.addDeleteBtnDaListener();
	}
	
	public void tabChangedListener() {
		appView.tabChangedListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				appView.getStatusBar().setNaziv(appView.getFrame().getTitle(), appView.getCentralPanel().getSelectedTabTitle());
			}
		});
	}
	
	public void addEntityListener() {
		appView.addAddEntityListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				switch(appView.getCentralPanel().getSelectedTabTitle()) {
					case "Studenti":
						{
							appView.getAddStudentDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddStudentDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
							appView.getAddStudentDialog().getPanelInformacije().clearTextFields();
							appView.getAddStudentDialog().getPanelInformacije().refreshComboBoxes();
							appView.getAddStudentDialog().getPanelInformacije().getTextFields().get(0).requestFocus();
							appView.getAddStudentDialog().setVisible(true);
							break;
						}
					case "Profesori":
						{
							appView.getAddProfesorDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddProfesorDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
							appView.getAddProfesorDialog().getPanelInformacije().clearTextFields();
							appView.getAddProfesorDialog().getPanelInformacije().getTextFields().get(0).requestFocus();
							appView.getAddProfesorDialog().setVisible(true);
							break;
						}
					case "Predmeti":
						{
							appView.getAddPredmetDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddPredmetDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
							appView.getAddPredmetDialog().getPanelInformacije().clearTextFields();
							appView.getAddPredmetDialog().getPanelInformacije().refreshComboBoxes();
							appView.getAddPredmetDialog().getPanelInformacije().getTextFields().get(0).requestFocus();
							appView.getAddPredmetDialog().setVisible(true);
							break;
						}
				}
			}
		});
		
		appView.addChangeEntityListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				switch(appView.getCentralPanel().getSelectedTabTitle()) {
					case "Studenti":
						{
							int selectedRow = AppCentralPanel.getInstance().getIndexStudent();
							ChangeStudentDialog dialog1 =appView.getChangeStudentDialog();
							NotSelectedDialog dialog2 = appView.getNotSelectedDialog();
							if(selectedRow >= 0) {
								Student selectedStudent = appData.getStudenti().get(selectedRow);
								dialog1.setLocationRelativeTo(appView.getFrame());
								appView.getChangeStudentDialog().getPanelInformacije().fillInStudent(selectedStudent);
								dialog1.getPanelPolozeni().refreshInfo(selectedStudent);
								appView.getAddStudentOnSubjectDialog().initTable(selectedStudent);;
								dialog1.getPanelNepolozeni().refreshInfo(selectedStudent);
								dialog1.getTabbedPane().setSelectedIndex(0);
								dialog1.setVisible(true);
							}else {
								dialog2.setLocationRelativeTo(appView.getFrame());
								dialog2.setVisible(true);
							}
							break;					
						}
					case "Profesori":
						{
							int selectedRow = AppCentralPanel.getInstance().getIndexProfesori();
							ChangeProfesorDialog dialog1 =appView.getChangeProfesorDialog();
							NotSelectedDialog dialog2 = appView.getNotSelectedDialog();
							if(selectedRow >= 0) {
								Profesor selectedProfesor = appData.getProfesori().get(selectedRow);
								dialog1.setLocationRelativeTo(appView.getFrame());
								appView.getChangeProfesorDialog().fillInProfesor(selectedProfesor);
								dialog1.getPredmeti().refreshInfo(selectedProfesor);
								dialog1.getTabbedPane().setSelectedIndex(0);
								dialog1.setVisible(true);
							} else {
								dialog2.setLocationRelativeTo(appView.getFrame());
								dialog2.setVisible(true);
							}
							break;	
						}
					case "Predmeti":
						{
							int selectedRow = AppCentralPanel.getInstance().getIndexPredmeti();
							ChangePredmetDialog dialog1 =appView.getChangePredmetDialog();
							NotSelectedDialog dialog2 = appView.getNotSelectedDialog();
							if(selectedRow >= 0) {
								dialog1.setLocationRelativeTo(appView.getFrame());
								appView.getChangePredmetDialog().fillInPredmet(appData.getPredmeti().get(selectedRow));
								dialog1.setVisible(true);
							} else {
								dialog2.setLocationRelativeTo(appView.getFrame());
								dialog2.setVisible(true);
							}
						}
				}
			}
		});
		
		appView.addDeleteEntityListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				switch(appView.getCentralPanel().getSelectedTabTitle()) {
					case "Studenti":
						{
							JDialog dialog = appView.getDeleteStudentDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
							break;					
						}
					case "Profesori":
						{
							JDialog dialog = appView.getDeleteProfesorDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
							break;	
						}
					case "Predmeti":
						{
							JDialog dialog = appView.getDeletePredmetDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
							break;
						}
				}
			}
		});
	}
	
	private void addOdustaniBtnListener() {
		OdustaniBtnListener obl = new OdustaniBtnListener(appView);
		appView.getAddStudentDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		
		appView.getPolaganjeDialog().getPanel().addBtnOdustaniListener(obl);
		
		appView.getDodavanjePredmetaProfesoruDialog().addBtnOdustaniListener(obl);
		
	}
	
	private void addBtnOdustaniChangeDialog() {
		BtnOdustaniChangeDialog bocd = new BtnOdustaniChangeDialog(appView);
		appView.getChangeStudentDialog().getPanelInformacije().addBtnOdustaniListener(bocd);
		appView.getChangeProfesorDialog().getPanelInformacije().addBtnOdustaniListener(bocd);
		appView.getChangePredmetDialog().addBtnOdustaniDialog(bocd);
		
	}

	private void addPotvrdiBtnListener() {
		PotvrdiBtnListener pbl = new PotvrdiBtnListener(appView, appData);
		appView.getAddStudentDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		
		appView.getPolaganjeDialog().getPanel().addBtnPotvrdiListener(pbl, pbl);
		
		appView.getDodavanjePredmetaProfesoruDialog().addBtnPotvrdiListener(pbl, pbl);
	}
	
	private void addBtnPotvrdiChangeListener() {
		BtnPotvrdiChangeDialog bpcd = new BtnPotvrdiChangeDialog(appView, appData);
		appView.getChangeStudentDialog().getPanelInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		appView.getChangeProfesorDialog().getPanelInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		appView.getChangePredmetDialog().addBtnPotvrdiListener(bpcd, bpcd);
		
	}
	
	private void addBtnDaListener() {
		BtnDaListener bdl = new BtnDaListener(appView);
		appView.getDeleteStudentDialog().addBtnDaListener(bdl);
		appView.getDeleteProfesorDialog().addBtnDaListener(bdl);
		appView.getDeletePredmetDialog().addBtnDaListener(bdl);
	}
	
	private void addBtnNeListener() {
		BtnNeListener bnl = new BtnNeListener(appView);
		appView.getDeleteStudentDialog().addBtnNeListener(bnl);
		appView.getDeleteProfesorDialog().addBtnNeListener(bnl);
		appView.getDeletePredmetDialog().addBtnNeListener(bnl);
	}
	
	private void addBtnOkListener() {
		BtnOkListener bol = new BtnOkListener(appView);
		appView.getNotSelectedDialog().addBtnOkListener(bol);
	}
	
	private void addDocumentListeners() {
		DocumentListenerStudent dls = new DocumentListenerStudent();
		DocumentListenerProfesor dlp = new DocumentListenerProfesor();
		DocumentListenerPredmet dlpr = new DocumentListenerPredmet();
		appView.getAddStudentDialog().getPanelInformacije().connectDocumentListener(dls);
		appView.getAddProfesorDialog().getPanelInformacije().connectDocumentListener(dlp);
		appView.getAddPredmetDialog().getPanelInformacije().connectDocumentListener(dlpr);
	}
	
	private void addPonistavanjeOceneDialogListeners() {
		appView.getChangeStudentDialog().getPanelPolozeni().addBtnPonistiActionListener(new PonistiOcenuBtnListener());
		appView.getPonistavanjeOceneDialog().addBtnsActionListener(new DaNeBtnListenerPonistiOcenu());
	}
	
	private void addPolaganjePredmetaBtnListeners() {
		appView.getChangeStudentDialog().getPanelNepolozeni().addBtnPolaganjeActionListener(
			new PolaganjePredmetaBtnListener());
	}
	
	private void addIzmenaProfesoraPredmetiBtnListeners() {
		appView.getChangeProfesorDialog().getPredmeti().addBtnDodajListener(new DodajPredmetBtnListener());
		appView.getChangeProfesorDialog().getPredmeti().addBtnUkloniListener(new UkloniPredmetBtnListener());
		appView.getUklanjanjePredmetaProfesoruDialog().addBtnsActionListener(new DaNeBtnListenerUkloniPredmet());
	}
	
	private void addDodajBtnListener() {
		appView.getChangeStudentDialog().getPanelNepolozeni().addDodajBtnListener(
				new DodajBtnListener());
	}
	
	private void addBtnDodajListener() {
		appView.getAddStudentOnSubjectDialog().addBtnDodajListener(new BtnDodajListener());
	}
	
	private void addBtnOdustaniListener() {
		appView.getAddStudentOnSubjectDialog().addBtnOdustaniListener(new BtnOdustaniListener());
	}
	
	private void addBtnObrisiActionListener() {
		appView.getChangeStudentDialog().getPanelNepolozeni().addBtnObrisiActionListener(new AddBtnObrisiListener());
	}
	
	private void addDeleteBtnNeListener() {
		AddBtnNeListener abnl = new AddBtnNeListener(appView);
		appView.getDeleteStudentFromSubject().addDeleteBtnNeListener(abnl);
	}
	
	private void addDeleteBtnDaListener() {
		AddBtnDaListener abdl = new AddBtnDaListener(appView);
		appView.getDeleteStudentFromSubject().addDeleteBtnDaListener(abdl);
	}
}
