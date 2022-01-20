package controller.dodavanjePredmetaProfesoru;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AppData;
import view.AppView;

public class DodajPredmetBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		AppView.getInstance().getDodavanjePredmetaProfesoruDialog().setLocationRelativeTo(
				AppView.getInstance().getChangeProfesorDialog());
		int selectedRow = AppView.getInstance().getCentralPanel().gettProfesori().getSelectedRow();
		String selectedProfesorEmail = (String) AppView.getInstance().getCentralPanel().gettProfesori().
				getValueAt(selectedRow, 3);
		int selectedProfesor = AppData.getInstance().getProfesorIdxByEmail(selectedProfesorEmail);
		AppView.getInstance().getDodavanjePredmetaProfesoruDialog().fillListInformation(AppData.getInstance().
				getProfesori().get(selectedProfesor));
		AppView.getInstance().getDodavanjePredmetaProfesoruDialog().setVisible(true);
	}
	
}
