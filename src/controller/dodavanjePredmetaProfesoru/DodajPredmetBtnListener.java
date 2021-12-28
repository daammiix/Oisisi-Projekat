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
		int selectedProfesor = AppView.getInstance().getCentralPanel().gettProfesori().getSelectedRow();
		AppView.getInstance().getDodavanjePredmetaProfesoruDialog().fillListInformation(AppData.getInstance().
				getProfesori().get(selectedProfesor));
		AppView.getInstance().getDodavanjePredmetaProfesoruDialog().setVisible(true);
	}
	
}
