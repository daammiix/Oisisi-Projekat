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
			int selectedRow = AppView.getInstance().getCentralPanel().gettStudenti().getSelectedRow();
			int selectedPredmet = AppView.getInstance().getChangeStudentDialog().getPanelPolozeni().getTableIspit().
					getSelectedRow();
			TableStudentIndexValue selectedValue = (TableStudentIndexValue) AppView.getInstance().getCentralPanel().gettStudenti().
					getValueAt(selectedRow, 0);
			String selectedStudentIndeks = selectedValue.getIndeks();
			Student s = AppData.getInstance().getStudentByIndeks(selectedStudentIndeks);
			Ocena o = s.getPolozeniIspiti().get(selectedPredmet);
			s.removePredmetFromPolozeni(selectedPredmet);
			AppView.getInstance().getChangeStudentDialog().getPanelPolozeni().refreshInfo(s);
			s.addNepolozenIspit(o);
			AppView.getInstance().getChangeStudentDialog().getPanelNepolozeni().refreshInfo(s);
			AppView.getInstance().getCentralPanel().gettmodelStudenti().setValueAt(s.getProsecnaOcena(), 
					selectedRow, 5);
			Predmet p = o.getPredmet();
			p.studentPao(s);
		}
		AppView.getInstance().getPonistavanjeOceneDialog().setVisible(false);
	}

}
