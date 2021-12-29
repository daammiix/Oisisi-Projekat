package controller.deleteStudentFromSubject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import view.AppView;
import view.changeDialogs.Student.Nepolozeni;

public class AddBtnObrisiListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Nepolozeni nepolozeni = AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni();
		int selectedPredmet = AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().getTable().getSelectedRow();
		if(selectedPredmet != -1) {
			AppView.getInstance().getDeleteStudentFromSubject().setLocationRelativeTo(AppView.getInstance().getChangeStudentDialog());
			AppView.getInstance().getDeleteStudentFromSubject().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(nepolozeni, "Niste izabrali predmet", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
