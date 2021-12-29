package controller.deleteStudentFromSubject;

import java.awt.event.*;
import javax.swing.*;

import model.AppData;
import model.Student;
import util.Util;
import view.*;

public class AddBtnDaListener implements MouseListener{
	
private AppView view;
	
	public AddBtnDaListener(AppView view) {
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedStudent = view.getCentralPanel().gettStudenti().getSelectedRow();
		int selectedPredmet = view.getChangeStudentDialog().getPanelNepolozeni().getTable().getSelectedRow();
		Student student = AppData.getInstance().getStudenti().get(selectedStudent);
		student.removePredmetFromNepolozeni(selectedPredmet);
		AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().refreshInfo(student);
		view.getDeleteStudentFromSubject().setVisible(false);
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
}
