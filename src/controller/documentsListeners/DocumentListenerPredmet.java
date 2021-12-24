package controller.documentsListeners;

import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.AppData;
import util.Util;
import view.AppView;

public class DocumentListenerPredmet implements DocumentListener {

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
	
	private boolean checkPredmetTextFields(ArrayList<JTextField> textFields) {
		AppView view = AppView.getInstance();
		AppData data = AppData.getInstance();
		if(!view.isTextFieldValid(textFields.get(0), Util.textPattern) ||
		   !view.isTextFieldValid(textFields.get(1), Util.textPattern) ||
		   !view.isTextFieldValid(textFields.get(2), Util.numberPattern) ||
		   !data.isSifraPredmetaUnique(textFields.get(0).getText()) ||
		   !data.isNazivPredmetaUnique(textFields.get(1).getText()))
			return false;
		else
			return true;
	}
	
	private void check() {
		if(checkPredmetTextFields(AppView.getInstance().getAddPredmetDialog().getPanelInformacije()
				.getTextFields()))
			AppView.getInstance().getAddPredmetDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(true);
		else
			AppView.getInstance().getAddPredmetDialog().getPanelInformacije().getBtnPotvrdi().setEnabled(false);
	}
}
