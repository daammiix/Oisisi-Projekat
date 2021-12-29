package controller.addStudentOnSubjectListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AppView;

public class BtnOdustaniListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event) {
			AppView.getInstance().getAddStudentOnSubjectDialog().setVisible(false);
	}
}
