package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.AppData;
import view.addDialogs.*;

public class AppView {
	private static AppView instance = null;
	
	public static AppView getInstance() {
		if(instance == null)
			instance = new AppView();
		return instance;
	}
	
	private static AppData data = AppData.getInstance();
	private AppFrame frame;
	private AppCentralPanel centralPanel;
	private AppMenuBar menuBar;
	private AppToolBar toolBar;
	private AppStatusBar statusBar;
	private AddStudentDialog addStudentDialog;
	private AddProfesorDialog addProfesorDialog;
	private AddPredmetDialog addPredmetDialog;
	
	private AppView() {
		frame = AppFrame.getInstance();
		centralPanel = AppCentralPanel.getInstance();
		menuBar = AppMenuBar.getInstance();
		toolBar = AppToolBar.getInstance();
		statusBar = new AppStatusBar();
		addStudentDialog = new AddStudentDialog(frame, "Dodavanje studenta", true);
		addProfesorDialog = new AddProfesorDialog(frame, "Dodavanje profesora", true);
		addPredmetDialog = new AddPredmetDialog(frame, "Dodavanje predmeta", true);
		
		frame.setJMenuBar(menuBar);
		
		frame.add(toolBar, BorderLayout.NORTH);
		
		frame.add(centralPanel, BorderLayout.CENTER);
		
		frame.add(statusBar, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	public void refreshTableStudenti() {
		centralPanel.clearTableStudenti();
		centralPanel.updateStudenti(data.getStudenti());
	}
	
	public void refreshTableProfesori() {
		centralPanel.clearTableProfesori();
		centralPanel.updateProfesori(data.getProfesori());
	}
	
	public void refreshTablePredmeti() {
		centralPanel.clearTablePredmeti();
		centralPanel.updatePredmeti(data.getPredmeti());
	}
	
	public void addAddEntityListener(ActionListener al) {
		toolBar.getBtnOpen().addActionListener(al);
		menuBar.getMiNew().addActionListener(al);
	}
	
	public boolean isTextFieldValid(JTextField tf, String pattern) {
		String text = tf.getText();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		if(m.matches())
			return true;
		return false;
	}
	
	// getters and setters

	public AppFrame getFrame() {
		return frame;
	}

	public AppCentralPanel getCentralPanel() {
		return centralPanel;
	}

	public AppMenuBar getMenuBar() {
		return menuBar;
	}

	public AppToolBar getToolBar() {
		return toolBar;
	}

	public AppStatusBar getStatusBar() {
		return statusBar;
	}

	public AddStudentDialog getAddStudentDialog() {
		return addStudentDialog;
	}

	public AddProfesorDialog getAddProfesorDialog() {
		return addProfesorDialog;
	}

	public AddPredmetDialog getAddPredmetDialog() {
		return addPredmetDialog;
	}
	
}
