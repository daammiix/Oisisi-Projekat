package controller.uklanjanjePredmetaProfesoru;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.AppView;

public class UkloniPredmetBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int[] selectedPredmeti = AppView.getInstance().getChangeProfesorDialog().getPredmeti().getTable()
				.getSelectedRows();
		if(selectedPredmeti.length == 0)
			JOptionPane.showMessageDialog(AppView.getInstance().getChangeProfesorDialog(), 
					"Niste izabrali predmet!", "Error!", JOptionPane.ERROR_MESSAGE);
		else {
			AppView.getInstance().getUklanjanjePredmetaProfesoruDialog().setLocationRelativeTo(
					AppView.getInstance().getChangeProfesorDialog());
			AppView.getInstance().getUklanjanjePredmetaProfesoruDialog().setVisible(true);
		}
	}

}
