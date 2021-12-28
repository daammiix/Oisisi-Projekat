package controller.ponistavanjeOcene;

import java.awt.event.*;
import javax.swing.JButton;
import model.*;
import view.AppView;

public class DaNeBtnListenerPonistiOcenu implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn.getActionCommand().equals("Da")) {
			int selectedStudent = AppView.getInstance().getCentralPanel().gettStudenti().getSelectedRow();
			int selectedPredmet = AppView.getInstance().getChangeStudentDialog().getPanelPolozeni().getTableIspit().
					getSelectedRow();
			Student s = AppData.getInstance().getStudenti().get(selectedStudent);
			Ocena o = s.getPolozeniIspiti().get(selectedPredmet);
			s.removePredmetFromPolozeni(selectedPredmet);
			AppView.getInstance().getChangeStudentDialog().getPanelPolozeni().refreshInfo(s);
			s.addNepolozenIspit(o);
			AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().refreshInfo(s);
		}
		AppView.getInstance().getPonistavanjeOceneDialog().setVisible(false);
	}

}
