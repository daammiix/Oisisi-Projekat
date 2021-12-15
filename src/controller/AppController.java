package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.potvrdiOdustani.*;
import model.AppData;
import view.AppView;

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
	}
	
	private void addOdustaniBtnListener() {
		OdustaniBtnListener obl = new OdustaniBtnListener(appView);
		appView.getAddStudentDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnOdustaniListener(obl);
		
	}
	
	private void addPotvrdiBtnListener() {
		PotvrdiBtnListener pbl = new PotvrdiBtnListener(appView, appData);
		appView.getAddStudentDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddProfesorDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		appView.getAddPredmetDialog().getPanelInformacije().addBtnPotvrdiListener(pbl, pbl);
		
	}
	
}
