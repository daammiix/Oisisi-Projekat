package controller.deleteStudentFromSubject;

import java.awt.event.*;
import javax.swing.*;

import model.AppData;
import model.Student;
import model.TableStudentIndexValue;
import util.Util;
import view.*;

public class AddBtnDaListener implements MouseListener{
	
private AppView view;
	
	public AddBtnDaListener(AppView view) {
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = view.getCentralPanel().gettStudenti().getSelectedRow();
		TableStudentIndexValue selectedValue = (TableStudentIndexValue) AppView.getInstance().getCentralPanel().gettStudenti().
				getValueAt(selectedRow, 0); 
		String selectedStudentIndeks = selectedValue.getIndeks();
		Student student = AppData.getInstance().getStudentByIndeks(selectedStudentIndeks);
		int selectedPredmet = view.getChangeStudentDialog().getPanelNepolozeni().getTable().getSelectedRow();
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
