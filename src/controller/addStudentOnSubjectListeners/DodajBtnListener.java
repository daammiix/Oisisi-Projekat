package controller.addStudentOnSubjectListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import model.AppData;
import model.Student;
import util.Util;
import view.AppCentralPanel;
import view.AppView;
import view.studentPredmetDialogs.AddStudentOnSubjectDialog;

public class DodajBtnListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		AppView.getInstance().getAddStudentOnSubjectDialog().setLocationRelativeTo(AppView.getInstance()
				.getChangeStudentDialog());
		AppView.getInstance().getAddStudentOnSubjectDialog().setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}