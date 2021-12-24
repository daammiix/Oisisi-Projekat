package controller.documentsListeners;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.AppData;
import util.Util;
import view.AppView;

public class DocumentListenerStudent implements DocumentListener {

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		check();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		check();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		check();
	}
	
	private boolean checkStudentTextFields(ArrayList<JTextField> textFields) {
		AppView view = AppView.getInstance();
		if(!view.isTextFieldValid(textFields.get(0), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(1), Util.stringPattern) ||
		   !view.isTextFieldValid(textFields.get(2), Util.datePattern) ||
		   !view.isTextFieldValid(textFields.get(3), Util.adressPattern) ||
		   !view.isTextFieldValid(textFields.get(4), Util.numTelPattern) ||
		   !view.isTextFieldValid(textFields.get(5), Util.emailPattern) ||
		   !view.isTextFieldValid(textFields.get(6), Util.brIndeksaPattern) ||
		   !view.isTextFieldValid(textFields.get(7), Util.godUpisaPattern) || 
		   !AppData.getInstance().isIndexStudentaUnique(textFields.get(6).getText()))
			return false;
		else
			return true;
	}
	
	private void check() {
		if(checkStudentTextFields(AppView.getInstance().getAddStudentDialog().getPanelInformacije()
				.getTextFields()))
			AppView.getInstance().getAddStudentDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(true);
		else
			AppView.getInstance().getAddStudentDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
	}

}
