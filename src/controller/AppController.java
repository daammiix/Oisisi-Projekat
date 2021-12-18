package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.potvrdiOdustani.*;
import model.AppData;
import view.AppView;
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
							appView.getAddStudentDialog().setVisible(true);
							break;
						}
					case "Profesori":
						{
							appView.getAddProfesorDialog().setLocationRelativeTo(appView.getFrame());
							appView.getAddProfesorDialog().setVisible(true);
							break;
						}
					case "Predmeti":
						{
							appView.getAddPredmetDialog().setLocationRelativeTo(appView.getFrame());
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
							JDialog dialog = appView.getChangeStudentDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
							break;					
						}
					case "Profesori":
						{
							JDialog dialog = appView.getChangeProfesorDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
							break;	
						}
					case "Predmeti":
						{
							JDialog dialog = appView.getChangePredmetDialogOrNotSelected();
							dialog.setLocationRelativeTo(appView.getFrame());
							dialog.setVisible(true);
							break;	
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
		
	}
	
	private void addBtnOdustaniChangeDialog() {
		BtnOdustaniChangeDialog bocd = new BtnOdustaniChangeDialog(appView);
		appView.getChangeStudentDialog().getPanelInformacije().addBtnOdustaniListener(bocd);
		appView.getChangeProfesorDialog().getPanelInformacije().addBtnOdustaniListener(bocd);
		appView.getChangePredmetDialog().getPanelInformacije().addBtnOdustaniListener(bocd);
		
	}
	
	private void addPotvrdiBtnListener() {
		PotvrdiBtnListener pbl = new PotvrdiBtnListener(appView, appData);
		appView.getAddStudentDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		
	}
	
	private void addBtnPotvrdiChangeListener() {
		BtnPotvrdiChangeDialog bpcd = new BtnPotvrdiChangeDialog(appView, appData);
		appView.getChangeStudentDialog().getPanelInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		appView.getChangeProfesorDialog().getPanelInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		appView.getChangePredmetDialog().getPanelInformacije().addBtnPotvrdiListener(bpcd, bpcd);
		
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
	
}
