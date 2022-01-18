package controller.changeSubject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.AppData;
import model.Katedra;
import model.Predmet;
import model.Profesor;
import util.Util;
import view.AppView;
import view.changeDialogs.ChangePredmetDialog;
import view.changeDialogs.ChooseProfessorDialog;
import view.katedraDialogs.KatedreDialog;
import view.katedraDialogs.SefKatedreDialog;
import view.katedraDialogs.TrenutniSefKatedre;

public class BtnPotvrdiProfesoraListener implements MouseListener, ActionListener{
	private AppView view;
	private AppData data;
	
	public BtnPotvrdiProfesoraListener(AppView view, AppData data) {
		this.view = view;
		this.data = data;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

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
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton btn = (JButton)event.getSource();
		switch(btn.getActionCommand()) {
		case "Remove":
			{
				int selectedRowPredmet = AppView.getInstance().getCentralPanel().gettPredmeti().getSelectedRow();
				Predmet predmet = AppData.getInstance().getPredmeti().get(selectedRowPredmet);
				Profesor profesor = predmet.getPredmetniProfesor();
				predmet.removeProfesorFromPredmet();
				profesor.removePredmetFromProfesor(predmet);
				AppView.getInstance().getChangePredmetDialog().fillInPredmet(AppData.getInstance().getPredmeti().get(selectedRowPredmet));
				ChangePredmetDialog dialog = AppView.getInstance().getChangePredmetDialog();
				ArrayList<JTextField> textFields = dialog.getTextFields();
				textFields.get(3).setText("");
				doesProfessorExists(textFields);
				AppView.getInstance().getRemoveProfessorDialog().setVisible(false);
				break;
			}
		case "Choose":
			{
				ChooseProfessorDialog cp = AppView.getInstance().getChooseProfessorDialog();
				int selectedRow = cp.getTable().getSelectedRow();
				if(selectedRow != -1) {
					Profesor profesor = AppData.getInstance().getProfesori().get(selectedRow);
					addProfesor(profesor);
					AppView.getInstance().getChooseProfessorDialog().setVisible(false);
					ArrayList<JTextField> textFields = AppView.getInstance().getChangePredmetDialog().getTextFields();
					doesProfessorExists(textFields);
				} else {
					JOptionPane.showMessageDialog(cp, "Niste oznacili profesora", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		case "RemoveSef":
			{
				int selectedRowKatedra = AppView.getInstance().getKatedreDialog().getTable().getSelectedRow();
				Katedra katedra = AppData.getInstance().getKatedra().get(selectedRowKatedra);
				Profesor profesor = katedra.getSefKatedre();
				katedra.removeSefFromKatedra();
				AppView.getInstance().getKatedreDialog().clearTable();
				AppView.getInstance().getKatedreDialog().initTable();
				TrenutniSefKatedre dialog = AppView.getInstance().getTrenutniSefKatedre();
				JTextField textField = dialog.getTextField();
				textField.setText("");
				doesSefExists(textField);
				AppView.getInstance().getRemoveSefKatedreDialog().setVisible(false);
				break;
			}
		case "ChooseSefKatedre":
			{
				int selectedRowKatedra = AppView.getInstance().getKatedreDialog().getTable().getSelectedRow();
				Katedra katedra = AppData.getInstance().getKatedra().get(selectedRowKatedra);
				SefKatedreDialog skd = AppView.getInstance().getSefKatedreDialog();
				int selectedRow = skd.getTable().getSelectedRow();
				if(selectedRow != -1) {
					Profesor profesor = AppView.getInstance().getSefKatedreDialog().getDozvoljeniProfesori().get(selectedRow);
					addSefKatedre(profesor);
					katedra.addSefKatedre(profesor);
					JTextField textField = AppView.getInstance().getTrenutniSefKatedre().getTextField();
					doesSefExists(textField);
					AppView.getInstance().getTrenutniSefKatedre().fillInSefKatedre(katedra);
					AppView.getInstance().getSefKatedreDialog().setVisible(false);
				} else {
					JOptionPane.showMessageDialog(skd, "Niste oznacili sefa katedre", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
	}

	
	public void addProfesor(Profesor profesor) {
		String[] data = {profesor.getIme(), profesor.getPrezime()};
		ChangePredmetDialog dialog = AppView.getInstance().getChangePredmetDialog();
		ArrayList<JTextField> textFields = dialog.getTextFields();
		textFields.get(3).setText(data[0] + " " + data[1]);
		int selectedRowPredmet = AppView.getInstance().getCentralPanel().gettPredmeti().getSelectedRow();
		AppData.getInstance().changePredmet(selectedRowPredmet, dialog.getTextFields(), dialog.getCbGodina(), dialog.getCbSemestar());
		
	}
	
	public void addSefKatedre(Profesor profesor) {
		String[] data = {profesor.getIme(), profesor.getPrezime()};
		TrenutniSefKatedre dialog = AppView.getInstance().getTrenutniSefKatedre();
		JTextField textField = dialog.getTextField();
		textField.setText(data[0] + " " + data[1]);
	}
	
	public void doesProfessorExists(ArrayList<JTextField> textFields) {
		String textF = textFields.get(3).getText();
		String text = textF.trim();
		if(text.equals("")) {
			AppView.getInstance().getChangePredmetDialog().getBtnMinus().setEnabled(false);
			AppView.getInstance().getChangePredmetDialog().getBtnPlus().setEnabled(true);
		} else {
			AppView.getInstance().getChangePredmetDialog().getBtnMinus().setEnabled(true);
			AppView.getInstance().getChangePredmetDialog().getBtnPlus().setEnabled(false);
		}
	}
	
	public void doesSefExists(JTextField textField) {
		String textF = textField.getText();
		String text = textF.trim();
		if(text.equals("") || text == null) {
			AppView.getInstance().getTrenutniSefKatedre().getBtnMinus().setEnabled(false);
			AppView.getInstance().getTrenutniSefKatedre().getBtnPlus().setEnabled(true);;
		} else {
			AppView.getInstance().getTrenutniSefKatedre().getBtnMinus().setEnabled(true);
			AppView.getInstance().getTrenutniSefKatedre().getBtnPlus().setEnabled(false);
		};
	}
}
